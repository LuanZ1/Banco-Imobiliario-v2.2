package Jogadas;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Banco Imobili�rio
 * 
 * @author Luan Felipe e Talles Souza
 * @version 2.0
 *
 * @see CarregarJogadas M�todo que Carrega as Jogadas do Jogo.
 */

public class CarregarJogadas {

	private int[][] NumeroTabuleiro = new int[100][100];

	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	/**
	 * 
	 * @param numeroTabuleiro
	 *            Especificando o n�mero da posi��o lida no tabuleiro.
	 */

	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	/**
	 * 
	 * 
	 * M�todo que estancia um novo arquivo (arquivo de jogadas) e faz a leitura
	 * das jogadas, instanciando uma nova leitura atrav�s da chamada do m�todo
	 * LerJogadas(), de modo a carregar a jogada atrav�s do tabuleiro.
	 * 
	 *
	 * @throws FileNotFoundException Lan�a a exce��o caso a escrita 
	 * no arquivo Log n�o for realizada com sucesso.
	 */
	public void CarregaJogadas() throws FileNotFoundException {
		File file = new File("jogadas4.txt");
		LerJogadas ler = new LerJogadas();
		ler.LerArquivo1(file);
		setNumeroTabuleiro(ler.getNumeroTabuleiro());

	}
}
