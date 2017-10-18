package stateandbehavior;

public class StopWatch {

	private boolean timeStatus; //true if time is running
	private int totalTickCount; 
	private int tickCount;
	private int currentlapTickCount;
	private int lastLapCount; 
	
	public StopWatch(){
		
	}
	
	public boolean isStarted(){
		if (timeStatus == true) {
			return true; 
		} else {
			return false; 
		}
	}
	
	public boolean isStopped(){
		if (timeStatus == false) {
			return true; 
		} else {
			return false;
		}
	}
	
	public int getTicks(){
		return totalTickCount; 
	}
	
	public int getTime(){
		if (isStarted()){
			return tickCount;
		} else {
			return -1; 
		}
	}
	
	public int getLapTime(){
		if (isStarted()){
			return currentlapTickCount; 
		} else {
			return -1; 
		}
	}
	
	public int getLastLapTime(){
		if (isStarted()){
			if (lastLapCount == 0){
				return -1; 
			} else {
				return lastLapCount; 
			}
		} else {
			return -1; 
		}
	}
	
	public void tick(int tick){
		tickCount += tick;
		currentlapTickCount += tick;  
		
	}
	
	public void start(){
		this.timeStatus = true; 
	}
	
	public void lap(){
		
	}
	
	public void stop(){
		timeStatus = false;
	}
	
}
