package patterns.observable.highscorelist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreList {

	private List<HighscoreListListener> listeners = new ArrayList<HighscoreListListener>();
	private List<Integer> results = new ArrayList<Integer>(); 
	private int maxSize; 
	
	public HighscoreList(int maxSize){
		this.maxSize = maxSize;
	}
	
	public void addHighscoreListListener(HighscoreListListener listener){
		if (!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener){
		if (listeners.contains(listener)){
			listeners.remove(listeners.indexOf(listener));
		}
	}
	
	public int size(){
		return results.size(); 
	}
	
	public int getElement(int index){
		if (index < size()){
			return results.get(index);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void broadcastChange(int index){
		for (HighscoreListListener l : listeners){
			l.listChanged(this, index);
		}
	}
	
	public void addResult(int result){
		int pos = 0; 
		while (pos < size() && result >= results.get(pos)){
			pos++; 
		}
		
		if (pos < maxSize){
			while (size() >= maxSize){
				results.remove(size()-1); 
			}
			results.add(pos,result);
			broadcastChange(pos);
			
		}
	}
	
	/*public String toString(){
		String out = "";
		int num = 1; 
		for (int res : results){
			out += num + ". " + res + "\n"; 
			num++;
		}
		
		return out; 
	}
	public static void main(String[] args) {
		HighscoreList hs = new HighscoreList(5);
		hs.addResult(103);
		hs.addResult(200);
		hs.addResult(33);
		hs.addResult(4512);
		hs.addResult(512);
		hs.addResult(215);
		hs.addResult(11364);
		hs.addResult(89);
		
		System.out.println(hs.results);
	}*/
}
