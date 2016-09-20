package br.com.workgame.assistant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BancoDePalavras {	
	
	private static ArrayList<String> listWords = new ArrayList<>();
	private static final String NAME_FILE_WORDS = "resource/banco/palavras.txt";	
	

	//Realiza a importação das palavras possíveis para a aplicação
	private static void importWords() {
		File file = new File(NAME_FILE_WORDS);
		try {		
			Scanner sc;
			try {
				sc = new Scanner(file);			
				while (sc.hasNextLine()){			
					listWords.add(sc.nextLine());
				}			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				sc = null;
			}		
		} finally {
			file = null;
		}
	}
	
	//Falso get para buscar uma nova palavra da lista aleatóriamente
	public static String getNewWord(){
		
		//Caso seja a primeira vez que a nova palavra foi requisitada, o sistema as importará
		if (listWords.size() == 0) 
			importWords();
		
		Random generator = new Random();		
		return listWords.get(generator.nextInt(listWords.size()));
	}
	
}
