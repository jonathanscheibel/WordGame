package br.com.workgame.engine.obfuscate.model;

import br.com.workgame.engine.obfuscate.interfaces.Embaralhador;

public class EmbaralhadorDigital implements Embaralhador {

	@Override
	public String embaralhar(String word) {		
		return word + "_EMBARALHADO_DIGITALMENTE";
	}

}
