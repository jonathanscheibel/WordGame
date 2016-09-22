package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoMedium implements MecanicaDoJogo{

	private static final int TRY_AGAIN_POSSIBLE = 2;
	private int numeroTentativaAtual;
	
	public MecanicaDoJogoMedium(){
		super();
		this.numeroTentativaAtual = 0;
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

	@Override
	public Integer getNumeroTentativaAtual() {
		return TRY_AGAIN_POSSIBLE - numeroTentativaAtual;
	}

	@Override
	public boolean isGamefinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getCurrentScore() {
		// TODO Auto-generated method stub
		return null;
	}
}
