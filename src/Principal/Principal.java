package Principal;

import java.io.IOException;
import Execu��o.Execu��o;
import Log.ArquivoLog;
import org.apache.log4j.Logger;

/**
*Banco Imobili�rio 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
* M�todo principal do projeto que instancia a execu��o do jogo, atrav�s do m�todo Execu��o
* que pertence ao pacote Execu��o.
* 
* N�o possui retorno, apenas "chama" o m�todo, de maneira a
* passar a responsabilidade a ele e como recurso � modulariza��o. 
*/


public class Principal{
	
	
	private static final Logger logger = Logger.getLogger(Principal.class);

	public static void main(String[] args) throws IOException {
		
	    if (logger.isDebugEnabled()) {
			logger.debug("entering main(String[])");
			logger.debug("args: " + args);
		}
		Execu��o c = new Execu��o();
	    new ArquivoLog("COME�A O JOGO");
	    c.Execu�aoJogo();
	    new ArquivoLog("Acabou Jogo");
	    
	    
	    System.out.println("Acabou");
		if (logger.isDebugEnabled()) {
			logger.debug("exiting main()");
		}
	   
		
		
		
	}
}
