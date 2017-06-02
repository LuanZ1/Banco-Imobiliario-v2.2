package Jogo;


public class Jogador {
	private int posicao =0;
	private double dinheiro = 0;
    private int ID_Jogador;
    private double RecebidaAluguel= 0;
    private double valorPagoemAluguel =0;
    private int voltas =0;
    private int perdeu = 0;
    private double gastoEmImoveis=0;
    private int passaVez =0;
    
    
   
	public double getRecebidaEmAluguel() {
		return RecebidaAluguel;
	}
    public void AdicionarRecebidaAluguel(double valor){
    	RecebidaAluguel += valor;
    }
	public int getPosicao(){
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public double getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	public int getID_Jogador() {
		return ID_Jogador;
	}
	public void setID_Jogador(int iD_Jogador) {
		ID_Jogador = iD_Jogador;
	}
	public void AdicionaDinheiro(double valor){
        dinheiro += valor;
    }
    public void RetiraDinheiro(double valor){
        dinheiro -= valor;
    }
	public double getValorPagoemAluguel() {
		return valorPagoemAluguel;
	}
	public void AdicionarValorPagoemAluguel(double valor) {
		valorPagoemAluguel += valor;
	}
	public int getPerdeu() {
		return perdeu;
	}
	public void setPerdeu(int perdeu) {
		this.perdeu = perdeu;
	}
	public int getVoltas() {
		return voltas;
	}
	public void setVoltas(int voltas) {
		this.voltas = voltas;
	}
	public double getGastoEmImoveis() {
		return gastoEmImoveis;
	}
	public void AdicionarGastoEmImoveis(double gastoEmImoveis) {
		this.gastoEmImoveis += gastoEmImoveis;
	}
	public int getPassaVez() {
		return passaVez;
	}
	public void setPassaVez(int passaVez) {
		this.passaVez += passaVez;
	}
}
