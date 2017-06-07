package Tabuleiro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Banco Imobiliário
 * 
 * @author Luan Felipe e Talles Souza
 * @version 2.0
 *
 * @see LerTabuleiro Método utilizado para a leitura do Tabuleiro.
 */

public class LerTabuleiro {

	private static final Logger logger = Logger.getLogger(LerTabuleiro.class);
	private File file;
	private List<List<String>> listas;
	private int[][] NumeroTabuleiro = new int[100][100];

	/**
	 * 
	 * @return <code>integer[][]</code> Especificando o número da posição lida
	 *         no tabuleiro.
	 */
	public List<List<String>> Lista() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering Lista()");
			logger.debug("exiting Lista()");
			logger.debug("returning: " + listas);
		}
		return listas;
	}

	/**
	 * 
	 * @return <code>Integer</code> Especicificando a matriz do Tabuleiro.
	 */
	
	public int[][] getNumeroTabuleiro() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getNumeroTabuleiro()");
			logger.debug("exiting getNumeroTabuleiro()");
			logger.debug("returning: " + NumeroTabuleiro);
		}
		return NumeroTabuleiro;
	}

	/**
	 * 
	 * @param numeroTabuleiro
	 *            Indica no Tabuleiro.
	 */
	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering setNumeroTabuleiro(int[][])");
			logger.debug("numeroTabuleiro: " + numeroTabuleiro);
		}
		NumeroTabuleiro = numeroTabuleiro;
		if (logger.isDebugEnabled()) {
			logger.debug("exiting setNumeroTabuleiro()");
		}
	}

	/**
	 * Método que faz a leitura do Arquivo.
	 * 
	 * @param file
	 *            Indica o arquivo
	 */
	public void LerArquivo1(File file) {

		if (logger.isDebugEnabled()) {
			logger.debug("entering LerArquivo1(File)");
			logger.debug("file: " + file);
		}
		this.file = file;
		this.listas = new ArrayList<List<String>>();
		this.criaListadeLinhasdoArquivo();
		this.imprimeLista();
		if (logger.isDebugEnabled()) {
			logger.debug("exiting LerArquivo1()");
		}
	}

	/**
	 * Método utilizado para dividir a string do arquivo txt dado, em partes
	 * menores, utilizando uma lista de strings e o comprimento. Este método que
	 * será essencial para a manipulação dos demais métodos do projeto que
	 * necessitarão das partes divididas das strings para a devida execução.
	 * 
	 */

	private void criaListadeLinhasdoArquivo() {

		if (logger.isDebugEnabled()) {
			logger.debug("entering criaListadeLinhasdoArquivo()");
		}
		List<String> dataFile = getDataFile();
		for (int x = 0; x < dataFile.size(); x++) {

			if (dataFile.get(x).length() >= 0) {
				listas.add(splitLine(dataFile.get(x)));
			} else {
				listas.add(splitLine2(dataFile.get(x)));
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting criaListadeLinhasdoArquivo()");
		}

	}

	/**
	 * Método que controla as listas a partir de uma matriz [i][j] e converte os
	 * valores da lista para inteiros através do método Integer.parseInt.
	 */

	public void imprimeLista() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering imprimeLista()");
		}
		int[][] NumeroTabuleiro = new int[50][50];
		for (int i = 0; i < listas.size(); i++) {
			for (int j = 0; j < listas.get(i).size(); j++) {

				NumeroTabuleiro[i][j] = Integer.parseInt(listas.get(i).get(j));
				setNumeroTabuleiro(NumeroTabuleiro);

			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("exiting imprimeLista()");
		}
	}

	/**
	 * Método que faz a leitura do arquivo e retorna os dados em uma lista.
	 * 
	 * @return <code>String</code> especificando o valor os dados da lista que
	 *         foram lidos.
	 * 
	 *         Exceção getDataFile criada para auxiliar a identificação dos
	 *         métodos que estão com situações de erro.
	 */
	public List<String> getDataFile() {

		if (logger.isDebugEnabled()) {
			logger.debug("entering getDataFile()");
		}
		List<String> data = new ArrayList<String>();
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));

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
		if (logger.isDebugEnabled()) {
			logger.debug("exiting getDataFile()");
			logger.debug("returning: " + data);
		}
		return data;
	}

	/**
	 * Método utilizado para separar cada linha do em arquivo em uma array de
	 * elementos através do método Split, que divide uma string em pequenos
	 * pedaços.
	 * 
	 * @param line
	 *            String que será verificada.
	 * @return <code>String</code> especificando o array de elementos retornado.
	 */
	public List<String> splitLine(String line) {
		if (logger.isDebugEnabled()) {
			logger.debug("entering splitLine(String)");
			logger.debug("line: \"" + line + "\"");
		}
		List<String> novo = new ArrayList<String>();
		String[] split = line.split(";");

		if (split.length <= 0) {
			if (logger.isDebugEnabled()) {
				logger.debug("split.length <= 0");
				logger.debug("exiting splitLine()");
				logger.debug("returning: " + null);
			}
			return null;
		}

		for (String string : split) {
			if (!string.isEmpty())
				novo.add(string);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("exiting splitLine()");
			logger.debug("returning: " + novo);
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
		if (logger.isDebugEnabled()) {
			logger.debug("entering splitLine2(String)");
			logger.debug("line: \"" + line + "\"");
		}
		List<String> novo = new ArrayList<String>();

		novo.add(line);

		if (logger.isDebugEnabled()) {
			logger.debug("exiting splitLine2()");
			logger.debug("returning: " + novo);
		}
		return novo;
	}

	/**
	 * @return <code>String</code> especificando a lista retornada.
	 */
	public List<List<String>> getListas() {
		if (logger.isDebugEnabled()) {
			logger.debug("entering getListas()");
			logger.debug("exiting getListas()");
			logger.debug("returning: " + listas);
		}
		return listas;
	}

}
