package patterns.delegation.logger;

import java.io.OutputStream;

public class FilteringLogger implements ILogger {

	ILogger logger;
	String[] severities;
	boolean errorLogging, infoLogging, warningLogging = false;
	OutputStream stream;
	String formatString = "%s: %s (%s)";
	// private List<String> list = new ArrayList<String>();
	// private ILogger l = new StreamLogger(stream);

	public FilteringLogger(ILogger logger, String... severities) {
		this.logger = logger;
		this.severities = severities;

		for (int i = 0; i < severities.length; i++) {
			this.setIsLogging(severities[i], true);
		}

	}

	public void log(String severity, String message, Exception exception) {

		for (String s : severities) {
			if (s == severity) {
				this.logger.log(severity, message, exception);
			}
		}
	}

	public boolean isLogging(String severity) {
		switch (severity) {
		case "error":
			return errorLogging;
		case "warning":
			return warningLogging;
		case "info":
			return infoLogging;
		default:
			throw new IllegalArgumentException("Invalid severity input");
		}
	}

	public void setIsLogging(String severity, boolean bol) {
		switch (severity) {
		case "error":
			this.errorLogging = bol;
			break;
		case "warning":
			this.warningLogging = bol;
			break;
		case "info":
			this.infoLogging = bol;
			break;
		default:
			throw new IllegalArgumentException("Invalid severity input");
		}
	}
}
