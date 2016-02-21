package br.ufg.inf.es.pds.rodaroda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.SimNao;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.Temas;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.TipoResposta;
import br.ufg.inf.es.pds.rodaroda.sorteio.SorteioAleatorio;
import br.ufg.inf.es.pds.rodaroda.util.Util;

public class RodaRoda implements Observer {

	private Scanner scan;
	private Configuracoes configuracoes;
	private FileImport fileImport;
	private String temaSorteado;
	private List<String> palavras;
	private Roleta roleta;

	String palavraSorteada;
	String palavraExibida;
	Observable observavel;
	char letra;

	public RodaRoda(Scanner scan, Configuracoes configuracoes) {
		this.scan = scan;
		this.configuracoes = configuracoes;
		observavel = new PainelPalavra();
		observavel.addObserver(this);

		sortearTema();
		sortearPalavra();
		if (configuracoes.getQtdeJogadores().equals(1)) {
			singlePlayer();
		} else {
			multiPlayer();
		}

	}

	private void singlePlayer() {
		Jogador jogador = new Jogador();
		jogador.setIdentificacao(1);

		jogador.incrementaQtdeSorteios();
		roleta = new Roleta(new SorteioAleatorio(), jogador.getQtdeSorteios());

		while (palavraExibida.contains("-") && jogador.getQtdeErros() < 3) {
			System.out.println(Util.internacionaliza("roleta.girarRoleta"));

			if (SimNao.NAO.getIdentificador().equals(Util.recuperaInteiro(scan, 1, 2))) {
				continue;
			}

			OpcoesRoleta opcaoRoleta = roleta.sortear();


			if (opcaoRoleta.equals(OpcoesRoleta.PERDE_TUDO)) {
				jogador.setPontuacao(0);
				System.out.println(Util.internacionaliza("roleta.perdeTudo"));
			} else if (opcaoRoleta.equals(OpcoesRoleta.PASSA_VEZ)) {
				System.out.println(Util.internacionaliza("roleta.passaVez"));
			} else {
				System.out.println(Util.internacionaliza("roleta.valendo", Util.internacionaliza(opcaoRoleta.getChave())));

				if (TipoResposta.PALAVRA.getTipo().equals(Util.recuperaInteiro(scan, 1, 2))) {
					String palavra = Util.recuperaPalavra(scan);
					if (palavraSorteada.equalsIgnoreCase(palavra)) {
						palavraExibida = palavra;
						jogador.adicionaPontuacao(opcaoRoleta.getPontuacao());
					} else {
						jogador.setQtdeErros(3);
					}
				} else {
					char letra = Util.recuperaLetra(scan);
					List<Integer> ocorrencias = new ArrayList<Integer>();
					int index = palavraSorteada.toLowerCase().indexOf(letra);
					while (index >= 0) {
						ocorrencias.add(index);
						palavraExibida = Util.replaceCharAt(palavraExibida, index, letra);
						index = palavraSorteada.indexOf(letra, index + 1);
					}

					if (ocorrencias.size() > 0) {
						jogador.adicionaPontuacao(opcaoRoleta.getPontuacao());
					} else {
						jogador.incrementaQtdeErros();
					}

					System.out.println(palavraExibida);
				}
			}
		}

		if (jogador.getQtdeErros().equals(3)) {
			System.out.println(Util.internacionaliza("rodaroda.vocePerdeu"));
		} else {
			System.out.println(Util.internacionaliza("rodaroda.voceVenceu", jogador.getPontuacao()));
		}
	}

	private void multiPlayer() {
		Jogador jogador = new Jogador();
		jogador.setIdentificacao(1);

		jogador.incrementaQtdeSorteios();
		roleta = new Roleta(new SorteioAleatorio(), jogador.getQtdeSorteios());

		while (palavraExibida.contains("-") && jogador.getQtdeErros() < 3) {
			System.out.println(Util.internacionaliza("roleta.girarRoleta"));

			if (SimNao.NAO.getIdentificador().equals(Util.recuperaInteiro(scan, 1, 2))) {
				continue;
			}

			OpcoesRoleta opcaoRoleta = roleta.sortear();

			if (opcaoRoleta.equals(OpcoesRoleta.PERDE_TUDO)) {
				jogador.setPontuacao(0);
				System.out.println(Util.internacionaliza("roleta.perdeTudo"));
			} else if (opcaoRoleta.equals(OpcoesRoleta.PASSA_VEZ)) {
				System.out.println(Util.internacionaliza("roleta.passaVez"));
			} else {
				System.out.println(Util.internacionaliza("roleta.valendo", Util.internacionaliza(opcaoRoleta.getChave())));
				char letra = Util.recuperaLetra(scan);
				List<Integer> ocorrencias = new ArrayList<Integer>();
				int index = palavraSorteada.toLowerCase().indexOf(letra);
				while (index >= 0) {
					ocorrencias.add(index);
					palavraExibida = Util.replaceCharAt(palavraExibida, index, letra);
					index = palavraSorteada.indexOf(letra, index + 1);
				}

				if (ocorrencias.size() > 0) {
					jogador.adicionaPontuacao(opcaoRoleta.getPontuacao());
				} else {
					jogador.incrementaQtdeErros();
				}

				System.out.println(palavraExibida);
			}
		}

		if (jogador.getQtdeErros().equals(3)) {
			System.out.println(Util.internacionaliza("rodaroda.vocePerdeu"));
		} else {
			System.out.println(Util.internacionaliza("rodaroda.voceVenceu", jogador.getPontuacao()));
		}
	}
	
	private void sortearTema() {
		Random rdm = new Random();
		Integer numeroTema = rdm.nextInt(4) + 1;
		Temas tema = Temas.fromIdentificador(numeroTema);
		temaSorteado = tema.getNomeArquivo();
		System.out.println(Util.internacionaliza("temas.definido", Util.internacionaliza(tema.getChave())));
		palavras = getFileImport().carregaArquivo(tema.getNomeArquivo());
	}

	private void sortearPalavra() {
		Collections.shuffle(palavras);
		palavraSorteada = palavras.get(0);
		palavraExibida = Util.inicializarPalavraExibida(palavraSorteada.length());
		System.out.println(Util.internacionaliza("palavras.quantidadeLetras", palavraExibida.length()));
	}

	public void update(Observable observado, Object arg1) {
		if (observado instanceof PainelPalavra) {
			PainelPalavra painelPalavra = (PainelPalavra) observado;
			if (TipoResposta.LETRA.getTipo().equals(painelPalavra.getTipo())) {

			} else {

			}
		}
	}

	public Configuracoes getConfiguracoes() {
		return configuracoes;
	}

	public FileImport getFileImport() {
		if (fileImport == null) {
			fileImport = new FileImport();
		}

		return fileImport;
	}

	public String getTema() {
		return temaSorteado;
	}

	public List<String> getPalavras() {
		return palavras;
	}

	public Roleta getRoleta() {
		return roleta;
	}

}
