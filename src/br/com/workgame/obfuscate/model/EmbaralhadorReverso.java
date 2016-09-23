package br.com.workgame.obfuscate.model;

import br.com.workgame.obfuscate.interfaces.Embaralhador;

public class EmbaralhadorReverso implements Embaralhador {

	//Embaralhamento tipo reverso
	private String shuffle(String input) {
		StringBuffer sb = new StringBuffer(input);
		StringBuffer inverter = sb.reverse();
		return inverter.toString();
	}
	
	@Override
	public String embaralhar(String word) {
		return shuffle(word);
	}

}
