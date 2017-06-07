package Estatistica;



import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Jogo.CarregarJogo;
import Jogo.Jogador;
import Log.ArquivoLog;
import org.apache.log4j.Logger;

/**
*Banco Imobili�rio 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
* @see EscreverEstatisticas M�todo que escrever� as estat�sticas atrav�s da chamada do m�todo CarregarJogo(),
* que ser� instanciado num novo CarregarJogo() e do m�todo ComecaJogo().
* 
* Utiliza a chamada da lista de jogadores getListajogador() e o n�mero de rodadas do jogo
* getNumeroRodadas().
* Cada atributo das estat�sticas ser� escrito em uma das 7 strings (cada uma representando
* um dado espec�fico caracter�stico do jogo.)
* 
*/

public class EscreverEstatisticas {
	
	
	private static final Logger logger = Logger.getLogger(EscreverEstatisticas.class);
	private ArrayList<Jogador> listajogador = new ArrayList<Jogador>();
    
	
	/**
	 * O m�todo escreve as estat�sticas no arquivo Estat�stica.
	 * @throws FileNotFoundException Retorna a exce��o do Log lan�ado.
	 */
	public void colocarNoArquivo() throws FileNotFoundException{
		if (logger.isDebugEnabled()) {
			logger.debug("entering colocarNoArquivo()");
		}
		CarregarJogo c = new CarregarJogo();
		c.ComecaJogo();
		
		listajogador=c.getListajogador();
		String str1;
		str1="1: "+c.getNumeroRodadas();
		String str2;
		str2="2: ";
	    for(int i=0; i< listajogador.size(); i++){
	    	str2 = str2 + listajogador.get(i).getID_Jogador() +"-"+ listajogador.get(i).getVoltas()+";";
	    }
	    String str3;
	    str3="3: ";
	    for(int i =0; i<listajogador.size();i++){
	    	str3 = str3 + listajogador.get(i).getID_Jogador()+"-"+listajogador.get(i).getDinheiro()+";";
	    }
	    String str4;
	    str4="4: ";
	    for(int i =0; i<listajogador.size();i++){
	    	str4 = str4 + listajogador.get(i).getID_Jogador()+"-"+listajogador.get(i).getRecebidaEmAluguel()+";";
	    }
	    String str5;
	    str5="5: ";
	    for(int i =0; i<listajogador.size();i++){
	    	str5 = str5 + listajogador.get(i).getID_Jogador()+"-"+listajogador.get(i).getValorPagoemAluguel()+";";
	    }
	    String str6;
	    str6="6: ";
	    for(int i =0; i<listajogador.size();i++){
	    	str6 = str6 + listajogador.get(i).getID_Jogador()+"-"+listajogador.get(i).getGastoEmImoveis()+";";
	    }
	    String str7;
	    str7="7: ";
	    for(int i =0; i<listajogador.size();i++){
	    	str7 = str7 + listajogador.get(i).getID_Jogador()+"-"+listajogador.get(i).getPassaVez()+";";
	    }
	    
		escrever(str1+"\r\n"+str2+"\r\n"+str3+"\r\n"+str4+"\r\n"+str5+"\r\n"+str6+"\r\n"+str7);
		if (logger.isDebugEnabled()) {
			logger.debug("exiting colocarNoArquivo()");
		}
		
	}
	

	 /** 
	 * 
	 *
	 * @param str str String que ser� escrita no arquivo de Estat�sticas.
	 * @throws FileNotFoundException Exce��o para tratar a leitura do arquivo Estat�stica.txt, caso ocorra um erro na 
	 * leitura, a seguinte mensagem ser� mostrada: "Falha ao escrever no arquivo"
	 */
	
	public void escrever(String str) throws FileNotFoundException{		
		
		if (logger.isDebugEnabled()) {
			logger.debug("entering escrever(String)");
			logger.debug("str: \"" + str + "\"");
		}
		try {
			FileWriter fr = new FileWriter("Estatistica.txt");
			fr.write(str);			
			fr.close();
			new ArquivoLog("Escrevendo Estatisticas...");
			
		} catch (IOException e) {
			
			
			new ArquivoLog("Falha ao escrever no arquivo");
			e.printStackTrace();
			
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting escrever()");
		}
		
		
	}
	
	

}
