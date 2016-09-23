package br.com.workgame.obfuscate.factory;

import java.util.Random;

import br.com.workgame.obfuscate.interfaces.Embaralhador;
import br.com.workgame.obfuscate.model.EmbaralhadorAnalogico;
import br.com.workgame.obfuscate.model.EmbaralhadorDigital;
import br.com.workgame.obfuscate.model.EmbaralhadorReverso;

public class FabricaEmbaralhadores {

	// Método que retorna um embaralhador aleatóriamente
	public static Embaralhador getRandomEmbaralhador() throws Exception {
		switch (new Random().nextInt(3)) {
		case 0:
			return new EmbaralhadorAnalogico();
		case 1:
			return new EmbaralhadorDigital();
		case 2:
			return new EmbaralhadorReverso();
		default:
			throw new Exception("Não foi possivel retornar um embaralhador válido!");
		}
	}
}
