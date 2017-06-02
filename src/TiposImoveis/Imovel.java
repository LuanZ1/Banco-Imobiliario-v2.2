package TiposImoveis;

import java.util.ArrayList;


public class Imovel{
	 
	private String nome;
	private double valor;
	private double taxa_aluguel;
	private int Pertence = 6;
	private ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	private int TipoPosicao;
	
	public int getPertence() {
		return Pertence;
	}
	public void setPertence(int pertence) {
		Pertence = pertence;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getTaxa_aluguel() {
		return taxa_aluguel;
	}
	public void setTaxa_aluguel(double taxa_aluguel) {
		this.taxa_aluguel = taxa_aluguel;
	}
	
    
	public Imovel geraComercio(){
		return geraComercio();
	}
	public Imovel geraHospital(){
		return geraHospital();
	}
	public Imovel geraResidencia(){
		return geraResidencia();
	}
	public Imovel geraIndustria(){
		return geraIndustria();
	}
	public Imovel geraHotel(){
		return geraHotel();
	}
	
	public ArrayList<Imovel> getListaImovel() {
		return listaImovel;
	}
	public void setListaImovel(ArrayList<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}
	
	public int getTipoPosicao() {
		return TipoPosicao;
	}
	public void setTipoPosicao(int tipoPosicao) {
		TipoPosicao = tipoPosicao;
	}	
}