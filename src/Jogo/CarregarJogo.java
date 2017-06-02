package Jogo;

import java.util.ArrayList;



import Jogadas.CarregarJogadas;
import Tabuleiro.Tabuleiro;
import TiposImoveis.Imovel;

public class CarregarJogo {

	private int[][] NumeroTabuleiro = new int[100][100];
	private int[][] NumeroJogadas = new int[100][100];
	private ArrayList<Jogador> listajogador = new ArrayList<Jogador>();
	private ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	private int numeroRodadas=0;

	public void CarregaVariaveis() {
		CriaTabuleiro();
		AdicionaJogadores();
		PegarJogadas();
		 //verJogadores();
		 //verTabuleiro();
	}

	public void ComecaJogo() {
		CarregaVariaveis();
		PosicaoInicio();
		int n = 0;
		int perdeu = 0;
		int linhaJogadas = 1;
		while (n == 0) {
			int j = QuemJoga(linhaJogadas);
			
			if(NumeroTabuleiro[0][0] == linhaJogadas){
				n=1;
			}
			else if (listajogador.get(j).getPerdeu() == 0) {
				int dado = NumeroJogadas[linhaJogadas][2];
				//dado = DaVolta(dado, j);
				
				if (listaImovel.get(dado).getTipoPosicao() == 2) {
					// passa vez
					DaVolta(dado, j);
					listajogador.get(j).setPassaVez(1);
					linhaJogadas++;
				} else if (listaImovel.get(dado).getTipoPosicao() == 3) {
					
					perdeu = CompraImovel(dado, j);
					
					if (perdeu == 1) {
						listajogador.get(j).setPerdeu(1);
					}
					linhaJogadas++;
				}
				
				else{
					n=1;
				}
				
			}
			else{
				linhaJogadas++;
			}
			if(NumeroJogadas[0][1]==NumeroJogadas[linhaJogadas][1]){
				contaRodadas();
			}
		}
		//System.out.println(numeroRodadas);
		

	}
	private void contaRodadas(){
		setNumeroRodadas(getNumeroRodadas() + 1);	
	}

	private void PosicaoInicio() {
		int linhatabuleiro = 1;
		if (NumeroTabuleiro[linhatabuleiro][2] == 1) {
			for (int i = 0; i < listajogador.size(); i++) {
				listajogador.get(i).setPosicao(0);
			}
		}
	}

	private int QuemJoga(int linhaJogador) {
		int n;
		n = NumeroJogadas[linhaJogador][1];
		//System.out.println(n);
		return n - 1;
	}
	private int DaVolta(int dado, int j){
		dado = dado + listajogador.get(j).getPosicao();
		
		if (dado >= listaImovel.size()) {
			dado = dado - listaImovel.size();
			listajogador.get(j).AdicionaDinheiro(200);
			listajogador.get(j).setVoltas(listajogador.get(j).getVoltas()+1);
		}
		listajogador.get(j).setPosicao(dado);
		return dado;
	}

	private int CompraImovel(int dado, int NJogador) {
		int n = 0;
		dado = DaVolta(dado, NJogador);
		double valor=0;
		//System.out.println(dado);
		if (listaImovel.get(dado).getPertence() == 6) {
			// Imovel pertence ao banco
			valor = listaImovel.get(dado).getValor();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listaImovel.get(dado).setPertence(listajogador.get(NJogador).getID_Jogador());
				listajogador.get(NJogador).AdicionarGastoEmImoveis(valor);
				return n = 0;
			} else {
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
				
			} else {
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
			} else {
				return n = 1;
			}
		} else if (listaImovel.get(dado).getPertence() == 3) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(2).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(2).AdicionarRecebidaAluguel(valor);
			} else {
				return n = 1;
			}
		} else if (listaImovel.get(dado).getPertence() == 4) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(3).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(3).AdicionarRecebidaAluguel(valor);
			} else {
				return n = 1;
			}
		} else if (listaImovel.get(dado).getPertence() == 5) {
			valor = listaImovel.get(dado).getTaxa_aluguel();
			if (listajogador.get(NJogador).getDinheiro() >= valor) {
				listajogador.get(NJogador).RetiraDinheiro(valor);
				listajogador.get(4).AdicionaDinheiro(valor);
				listajogador.get(NJogador).AdicionarValorPagoemAluguel(valor);
				listajogador.get(4).AdicionarRecebidaAluguel(valor);
			} else {
				return n = 1;
			}
		}

		return n;
	}

	private void CriaTabuleiro() {
		Tabuleiro t = new Tabuleiro();
		t.CriarTabuleiro();
		setListaImovel(t.getListaImovel());
		setNumeroTabuleiro(t.getNumeroTabuleiro());
	}

	private void AdicionaJogadores() {
		Add_Jogador AddJ = new Add_Jogador();
		AddJ.AdicionarJogadores();
		setListajogador(AddJ.getListajogador());
	}

	private void PegarJogadas() {
		CarregarJogadas c = new CarregarJogadas();
		c.CarregaJogadas();
		setNumeroJogadas(c.getNumeroTabuleiro());
	}

	public void verJogadores() {
		for (int i = 0; i < listajogador.size(); i++) {
			System.out.println("Jogador: " + listajogador.get(i).getID_Jogador());
			System.out.println("Dinheiro: " + listajogador.get(i).getDinheiro());
            System.out.println("Voltas: "+ listajogador.get(i).getVoltas());
            System.out.println("aluguel: "+listajogador.get(i).getValorPagoemAluguel());
            System.out.println("Recebido Aluguel: "+ listajogador.get(i).getRecebidaEmAluguel());
            System.out.println("Gasto Imovel: "+ listajogador.get(i).getGastoEmImoveis());
            System.out.println("Passa vez: "+ listajogador.get(i).getPassaVez());
            System.out.println("");
		}
	}

	public void verTabuleiro() {

		for (int i = 0; i < listaImovel.size(); i++) {
			System.out.println(" " + listaImovel.get(i).getNome() + "|"
					+ " Dono Jogador: " + listaImovel.get(i).getPertence()+"taxa: "+listaImovel.get(i).getTaxa_aluguel());
		}
	}

	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	public ArrayList<Jogador> getListajogador() {
		return listajogador;
	}

	public void setListajogador(ArrayList<Jogador> listajogador) {
		this.listajogador = listajogador;
	}

	public ArrayList<Imovel> getListaImovel() {
		return listaImovel;
	}

	public void setListaImovel(ArrayList<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}

	public int[][] getNumeroJogadas() {
		return NumeroJogadas;
	}

	public void setNumeroJogadas(int[][] numeroJogadas) {
		NumeroJogadas = numeroJogadas;
	}

	public int getNumeroRodadas() {
		return numeroRodadas;
	}

	public void setNumeroRodadas(int numeroRodadas) {
		this.numeroRodadas = numeroRodadas;
	}

}
