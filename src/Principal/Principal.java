package Principal;

import java.io.IOException;
import Execução.Execução;
import Log.ArquivoLog;
import org.apache.log4j.Logger;

/**
*Banco Imobiliário 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
* Método principal do projeto que instancia a execução do jogo, através do método Execução
* que pertence ao pacote Execução.
* 
* Não possui retorno, apenas "chama" o método, de maneira a
* passar a responsabilidade a ele e como recurso à modularização. 
*/


public class Principal{
	
	
	private static final Logger logger = Logger.getLogger(Principal.class);

	public static void main(String[] args) throws IOException {
		
	    if (logger.isDebugEnabled()) {
			logger.debug("entering main(String[])");
			logger.debug("args: " + args);
		}
		Execução c = new Execução();
	    new ArquivoLog("COMEÇA O JOGO");
	    c.ExecuçaoJogo();
	    new ArquivoLog("Acabou Jogo");
	    
	    
	    System.out.println("Acabou");
		if (logger.isDebugEnabled()) {
			logger.debug("exiting main()");
		}
	   
		
		
		
	}
}
