package br.ufg.inf.es.pds.rodaroda;

public class Configuracoes {

	private Integer qtdeJogadores;
	private Integer qtdePalavrasEtapa;
	private Integer qtdeEtapas;

	public Configuracoes() {

	}

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

}
