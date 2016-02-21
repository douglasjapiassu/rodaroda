package br.ufg.inf.es.pds.rodaroda.sorteio;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.NumeroOpcao;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;

public class SorteioViciado extends Sorteio implements ComportamentoSorteio {

	public OpcoesRoleta pegarValorSorteadoPorNumeroSorteio(Integer numeroSorteio) {
		if (numeroSorteio.equals(2)) {
			return OpcoesRoleta.PASSA_VEZ;
		}

		Integer numero = possibilidadesDeSorteio.get(numeroSorteio - 1);
		return NumeroOpcao.fromNumero(numero);
	}

}
