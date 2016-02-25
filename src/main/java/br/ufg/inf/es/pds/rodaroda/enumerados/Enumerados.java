package br.ufg.inf.es.pds.rodaroda.enumerados;

/**
 * Classe responsável por organizar os enums utilizados no RodaRoda.
 *
 * @author douglas.japiassu
 * @author guilherme.caixeta
 */
public class Enumerados {

	/**
	 * <pre>
	 * Tipo de estatísticas:
	 * - Quantidade de Sorteios
	 * - Quantidade de Acertos de Palavras
	 * - Quantidade de Acertos de Letras
	 * </pre>
	 *
	 */
	public enum TipoEstatistica {
		QTDE_SORTEIOS(1, "estatistica.qtdeSorteios"),
		QTDE_ACERTO_PALAVRA(2, "estatistica.qtdeAcertoPalavra"),
		QTDE_ACERTO_LETRA(3, "estatistica.qtdeAcertoLetra");

		private Integer identificador;
		private String chave;

		private TipoEstatistica(Integer identificador, String chave) {
			this.identificador = identificador;
			this.chave = chave;
		}

		public Integer getIdentificador() {
			return identificador;
		}

		public String getChave() {
			return chave;
		}
	}

	public enum SimNao {
		SIM(1, "comum.sim"),
		NAO(2, "comum.nao");

		private Integer identificador;
		private String chave;

		private SimNao(Integer identificador, String chave) {
			this.identificador = identificador;
			this.chave = chave;
		}

		public Integer getIdentificador() {
			return identificador;
		}

		public String getChave() {
			return chave;
		}
	}

	/**
	 * <pre>
	 * Tipo de resposta:
	 * - Letra
	 * - Palavra
	 * </pre>
	 *
	 */
	public enum TipoResposta {
		LETRA(1, "tipoResposta.letra"),
		PALAVRA(2, "tipoResposta.palavra");

		Integer tipo;
		String chave;

		private TipoResposta(Integer tipo, String chave) {
			this.tipo = tipo;
			this.chave = chave;
		}

		public Integer getTipo() {
			return tipo;
		}

		public String getChave() {
			return chave;
		}
	}

	/**
	 * <pre>
	 * Opções do Menu:
	 * - 0 - Escolha opção
	 * - 1 - Definir quantidade de jogadores
	 * - 2 - Definir quantidade de palavras por etapa
	 * - 3 - Definir quantidade de etapas
	 * - 4 - Sair
	 * </pre>
	 *
	 */
	public enum OpcoesMenu {

		ESCOLHA_OPCAO(0, "menu.escolhaOpcao"),
		ESCOLHA_QTDE_JOGADORES(1, "menu.definirQtdeJogadores"),
		ESCOLHA_QTDE_PALAVRAS_ETAPA(2, "menu.definirQtdePalavrasEtapa"),
		ESCOLHA_QTDE_ETAPAS(3, "menu.definirQtdeEtapas"),
		SAIR(4, "menu.sair");

		private Integer numeroOpcao;
		private String chave;

		private OpcoesMenu(Integer numeroOpcao, String chave) {
			this.numeroOpcao = numeroOpcao;
			this.chave = chave;
		}

		public Integer getNumeroOpcao() {
			return numeroOpcao;
		}

		public String getChave() {
			return chave;
		}

	}

	/**
	 * Contém os números de opção referentes as opções da roleta, conforme divisão:
	 * 
	 * <pre>
	 * - 2 {@link OpcoesRoleta#PERDE_TUDO}
	 * - 2 {@link OpcoesRoleta#PASSA_VEZ}
	 * - 4 {@link OpcoesRoleta#CEM_PONTOS}
	 * - 4 {@link OpcoesRoleta#DUZENTOS_PONTOS}
	 * - 4 {@link OpcoesRoleta#QUATROCENTOS_PONTOS}
	 * - 2 {@link OpcoesRoleta#QUINHENTOS_PONTOS}
	 * - 2 {@link OpcoesRoleta#MIL_PONTOS}
	 * </pre>
	 *
	 */
	public enum NumeroOpcao {
		UM(1, OpcoesRoleta.PERDE_TUDO),
		DOIS(2, OpcoesRoleta.PERDE_TUDO),
		TRES(3, OpcoesRoleta.PASSA_VEZ),
		QUATRO(4, OpcoesRoleta.PASSA_VEZ),
		CINCO(5, OpcoesRoleta.CEM_PONTOS),
		SEIS(6, OpcoesRoleta.CEM_PONTOS),
		SETE(7, OpcoesRoleta.CEM_PONTOS),
		OITO(8, OpcoesRoleta.CEM_PONTOS),
		NOVE(9, OpcoesRoleta.DUZENTOS_PONTOS),
		DEZ(10, OpcoesRoleta.DUZENTOS_PONTOS),
		ONZE(11, OpcoesRoleta.DUZENTOS_PONTOS),
		DOZE(12, OpcoesRoleta.DUZENTOS_PONTOS),
		TREZE(13, OpcoesRoleta.QUATROCENTOS_PONTOS),
		QUATORZE(14, OpcoesRoleta.QUATROCENTOS_PONTOS),
		QUINZE(15, OpcoesRoleta.QUATROCENTOS_PONTOS),
		DEZESSEIS(16, OpcoesRoleta.QUATROCENTOS_PONTOS),
		DEZESSETE(17, OpcoesRoleta.QUINHENTOS_PONTOS),
		DEZOITO(18, OpcoesRoleta.QUINHENTOS_PONTOS),
		DEZENOVE(19, OpcoesRoleta.MIL_PONTOS),
		VINTE(20, OpcoesRoleta.MIL_PONTOS);

		private Integer numero;
		private OpcoesRoleta opcao;

		private NumeroOpcao(Integer numero, OpcoesRoleta opcao) {
			this.numero = numero;
			this.opcao = opcao;
		}

		public static OpcoesRoleta fromNumero(Integer numero) {
			for(NumeroOpcao numeroOpcao : NumeroOpcao.values()) {
				if (numeroOpcao.getNumero().equals(numero)) {
					return numeroOpcao.getOpcao();
				}
			}

			return null;
		}

		public Integer getNumero() {
			return numero;
		}

		public OpcoesRoleta getOpcao() {
			return opcao;
		}
	}

	/**
	 * <pre>
	 * Opções da roleta:
	 * - Perde tudo
	 * - Passa a vez
	 * - 100 pontos
	 * - 200 pontos
	 * - 400 pontos
	 * - 500 pontos
	 * - 1000 pontos
	 * </pre>
	 *
	 */
	public enum OpcoesRoleta {

		PERDE_TUDO(0, 2, "roleta.perdeTudo"),
		PASSA_VEZ(1, 2, "roleta.passaVez"),
		CEM_PONTOS(100, 4, "roleta.cemPontos"),
		DUZENTOS_PONTOS(200, 4, "roleta.duzentosPontos"),
		QUATROCENTOS_PONTOS(400, 4, "roleta.quatrocentosPontos"),
		QUINHENTOS_PONTOS(500, 2, "roleta.quinhentosPontos"),
		MIL_PONTOS(1000, 2, "roleta.milPontos");

		private Integer pontuacao;
		private Integer qtdeDivisoes;
		private String chave;

		private OpcoesRoleta(Integer pontuacao, Integer qtdeDivisoes, String chave) {
			this.pontuacao = pontuacao;
			this.qtdeDivisoes = qtdeDivisoes;
			this.chave = chave;
		}

		public Integer getPontuacao() {
			return pontuacao;
		}

		public Integer getQtdeDivisoes() {
			return qtdeDivisoes;
		}

		public String getChave() {
			return chave;
		}

	}

	/**
	 * <pre>
	 * Temas do jogo:
	 * - Animais
	 * - Cidades
	 * - Filmes
	 * - Profissões
	 * </pre>
	 *
	 */
	public enum Temas {

		ANIMAIS(1, "animais", "temas.animais"),
		CIDADE(2, "cidades", "temas.cidades"),
		FILME(3, "filmes", "temas.filmes"),
		PROFISSOES(4, "profissoes", "temas.profissoes");

		private final Integer identificador;
		private final String nomeArquivo;
		private final String chave;

		private Temas(final Integer identificador, final String nomeArquivo, final String chave) {
			this.identificador = identificador;
			this.nomeArquivo = nomeArquivo;
			this.chave = chave;
		}

		public static Temas fromIdentificador(final Integer identificador) {
			Temas retorno = null;

			for (final Temas tema : Temas.values()) {
				if (tema.getIdentificador().equals(identificador)) {
					retorno = tema;
					break;
				}
			}
			return retorno;
		}

		public Integer getIdentificador() {
			return identificador;
		}

		public String getNomeArquivo() {
			return nomeArquivo;
		}

		public String getChave() {
			return chave;
		}
	}

}
