package br.com.workgame.engine.model;

import br.com.workgame.engine.interfaces.MecanicaDoJogo;

public class MecanicaDoJogoEasy implements MecanicaDoJogo {

	private static final int TRY_AGAIN_POSSIBLE = 3; 	//Tentativas possíveis
	private static final int RATING 			= 1; 	//Peso
	private static final int MAXIMUM_RESET 		= 10; 	//Acertos para zerar o jogo 
	
	public Integer numeroTentativaAtual;
	public Integer pontuacaoAtual;
	
	public MecanicaDoJogoEasy(){
		super();
		this.numeroTentativaAtual = 0;
		setCurrentScore(0);
	}
	
	public Integer getNumeroTentativaAtual() {
		return numeroTentativaAtual;
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
