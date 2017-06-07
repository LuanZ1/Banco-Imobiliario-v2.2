package Log;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import org.apache.log4j.Logger;

public class ArquivoLog {
	
	private static final Logger logger = Logger.getLogger(ArquivoLog.class);
	File Arquivo;
	FileReader FileReader;
	BufferedReader bufferredRead;
	FileWriter fileWriter;
	BufferedWriter bufferedwriter;
	
	

	public ArquivoLog(String erros) throws FileNotFoundException{
		
		EscreverLog(erros);
		
	}
	
	
	private void EscreverLog(String erros) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("entering EscreverLog(String)");
			logger.debug("erros: \"" + erros + "\"");
		}
		Arquivo = new File("Exceptions.log");
		try {
			
			Arquivo = new File("log.log");
			FileReader = new FileReader(Arquivo);
			bufferredRead = new BufferedReader(FileReader);
			Vector<String> texto = new Vector<String>();
			while(bufferredRead.ready()){
				
				texto.add(bufferredRead.readLine());
				
			}
			fileWriter = new FileWriter(Arquivo);
			bufferedwriter = new BufferedWriter(fileWriter);
			for(int i =0;i<texto.size();i++){
				
				bufferedwriter.write(texto.get(i).toString());
				bufferedwriter.newLine();
				
			}
			bufferedwriter.write(erros);
			bufferedwriter.close();
			bufferredRead.close();
			
		} catch (FileNotFoundException e) {
			
			try {
				
				Arquivo.createNewFile();
				EscreverLog(erros);
				
			} catch (IOException e1) {
				
				System.exit(0);
			}
			
		}
		catch(IOException er){
			
			System.exit(0);	
			
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting EscreverLog()");
		}
		
		
		
	}
}
