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
*Banco Imobili�rio 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
*@see Tabuleiro M�todo utilizado para a cria��o do Tabuleiro, atrav�s da chamada do 
*procedimento de leitura do arquivo dos valores do Tabuleiro. O m�todo adiciona cada tipo de im�vel,
*na qual a posi��o � respeitada pela Regra de N�gocio estabelecida.
*/

public class Tabuleiro {

	private ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	
	/**
	 * @return <code>ArrayList</code> retorno da lista de Im�veis do jogo.
	 */
	public ArrayList<Imovel> getListaImovel() {
		return listaImovel;
	}

	/**
	 * 
	 * @param listaImovel Seta a lista de Im�veis.
	 */
	public void setListaImovel(ArrayList<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}

	private int[][] NumeroTabuleiro = new int[100][100];
	

	/**
	 * @return <code>integer[][]</code> retorno da posi��o espec�fica no Tabuleiro.
	 */
	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	/**
	 * M�todo que cria a Tabuleiro, atrav�s da chamada do arquivo de leitura "tabuleiro.txt"
	 * na qual os Im�veis ser�o adicionados em cada posi��o, de acordo com a Regra de Neg�cio.
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
	 * @param numeroTabuleiro Seta a posi��o no Tabuleiro.
	 */
	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	/**
	 * M�todo para imprimir o tabuleiro, mostrando as "caracter�sticas" preenchidas atrav�s 
	 * da Lista de Im�veis instanciada no Tabuleiro.
	 */
	public void verTabuleiro() {

		for (int i = 0; i < listaImovel.size(); i++) {
			System.out.println(" "+listaImovel.get(i).getTipoPosicao()+" "+listaImovel.get(i).getNome()+" "+listaImovel.get(i).getTaxa_aluguel());
		}
	}
	
	/**
	 * M�todo para adicionar o Im�vel do tipo Resid�ncia no Tabuleiro.
	 * 
	 * @param k Indica a Posi��o no Tabuleiro
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
	 * M�todo para adicionar o Im�vel do tipo Com�rcio no Tabuleiro.
	 * @param k Indica a Posi��o no Tabuleiro
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
	 * M�todo para adicionar o Im�vel do tipo Ind�stria no Tabuleiro.
	  *@param k Indica a Posi��o no Tabuleiro
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
	 * M�todo para adicionar o Im�vel do tipo Hotel no Tabuleiro.
	 * @param k Indica a Posi��o no Tabuleiro
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
	 * M�todo para adicionar o Im�vel do tipo Hospital no Tabuleiro.
	 * @param k Indica a Posi��o no Tabuleiro
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
	 * M�todo para adicionar o Im�vel do tipo Vazio no Tabuleiro.
	 * @param k Indica a Posi��o no Tabuleiro
	 * @param j Indica o Jogador
	 * 
	 */
	public void AdicionarVazio(int k, int j) {
		listaImovel.add(new Vazio());
		listaImovel.get(j).setTipoPosicao(NumeroTabuleiro[k][2]);
	}

}
