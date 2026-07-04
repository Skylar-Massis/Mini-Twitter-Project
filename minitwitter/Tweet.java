package minitwitter;

//Class for tweet. Not necessary but good to keep around if I want
//to add more information to messages
public class Tweet {
    private String tweetMessage;
    
    public String getTweetMessage() {
        return tweetMessage;
    }

    public void setTweetMessage(String tweetMessage) {
        this.tweetMessage = tweetMessage;
    }
}
