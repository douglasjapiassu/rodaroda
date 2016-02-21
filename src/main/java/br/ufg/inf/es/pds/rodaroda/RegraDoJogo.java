package br.ufg.inf.es.pds.rodaroda;

import java.util.Observable;
import java.util.Observer;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.TipoResposta;

public class RegraDoJogo implements Observer {


	public RegraDoJogo() {

	}

	public void update(Observable observado, Object arg1) {
		if (observado instanceof PainelPalavra) {
			PainelPalavra painelPalavra = (PainelPalavra) observado;
			if (TipoResposta.LETRA.getTipo().equals(painelPalavra.getTipo())) {

			} else {

			}
		}
	}

}
