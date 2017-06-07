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

/**
*Banco Imobiliário 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
*@see Tabuleiro Método utilizado para a criação do Tabuleiro, através da chamada do 
*procedimento de leitura do arquivo dos valores do Tabuleiro. O método adiciona cada tipo de imóvel,
*na qual a posição é respeitada pela Regra de Négocio estabelecida.
*/

public class Tabuleiro {

	private ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	
	/**
	 * @return <code>ArrayList</code> retorno da lista de Imóveis do jogo.
	 */
	public ArrayList<Imovel> getListaImovel() {
		return listaImovel;
	}

	/**
	 * 
	 * @param listaImovel Seta a lista de Imóveis.
	 */
	public void setListaImovel(ArrayList<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}

	private int[][] NumeroTabuleiro = new int[100][100];
	

	/**
	 * @return <code>integer[][]</code> retorno da posição específica no Tabuleiro.
	 */
	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	/**
	 * Método que cria a Tabuleiro, através da chamada do arquivo de leitura "tabuleiro.txt"
	 * na qual os Imóveis serão adicionados em cada posição, de acordo com a Regra de Negócio.
	 */
	public void CriarTabuleiro() {
		File file = new File("tabuleiro1.txt");
		LerTabuleiro ler = new LerTabuleiro();
		ler.LerArquivo1(file);
		setNumeroTabuleiro(ler.getNumeroTabuleiro());
		int j = 0;
		int k = 1;
		int n = NumeroTabuleiro[0][0];
		for (int i = 1; i <= n; i++) {
			
			if (NumeroTabuleiro[i][3] == 1) {
				AdicionarResidencia(k, j);
				j++;
				k++;
			} else if (NumeroTabuleiro[i][3] == 2) {
				AdicionarComercio(k, j);
				k++;
				j++;
			} else if (NumeroTabuleiro[i][3] == 3) {
				AdicionarIndustria(k, j);
				j++;
				k++;
			} else if (NumeroTabuleiro[i][3] == 4) {
				AdicionarHotel(k, j);
				j++;
				k++;
			} else if (NumeroTabuleiro[i][3] == 5) {
				AdicionarHosptal(k, j);
				j++;
				k++;
			} else if (NumeroTabuleiro[i][3] == 0) {
				AdicionarVazio(k, j);
				j++;
				k++;
			}
		}
	}
	
	/**
	 * 
	 * @param numeroTabuleiro Seta a posição no Tabuleiro.
	 */
	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	/**
	 * Método para imprimir o tabuleiro, mostrando as "características" preenchidas através 
	 * da Lista de Imóveis instanciada no Tabuleiro.
	 */
	public void verTabuleiro() {

		for (int i = 0; i < listaImovel.size(); i++) {
			System.out.println(" "+listaImovel.get(i).getTipoPosicao()+" "+listaImovel.get(i).getNome()+" "+listaImovel.get(i).getTaxa_aluguel());
		}
	}
	
	/**
	 * Método para adicionar o Imóvel do tipo Residência no Tabuleiro.
	 * 
	 * @param k Indica a Posição no Tabuleiro
	 * @param j Indica o Jogador
	 *  
	 */
	public void AdicionarResidencia(int k, int j) {
		listaImovel.add(new Residencia());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
	}

	/**
	 * Método para adicionar o Imóvel do tipo Comércio no Tabuleiro.
	 * @param k Indica a Posição no Tabuleiro
	 * @param j Indica o Jogador
	 * 
	 */
	public void AdicionarComercio(int k, int j) {
		listaImovel.add(new Comercio());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		double valor = (NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100;
		listaImovel.get(j).setTaxa_aluguel(valor);
	}

	/**
	 * Método para adicionar o Imóvel do tipo Indústria no Tabuleiro.
	  *@param k Indica a Posição no Tabuleiro
	 * @param j Indica o Jogador
	 * 
	 */
	public void AdicionarIndustria(int k, int j) {
		listaImovel.add(new Industria());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
		
	}
	

	/**
	 * Método para adicionar o Imóvel do tipo Hotel no Tabuleiro.
	 * @param k Indica a Posição no Tabuleiro
	 * @param j Indica o Jogador
	 * 
	 */
	public void AdicionarHotel(int k, int j) {
		listaImovel.add(new Hotel());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
	}
	
	/**
	 * Método para adicionar o Imóvel do tipo Hospital no Tabuleiro.
	 * @param k Indica a Posição no Tabuleiro
	 * @param j Indica o Jogador
	 * 
	 */
	public void AdicionarHosptal(int k, int j) {
		listaImovel.add(new Hosptal());
		listaImovel.get(j).setValor(NumeroTabuleiro[k][4]);
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
		listaImovel.get(j).setTaxa_aluguel((NumeroTabuleiro[k][5] * NumeroTabuleiro[k][4])/100);
	}
	
	/**
	 * Método para adicionar o Imóvel do tipo Vazio no Tabuleiro.
	 * @param k Indica a Posição no Tabuleiro
	 * @param j Indica o Jogador
	 * 
	 */
	public void AdicionarVazio(int k, int j) {
		listaImovel.add(new Vazio());
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
	}

}
