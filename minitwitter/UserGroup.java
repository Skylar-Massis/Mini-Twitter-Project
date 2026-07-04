package minitwitter;

import java.util.ArrayList;
import java.util.List;

//Implements group so that it can be used with the compoosite design principle.
public final class UserGroup implements UserComponent{
    private String GroupID;
    private List<UserComponent> children = new ArrayList<>();
    private final long creationTime;

    public UserGroup(){
        this.creationTime = System.currentTimeMillis();
    }

    public UserGroup(String name){
        this();
        this.setID(name);
    }

    public long getCreationTime() {
        return creationTime;
    }
    
    @Override
    public String getID(){
        return GroupID;
    }
    
    // Used when creating a new group
    @Override
    public void setID(String newID){
        GroupID = newID;
    }
    
    // Needs this method to add people to the group
    public void addChild(UserComponent child){
        children.add(child);
    }
    
    public List<UserComponent> getChildren(){
        return children;
    }

    
    @Override
    public boolean isLeaf() { 
        return false; 
    }
    
    @Override
    public String toString(){
        return getID();
    }
    
    @Override
    public void accept(Visitor v){
        v.visitGroup(this);
        for (UserComponent c : children){
            c.accept(v);
        }
    }
}
