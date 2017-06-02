package Jogadas;

import java.io.File;


public class CarregarJogadas {
	
	private int[][] NumeroTabuleiro = new int[100][100];
    
	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}



	public void CarregaJogadas() {
		File file = new File("jogadas4.txt");
		LerJogadas ler = new LerJogadas();
		ler.LerArquivo1(file);
		setNumeroTabuleiro(ler.getNumeroTabuleiro());
		
		
	}
}
