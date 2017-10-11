package patterns.observable.highscorelist;

public interface HighscoreListListener {

	void listChanged(HighscoreList list, int value);
	
}
