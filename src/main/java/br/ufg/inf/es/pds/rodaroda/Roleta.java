package br.ufg.inf.es.pds.rodaroda;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;
import br.ufg.inf.es.pds.rodaroda.sorteio.ComportamentoSorteio;
import br.ufg.inf.es.pds.rodaroda.sorteio.SorteioAleatorio;
import br.ufg.inf.es.pds.rodaroda.sorteio.SorteioViciado;

/**
 * Classe responsável por realizar o sorteio da roleta. Utilizando o padrão Strategy, podemos definir qual será a estratégia do sorteio no seu construtor.
 *
 * @see ComportamentoSorteio
 * @see SorteioAleatorio
 * @see SorteioViciado
 * @author douglas.japiassu
 * @author guilherme.caixeta
 */
public class Roleta {

	ComportamentoSorteio comportamentoSorteio;

	public Roleta(ComportamentoSorteio comportamentoSorteio) {
		this.comportamentoSorteio = comportamentoSorteio;
	}

	/**
	 * Realiza o sorteio e retorna o valor.
	 *
	 * @see Enumerados.OpcoesRoleta
	 * @param numeroSorteio
	 * @return OpcoesRoleta sorteado
	 */
	public OpcoesRoleta sortear(Integer numeroSorteio) {
		comportamentoSorteio.sorteiaNumeros();

		return comportamentoSorteio.pegarValorSorteadoPorNumeroSorteio(numeroSorteio);
	}

}
