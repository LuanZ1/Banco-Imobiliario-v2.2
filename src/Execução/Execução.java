package Execu��o;

import Estatistica.EscreverEstatisticas;
import Jogo.CarregarJogo;

public class Execu��o {
 
    public void Execu�aoJogo(){
    	CarregarJogo c = new CarregarJogo();
		c.ComecaJogo();
		c.verJogadores();
		//c.verTabuleiro();
		EscreverEstatisticas es = new EscreverEstatisticas();
		es.colocarNoArquivo();
    }
	
}
