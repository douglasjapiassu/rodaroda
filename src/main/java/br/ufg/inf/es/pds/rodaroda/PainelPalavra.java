package br.ufg.inf.es.pds.rodaroda;

import java.util.Observable;

public class PainelPalavra extends Observable {

	private String palavraDigitada;
	private char letraDigitada;
	private String tipo;

	public String getPalavraDigitada() {
		return palavraDigitada;
	}

	public void setPalavraDigitada(String palavraDigitada) {
		this.palavraDigitada = palavraDigitada;

		setChanged();
		notifyObservers();
	}

	public char getLetraDigitada() {
		return letraDigitada;
	}

	public void setLetraDigitada(char letraDigitada) {
		this.letraDigitada = letraDigitada;

		setChanged();
		notifyObservers();
	}

	public String getTipo() {
		return tipo;
	}

}
