package patterns.delegation.logger;

public class DistributingLogger implements ILogger{

	private ILogger errorLogger;
	private ILogger warningLogger;
	private ILogger infoLogger;
	
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger){
		this.errorLogger = errorLogger;
		this.warningLogger = warningLogger; 
		this.infoLogger = infoLogger; 
	}
	
	public void log(String severity, String message, Exception exception) {
		switch (severity){
		case "error": 
			errorLogger.log(severity, message, exception);
			break;
		case "warning":
			warningLogger.log(severity, message, exception);
			break;
		case "info": 
			infoLogger.log(severity, message, exception);
			break;
		default: 
			throw new IllegalArgumentException("Invalid severity input"); 
		}
		
	}	
	
	public void setLogger(String severity, ILogger logger) {
		switch (severity){
		case "error": 
			errorLogger = logger; 
			break;
		case "warning":
			warningLogger = logger;
			break;
		case "info": 
			infoLogger = logger;
			break; 
		default: 
			throw new IllegalArgumentException("Invalid severity input"); 
		}
	}
	
}
