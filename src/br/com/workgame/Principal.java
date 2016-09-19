package br.com.workgame;

import java.io.FileNotFoundException;

import br.com.workgame.engine.BancoDePalavras;
import br.com.workgame.engine.obfuscate.factory.FabricaEmbaralhadores;
import br.com.workgame.engine.obfuscate.interfaces.Embaralhador;

/**
 * É essa classe que é responsável por ler a entrada do usuário e por imprimir
 * as informações no console. Nenhuma outra classe pode imprimir ou ler do
 * console.
 */
public class Principal {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(BancoDePalavras.getNewWord());
		System.out.println(BancoDePalavras.getNewWord());			
		
		Embaralhador e;		
		try {
			e = FabricaEmbaralhadores.getRandomEmbaralhador();
			System.out.println(e.embaralhar("Jonatah"));
		} catch (Exception e1) {		
			e1.printStackTrace();
		}
		
		
		
		
	}


}
