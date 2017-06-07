package TiposImoveis;

/**
 **Banco Imobiliario 
 *@author Luan Felipe e Talles Souza
 *@version 2.0
 *
 * @see Vazio M�todo "filho" que herda os atributos do m�todo "pai" do tipo Imovel
 *  por�m com as caracter�sticas e expecifica��es de um Im�vel Vazio (nulo).  
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
