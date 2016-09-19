package br.com.workgame;

import java.io.FileNotFoundException;

import br.com.workgame.engine.BancoDePalavras;

/**
 * É essa classe que é responsável por ler a entrada do usuário e por imprimir
 * as informações no console. Nenhuma outra classe pode imprimir ou ler do
 * console.
 */
public class Principal {
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(BancoDePalavras.getNewWord());
		System.out.println(BancoDePalavras.getNewWord());
	}


}
