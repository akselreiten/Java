package patterns.delegation.logger;

import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamLogger implements ILogger {

	OutputStream stream; 
	String formatString = "%s: %s (%s)"; 
	
	public StreamLogger(OutputStream stream) {
		this.stream = stream; 
	}

	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
	
	public void log(String severity, String message, Exception exception) {

		PrintWriter writer = new PrintWriter(stream);
		String logMessage = String.format(this.formatString, severity, message, exception);
		writer.println(logMessage);
		writer.flush(); //tømmer bufferen
		
	}
	
}
