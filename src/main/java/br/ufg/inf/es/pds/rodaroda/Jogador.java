package br.ufg.inf.es.pds.rodaroda;

import br.ufg.inf.es.pds.rodaroda.util.Util;

/**
 * Classe responsável por manter as informações do Jogador.
 *
 * @author guilherme.caixeta
 *
 */
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

	/**
	 * Adiciona a pontuação para o jogador.
	 *
	 * @param pontuacao
	 */
	public void adicionaPontuacao(Integer pontuacao) {
		this.pontuacao = Util.nullToZero(this.pontuacao);
		this.pontuacao += pontuacao;
		imprimePontuacao();
	}

	private void imprimePontuacao() {
		System.out.println(Util.internacionaliza("jogador.pontuacao", getNome(), getPontuacao()));
	}

	/**
	 * Incrementa a quantidade de sorteios realizados.
	 */
	public void incrementaQtdeSorteios() {
		qtdeSorteios = Util.nullToZero(qtdeSorteios);
		qtdeSorteios++;
	}

	/**
	 * Incrementa a quantidade de tentativas realizadas.
	 */
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
