package Jogadas;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Banco Imobiliário
 * 
 * @author Luan Felipe e Talles Souza
 * @version 2.0
 *
 * @see CarregarJogadas Método que Carrega as Jogadas do Jogo.
 */

public class CarregarJogadas {

	private int[][] NumeroTabuleiro = new int[100][100];

	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	/**
	 * 
	 * @param numeroTabuleiro
	 *            Especificando o número da posição lida no tabuleiro.
	 */

	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	/**
	 * 
	 * 
	 * Método que estancia um novo arquivo (arquivo de jogadas) e faz a leitura
	 * das jogadas, instanciando uma nova leitura através da chamada do método
	 * LerJogadas(), de modo a carregar a jogada através do tabuleiro.
	 * 
	 *
	 * @throws FileNotFoundException Lança a exceção caso a escrita 
	 * no arquivo Log não for realizada com sucesso.
	 */
	public void CarregaJogadas() throws FileNotFoundException {
		File file = new File("jogadas4.txt");
		LerJogadas ler = new LerJogadas();
		ler.LerArquivo1(file);
		setNumeroTabuleiro(ler.getNumeroTabuleiro());

	}
}
