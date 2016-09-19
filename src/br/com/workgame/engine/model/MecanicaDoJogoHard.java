package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoHard implements MecanicaDoJogo {

	@Override
	public boolean isTerminate() {
		return false;
	}

	@Override
	public boolean isAssert() {
		return false;
	}

	@Override
	public boolean isTryAgain() {
		return false;
	}

	@Override
	public double getFinalScore() {
		return 0;
	}

}
