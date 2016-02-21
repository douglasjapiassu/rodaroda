package br.ufg.inf.es.pds.rodaroda.sorteio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.NumeroOpcao;

public class Sorteio {

	List<Integer> possibilidadesDeSorteio = new ArrayList<Integer>();

	public void sorteiaNumeros() {
		for (NumeroOpcao numeroOpcao : NumeroOpcao.values()) {
			possibilidadesDeSorteio.add(numeroOpcao.getNumero());
		}

		Collections.shuffle(possibilidadesDeSorteio);
	}
}
