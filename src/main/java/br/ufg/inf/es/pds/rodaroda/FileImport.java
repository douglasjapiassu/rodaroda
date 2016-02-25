package br.ufg.inf.es.pds.rodaroda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.Temas;

/**
 * Classe responsável por importar os arquivos de texto e retornar em forma de Map (todos os arquivos) ou List (um arquivo apenas).
 *
 * @author douglas.japiassu
 */
public class FileImport {

	/**
	 * Carrega as listas de temas.
	 *
	 * @see Enumerados.Temas
	 * @return Map contendo os conteúdos dos arquivos
	 */
	public Map<Integer, List<String>> carregarListasTemas() {
		Map<Integer, List<String>> temas = new HashMap<Integer, List<String>>();

		for (Temas tema : Temas.values()) {
			temas.put(tema.getIdentificador(), carregaArquivo(tema.getNomeArquivo()));
		}
		return temas;
	}

	/**
	 * Carrega uma lista de acordo com o nome do arquivo passado.
	 *
	 * @param nomeArquivo
	 * @return List contendo os valores do arquivo
	 */
	public List<String> carregaArquivo(String nomeArquivo) {
		List<String> list = new ArrayList<String>();
		try {
			FileReader arq = new FileReader("src/main/resources/" + nomeArquivo + ".txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				list.add(linha);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		return list;
	}
}
