package br.ufg.inf.es.pds.rodaroda;

import java.util.Observable;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.TipoResposta;

public class PainelPalavra extends Observable {

	private String palavraDigitada;
	private char letraDigitada;
	private Integer tipo;

	public String getPalavraDigitada() {
		return palavraDigitada;
	}

	public void setPalavraDigitada(String palavraDigitada) {
		this.palavraDigitada = palavraDigitada;
		tipo = TipoResposta.PALAVRA.getTipo();

		setChanged();
		notifyObservers();
	}

	public char getLetraDigitada() {
		return letraDigitada;
	}

	public void setLetraDigitada(char letraDigitada) {
		this.letraDigitada = letraDigitada;
		tipo = TipoResposta.LETRA.getTipo();

		setChanged();
		notifyObservers();
	}

	public Integer getTipo() {
		return tipo;
	}

}
