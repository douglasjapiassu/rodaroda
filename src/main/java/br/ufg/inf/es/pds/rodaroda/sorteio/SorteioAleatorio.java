package br.ufg.inf.es.pds.rodaroda.sorteio;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.NumeroOpcao;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;

/**
 * Estratégia de sorteio Aleatório. Apenas retira o número selecionado da lista embaralhada.
 *
 */
public class SorteioAleatorio extends Sorteio implements ComportamentoSorteio {

	public OpcoesRoleta pegarValorSorteadoPorNumeroSorteio(Integer numeroSorteio) {
		Integer numero = possibilidadesDeSorteio.get(numeroSorteio - 1);
		return NumeroOpcao.fromNumero(numero);
	}

}
