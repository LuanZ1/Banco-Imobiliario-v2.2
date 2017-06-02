package Tabuleiro;

import java.io.File;
import java.util.ArrayList;
import TiposImoveis.Comercio;
import TiposImoveis.Hosptal;
import TiposImoveis.Hotel;
import TiposImoveis.Industria;
import TiposImoveis.Residencia;
import TiposImoveis.Vazio;
import TiposImoveis.Imovel;

public class Tabuleiro {

	private ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	
	public ArrayList<Imovel> getListaImovel() {
		return listaImovel;
	}

	public void setListaImovel(ArrayList<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}

	private int[][] NumeroTabuleiro = new int[100][100];
	

	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	public void CriarTabuleiro() {
		File file = new File("tabuleiro1.txt");
		LerTabuleiro ler = new LerTabuleiro();
		ler.LerArquivo1(file);
		setNumeroTabuleiro(ler.getNumeroTabuleiro());
		int j = 0;
		int k = 1;
	    int p = 0;
		int n = NumeroTabuleiro[0][0];
		for (int i = 1; i <= n; i++) {
			
			if (NumeroTabuleiro[i][3] == 1) {
				AdicionarResidencia(k, j, p);
				
				j++;
				k++;
				p++;
			} else if (NumeroTabuleiro[i][3] == 2) {
				AdicionarComercio(k, j, p);
				k++;
				j++;
				p++;
			} else if (NumeroTabuleiro[i][3] == 3) {
				AdicionarIndustria(k, j, p);
				j++;
				k++;
				p++;
			} else if (NumeroTabuleiro[i][3] == 4) {
				AdicionarHotel(k, j, p);
				j++;
				k++;
				p++;
			} else if (NumeroTabuleiro[i][3] == 5) {
				AdicionarHosptal(k, j, p);
				j++;
				k++;
				p++;
			} else if (NumeroTabuleiro[i][3] == 0) {
				AdicionarVazio(k, j, p);
				j++;
				p++;
				k++;
			}
		}
	}
	
	
	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	public void verTabuleiro() {

		for (int i = 0; i < listaImovel.size(); i++) {
			System.out.println(" "+listaImovel.get(i).getTipoPosicao()+" "+listaImovel.get(i).getNome()+" "+listaImovel.get(i).getTaxa_aluguel());
		}
	}
	public void AdicionarResidencia(int k, int j, int p) {
		listaImovel.add(new Residencia());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
	}

	public void AdicionarComercio(int k, int j, int p) {
		listaImovel.add(new Comercio());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		double valor = (NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100;
		listaImovel.get(j).setTaxa_aluguel(valor);
	}

	public void AdicionarIndustria(int k, int j, int p) {
		listaImovel.add(new Industria());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
		
	}

	public void AdicionarHotel(int k, int j, int p) {
		listaImovel.add(new Hotel());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
	}

	public void AdicionarHosptal(int k, int j, int p) {
		listaImovel.add(new Hosptal());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
	}
	public void AdicionarVazio(int k, int j, int p) {
		listaImovel.add(new Vazio());
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
	}

}
