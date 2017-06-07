package Jogadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
*Banco Imobili�rio 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
*@see LerJogadas M�todo utilizado para ler as Jogadas do Jogo.
*/

import Log.ArquivoLog;

public class LerJogadas {

	private File file;
	private List<List<String>> listas;
	private int[][] NumeroTabuleiro = new int[100][100];

	public List<List<String>> Lista() {
		return listas;
	}

	/**
	 * 
	 * @return <code>integer[][]</code> Especificando o n�mero da posi��o lida
	 *         no tabuleiro.
	 */

	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	/**
	 * 
	 * @param numeroTabuleiro
	 *            Indica no Tabuleiro.
	 */

	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	/**
	 * 
	 * M�todo que faz a leitura do Arquivo.
	 * 
	 * @param file Indica o arquivo
	 *            
	 * @throws FileNotFoundException Lan�a a exce��o caso a escrita 
	 * no arquivo Log n�o for realizada com sucesso.
	 */

	public void LerArquivo1(File file) throws FileNotFoundException {

		this.file = file;
		this.listas = new ArrayList<List<String>>();
		this.criaListadeLinhasdoArquivo();
		new ArquivoLog("Tirando '%'");
		new ArquivoLog("Tirando ';'");
		this.imprimeLista();

	}

	/**
	 * M�todo utilizado para dividir a string do arquivo txt dado, em partes
	 * menores, utilizando uma lista de strings e o comprimento. Este m�todo que
	 * ser� essencial para a manipula��o dos demais m�todos do projeto que
	 * necessitar�o das partes divididas das strings para a devida execu��o.
	 * 
	 */

	private void criaListadeLinhasdoArquivo() throws FileNotFoundException {

		List<String> dataFile = getDataFile();
		for (int x = 0; x < dataFile.size(); x++) {

			if (dataFile.get(x).length() >= 0) {
				listas.add(splitLine(dataFile.get(x)));

			} else {
				listas.add(splitLine2(dataFile.get(x)));
			}
		}

	}

	/**
	 * 
	 * @param str
	 *            String que ser� verificada.
	 * @return Retorno de um valor verdadeiro para a String com formato
	 *         n�merico. Exce��o que trata a utiliza��o dos valores da string
	 *         convertidos em um valor de Double atrav�s do m�todo
	 *         Double.parseDouble(str).
	 */

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * M�todo que controla as listas a partir de uma matriz [i][j] e converte os
	 * valores da lista para inteiros atrav�s do m�todo Integer.parseInt.
	 *
	 * @throws FileNotFoundException Lan�a a exce��o caso a escrita 
	 * no arquivo Log n�o for realizada com sucesso.
	 */

	public void imprimeLista() throws FileNotFoundException {

		for (int i = 0; i < listas.size(); i++) {
			for (int j = 0; j < listas.get(i).size(); j++) {

				NumeroTabuleiro[i][j] = Integer.parseInt(listas.get(i).get(j));

			}
		}
		new ArquivoLog("Jogadas Armazenadas no Vetor...");

	}

	/**
	 * M�todo que faz a leitura do arquivo e retorna os dados em uma lista.
	 * 
	 * @return <code>String</code> especificando o valor os dados da lista que
	 *         foram lidos.
	 * 
	 *         Exce��o criada para auxiliar a identifica��o dos m�todos que
	 *         est�o com situa��es de erro.
	 */
	public List<String> getDataFile() {

		List<String> data = new ArrayList<String>();
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));
			new ArquivoLog("Lendo arquivo Jogadas...");
			try {

				while (br.ready()) {
					String line = br.readLine();
					data.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return data;
	}

	/**
	 * 
	 * M�todo utilizado para separar cada linha do em arquivo em uma array de
	 * elementos atrav�s do m�todo Split, que divide uma string em pequenos
	 * peda�os.
	 * 
	 * @param line String que ser� verificada.
	 *           
	 * @return <code>String</code> especificando o array de elementos retornado.
	 * @throws FileNotFoundException  Exce��o para tratar a leitura do arquivo Estat�stica.txt, caso ocorra um erro na 
	 * leitura, a seguinte mensagem ser� mostrada: "Falha ao escrever no arquivo"
	 */

	public List<String> splitLine(String line) throws FileNotFoundException {
		List<String> novo = new ArrayList<String>();

		String[] split = line.split("%");
		String[] split1 = line.split(";");
		if (split.length <= 0) {

			return null;

		}
		if (split1.length <= 0) {

			return null;

		}

		for (String string : split) {

			if (!string.isEmpty()) {
				if (isNumeric(string) == true) {
					novo.add(string);
				}
				for (String string1 : split1) {
					if (!string1.isEmpty()) {

						if (isNumeric(string1) == true) {
							novo.add(string1);
						}
					}
				}
			}

		}

		return novo;
	}

	/**
	 * @param line
	 *            String que ser� verificada.
	 * @return <code>String</code> especificando o novo valor do array que foi
	 *         dividido pelo m�todo Split.
	 */

	public List<String> splitLine2(String line) {
		List<String> novo = new ArrayList<String>();

		novo.add(line);

		return novo;
	}

	/**
	 * @return <code>String</code> especificando a lista retornada.
	 */

	public List<List<String>> getListas() {
		return listas;
	}

}
