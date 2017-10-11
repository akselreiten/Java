package interfaces.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount>{

	@Override
	public int compare(TwitterAccount t1, TwitterAccount t2) {
		int s = t1.getUserName().compareTo(t2.getUserName());
		if (s != 0){
			return s;
		}
		return 0;
	}

}
