package Jogadas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerJogadas {

	private File file;
	private List<List<String>> listas;
	private int[][] NumeroTabuleiro = new int[100][100];
	public List<List<String>> Lista() {
		return listas;
	}

	public int[][] getNumeroTabuleiro() {
		return NumeroTabuleiro;
	}

	public void setNumeroTabuleiro(int[][] numeroTabuleiro) {
		NumeroTabuleiro = numeroTabuleiro;
	}

	public void LerArquivo1(File file) {

		this.file = file;
		this.listas = new ArrayList<List<String>>();
		this.criaListadeLinhasdoArquivo();
        this.imprimeLista();
		

	}

	private void criaListadeLinhasdoArquivo() {

		List<String> dataFile = getDataFile();
		for (int x = 0; x < dataFile.size(); x++) {

			if (dataFile.get(x).length() >= 0) {
				listas.add(splitLine(dataFile.get(x)));

			} else {
				listas.add(splitLine2(dataFile.get(x)));
			}
		}

	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public void imprimeLista() {
		
		for (int i = 0; i < listas.size(); i++) {
			for (int j = 0; j < listas.get(i).size(); j++) {

				NumeroTabuleiro[i][j] =Integer.parseInt(listas.get(i).get(j));
				//System.out.println(NumeroTabuleiro[i][j]);
				

			}
		}
		
	}

	/** Faz a leitura do arquivo e retorna os dados em uma lista */
	public List<String> getDataFile() {

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
		return data;
	}

	/** Separa cada linha do em arquivo em uma array de elementos */
	public List<String> splitLine(String line) {
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

	

	public List<String> splitLine2(String line) {
		List<String> novo = new ArrayList<String>();

		novo.add(line);

		return novo;
	}

	public List<List<String>> getListas() {
		return listas;
	}

}
