package ar.edu.unlp.oo1.ejercicio1.app;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.ArrayList;
import java.util.logging.LogRecord;

public class WordFilterHandler extends ConsoleHandler {

	private List<String> censoredWords;
	
	public WordFilterHandler() {
		super();
		this.censoredWords = new ArrayList<String>();
	}
	
	public void addCensoredWord(String word) {
		this.censoredWords.add(word);
	}
	
	public void removeCensoredWord(String word) {
		this.censoredWords.remove(word);
	}
	
	@Override
	public void publish(LogRecord record) {
		String message = record.getMessage();
		for (String word : this.censoredWords) {
			if (message.contains(word)) {
				record.setMessage(message.replace(word, "***"));
			}
		}
		super.publish(record);
	}
	
}
