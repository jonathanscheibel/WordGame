package br.com.workgame.obfuscate.model;

import br.com.workgame.obfuscate.interfaces.Embaralhador;

public class EmbaralhadorAnalogico implements Embaralhador {

	@Override
	public String embaralhar(String word) {
		return word + "_EMBARALHADO_ANALOGICAMENTE";
	}
}
