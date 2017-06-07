package Jogo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Jogadas.CarregarJogadas;
import Log.ArquivoLog;
import Tabuleiro.Tabuleiro;
import TiposImoveis.Imovel;
import org.apache.log4j.Logger;

/**
 * Banco Imobili�rio
 * 
 * @author Luan Felipe e Talles Souza
 * @version 2.0
 *
 * @see CarregarJogo M�todo utilizado para carregar o jogo, atrav�s da chamada
 *      das principais fun��es que dar�o in�cio ao Jogo, al�m de controlar a
 *      cria��o do Tabuleiro, controlar as jogadas, e mostrar de maneira
 *      atualizada o que cada jogador (cada um com seu id pr�prio) possui (Valor
 *      em Dinheiro, Im�vel Adiquirido, N�mero de Voltas) al�m da sua posi��o no
 *      Tabuleiro.
 */

public class CarregarJogo {

	private static final Logger logger = Logger.getLogger(CarregarJogo.class);
	private int[][] NumeroTabuleiro = new int[100][100];
	private int[][] NumeroJogadas = new int[100][100];
	private ArrayList<Jogador> listajogador = new ArrayList<Jogador>();
	private ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	private int numeroRodadas = 0;
	String j1;

	/**
	 * M�todo que chama as principais fun��es para iniciar o Jogo.
	 * 
	 * @throws FileNotFoundException Lan�a a exce��o caso a escrita 
	 * no arquivo Log n�o for realizada com sucesso.
	 */
	public void CarregaVariaveis() throws FileNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("entering CarregaVariaveis()");
		}
		CriaTabuleiro();
		AdicionaJogadores();
		PegarJogadas();
		new ArquivoLog("Carrega Variaveis para Inicio Jogo...");
		// verJogadores();
		// verTabuleiro();
		if (logger.isDebugEnabled()) {
			logger.debug("exiting CarregaVariaveis()");
		}
	}

	/**
	 * 
	 * M�todo que carrega as Jogadas e os Jogadores para dar in�cio ao jogo e
	 * tendo o controle de cada atualiza��o atrav�s das listas de Jogadores
	 * (listajogador) e Im�veis (listaImovel) e da posi��o de cada um dos
	 * Jogadores no Tabuleiro.
	 *
	 * @throws FileNotFoundException  Exce��o para tratar a leitura do arquivo Estat�stica.txt, caso ocorra um erro na 
	 * leitura, a seguinte mensagem ser� mostrada: "Falha ao escrever no arquivo"
	 */
	public void ComecaJogo() throws FileNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("entering ComecaJogo()");
		}
		CarregaVariaveis();
		new ArquivoLog("Come�a Jogo...");
		// PosicaoInicio();
		// int n = 0;
		int perdeu = 0;
		int linhaJogadas = 1;

		for (int i = 1; i < NumeroJogadas[0][0]; i++) {
			int j = NumeroJogadas[linhaJogadas][1];
			j1 = Integer.toString(j);
			new ArquivoLog("Joga Jogador" + j1);
			j--;

			if (listajogador.get(j).getPerdeu() == 0) {
				int dado = 0;
				dado = DaVolta(dado, j, linhaJogadas);
				// System.out.println(dado);
				if (listaImovel.get(dado).getTipoPosicao() == 2) {
					// passa vez
					// DaVolta(dado, j, linhaJogadas);
					linhaJogadas++;
				} else if (listaImovel.get(dado).getTipoPosicao() == 3) {

					perdeu = CompraImovel(dado, j, linhaJogadas);

					if (perdeu == 1) {
						listajogador.get(j).setPerdeu(1);
					}
					linhaJogadas++;
				} else if (listaImovel.get(dado).getTipoPosicao() == 7) {
					linhaJogadas++;
				} else {
					linhaJogadas++;
				}

			} else if (listajogador.get(j).getPerdeu() == 1) {
				linhaJogadas++;
			}

			if (NumeroJogadas[0][1] == NumeroJogadas[linhaJogadas][1]) {
				contaRodadas();
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting ComecaJogo()");
		}

	}

	/**
	 * M�todo que faz a contagem das rodadas do Jogo.
	 */
	private void contaRodadas() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering contaRodadas()");
		}
		setNumeroRodadas(getNumeroRodadas() + 1);
		if (logger.isDebugEnabled()) {
			logger.debug("exiting contaRodadas()");
		}
	}

	/**
	 * M�todo que controla o Jogador no tabuleiro, mostrando a posi��o e
	 * adicionando um valor extra de dinheiro quando ele completa a volta no
	 * Tabuleiro.
	 * 
	 * @param dado para controle do Jogador
	 *            
	 * @param j que indica o �ndice
	 *            
	 * 
	 * @return <code>integer[][]</code> especificando a posi��o do Jogador logo
	 *         ap�s a volta completa no Tabuleiro.
	 */
	private int DaVolta(int dado, int j, int linhasJogadas) {

		if (logger.isDebugEnabled()) {
			logger.debug("entering DaVolta(int,int,int)");
			logger.debug("dado: " + dado);
			logger.debug("j: " + j);
			logger.debug("linhasJogadas: " + linhasJogadas);
		}
		dado = NumeroJogadas[linhasJogadas][2];
		dado = dado + listajogador.get(j).getPosicao();

		if (dado >= NumeroTabuleiro[0][0]) {
			dado = dado - NumeroTabuleiro[0][0];
			listajogador.get(j).AdicionaDinheiro(500);
			listajogador.get(j).setVoltas(1);
		}
		listajogador.get(j).setPosicao(dado);
		if (logger.isDebugEnabled()) {
			logger.debug("exiting DaVolta()");
			logger.debug("returning: " + dado);
		}
		return dado;
	}

	/**
	 *M�todo para controlar a Compra dos Im�veis realizada por cada jogador, de forma que
	 *a cada compra seu valor em dinheiro diminui, por�m com a possibilidade de receber um valor
	 *caso os demais jogadores "caiam" na posi��o do Im�vel adiquirido por tal Jogador.
	 * @param dado
	 * @param NJogador
	 * @return <code>Integer</code> indica um valor 0, ou seja nenhum Im�vel foi adiquirido pelo 
	 * Jogador
	 */
	private int CompraImovel(int dado, int NJogador, int linhaJogadas) throws FileNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("entering CompraImovel(int,int,int)");
			logger.debug("dado: " + dado);
			logger.debug("NJogador: " + NJogador);
			logger.debug("linhaJogadas: " + linhaJogadas);
		}
		int n = 0;
		//dado = DaVolta(dado, NJogador, linhaJogadas);
		double valor=0;
		//System.out.println(dado);
		if (listaImovel.get(dado).getPertence() == 6) {
			// Imovel pertence ao banco
			valor = listaImovel.get(dado).getValor();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listaImovel.get(dado).setPertence(listajogador.get(NJogador).getID_Jogador());
				listajogador.get(NJogador).AdicionarGastoEmImoveis(valor);
				new ArquivoLog(" Compro Imovel:"+listaImovel.get(dado).getNome());
				if (logger.isDebugEnabled()){
					logger.debug("exiting CompraImovel()");
					logger.debug("returning: 0");
					}
				return n = 0;
			} else {
				if (logger.isDebugEnabled()){
					logger.debug("exiting CompraImovel()");
					logger.debug("returning: =0");
					}
				// Impossivel compra imovel sem dinherio
				return n = 0;
			}
		} else if (listaImovel.get(dado).getPertence() == 1) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(0).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(0).AdicionarRecebidaAluguel(valor);
				new ArquivoLog("Pagou aluguel para o jogador 1");
				
			} else {
				if (logger.isDebugEnabled()){
					logger.debug("exiting CompraImovel()");
					logger.debug("returning: 1");
					}
				// perdeu
				return n = 1;
			}
		} else if (listaImovel.get(dado).getPertence() == 2) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(1).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(1).AdicionarRecebidaAluguel(valor);
				new ArquivoLog("Pagou aluguel para o jogador 2");
			} else {
				if (logger.isDebugEnabled()){
					logger.debug("exiting CompraImovel()");
					logger.debug("returning:1 ");
					}
				return n = 1;
			}
		} else if (listaImovel.get(dado).getPertence() == 3) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(2).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(2).AdicionarRecebidaAluguel(valor);
				new ArquivoLog("Pagou aluguel para o jogador 3");
			} else {
				if (logger.isDebugEnabled()){
					logger.debug("exiting CompraImovel()");
					logger.debug("returning: 1");
					}
				return n = 1;
			}
		} else if (listaImovel.get(dado).getPertence() == 4) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(3).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(3).AdicionarRecebidaAluguel(valor);
				new ArquivoLog("Pagou aluguel para o jogador 4");
			} else {
				if (logger.isDebugEnabled()){
					logger.debug("exiting CompraImovel()");
					logger.debug("returning: 1");
					}
				return n = 1;
			}
		} else if (listaImovel.get(dado).getPertence() == 5) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(4).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(4).AdicionarRecebidaAluguel(valor);
				new ArquivoLog("Pagou aluguel para o jogador 5");
			} else {
				if (logger.isDebugEnabled()){logger.debug("exiting CompraImovel()");logger.debug("returning:1 ");}
				return n = 1;
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("exiting CompraImovel()");
			logger.debug("returning: " + n);
		}
		return n;
	}

	/**
	 * M�todo de cria��o do Tabuleiro, instancia um novo tabuleiro e carrega os
	 * Im�veis no Tabuleiro atrav�s da lista de Im�veis ListaImovel.
	 */
	private void CriaTabuleiro() throws FileNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("entering CriaTabuleiro()");
		}
		Tabuleiro t = new Tabuleiro();
		t.CriarTabuleiro();
		setListaImovel(t.getListaImovel());
		setNumeroTabuleiro(t.getNumeroTabuleiro());
		new ArquivoLog("Criando Tabuleiro...");
		if (logger.isDebugEnabled()) {
			logger.debug("exiting CriaTabuleiro()");
		}
	}

	/**
	 * M�todo para adicionar os Jogadores no jogo, instancia um novo Jogador e
	 * adciona na lista de Jogadores Listajogador.
	 */
	private void AdicionaJogadores() throws FileNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("entering AdicionaJogadores()");
		}
		Add_Jogador AddJ = new Add_Jogador();
		AddJ.AdicionarJogadores();
		setListajogador(AddJ.getListajogador());
		if (logger.isDebugEnabled()) {
			logger.debug("exiting AdicionaJogadores()");
		}
	}

	/**
	 * M�todo para contolar as jogadas realizadas pelos jogadores, instancia o
	 * m�todo CarregarJogadas e carrega as jogadas do Tabuleiro.
	 */
	private void PegarJogadas() throws FileNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("entering PegarJogadas()");
		}
		CarregarJogadas c = new CarregarJogadas();
		c.CarregaJogadas();
		setNumeroJogadas(c.getNumeroTabuleiro());
		if (logger.isDebugEnabled()) {
			logger.debug("exiting PegarJogadas()");
		}
	}

	/**
	 * M�todo para mostrar os Resultados do jogo, mostrando o jogador, o valor
	 * em dinheiro, o im�vel e o valor recebido por ele, al�m do n�mero de
	 * voltas que ele deu no Tabuleiro, e o gasto feito pela compra do
	 * Im�vel(is).
	 */
	public void verJogadores() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering verJogadores()");
		}
		for (int i = 0; i < listajogador.size(); i++) {
			System.out.println("Jogador: " + listajogador.get(i).getID_Jogador());
			System.out.println("Dinheiro: " + listajogador.get(i).getDinheiro());
			System.out.println("Voltas: " + listajogador.get(i).getVoltas());
			System.out.println("aluguel: " + listajogador.get(i).getValorPagoemAluguel());
			System.out.println("Recebido Aluguel: " + listajogador.get(i).getRecebidaEmAluguel());
			System.out.println("Gasto Imovel: " + listajogador.get(i).getGastoEmImoveis());
			System.out.println("Passa vez: " + listajogador.get(i).getPassaVez());
			System.out.println("");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting verJogadores()");
		}
	}

	/**
	 * M�todo para mostrar o Tabuleiro, indica o Im�vel e o Jogador que o
	 * adiquiriu.
	 */
	public void verTabuleiro() {

		if (logger.isDebugEnabled()) {
			logger.debug("entering verTabuleiro()");
		}
		for (int i = 0; i < listaImovel.size(); i++) {
			System.out.println(" " + listaImovel.get(i).getNome() + "|" + " Dono Jogador: "
					+ listaImovel.get(i).getPertence() + "taxa: " + listaImovel.get(i).getTaxa_aluguel());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting verTabuleiro()");
		}
	}

	/**
	 * @return <code>Integer[][]</code> indica a posi��o dos Jogadores no
	 *         Tabuleiro.
	 */
	public int[][] getNumeroTabuleiro() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getNumeroTabuleiro()");
			logger.debug("exiting getNumeroTabuleiro()");
			logger.debug("returning: " + NumeroTabuleiro);
		}
		return NumeroTabuleiro;
	}

	/**
	 * @param numeroTabuleiro
	 *            Indica a posi��o do Jogador no Tabuleiro.
	 */
	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setNumeroTabuleiro(int[][])");
			logger.debug("numeroTabuleiro: " + numeroTabuleiro);
		}
		NumeroTabuleiro = numeroTabuleiro;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setNumeroTabuleiro()");
		}
	}

	/**
	 * @return <code>ArrayList</code> Indica a lista de Jogadores.
	 */
	public ArrayList<Jogador> getListajogador() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getListajogador()");
			logger.debug("exiting getListajogador()");
			logger.debug("returning: " + listajogador);
		}
		return listajogador;
	}

	/**
	 * 
	 * @param listajogador
	 *            Seta os valores da lista de Jogadores.
	 */
	public void setListajogador(ArrayList<Jogador> listajogador) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setListajogador(ArrayList<Jogador>)");
			logger.debug("listajogador: " + listajogador);
		}
		this.listajogador = listajogador;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setListajogador()");
		}
	}

	/**
	 * 
	 * @return <code>ArrayList</code> Indica a lista de Im�veis.
	 */
	public ArrayList<Imovel> getListaImovel() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getListaImovel()");
			logger.debug("exiting getListaImovel()");
			logger.debug("returning: " + listaImovel);
		}
		return listaImovel;
	}

	/**
	 * 
	 * @param listaImovel
	 *            Seta os valores da lista de Im�veis.
	 */
	public void setListaImovel(ArrayList<Imovel> listaImovel) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setListaImovel(ArrayList<Imovel>)");
			logger.debug("listaImovel: " + listaImovel);
		}
		this.listaImovel = listaImovel;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setListaImovel()");
		}
	}

	/**
	 * 
	 * @return <code>Integer[][]</code> Indica o n�mero de Jogadas realizadas.
	 */
	public int[][] getNumeroJogadas() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getNumeroJogadas()");
			logger.debug("exiting getNumeroJogadas()");
			logger.debug("returning: " + NumeroJogadas);
		}
		return NumeroJogadas;
	}

	/**
	 * 
	 * @param numeroJogadas
	 *            Seta o n�mero de Jogadas realizadas.
	 */
	public void setNumeroJogadas(int[][] numeroJogadas) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setNumeroJogadas(int[][])");
			logger.debug("numeroJogadas: " + numeroJogadas);
		}
		NumeroJogadas = numeroJogadas;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setNumeroJogadas()");
		}
	}

	/**
	 * 
	 * @return <code>Integer</code> Indica o n�mero de Jogadas realizadas.
	 */
	public int getNumeroRodadas() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getNumeroRodadas()");
			logger.debug("exiting getNumeroRodadas()");
			logger.debug("returning: " + numeroRodadas);
		}
		return numeroRodadas;
	}

	/**
	 * 
	 * @param numeroRodadas
	 *            Seta o n�mero de Jogadas realizadas.
	 */
	public void setNumeroRodadas(int numeroRodadas) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setNumeroRodadas(int)");
			logger.debug("numeroRodadas: " + numeroRodadas);
		}
		this.numeroRodadas = numeroRodadas;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setNumeroRodadas()");
		}
	}

}
