package Execução;

import Estatistica.EscreverEstatisticas;
import Jogo.CarregarJogo;

public class Execução {
 
    public void ExecuçaoJogo(){
    	CarregarJogo c = new CarregarJogo();
		c.ComecaJogo();
		c.verJogadores();
		//c.verTabuleiro();
		EscreverEstatisticas es = new EscreverEstatisticas();
		es.colocarNoArquivo();
    }
	
}
