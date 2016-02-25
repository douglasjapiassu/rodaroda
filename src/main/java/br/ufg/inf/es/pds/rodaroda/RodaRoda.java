package br.ufg.inf.es.pds.rodaroda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.OpcoesRoleta;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.SimNao;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.Temas;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.TipoEstatistica;
import br.ufg.inf.es.pds.rodaroda.enumerados.Enumerados.TipoResposta;
import br.ufg.inf.es.pds.rodaroda.sorteio.SorteioAleatorio;
import br.ufg.inf.es.pds.rodaroda.util.Util;
import br.ufg.inf.es.pds.rodaroda.util.UtilComparator;

/**
 * Classe responsável por toda a execução do jogo. As regras estão todas implementadas aqui. Essa classe é observada pelo observer {@link Estatisticas}}.
 *
 * @author douglas.japiassu
 * @author guilherme.caixeta
 */
public class RodaRoda extends Observable {

	private Scanner scan;
	private Configuracoes configuracoes;
	private FileImport fileImport;
	private String temaSorteado;
	private List<String> palavras;
	private List<Jogador> listaJogadores;
	private Roleta roleta;
	private Estatisticas estatistica;

	String palavraSorteada;
	String palavraExibida;
	private Integer etapaAtual;
	private Integer indicePalavra;

	/**
	 * Construtor que recebe o scanner e as {@link Configuracoes}}
	 *
	 * @param scan
	 * @param configuracoes
	 */
	public RodaRoda(Scanner scan, Configuracoes configuracoes) {
		this.scan = scan;
		this.configuracoes = configuracoes;
		estatistica = new Estatisticas();
		addObserver(estatistica);
		sortearTema();
		etapaAtual = 1;
		setIndicePalavra(1);
		while (etapaAtual <= configuracoes.getQtdeEtapas()) {
			defineListaJogadores();
			imprimePlacar();
			sortearPalavra();
			jogar();
		}

		imprimePlacar();
		defineVencedor();
		estatistica.imprimeEstatistica();
	}

	/**
	 * Recupera os nomes dos jogadores, a depender da quantidade de jogadores escolhidos ({@link Configuracoes#getQtdeJogadores()}}).
	 *
	 */
	private void defineListaJogadores() {
		listaJogadores = new ArrayList<Jogador>();
		for (int numeroJogador = 1; numeroJogador <= configuracoes.getQtdeJogadores(); numeroJogador++) {
			imprime(Util.internacionaliza("configuracao.digiteNomeJogador", numeroJogador));
			Jogador jogador = new Jogador();
			jogador.setIdentificacao(numeroJogador);
			jogador.setNome(Util.recuperaPalavra(scan));
			listaJogadores.add(jogador);
		}
	}

	/**
	 * Imprime uma mensagem com quebra de linha no começo, para melhor visualização.
	 *
	 * @param mensagem
	 */
	private void imprime(String mensagem) {
		System.out.println("\n" + mensagem);
	}

	/**
	 * Define através da lista de jogadores, qual é o vencedor ordenando a lista pela pontuação.
	 *
	 * @see UtilComparator#getComparatorPorPontuacao()
	 */
	private void defineVencedor() {
		Collections.sort(listaJogadores, UtilComparator.getComparatorPorPontuacao());

		Jogador vencedor = listaJogadores.iterator().next();
		imprime(Util.internacionaliza("rodaroda.vencedor", vencedor.getNome(), vencedor.getPontuacao()));
	}

	/**
	 * Imprime o placar do jogo.
	 */
	private void imprimePlacar() {
		for (Jogador jogador : listaJogadores) {
			imprime(Util.internacionaliza("jogador.numeroJogador", jogador.getIdentificacao()));
			imprime(Util.internacionaliza("jogador.nomeJogador", jogador.getNome()));
			imprime(Util.internacionaliza("jogador.pontuacaoAtual", Util.nullToZero(jogador.getPontuacao())));
			imprime("########################################");
		}
	}

	/**
	 * Interação do jogo.
	 */
	private void jogar() {
		Integer indiceJogador = 0;
		Jogador jogadorAtual = listaJogadores.get(0);
		roleta = new Roleta(new SorteioAleatorio());

		Boolean continuarExecucao = true;
		Boolean continuaMesmoJogador = true;

		while (continuarExecucao) {
			setChanged();
			notifyObservers(TipoEstatistica.QTDE_SORTEIOS);
			if (!continuaMesmoJogador) {
				indiceJogador++;
				try {
					jogadorAtual = listaJogadores.get(indiceJogador);
				} catch (Exception e) {
					indiceJogador = 0;
					jogadorAtual = listaJogadores.get(indiceJogador);
				}

				jogadorAtual.setQtdeSorteios(0);
			}


			imprime(Util.internacionaliza("rodaroda.vezDoJogador", jogadorAtual.getNome()));
			imprime(Util.internacionaliza("roleta.girarRoleta"));
			if (SimNao.NAO.getIdentificador().equals(Util.recuperaInteiro(scan, 1, 2))) {
				continuaMesmoJogador = false;
				continue;
			}

			jogadorAtual.incrementaQtdeSorteios();
			OpcoesRoleta opcaoRoleta = roleta.sortear(jogadorAtual.getQtdeSorteios());

			if (opcaoRoleta.equals(OpcoesRoleta.PERDE_TUDO)) {
				jogadorAtual.setPontuacao(0);
				imprime(Util.internacionaliza("roleta.perdeTudo"));
				continuaMesmoJogador = false;
			} else if (opcaoRoleta.equals(OpcoesRoleta.PASSA_VEZ)) {
				imprime(Util.internacionaliza("roleta.passaVez"));
				continuaMesmoJogador = false;
			} else {
				imprime(Util.internacionaliza("roleta.valendo", Util.internacionaliza(opcaoRoleta.getChave())));

				imprime(Util.internacionaliza("tipoResposta.escolher"));
				if (TipoResposta.PALAVRA.getTipo().equals(Util.recuperaInteiro(scan, 1, 2))) {
					imprime(Util.internacionaliza("tipoResposta.digiteUmaPalavra"));
					String palavra = Util.recuperaPalavra(scan);

					if (palavraSorteada.equalsIgnoreCase(palavra)) {
						palavraExibida = palavra;
						jogadorAtual.adicionaPontuacao(opcaoRoleta.getPontuacao());

						setChanged();
						notifyObservers(TipoEstatistica.QTDE_ACERTO_PALAVRA);
					} else {
						jogadorAtual.setErrouPalavra(true);
						continuarExecucao = false;
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
						jogadorAtual.adicionaPontuacao(opcaoRoleta.getPontuacao());
						continuaMesmoJogador = true;
						setChanged();
						notifyObservers(TipoEstatistica.QTDE_ACERTO_LETRA);
					} else {
						continuaMesmoJogador = false;
						imprime(Util.internacionaliza("rodaroda.letraNaoEncontrada", jogadorAtual.getNome()));
					}

					jogadorAtual.incrementaQtdeTentativas();

					imprime(Util.internacionaliza("rodaroda.tema", temaSorteado));
					imprime(palavraExibida);
				}
			}

			if ((jogadorAtual.getErrouPalavra() == null || !jogadorAtual.getErrouPalavra()) && palavraExibida.contains("-")) {
				continuarExecucao = true;
			} else {
				if (getIndicePalavra().compareTo(configuracoes.getQtdePalavrasEtapa()) < 1) {
					imprime(Util.internacionaliza("rodaroda.palavraCompleta", palavraSorteada, jogadorAtual.getNome()));
					setIndicePalavra(getIndicePalavra() + 1);
					sortearPalavra();
				} else {
					continuarExecucao = false;
				}
			}
		}

		imprime(Util.internacionaliza("rodaroda.fimEtapa"));
		etapaAtual++;
	}

	/**
	 * Realiza o sorteio via {@link Random} do tema do jogo.
	 */
	private void sortearTema() {
		Random rdm = new Random();
		Integer numeroTema = rdm.nextInt(4) + 1;
		Temas tema = Temas.fromIdentificador(numeroTema);
		temaSorteado = tema.getNomeArquivo();
		imprime(Util.internacionaliza("temas.definido", Util.internacionaliza(tema.getChave())));
		palavras = getFileImport().carregaArquivo(tema.getNomeArquivo());
	}

	/**
	 * Realiza o sorteio das palavras. Caso seja a primeira palavra a sortear, é feito o "embaralhamento" da lista de palavras, após isso só retira da lista na ordem em que as palavras serão
	 * sorteadas.
	 */
	private void sortearPalavra() {
		if (getIndicePalavra().equals(1)) {
			Collections.shuffle(palavras);
		}
		palavraSorteada = palavras.get(getIndicePalavra() - 1);
		palavraExibida = Util.inicializarPalavraExibida(palavraSorteada);
		imprime(Util.internacionaliza("palavras.quantidadeLetras", Util.getTamanhoPalavra(palavraSorteada)));
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

	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}

	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}

	public Integer getIndicePalavra() {
		return indicePalavra;
	}

	public void setIndicePalavra(Integer indicePalavra) {
		this.indicePalavra = indicePalavra;
	}

}
