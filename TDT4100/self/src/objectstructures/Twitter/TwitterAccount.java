package objectstructures.Twitter;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {

	String username;
	List<Tweet> tweets = new ArrayList<Tweet>();
	List<Tweet> retweets = new ArrayList<Tweet>();
	List<TwitterAccount> followers = new ArrayList<TwitterAccount>();
	List<TwitterAccount> following = new ArrayList<TwitterAccount>();
	
	public TwitterAccount(String username){
		this.username = username; 
	}
	
	public String getUserName(){
		return username; 
	}
	
	public void follow(TwitterAccount account){
		if (!(this.following.contains(account))){
			this.following.add(account);
			account.followers.add(this);
		}
	}
	
	public void unfollow(TwitterAccount account){
		if (this.following.contains(account)){
			this.following.remove(this.following.indexOf(account));
			account.followers.remove(account.followers.indexOf(this));
		}
	}
	
	public boolean isFollowing(TwitterAccount account){
		if (this.following.contains(account)){
			return true; 
		} 
		return false; 
	}
	
	public boolean isFollowedBy(TwitterAccount account){
		if (this.followers.contains(account)){
			return true;
		}
		return false; 
	}
	
	public void tweet(String text){
		Tweet newTweet = new Tweet(this,text);
		tweets.add(newTweet);
	}
	
	public void retweet(Tweet tweet){
		Tweet newRetweet = new Tweet(this,tweet);
		retweets.add(newRetweet);
	}
	
	public Tweet getTweet(int i) {
		return tweets.get(tweets.size()-1-i);
	}
	
	public int getTweetCount(){
		return tweets.size();
	}
	
	public int getRetweetCount(){
		return retweets.size();
	}
	
	public String toString(){
		return username;
	}
	
	public static void main(String[] args) {
		List<TwitterAccount> followers = new ArrayList<TwitterAccount>();
		TwitterAccount reiten = new TwitterAccount("reiten");
		TwitterAccount melstveit = new TwitterAccount("melstveit");
		TwitterAccount osvik = new TwitterAccount("osvik");
		TwitterAccount dahl = new TwitterAccount("dahl");
		
		reiten.follow(osvik); 
		reiten.follow(dahl);
		melstveit.follow(osvik);
		System.out.println(osvik.followers);
		System.out.println(reiten.following);
		
		reiten.tweet("Hei");
		reiten.tweet("på deg! Tweet #2 omg");
		
		Tweet a = reiten.getTweet(0);
		
		System.out.println(a);
		
	}
	
}
