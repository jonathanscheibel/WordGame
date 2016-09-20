package br.com.workgame.obfuscate.factory;

import java.util.Random;

import br.com.workgame.obfuscate.interfaces.Embaralhador;
import br.com.workgame.obfuscate.model.EmbaralhadorAnalogico;
import br.com.workgame.obfuscate.model.EmbaralhadorDigital;

public class FabricaEmbaralhadores {

	// Método que retorna um embaralhador aleatóriamente
	public static Embaralhador getRandomEmbaralhador() throws Exception {
		switch (new Random().nextInt(2)) {
		case 0:
			return new EmbaralhadorAnalogico();
		case 1:
			return new EmbaralhadorDigital();
		default:
			throw new Exception("Não foi possivel retornar um embaralhador válido!");
		}
	}
}
