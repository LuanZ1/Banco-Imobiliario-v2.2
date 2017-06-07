package Jogo;

/**
 * Banco Imobili�rio
 * 
 * @author Luan Felipe e Talles Souza
 * @version 2.0
 *
 * @see Jogador M�todo para indicar as principais a��es dos Jogadores, que ser�o
 *      controlados atrav�s das Jogadas no Tabuleiro.
 *
 */

public class Jogador {
	private int posicao = 0;
	private double dinheiro = 0;
	private int ID_Jogador;
	private double RecebidaAluguel = 0;
	private double valorPagoemAluguel = 0;
	private int voltas = 0;
	private int perdeu = 0;
	private double gastoEmImoveis = 0;
	private int passaVez = 0;

	/**
	 * 
	 * @return <code>double</code> especificando o Valor recebido no Aluguel
	 */
	public double getRecebidaEmAluguel() {
		return RecebidaAluguel;
	}

	/**
	 * 
	 * @param valor
	 *            Calcula o Valor do Aluguel que � somado ao valor do dinheiro
	 *            do Jogador.
	 */
	public void AdicionarRecebidaAluguel(double valor) {
		RecebidaAluguel += valor;
	}

	/**
	 * 
	 * @return <code>Integer</code> Especifica a posi��o do Jogador no
	 *         Tabuleiro.
	 */
	public int getPosicao() {
		return posicao;
	}

	/**
	 * 
	 * @param posicao
	 *            Seta a posi��o do Jogador.
	 */
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	/**
	 * 
	 * @return <code>double</code> Especifica o valor em dinheiro possuido pelo
	 *         Jogador.
	 */
	public double getDinheiro() {
		return dinheiro;
	}

	/**
	 * 
	 * @param dinheiro
	 *            Seta o valor em dinheiro do Jogador.
	 */
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	/**
	 * 
	 * @return <code>Integer</code> Especifica o N�mero Identificador de cada
	 *         Jogador.
	 */

	public int getID_Jogador() {
		return ID_Jogador;
	}

	/**
	 * 
	 * @param iD_Jogador
	 *            Seta o valor do id de cada Jogador.
	 */
	public void setID_Jogador(int iD_Jogador) {
		ID_Jogador = iD_Jogador;
	}

	/**
	 * 
	 * @param valor
	 *            Calcula o valor de acr�scimo ao Jogador durante as Jogadas.
	 */
	public void AdicionaDinheiro(double valor) {
		dinheiro += valor;
	}

	/**
	 * 
	 * @param valor
	 *            Calcula o valor que cada Jogador perdeu durante as Jogadas.
	 */
	public void RetiraDinheiro(double valor) {
		dinheiro -= valor;
	}

	/**
	 * 
	 * @return <code>double</code> Espefica o valor que cada Jogador pagou de
	 *         Aluguel durante as Jogadas.
	 */
	public double getValorPagoemAluguel() {
		return valorPagoemAluguel;
	}

	/**
	 * 
	 * @param valor
	 *            Calcula o valor subtra�do do Jogador, pago pelos alugu�is.
	 */
	public void AdicionarValorPagoemAluguel(double valor) {
		valorPagoemAluguel += valor;
	}

	/**
	 * 
	 * @return <code>double</code> Indica que o jogador perdeu o Jogo.
	 */
	public int getPerdeu() {
		return perdeu;
	}

	/**
	 * 
	 * @param perdeu
	 *            Seta o id do Jogador que perdeu o Jogo.
	 */
	public void setPerdeu(int perdeu) {
		this.perdeu = perdeu;
	}

	/**
	 * 
	 * @return <code>Integer</code> Indica o n�mero de voltas dadas pelo
	 *         Jogador.
	 */
	public int getVoltas() {
		return voltas;
	}

	/**
	 * 
	 * @param voltas
	 *            Seta o n�mero de voltas dada pelo Jogador
	 */
	public void setVoltas(int voltas) {
		this.voltas += voltas;
	}

	/**
	 * 
	 * @return <code>double</code> Indica os valores gastos pelos Jogadores nas
	 *         compras dos Im�veis.
	 */
	public double getGastoEmImoveis() {
		return gastoEmImoveis;
	}

	/**
	 * 
	 * @param gastoEmImoveis
	 *            Calcula os valores gastos pelos Jogadores nas compras dos
	 *            Im�veis.
	 */
	public void AdicionarGastoEmImoveis(double gastoEmImoveis) {
		this.gastoEmImoveis += gastoEmImoveis;
	}

	/**
	 * 
	 * @return <code>Integer</code> Indica o que o Jogador passou a vez na
	 *         Jogada.
	 */
	public int getPassaVez() {
		return passaVez;
	}

	/**
	 * 
	 * @param passaVez
	 *            Calcula o n�mero de vezes que o Jogador passou a vez
	 */
	public void setPassaVez(int passaVez) {
		this.passaVez += passaVez;
	}
}
