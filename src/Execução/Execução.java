package Execução;

import java.io.FileNotFoundException;

import Estatistica.EscreverEstatisticas;

/**
*Banco Imobiliário 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
*@see Execução  Método utilizado para a chamada dos métodos principais de execução do jogo em si,
*instancia um novo jogo através da chamada CarregarJogo(), e através dessa chamada,
*carrega os métodos ComecaJogo() e verJogadores().
*Por último, instancia as estatísticas que serão geradas pela execução do jogo e 
*que serão escritas posteriormente no arquivo, através do método colocarNoArquivo().
*/


public class Execução {
 
    public void ExecuçaoJogo() throws FileNotFoundException{
    	//CarregarJogo c = new CarregarJogo();
		//c.ComecaJogo();
		//c.verJogadores();
		//c.verTabuleiro();
		EscreverEstatisticas es = new EscreverEstatisticas();
		es.colocarNoArquivo();
    }
	
}
