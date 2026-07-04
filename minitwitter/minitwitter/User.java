package minitwitter;

import java.util.ArrayList;
import java.util.List;

//Class for User.
public final class User implements UserComponent, Subject{
    private String UserID;
    private List<Tweet> tweets;
    private List<User> following = new ArrayList<>();
    private List<User> followedBy = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private List<String> feed = new ArrayList<>();
    private final long creationTime;
    private long lastUpdateTime;

    //Constructor for user
    public User(){
        this.creationTime = System.currentTimeMillis();
        this.lastUpdateTime = this.creationTime;
    }
    
    //Constructor for user which allows for names
    public User(String name){
        this();
        this.setID(name);
    }

    //Getter for creationtime
    public long getCreationTime() {
        return creationTime;
    }
    
    //Getter for lastupdatetime
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }
    
    //Getter for followedBy
    public List<User> getFollowedBy() {
        return followedBy;
    }
    
    //Setter for followedBy
    public void setFollowedBy(List<User> followedBy) {
        this.followedBy = followedBy;
    }
    
    //Method to post a tweet. It notifies the observers as well
    public void postTweet(String message){
        Tweet t = new Tweet();
        t.setTweetMessage(message);
        feed.add(t.getTweetMessage());
        lastUpdateTime = System.currentTimeMillis();
        notifyObservers(message);
        for (User follower : followedBy) {
            follower.getFeed().add(message);
            follower.lastUpdateTime = System.currentTimeMillis();
            follower.notifyObservers(message);
        }
    }
    // Returns the tweets list for the user object
    public List<Tweet> getTweets(){
        return tweets;
    }
    
    //Gets the feed for the user object
    public List<String> getFeed() {
        return feed;
    }

    //Sets the feed for the user object
    public void setFeed(List<String> feed) {
        this.feed = feed;
    }

    //Gets who the user is following
    public List<User> getFollowing() {
        return following;
    }

    //Sets who the user is following
    public void setFollowing(List<User> following) {
        this.following = following;
    }
    
    // Gets the ID for the user
    @Override
    public String getID() {
        return UserID;
    }

    // Sets the ID for the user
    @Override
    public void setID(String newID) {
        this.UserID = newID;
    }
    
    //Users are always leafs so this is always true
    @Override 
    public boolean isLeaf() { 
        return true; 
    }
    
    //This is for the tree so that the User shows up with the ID instead of
    //what the object appears as.
    @Override
    public String toString(){
        return getID();
    }
    
    //Method so that user is visitable
    @Override
    public void accept(Visitor v){
        v.visitUser(this);
    }
    
    //Method so that user can add observers
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }
    
    //Method so that user can remove observer
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    
    //Notifies the observers of a new message
    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
