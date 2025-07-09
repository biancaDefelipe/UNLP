package ar.edu.unlp.oo1.ejercicio1.app;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;


public class JSONFormatter extends SimpleFormatter {

	//{ "message": "Logging with json", "level": "info" }
	@Override
	public String format(LogRecord record) {
		return "{" + "message: " + record.getMessage()
				+ ", " + "level :" + record.getLevel().toString()
				+ " }";
	}

}
