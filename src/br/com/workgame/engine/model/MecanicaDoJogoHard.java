package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoHard implements MecanicaDoJogo {

	private static final int TRY_AGAIN_POSSIBLE = 1;
	private int numeroTentativaAtual;
	
	public MecanicaDoJogoHard(){
		super();
		this.numeroTentativaAtual = 0;
	}
	
	@Override
	public boolean isTerminate() {
		return false;
	}

	@Override
	public boolean isAssert(String expected, String Word) {
		if (expected.equals(Word)) {
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

	@Override
	public Integer getNumeroTentativaAtual() {
		return TRY_AGAIN_POSSIBLE - numeroTentativaAtual;
	}

}
