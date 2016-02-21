package br.ufg.inf.es.pds.rodaroda;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;
import br.ufg.inf.es.pds.rodaroda.sorteio.ComportamentoSorteio;

public class Roleta {

	ComportamentoSorteio comportamentoSorteio;

	public Roleta(ComportamentoSorteio comportamentoSorteio) {
		this.comportamentoSorteio = comportamentoSorteio;
	}

	public OpcoesRoleta sortear(Integer numeroSorteio) {
		comportamentoSorteio.sorteiaNumeros();

		return comportamentoSorteio.pegarValorSorteadoPorNumeroSorteio(numeroSorteio);
	}

}
