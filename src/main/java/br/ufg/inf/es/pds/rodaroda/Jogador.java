package br.ufg.inf.es.pds.rodaroda;

import br.ufg.inf.es.pds.rodaroda.util.Util;

public class Jogador {

	private Integer identificacao;
	private String nome;
	private Integer qtdeSorteios;
	private Integer qtdeTentativas;
	private Integer pontuacao;
	private Boolean errouPalavra;

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

	public Integer getQtdeTentativas() {
		return Util.nullToZero(qtdeTentativas);
	}

	public void setQtdeTentativas(Integer qtdeTentativas) {
		this.qtdeTentativas = qtdeTentativas;
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
		imprimePontuacao();
	}

	public void imprimePontuacao() {
		System.out.println(Util.internacionaliza("jogador.pontuacao", getNome(), getPontuacao()));
	}

	public void incrementaQtdeSorteios() {
		qtdeSorteios = Util.nullToZero(qtdeSorteios);
		qtdeSorteios++;
	}

	public void incrementaQtdeTentativas() {
		qtdeTentativas = Util.nullToZero(qtdeTentativas);
		qtdeTentativas++;
	}

	public Boolean getErrouPalavra() {
		return errouPalavra;
	}

	public void setErrouPalavra(Boolean errouPalavra) {
		this.errouPalavra = errouPalavra;
	}

}
