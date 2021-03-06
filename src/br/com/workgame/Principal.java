package br.com.workgame;

import java.io.FileNotFoundException;
import java.util.Scanner;

import br.com.workgame.assistant.BancoDePalavras;
import br.com.workgame.engine.enums.TipoMecanicas;
import br.com.workgame.engine.factory.FabricaMecanicaDoJogo;
import br.com.workgame.engine.interfaces.MecanicaDoJogo;
import br.com.workgame.obfuscate.factory.FabricaEmbaralhadores;
import br.com.workgame.obfuscate.interfaces.Embaralhador;

/**
 * É essa classe que é responsável por ler a entrada do usuário e por imprimir
 * as informações no console. Nenhuma outra classe pode imprimir ou ler do
 * console.
 */
public class Principal {
	private static MecanicaDoJogo mecanica;
	private static Scanner enter;

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Bem vindo ao WordGame!");
		enter = new Scanner(System.in);
		try {
			play();
		} finally {
			enter.close();
		}
		System.out.println("GoodBye");
	}

	// Método recursivo para encontrar a palavra correta ou até encontrar o ponto de parada
	private static boolean assertResponse(String wordOriginal, String obfuscate) throws Exception {
		if (!mecanica.isTryAgain()) {
			System.out.println("GAME OVER! - Pontuação final: " + mecanica.getCurrentScore());
			return false;
		}

		System.out.println("Que palavra é essa?? " + obfuscate);
		System.out.print("R:");
		String trying = enter.next();

		if (mecanica.isAssert(wordOriginal, trying)) {
			System.out.println("Você acertou! Sua pontuação atual é de: " + mecanica.getCurrentScore());
			return true;
		} else {
			System.out.println("Você não acertou e ainda possui " + Integer.toString(mecanica.tryingPossible()) + " tentativas.");
			return assertResponse(wordOriginal, obfuscate);
		}
	}

	private static void continuos() throws Exception {

		Embaralhador embaralhador = FabricaEmbaralhadores.getRandomEmbaralhador();
		String wordOriginal = BancoDePalavras.getNewWord();
		String wordObfuscate = embaralhador.embaralhar(wordOriginal);

		if (assertResponse(wordOriginal, wordObfuscate)) {
			if (mecanica.isGamefinished()) 
				System.out.println("Você zerou/concluiu o jogo!");
			else
				continuos();
			
		} else {
			System.out.println(" ");
			System.out.println("Deseja continuar jogando? [S/N]");
			String digitReplay = enter.next();
			if (digitReplay.equalsIgnoreCase("S"))
				play();
			else
				return;
		}
	}

	private static void play() {

		try {
			System.out.println("Escolha um tipo de dificuldade:");
			System.out.println("1: Fácil 	(Valendo 1 ponto)");
			System.out.println("2: Médio 	(Valendo 2 ponto)");
			System.out.println("3: Difícil	(Valendo 3 ponto)");
			System.out.println("?: Sair");
			System.out.print("R:");

			int difficulty = Integer.parseInt(enter.next());
			System.out.println(difficulty);
			try {
				switch (difficulty) {
				case 1:
					mecanica = FabricaMecanicaDoJogo.getMecanicaDoJogo(TipoMecanicas.EASY);
					break;
				case 2:
					mecanica = FabricaMecanicaDoJogo.getMecanicaDoJogo(TipoMecanicas.MEDIUM);
					break;
				case 3:
					mecanica = FabricaMecanicaDoJogo.getMecanicaDoJogo(TipoMecanicas.HARD);
					break;
				default:
					return;
				}

				continuos();

			} finally {
				mecanica = null;
			}

		} catch (Exception e) {

		}
	}
}
