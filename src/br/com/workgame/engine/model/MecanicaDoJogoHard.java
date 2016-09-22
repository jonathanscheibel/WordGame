package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoHard implements MecanicaDoJogo {

	private static final int TRY_AGAIN_POSSIBLE = 1;
	private int numeroTentativaAtual;
	public Integer pontuacaoAtual;
	
	public MecanicaDoJogoHard(){
		super();
		this.numeroTentativaAtual = 0;
		setCurrentScore(0);
	}
	
	@Override
	public boolean isTerminate() {
		return false;
	}

	@Override
	public boolean isAssert(String expected, String Word) {
		if (expected.equals(Word)) {
			System.out.println("Acertou_Hard");
			return true;			
		} else {
			numeroTentativaAtual++;
			System.out.println("Errou_Hard");
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

	private void setCurrentScore(Integer ponint){
		pontuacaoAtual = ponint; 
	}
}
