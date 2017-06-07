package Jogadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
*Banco Imobiliário 
*@author Luan Felipe e Talles Souza
*@version 2.0
*
*@see LerJogadas Método utilizado para ler as Jogadas do Jogo.
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
	 * @return <code>integer[][]</code> Especificando o número da posição lida
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
	 * Método que faz a leitura do Arquivo.
	 * 
	 * @param file Indica o arquivo
	 *            
	 * @throws FileNotFoundException Lança a exceção caso a escrita 
	 * no arquivo Log não for realizada com sucesso.
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
	 * Método utilizado para dividir a string do arquivo txt dado, em partes
	 * menores, utilizando uma lista de strings e o comprimento. Este método que
	 * será essencial para a manipulação dos demais métodos do projeto que
	 * necessitarão das partes divididas das strings para a devida execução.
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
	 *            String que será verificada.
	 * @return Retorno de um valor verdadeiro para a String com formato
	 *         númerico. Exceção que trata a utilização dos valores da string
	 *         convertidos em um valor de Double através do método
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
	 * Método que controla as listas a partir de uma matriz [i][j] e converte os
	 * valores da lista para inteiros através do método Integer.parseInt.
	 *
	 * @throws FileNotFoundException Lança a exceção caso a escrita 
	 * no arquivo Log não for realizada com sucesso.
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
	 * Método que faz a leitura do arquivo e retorna os dados em uma lista.
	 * 
	 * @return <code>String</code> especificando o valor os dados da lista que
	 *         foram lidos.
	 * 
	 *         Exceção criada para auxiliar a identificação dos métodos que
	 *         estão com situações de erro.
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
	 * Método utilizado para separar cada linha do em arquivo em uma array de
	 * elementos através do método Split, que divide uma string em pequenos
	 * pedaços.
	 * 
	 * @param line String que será verificada.
	 *           
	 * @return <code>String</code> especificando o array de elementos retornado.
	 * @throws FileNotFoundException  Exceção para tratar a leitura do arquivo Estatística.txt, caso ocorra um erro na 
	 * leitura, a seguinte mensagem será mostrada: "Falha ao escrever no arquivo"
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
	 *            String que será verificada.
	 * @return <code>String</code> especificando o novo valor do array que foi
	 *         dividido pelo método Split.
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
