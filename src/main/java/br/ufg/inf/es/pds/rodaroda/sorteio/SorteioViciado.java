package br.ufg.inf.es.pds.rodaroda.sorteio;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.NumeroOpcao;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;

/**
 * Estratégia de sorteio Viciado. Sempre que for o 2º sorteio seguido de um Jogador, a opção sorteada será {@link OpcoesRoleta#PASSA_VEZ}
 *
 */
public class SorteioViciado extends Sorteio implements ComportamentoSorteio {

	public OpcoesRoleta pegarValorSorteadoPorNumeroSorteio(Integer numeroSorteio) {
		if (numeroSorteio.equals(2)) {
			return OpcoesRoleta.PASSA_VEZ;
		}

		Integer numero = possibilidadesDeSorteio.get(numeroSorteio - 1);
		return NumeroOpcao.fromNumero(numero);
	}

}
