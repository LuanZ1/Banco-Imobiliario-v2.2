package TiposImoveis;

import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
**Banco Imobiliario 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
*@see Imovel Método para indicar as principais atributos dos Imóveis, que serão controlados
*através das Jogadas no Tabuleiro.
*/
public class Imovel{
	 
	private static final Logger logger = Logger.getLogger(Imovel.class);
	private String nome;
	private double valor;
	private double taxa_aluguel;
	private int Pertence = 6;
	private ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	private int TipoPosicao;
	
	/**
	 * @return <code>integer</code> Referenciando a posse do Imóvel.
	 */
	public int getPertence() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getPertence()");
			logger.debug("exiting getPertence()");
			logger.debug("returning: " + Pertence);
		}
		return Pertence;
	}
	
	/**
	 * @param pertence Seta o Imóvel pertencente ao Jogador.
	 */
	public void setPertence(int pertence) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setPertence(int)");
			logger.debug("pertence: " + pertence);
		}
		Pertence = pertence;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setPertence()");
		}
	}
	
	/**
	 * @return <code>string</code> Especificando o nome do Imóvel.
	 */
	public String getNome() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getNome()");
			logger.debug("exiting getNome()");
			logger.debug("returning: " + nome);
		}
		return nome;
	}
	
	/**
	 * @param nome Seta o nome do Imóvel.
	 */
	public void setNome(String nome) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setNome(String)");
			logger.debug("nome: \"" + nome + "\"");
		}
		this.nome = nome;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setNome()");
		}
	}
	
	/**
	 * @return <code>double</code> Especificando o valor para a compra de cada Imóvel.
	 */
	public double getValor() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getValor()");
			logger.debug("exiting getValor()");
			logger.debug("returning: " + valor);
		}
		return valor;
	}
	
	/**
	 * @param valor Seta o valor do Imóvel para ser adquirido.
	 */
	public void setValor(double valor) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setValor(double)");
			logger.debug("valor: " + valor);
		}
		this.valor = valor;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setValor()");
		}
	}
	
	/**
	 * @return <code>double</code> Especificando o valor da Taxa de Aluguel de cada Imóvel.
	 */
	public double getTaxa_aluguel() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getTaxa_aluguel()");
			logger.debug("exiting getTaxa_aluguel()");
			logger.debug("returning: " + taxa_aluguel);
		}
		return taxa_aluguel;
	}
	
	/**
	 * @param taxa_aluguel Seta a taxa de Aluguel para o Imóvel adquirido.
	 */
	public void setTaxa_aluguel(double taxa_aluguel) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setTaxa_aluguel(double)");
			logger.debug("taxa_aluguel: " + taxa_aluguel);
		}
		this.taxa_aluguel = taxa_aluguel;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setTaxa_aluguel()");
		}
	}
	
	/**
	 * @return <code>Imovel</code> Retorno do método que indica um Imóvel do tipo Comercio.
	 * 
	 */
	public Imovel geraComercio(){
		if (logger.isDebugEnabled()) {
			logger.debug("entering geraComercio()");
			logger.debug("exiting geraComercio()");
		}
		return geraComercio();
	}
	
	/**
	 * @return <code>Imovel</code> Retorno do método que indica um Imóvel do tipo Hospital.
	 * 
	 */
	public Imovel geraHospital(){
		if (logger.isDebugEnabled()) {
			logger.debug("entering geraHospital()");
			logger.debug("exiting geraHospital()");
		}
		return geraHospital();
	}
	
	/**
	 * @return <code>Imovel</code> Retorno do método que indica um Imóvel do tipo Residencia.
	 * 
	 */
	public Imovel geraResidencia(){
		if (logger.isDebugEnabled()) {
			logger.debug("entering geraResidencia()");
			logger.debug("exiting geraResidencia()");
		}
		return geraResidencia();
	}
	
	/**
	 * @return <code>Imovel</code> Retorno do método que indica um Imóvel do tipo Industria.
	 * 
	 */
	public Imovel geraIndustria(){
		if (logger.isDebugEnabled()) {
			logger.debug("entering geraIndustria()");
			logger.debug("exiting geraIndustria()");
		}
		return geraIndustria();
	}
	
	/**
	 * @return <code>Imovel</code> Retorno do método que indica um Imóvel do tipo Hotel.
	 * 
	 */
	public Imovel geraHotel(){
		if (logger.isDebugEnabled()) {
			logger.debug("entering geraHotel()");
			logger.debug("exiting geraHotel()");
		}
		return geraHotel();
	}
	
	/**
	 * @return <code>ArrayList</code> Retorno da lista de Imóveis do jogo.
	 */
	public ArrayList<Imovel> getListaImovel() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getListaImovel()");
			logger.debug("exiting getListaImovel()");
			logger.debug("returning: " + listaImovel);
		}
		return listaImovel;
	}
	
	/**
	 * @param listaImovel Seta o Imóvel na lista de Imóveis.
	 */
	public void setListaImovel(ArrayList<Imovel> listaImovel) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setListaImovel(ArrayList<Imovel>)");
			logger.debug("listaImovel: " + listaImovel);
		}
		this.listaImovel = listaImovel;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setListaImovel()");
		}
	}
	
	/**
	 * @return <code>integer</code> Especificando a posição do Imóvel.
	 */
	public int getTipoPosicao() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getTipoPosicao()");
			logger.debug("exiting getTipoPosicao()");
			logger.debug("returning: " + TipoPosicao);
		}
		return TipoPosicao;
	}
	
	/**
	 * @param tipoPosicao Seta a posição do Imóvel
	 */
	public void setTipoPosicao(int tipoPosicao) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setTipoPosicao(int)");
			logger.debug("tipoPosicao: " + tipoPosicao);
		}
		TipoPosicao = tipoPosicao;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setTipoPosicao()");
		}
	}	
}