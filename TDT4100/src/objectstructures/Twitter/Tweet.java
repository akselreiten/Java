package objectstructures.Twitter;

public class Tweet {
	
	private Tweet originalTweet;
	private TwitterAccount account; 
	private String tweetText; 
	int retweetCount;
	
	//Ny originaltweet-konstruktør
	public Tweet(TwitterAccount account, String tweetText){
		this.tweetText = tweetText; 
		this.account = account; 
	}
	
	//Ny retweet-konstruktør
	public Tweet(TwitterAccount account, Tweet tweet) {
		if (tweet.getOriginalTweet() == null){
			//da er tweet originaltweet. 
			originalTweet = tweet; 
		} else {
			//Tweeten er bare en retweet
			
			if (tweet.getOriginalTweet().getOwner().equals(account)){
				throw new IllegalArgumentException("Can't retweet your own tweet!");
			}
			
			originalTweet = tweet.getOriginalTweet();
		}
		
		this.tweetText = tweet.getText();
		this.account = account; 
		originalTweet.retweetCount++;
	}
	
	public String getText(){
		return tweetText; 
	}
	
	public TwitterAccount getOwner(){
		return account; 
	}
	
	public Tweet getOriginalTweet(){
		return originalTweet;
	}
	
	public int getRetweetCount(){
		return retweetCount; 
	}
	
	public static void main(String[] args) {
	}
	
	@Override
	public String toString(){
		return account + " has tweeted:\n" + tweetText;
		
		/*if (account != originalTweet.getOwner() && getOriginalTweet() != null){
			return account + " has retweeted" + originalTweet.getOwner() + ":\n"
					+ tweetText;
		}
		return account + " has tweeted:\n" + tweetText; */
	}
	
}
