package interfaces.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount>{

	@Override
	public int compare(TwitterAccount o1, TwitterAccount o2) {
		if(o1.followers.size() > o2.followers.size()){
		      return 1;
		   }else if(o1.followers.size() < o2.followers.size()){
		      return -1;
		   }else{
		     return 0;
		   }
	}

}
