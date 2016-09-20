package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoEasy implements MecanicaDoJogo {

	@Override
	public boolean isTerminate() {
		return false;
	}

	@Override
	public boolean isAssert(String Word) {
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
