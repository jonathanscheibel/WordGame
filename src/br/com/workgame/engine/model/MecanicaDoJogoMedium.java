package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoMedium implements MecanicaDoJogo{

	private static final int TRY_AGAIN_POSSIBLE = 2;	//Tentativas possíveis
	private static final int RATING 			= 2; 	//Peso
	private static final int MAXIMUM_RESET 		= 15; 	//Acertos para zerar o jogo 
	
	private int numeroTentativaAtual;
	public Integer pontuacaoAtual;
	
	public MecanicaDoJogoMedium(){
		super();
		this.numeroTentativaAtual = 0;
		setCurrentScore(0);
	}

	@Override
	public boolean isAssert(String expected, String Word) {
		if (expected.equalsIgnoreCase(Word)) {
			setCurrentScore(getCurrentScore()+RATING);	
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
	
	public int tryingPossible(){
		return TRY_AGAIN_POSSIBLE - numeroTentativaAtual; 
	}

	@Override
	public Integer getNumeroTentativaAtual() {
		return TRY_AGAIN_POSSIBLE - numeroTentativaAtual;
	}

	@Override
	public boolean isGamefinished() {
		return getCurrentScore() >= MAXIMUM_RESET;
	}

	@Override
	public Integer getCurrentScore() {
		return pontuacaoAtual;
	}
	
	private void setCurrentScore(Integer ponint){
		pontuacaoAtual = ponint; 
	}
}
