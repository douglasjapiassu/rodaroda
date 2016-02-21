package br.ufg.inf.es.pds.rodaroda;

import java.io.IOException;
import java.util.Scanner;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesMenu;
import br.ufg.inf.es.pds.rodaroda.util.Util;

public class Main {

	public static void main(String[] args) throws IOException {
		iniciarRodaRoda();
	}

	private static void iniciarRodaRoda() {
		System.out.println(Util.internacionaliza("rodaroda.bemVindo"));
		Scanner scan = new Scanner(System.in);
		Configuracoes config = new Configuracoes();
		/*
		 * config.setQtdeEtapas(1); config.setQtdeJogadores(1); config.setQtdePalavrasEtapa(1);
		 */

		if (definirConfiguracoes(scan, config)) {
			// if (config != null) {
			System.out.println("Configurações definidas");
			System.out.println("\nINÍCIO");
			RodaRoda rodaRoda = new RodaRoda(scan, config);
			rodaRoda.getPalavras();
		} else {
			System.out.println("Configurações não finalizadas.");
		}
	}

	private static void exibeOpcoesMenu() {
		System.out.println("------------ MENU ------------");
		for (OpcoesMenu opcao : OpcoesMenu.values()) {
			System.out.println(Util.internacionaliza(opcao.getChave()));
		}
		System.out.println("");
	}

	private static Boolean definirConfiguracoes(Scanner scan, Configuracoes configuracao) {
		Boolean faltaDefinirConfiguracao = true;
		Boolean configuracoesPreenchidas = false;
		Integer opcao = 0;

		while (faltaDefinirConfiguracao) {
			exibeOpcoesMenu();
			try {
				opcao = scan.nextInt();

				if (opcao.equals(OpcoesMenu.SAIR.getNumeroOpcao())) {
					faltaDefinirConfiguracao = false;
					System.out.println(Util.internacionaliza("menu.encerraConfiguracoes"));
				} else {
					System.out.println(Util.internacionaliza("menu.digiteNumeroValido"));
					if (opcao.equals(OpcoesMenu.ESCOLHA_QTDE_JOGADORES.getNumeroOpcao())) {
						configuracao.setQtdeJogadores(Util.recuperaInteiro(scan, 1, 3));
						System.out.println(Util.internacionaliza("menu.opcaoDefinida"));
					} else if (opcao.equals(OpcoesMenu.ESCOLHA_QTDE_PALAVRAS_ETAPA.getNumeroOpcao())) {
						configuracao.setQtdePalavrasEtapa(Util.recuperaInteiro(scan, 1, 3));
						System.out.println(Util.internacionaliza("menu.opcaoDefinida"));
					} else if (opcao.equals(OpcoesMenu.ESCOLHA_QTDE_ETAPAS.getNumeroOpcao())) {
						configuracao.setQtdeEtapas(Util.recuperaInteiro(scan, 1, 7));
						System.out.println(Util.internacionaliza("menu.opcaoDefinida"));
					}
				}
			} catch (Exception e) {
				System.err.println(Util.internacionaliza("menu.erroLeitura"));
				faltaDefinirConfiguracao = true;
				scan.next();
			}

			if (Util.isMaiorQueZero(configuracao.getQtdeJogadores()) && Util.isMaiorQueZero(configuracao.getQtdePalavrasEtapa()) && Util.isMaiorQueZero(configuracao.getQtdeEtapas())) {
				configuracoesPreenchidas = true;
				faltaDefinirConfiguracao = false;
			}
		}

		return configuracoesPreenchidas;
	}

}
