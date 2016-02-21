package br.ufg.inf.es.pds.rodaroda;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;
import br.ufg.inf.es.pds.rodaroda.sorteio.ComportamentoSorteio;

public class Roleta {

	ComportamentoSorteio comportamentoSorteio;
	private Integer numeroSorteio;

	public Roleta(ComportamentoSorteio comportamentoSorteio, Integer numeroSorteio) {
		this.comportamentoSorteio = comportamentoSorteio;
		this.numeroSorteio = numeroSorteio;
	}

	public OpcoesRoleta sortear() {
		comportamentoSorteio.sorteiaNumeros();

		return comportamentoSorteio.pegarValorSorteadoPorNumeroSorteio(getNumeroSorteio());
	}

	public Integer getNumeroSorteio() {
		return numeroSorteio;
	}

}
