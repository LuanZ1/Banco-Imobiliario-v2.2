package Jogo;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Jogadas.CarregarJogadas;
import Log.ArquivoLog;
import org.apache.log4j.Logger;

/**
 **Banco Imobiliario 
 *@author Luan Felipe e Talles Souza
 *@version 2.0
 *
 * @see Add_Jogador Método utilizado para adicionar os Jogadores, na qual cada Jogador será instanciado
 * como novo, obtendo um id próprio e posteriormente suas jogadas serão instanciadas,
 * de forma que elas indicarão a posição no Tabuleiro e o Valor do Dinheiro que cada um possui,
 * de modo que eles serão adicionados na lista de Jogadores. 
 */



public class Add_Jogador {
	
	private static final Logger logger = Logger.getLogger(Add_Jogador.class);
	private int[][] NumeroTabuleiro = new int[100][100];
	private ArrayList<Jogador> listajogador = new ArrayList<Jogador>();
	  
	public void AdicionarJogadores() throws FileNotFoundException{
		if (logger.isDebugEnabled()) {
			logger.debug("entering AdicionarJogadores()");
		}
		Jogador[] j = new Jogador[5]; 
		CarregarJogadas c = new CarregarJogadas();
		c.CarregaJogadas();
		setNumeroTabuleiro(c.getNumeroTabuleiro());
		
		int id = 1;
		for (int i = 0; i <NumeroTabuleiro[0][1]; i++) {
			j[i] = new Jogador();
			j[i].setID_Jogador(id);
			j[i].setDinheiro(NumeroTabuleiro[0][2]);
			id++;
			listajogador.add(j[i]);
		}
		new ArquivoLog("Adicionando Jogadores...");
		if (logger.isDebugEnabled()) {
			logger.debug("exiting AdicionarJogadores()");
		}
	}
	
	/**
	 * Método que mostra os Jogadores e o Valor em dinheiro que cada um possui,
	 * através da lista de jogadores "listajogador.size()".
	 */
	
	public void verJogadores(){
		if (logger.isDebugEnabled()) {
			logger.debug("entering verJogadores()");
		}
		for(int i =0; i<listajogador.size();i++){
			System.out.println("Jogador: " +listajogador.get(i).getID_Jogador());
			System.out.println("Dinheiro: " +listajogador.get(i).getDinheiro());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting verJogadores()");
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
	 * @return <code>Integer[][]</code> Indica a posição dos Jogadores no Tabuleiro.
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
	 * @param numeroTabuleiro Indica a posição do Jogador no Tabuleiro.
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
	
	
}
