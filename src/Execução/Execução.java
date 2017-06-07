package Execu��o;

import java.io.FileNotFoundException;

import Estatistica.EscreverEstatisticas;

/**
*Banco Imobili�rio 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
*@see Execu��o  M�todo utilizado para a chamada dos m�todos principais de execu��o do jogo em si,
*instancia um novo jogo atrav�s da chamada CarregarJogo(), e atrav�s dessa chamada,
*carrega os m�todos ComecaJogo() e verJogadores().
*Por �ltimo, instancia as estat�sticas que ser�o geradas pela execu��o do jogo e 
*que ser�o escritas posteriormente no arquivo, atrav�s do m�todo colocarNoArquivo().
*/


public class Execu��o {
 
    public void Execu�aoJogo() throws FileNotFoundException{
    	//CarregarJogo c = new CarregarJogo();
		//c.ComecaJogo();
		//c.verJogadores();
		//c.verTabuleiro();
		EscreverEstatisticas es = new EscreverEstatisticas();
		es.colocarNoArquivo();
    }
	
}
