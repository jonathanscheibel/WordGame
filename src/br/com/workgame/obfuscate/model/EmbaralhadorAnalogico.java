package br.com.workgame.obfuscate.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.workgame.obfuscate.interfaces.Embaralhador;

public class EmbaralhadorAnalogico implements Embaralhador {

	//Embaralhamento usando Collections
	private String shuffle(String input) {
		char[] caracteres = input.toCharArray();
		List<Character> ocharaters  = new ArrayList<Character>(caracteres.length);
		for (char c:  caracteres ){
		  ocharaters.add(c);
		}
		Collections.shuffle(ocharaters);
		for ( int i =0; i < caracteres.length ; i++ ){
		     caracteres[i] = ocharaters.get(i); 
		}
		return new String(caracteres);
	}
	
	@Override
	public String embaralhar(String word) {		
		return shuffle(word);
	}
}
