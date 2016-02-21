package br.ufg.inf.es.pds.rodaroda;

import br.ufg.inf.es.pds.rodaroda.util.Util;

public class Jogador {

	private Integer identificacao;
	private String nome;
	private Integer qtdeSorteios;
	private Integer qtdeErros;
	private Integer pontuacao;

	public Integer getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(Integer identificacao) {
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdeSorteios() {
		return Util.nullToZero(qtdeSorteios);
	}

	public void setQtdeSorteios(Integer qtdeSorteios) {
		this.qtdeSorteios = qtdeSorteios;
	}

	public Integer getQtdeErros() {
		return Util.nullToZero(qtdeErros);
	}

	public void setQtdeErros(Integer qtdeErros) {
		this.qtdeErros = qtdeErros;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void adicionaPontuacao(Integer pontuacao) {
		this.pontuacao = Util.nullToZero(this.pontuacao);
		this.pontuacao += pontuacao;
		this.imprimePontuacao();
	}

	public void imprimePontuacao() {
		System.out.println(Util.internacionaliza("jogador.pontuacao", getPontuacao()));
	}

	public void incrementaQtdeSorteios() {
		this.qtdeSorteios = Util.nullToZero(this.qtdeSorteios);
		this.qtdeSorteios++;
	}

	public void incrementaQtdeErros() {
		this.qtdeErros = Util.nullToZero(this.qtdeErros);
		this.qtdeErros++;
	}

}
