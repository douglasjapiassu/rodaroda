package br.ufg.inf.es.pds.rodaroda.sorteio;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;

public interface ComportamentoSorteio {

	void sorteiaNumeros();

	OpcoesRoleta pegarValorSorteadoPorNumeroSorteio(Integer numeroSorteio);

}
