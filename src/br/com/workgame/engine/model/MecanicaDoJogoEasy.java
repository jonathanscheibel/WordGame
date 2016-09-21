package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoEasy implements MecanicaDoJogo {

	private static final int TRY_AGAIN_POSSIBLE = 3;
	public Integer numeroTentativaAtual;

	public MecanicaDoJogoEasy(){
		super();
		this.numeroTentativaAtual = 0;
	}
	
	public Integer getNumeroTentativaAtual() {
		return numeroTentativaAtual;
	}
	
	@Override
	public boolean isTerminate() {
		return false;
	}

	@Override
	public boolean isAssert(String expected, String Word) {
		if (expected.equalsIgnoreCase(Word)) {
			return true;
		} else {
			numeroTentativaAtual++;
			return false;
		}
	}

	@Override
	public boolean isTryAgain() {
		return numeroTentativaAtual < TRY_AGAIN_POSSIBLE;
	}

	@Override
	public double getFinalScore() {
		return 0;
	}
	
	public int tryingPossible(){
		return TRY_AGAIN_POSSIBLE - numeroTentativaAtual; 
	}

}
