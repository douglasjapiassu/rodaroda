package br.ufg.inf.es.pds.rodaroda.util;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Util {

	private static final String BUNDLE_NAME = "Mensagens";
	private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

	public static String internacionaliza(String chave, Object... args) {
		return internacionaliza(LOCALE_PT_BR, chave, args);
	}

	public static String internacionaliza(Locale locale, String chave, Object... args) {
		String mensagem = "";
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);

		if (bundle != null) {
			mensagem = bundle.getString(chave);

			if (mensagem != null && args.length > 0) {
				mensagem = MessageFormat.format(mensagem, args);
			}
		}

		return mensagem;
	}

	public static Boolean isMaiorQueZero(Integer number) {
		return nullToZero(number) > 0;
	}

	public static Integer nullToZero(Integer number) {
		if (number == null) {
			return 0;
		}

		return number;
	}

	public static String replaceCharAt(String s, int pos, char c) {
		return s.substring(0, pos) + c + s.substring(pos + 1);
	}

	public static String inicializarPalavraExibida(String palavraSorteada) {
		char charToFill = '-';
		String palavraExibida = "";

		String[] aux = palavraSorteada.split(" ");

		for (String parte : aux) {
			if (parte.length() > 0) {
				char[] array = new char[parte.length()];

				Arrays.fill(array, charToFill);
				if (palavraExibida.length() > 0) {
					palavraExibida += " ";
				}

				palavraExibida += new String(array);
			}
		}

		return palavraExibida;
	}

	public static Integer getTamanhoPalavra(String palavraSorteada) {
		Integer tamanhoPalavra = 0;
		String[] aux = palavraSorteada.split(" ");

		for (String parte : aux) {
			tamanhoPalavra += parte.length();
		}

		return tamanhoPalavra;
	}

	public static Integer recuperaInteiro(Scanner scan, Integer valorInicial, Integer valorFinal) {
		Integer retorno = 0;
		Boolean nok = true;

		do {

			try {
				retorno = scan.nextInt();

				if (retorno >= valorInicial && retorno <= valorFinal) {
					nok = false;
				} else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.err.println(Util.internacionaliza("menu.valorInvalido"));
				scan.nextLine();
			}
		} while (nok);

		return retorno;
	}

	public static char recuperaLetra(Scanner scan) {
		String letra = "";
		Boolean nok = true;

		do {
			System.out.println(Util.internacionaliza("tipoResposta.digiteUmaLetra"));
			try {
				letra = scan.next();

				if (letra.length() == 1) {
					nok = false;
				} else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.err.println(Util.internacionaliza("menu.valorInvalido"));
				scan.nextLine();
			}
		} while (nok);

		return letra.toLowerCase().charAt(0);
	}

	public static String recuperaPalavra(Scanner scan) {
		String palavra = "";
		Boolean nok = true;

		do {
			try {
				palavra = scan.next();
				nok = false;
			} catch (Exception e) {
				System.err.println(Util.internacionaliza("menu.valorInvalido"));
				scan.nextLine();
			}
		} while (nok);

		return palavra.toLowerCase();
	}
}

