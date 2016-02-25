package br.ufg.inf.es.pds.rodaroda.sorteio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.NumeroOpcao;

/**
 * Classe responsável por fazer o sorteio de {@link NumeroOpcao}
 *
 */
public class Sorteio {

	List<Integer> possibilidadesDeSorteio = new ArrayList<Integer>();

	/**
	 * Faz o sorteio dos números guardando as opções disponíveis numa lista e, em seguida, "embaralhando" via {@link Collections#shuffle}
	 */
	public void sorteiaNumeros() {
		for (NumeroOpcao numeroOpcao : NumeroOpcao.values()) {
			possibilidadesDeSorteio.add(numeroOpcao.getNumero());
		}

		Collections.shuffle(possibilidadesDeSorteio);
	}
}
