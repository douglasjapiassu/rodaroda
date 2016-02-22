package br.ufg.inf.es.pds.rodaroda;

import java.util.Observable;
import java.util.Observer;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.TipoEstatistica;
import br.ufg.inf.es.pds.rodaroda.util.Util;

public class Estatisticas implements Observer {

	private Integer qtdeSorteios;
	private Integer qtdeAcertosPalavra;
	private Integer qtdeAcertosLetra;


	public Estatisticas() {

	}

	public void update(Observable observado, Object tipo) {
		if (observado instanceof RodaRoda) {
			if (TipoEstatistica.QTDE_SORTEIOS.equals(tipo)) {
				incrementaQtdeSorteio();
			} else if (TipoEstatistica.QTDE_ACERTO_PALAVRA.equals(tipo)) {
				incrementaQtdeAcertosPalavra();
			} else if (TipoEstatistica.QTDE_ACERTO_LETRA.equals(tipo)) {
				incrementaQtdeAcertosLetra();
			}
		}
	}

	private void incrementaQtdeSorteio() {
		qtdeSorteios = Util.nullToZero(qtdeSorteios) + 1;
	}

	private void incrementaQtdeAcertosPalavra() {
		qtdeAcertosPalavra = Util.nullToZero(qtdeAcertosPalavra) + 1;
	}

	private void incrementaQtdeAcertosLetra() {
		qtdeAcertosLetra = Util.nullToZero(qtdeAcertosLetra) + 1;
	}

	public Integer getQtdeSorteios() {
		return Util.nullToZero(qtdeSorteios);
	}

	public Integer getQtdeAcertosPalavra() {
		return Util.nullToZero(qtdeAcertosPalavra);
	}

	public Integer getQtdeAcertosLetra() {
		return Util.nullToZero(qtdeAcertosLetra);
	}

	public void imprimeEstatistica() {
		System.out.println("##### ESTATÍSTICAS #####");
		System.out.println(Util.internacionaliza(TipoEstatistica.QTDE_SORTEIOS.getChave(), getQtdeSorteios()));
		System.out.println(Util.internacionaliza(TipoEstatistica.QTDE_ACERTO_PALAVRA.getChave(), getQtdeAcertosPalavra()));
		System.out.println(Util.internacionaliza(TipoEstatistica.QTDE_ACERTO_LETRA.getChave(), getQtdeAcertosLetra()));
	}

}
