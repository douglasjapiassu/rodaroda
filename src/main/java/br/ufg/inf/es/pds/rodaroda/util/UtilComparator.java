package br.ufg.inf.es.pds.rodaroda.util;

import java.util.Comparator;

import br.ufg.inf.es.pds.rodaroda.Jogador;


public class UtilComparator {

	public static Comparator<Jogador> getComparatorPorPontuacao() {
		return new Comparator<Jogador>() {
			public int compare(Jogador j1, Jogador j2) {
				return j1.getPontuacao().compareTo(j2.getPontuacao());
			}
		};
	}
}

