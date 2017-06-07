package TiposImoveis;

/**
 **Banco Imobiliario 
 *@author Luan Felipe e Talles Souza
 *@version 2.0
 *
 * @see Vazio Método "filho" que herda os atributos do método "pai" do tipo Imovel
 *  porém com as características e expecificações de um Imóvel Vazio (nulo).  
 *  
 */
public class Vazio extends Imovel {
         
         public Vazio(){
        	 setNome("Vazio");
        	 setPertence(7);
        	 setValor(0);
        	 setTaxa_aluguel(0);
        	 setTipoPosicao(7);
         }
}
