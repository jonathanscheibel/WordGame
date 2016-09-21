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
		
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Bem vindo ao WordGame!");
		play();
	}

	//Recursividade para encontrar a palavra correta ou encontrar o ponto de parada 
	private static void assertResponse(String wordOriginal, String obfuscate){

		if (!mecanica.isTryAgain()) {
			System.out.println("Você esgotou o número máximo de tentativas!");
			return;
		}
		
		System.out.println("Que palavra é essa? " + obfuscate);
		System.out.print("R:");
		Scanner enter = new Scanner(System.in);
		try {
			String trying = enter.next();
			
			System.out.println("Antes tentativa: " + mecanica.getNumeroTentativaAtual());

			
			if (mecanica.isAssert(wordOriginal, trying)) {
				System.out.println("Acertou!");
			} else {				
				System.out.println("Depois tentativa: " + mecanica.getNumeroTentativaAtual());
				System.out.println("Você não acertou e ainda possui " + Integer.toString(mecanica.tryingPossible()) + " tentativas.");
				assertResponse(wordOriginal, obfuscate);
			}			
			
		} finally {
			enter.close();
		}
	}
	
	private static void play() {		
		Scanner enter = new Scanner(System.in);
		try {
			
			System.out.println("Escolha um tipo de dificuldade:");
			System.out.println("1: Fácil");
			System.out.println("2: Médio");
			System.out.println("3: Difícil");			

			try {				
				switch (enter.nextInt()) {
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
			
				assertResponse(wordOriginal, wordObfuscate);
				
			} finally {
				mecanica = null;
			}
			System.out.println("GoodBye");
			
		} catch (Exception e) {
			e.printStackTrace();
			play();
		} finally {
			enter.close();
		}
		
		
	}
}
