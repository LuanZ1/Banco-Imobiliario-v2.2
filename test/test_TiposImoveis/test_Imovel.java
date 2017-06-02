package test_TiposImoveis;

import static org.junit.Assert.*;



import org.junit.Test;

import TiposImoveis.Imovel;

public class test_Imovel {

	@Test
	public void testNome() {
		Imovel i = new Imovel();
		i.setNome("Hotel");
		String Nome = i.getNome();
		assertEquals(Nome, "Hotel");
	}
	@Test
	public void testValor() {
		Imovel i = new Imovel();
		i.setValor(300);
		double valor = i.getValor();
		assertTrue(valor== 300);
	}
	@Test
	public void testTaxa_aluguel() {
		Imovel i = new Imovel();
		i.setTaxa_aluguel(50);
		double valor = i.getTaxa_aluguel();
		assertTrue(valor== 50);
	}
	@Test
	public void testPertence() {
		Imovel i = new Imovel();
		i.setPertence(5);
		int valor = i.getPertence();
		assertEquals(valor, 5);
	}
	@Test
	public void testVisitas() {
		Imovel i = new Imovel();
		i.setTipoPosicao(3);
		int valor = i.getTipoPosicao();
		assertEquals(valor, 3);
	}
	
	

}
