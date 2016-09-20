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

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Bem vindo ao WordGame!");
		play();
	}

	private static void play() {
		Scanner in = new Scanner(System.in);
		try {			
			System.out.println("Escolha um tipo de dificuldade:");
			System.out.println("1: Fácil");
			System.out.println("2: Médio");
			System.out.println("3: Difícil");

			MecanicaDoJogo m;

			switch (in.nextInt()) {
			case 1:
				m = FabricaMecanicaDoJogo.getMecanicaDoJogo(TipoMecanicas.EASY);
				break;
			case 2:
				m = FabricaMecanicaDoJogo.getMecanicaDoJogo(TipoMecanicas.MEDIUM);
				break;
			case 3:
				m = FabricaMecanicaDoJogo.getMecanicaDoJogo(TipoMecanicas.HARD);
				break;
			default:				
				throw new Exception("Tipo de dificuldade indisponível.");				
			}
			
			Embaralhador embaralhador = FabricaEmbaralhadores.getRandomEmbaralhador();
			embaralhador.embaralhar(BancoDePalavras.getNewWord());
			
			m.isAssert("");
			
			System.out.println("GoodBye");
			
		} catch (Exception e) {
			e.printStackTrace();
			play();
		} finally {
			in.close();
		}
	}
}
