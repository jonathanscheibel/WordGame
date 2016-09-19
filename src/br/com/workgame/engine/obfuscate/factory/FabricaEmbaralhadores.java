package br.com.workgame.engine.obfuscate.factory;

import java.util.Random;

import br.com.workgame.engine.obfuscate.interfaces.Embaralhador;
import br.com.workgame.engine.obfuscate.model.EmbaralhadorAnalogico;
import br.com.workgame.engine.obfuscate.model.EmbaralhadorDigital;

/**
 * 
 * @author jonathan
 *
 */
public class FabricaEmbaralhadores {

	//Método que retorna um embaralhador aleatóriamente
	public static Embaralhador getRandomEmbaralhador() throws Exception{	
		switch (new Random().nextInt(2)) {
			case 0: return new EmbaralhadorAnalogico();
			case 1: return new EmbaralhadorDigital();				
			default: throw new Exception("Não foi possivel retornar um embaralhador válido!");
		}
	}
}
