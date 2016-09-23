package br.com.workgame.obfuscate.model;

import java.util.ArrayList;
import java.util.List;

import br.com.workgame.obfuscate.interfaces.Embaralhador;

public class EmbaralhadorDigital implements Embaralhador {

	//Embaralhamento usando random
	private String shuffle(String input) {
		List<Character> characters = new ArrayList<Character>();
		for (char c : input.toCharArray()) {
			characters.add(c);
		}
		StringBuilder output = new StringBuilder(input.length());
		while (characters.size() != 0) {
			int randPicker = (int) (Math.random() * characters.size());
			output.append(characters.remove(randPicker));
		}
		return output.toString();
	}

	@Override
	public String embaralhar(String word) {
		return shuffle(word);
	}

}
