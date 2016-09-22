package br.com.workgame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
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

	// Método recursivo para encontrar a palavra correta ou até encontrar o
	// ponto de parada
	private static boolean assertResponse(String wordOriginal, String obfuscate) {
		if (!mecanica.isTryAgain()) {
			System.out.println("Você esgotou o número máximo de tentativas! GAME OVER");
			return false;
		}
		
		System.out.println("Que palavra é essa?? " + obfuscate);
		System.out.print("R:");		
		try {
			String trying = enter.next();
			if (mecanica.isAssert(wordOriginal, trying)) {				
				if (mecanica.isGamefinished()) {
					System.out.println("Parabéns, você zerou/concluiu o jogo!");
				}
				return true;
			} else {
				System.out.println("Você não acertou e ainda possui " + Integer.toString(mecanica.tryingPossible()) + " tentativas.");
				return assertResponse(wordOriginal, obfuscate);
			}
		} catch(Exception e) {
			return false;
		}		
	}

	private static void play() {
		BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Escolha um tipo de dificuldade:");
			System.out.println("1: Fácil");
			System.out.println("2: Médio");
			System.out.println("3: Difícil");
			System.out.print("R:");

			int difficulty = Integer.parseInt(enter.readLine());
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
					throw new Exception("Tipo de dificuldade indisponível.");
				}

				Embaralhador embaralhador = FabricaEmbaralhadores.getRandomEmbaralhador();
				String wordOriginal = BancoDePalavras.getNewWord();
				String wordObfuscate = embaralhador.embaralhar(wordOriginal);
				boolean testAssert = assertResponse(wordOriginal, wordObfuscate);
				
				if (!testAssert) {
					System.out.println("Deseja continuar jogando? [S/N]");				
					String digitReplay = enter.readLine();
					if (digitReplay.equalsIgnoreCase("S")) {
						play();
					}
				}
				
			} finally {
				mecanica = null;
			}

		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
}
