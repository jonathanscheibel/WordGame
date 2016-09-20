package br.com.workgame.engine.factory;

import br.com.workgame.engine.enums.TipoMecanicas;
import br.com.workgame.engine.interfaces.MecanicaDoJogo;
import br.com.workgame.engine.model.MecanicaDoJogoEasy;
import br.com.workgame.engine.model.MecanicaDoJogoHard;
import br.com.workgame.engine.model.MecanicaDoJogoMedium;

public class FabricaMecanicaDoJogo {

	//Retorna a MecanicaDoJogo que deve ser utiliza
	public static MecanicaDoJogo getMecanicaDoJogo(TipoMecanicas mecanica) throws Exception {
		if (mecanica == TipoMecanicas.EASY) {
			return new MecanicaDoJogoEasy();
		}
		
		if (mecanica == TipoMecanicas.MEDIUM) {
			return new MecanicaDoJogoMedium();
		}
		
		if (mecanica == TipoMecanicas.HARD) {
			return new MecanicaDoJogoHard();
		}
		
		throw new Exception("não foi possível identificar o tipo de mecanica!");
		
	}	
	
}
