package Jogo;
import java.util.ArrayList;

import Jogadas.CarregarJogadas;



public class Add_Jogador {
	
	private int[][] NumeroTabuleiro = new int[100][100];
	private ArrayList<Jogador> listajogador = new ArrayList<Jogador>();
	  
	public void AdicionarJogadores(){
		Jogador[] j = new Jogador[5]; 
		CarregarJogadas c = new CarregarJogadas();
		c.CarregaJogadas();
		setNumeroTabuleiro(c.getNumeroTabuleiro());
		
		int id = 1;
		for (int i = 0; i <NumeroTabuleiro[0][1]; i++) {
			j[i] = new Jogador();
			j[i].setID_Jogador(id);
			j[i].setDinheiro(NumeroTabuleiro[0][2]);
			id++;
			listajogador.add(j[i]);
		}
	}
	
	public void verJogadores(){
		for(int i =0; i<listajogador.size();i++){
			System.out.println("Jogador: " +listajogador.get(i).getID_Jogador());
			System.out.println("Dinheiro: " +listajogador.get(i).getDinheiro());
		}
	}

	public ArrayList<Jogador> getListajogador() {
		return listajogador;
	}
	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}
	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}
	
}
