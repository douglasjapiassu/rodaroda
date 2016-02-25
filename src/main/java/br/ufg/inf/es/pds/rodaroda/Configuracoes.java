package br.ufg.inf.es.pds.rodaroda;

import java.util.List;

/**
 *
 * Classe responsável por manter as informações de configuração do jogo.
 *
 * @author douglas.japiassu
 * @author guilherme.caixeta
 *
 */
public class Configuracoes {

	private Integer qtdeJogadores;
	private Integer qtdePalavrasEtapa;
	private Integer qtdeEtapas;
	private List<Jogador> listaJogadores;

	public Configuracoes() {

	}

	/**
	 * Construtor padrão
	 *
	 * @param qtdeJogadores
	 * @param qtdePalavrasEtapa
	 * @param qtdeEtapas
	 */
	public Configuracoes(Integer qtdeJogadores, Integer qtdePalavrasEtapa, Integer qtdeEtapas) {
		this.qtdeJogadores = qtdeJogadores;
		this.qtdePalavrasEtapa = qtdePalavrasEtapa;
		this.qtdeEtapas = qtdeEtapas;
	}

	public Integer getQtdeJogadores() {
		return qtdeJogadores;
	}

	public void setQtdeJogadores(Integer qtdeJogadores) {
		this.qtdeJogadores = qtdeJogadores;
	}

	public Integer getQtdePalavrasEtapa() {
		return qtdePalavrasEtapa;
	}

	public void setQtdePalavrasEtapa(Integer qtdePalavrasEtapa) {
		this.qtdePalavrasEtapa = qtdePalavrasEtapa;
	}

	public Integer getQtdeEtapas() {
		return qtdeEtapas;
	}

	public void setQtdeEtapas(Integer qtdeEtapas) {
		this.qtdeEtapas = qtdeEtapas;
	}

	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}

	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}

}
