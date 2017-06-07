package test_Jogo;

import static org.junit.Assert.*;

import org.junit.Test;

import Jogo.Jogador;
/**
*Banco Imobiliário 
*@author Luan Felipe e Talles Souza
*@version 2.0
*/

public class test_Jogador {

	@Test
	public void testPosicao() {
		Jogador j = new Jogador();
		j.setPosicao(1);
		int posicao;
		posicao = j.getPosicao();
		assertEquals(posicao, 1);
	}
	@Test
	public void testDinherio() {
		Jogador j = new Jogador();
		j.setDinheiro(3000.0);
		double Dinheiro;
		Dinheiro = j.getDinheiro();
		assertTrue(Dinheiro==3000.0);
	}
	@Test
	public void testAdicionaDinherio() {
		Jogador j = new Jogador();
		j.AdicionaDinheiro(30);
		j.AdicionaDinheiro(30);
		double Dinheiro;
		Dinheiro = j.getDinheiro();
		assertTrue(Dinheiro==60);
	}
	@Test
	public void testID_jogador() {
		Jogador j = new Jogador();
		j.setID_Jogador(3);
		int ID;
		ID = j.getID_Jogador();
		assertEquals(ID, 3);
	}
	@Test
	public void testRecebidaAluguel() {
		Jogador j = new Jogador();
		j.AdicionarRecebidaAluguel(40);
		j.AdicionarRecebidaAluguel(50);
		double Recebido;
		Recebido =j.getRecebidaEmAluguel();
		assertTrue(Recebido==90);
	}
	@Test
	public void testvalorPagoemAluguel() {
		Jogador j = new Jogador();
		j.AdicionarValorPagoemAluguel(50);
		j.AdicionarValorPagoemAluguel(50);
		double Recebido;
		Recebido =j.getValorPagoemAluguel();
		assertTrue(Recebido==100);
	}
	@Test
	public void testVoltas() {
		Jogador j = new Jogador();
		j.setVoltas(3);
		int Voltas;
		Voltas =j.getVoltas();
		assertEquals(Voltas, 3);
	}
	@Test
	public void testPerdeu() {
		Jogador j = new Jogador();
		j.setPerdeu(4);
		int Perdeu;
		Perdeu =j.getPerdeu();
		assertEquals(Perdeu, 4);
	}
	@Test
	public void testGastoEmImoveis() {
		Jogador j = new Jogador();
		j.AdicionarGastoEmImoveis(300);
		j.AdicionarGastoEmImoveis(500);
		double Recebido;
		Recebido =j.getGastoEmImoveis();
		assertTrue(Recebido==800);
	}
	@Test
	public void testPassaVez() {
		Jogador j = new Jogador();
		j.setPassaVez(1);
		j.setPassaVez(3);
		int Passavez;
		Passavez =j.getPassaVez();
		assertEquals(Passavez, 4);
	}
	
	
	
}
