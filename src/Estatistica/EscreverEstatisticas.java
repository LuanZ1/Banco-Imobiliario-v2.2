package Estatistica;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Jogo.CarregarJogo;
import Jogo.Jogador;

public class EscreverEstatisticas {
	
	
	private ArrayList<Jogador> listajogador = new ArrayList<Jogador>();

	
	public void colocarNoArquivo(){
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
		
	}
	
	public void escrever(String str){		
		
		try {
			FileWriter fr = new FileWriter("Estatistica.txt");
			fr.write(str);			
			fr.close();
			
		} catch (IOException e) {
			
			System.out.println("Falha ao escrever no arquivo");
			e.printStackTrace();
			
		}
	}

}
