package br.com.workgame.engine.interfaces;

/**
 * Interface que representa o andamento e a lógica do jogo. É responsável por
 * ditar o andamento do jogo. Ela que vai dizer se o jogo acabou ou não, se o
 * usuário acertou a palavra ou não, se o usuário pode tentar acertar a palavra
 * novamente e qual foi a pontuação final do jogador. Pelo menos duas
 * implementações dessa interface devem ser criadas
 * 
 * @author jonathan
 *
 */
public interface MecanicaDoJogo {

	public boolean isTerminate();
	public boolean isAssert(String expected, String Word);
	public boolean isTryAgain();
	public double getFinalScore();
	public int tryingPossible();
	public Integer getNumeroTentativaAtual();
	
}
