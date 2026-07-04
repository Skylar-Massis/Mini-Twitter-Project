package minitwitter;

import java.util.ArrayList;
import java.util.List;

public final class User implements UserComponent, Subject{
    private String UserID;
    private List<Tweet> tweets;
    private List<User> following = new ArrayList<>();
    private List<User> followedBy = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private List<String> feed = new ArrayList<>();

    public List<User> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(List<User> followedBy) {
        this.followedBy = followedBy;
    }

    public User(){}
    
    public User(String name){
        this.setID(name);
    }
    
    
    public void postTweet(String message){
    Tweet t = new Tweet();
    t.setTweetMessage(message);
    feed.add(t.getTweetMessage());
    notifyObservers(message);
    for (User follower : followedBy) {
        follower.getFeed().add(message);
        follower.notifyObservers(message);
    }
    }
    
    public List<Tweet> getTweets(){
        return tweets;
    }
    
    
    public List<String> getFeed() {
        return feed;
    }

    public void setFeed(List<String> feed) {
        this.feed = feed;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }
    
    @Override
    public String getID() {
        return UserID;
    }

    @Override
    public void setID(String newID) {
        this.UserID = newID;
    }
    
    @Override 
    public boolean isLeaf() { 
        return true; 
    }
    
    @Override
    public String toString(){
        return getID();
    }
    
    @Override
    public void accept(Visitor v){
        v.visitUser(this);
    }
    
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    
    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
