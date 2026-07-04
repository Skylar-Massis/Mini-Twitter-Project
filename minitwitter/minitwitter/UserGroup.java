package minitwitter;

import java.util.ArrayList;
import java.util.List;

//Implements group so that it can be used with the compoosite design principle.
public final class UserGroup implements UserComponent{
    private String GroupID;
    private List<UserComponent> children = new ArrayList<>();
    private final long creationTime;

    //UserGroup constructor
    public UserGroup(){
        this.creationTime = System.currentTimeMillis();
    }

    //UserGroup constructor that sets the ID
    public UserGroup(String name){
        this();
        this.setID(name);
    }

    //Gets the creation time of the group
    public long getCreationTime() {
        return creationTime;
    }
    
    //Gets the ID of the group
    @Override
    public String getID(){
        return GroupID;
    }
    
    //Sets the ID for the group
    @Override
    public void setID(String newID){
        GroupID = newID;
    }
    
    //Needs this method to add people to the group
    public void addChild(UserComponent child){
        children.add(child);
    }
    
    //Returns the children for the UserGroup
    public List<UserComponent> getChildren(){
        return children;
    }

    //Returns false because the UserGroup is a parent that can contain other
    //UserGroups or users. This is because it is composite and part of the 
    //component interface.
    @Override
    public boolean isLeaf() { 
        return false; 
    }
    
    //Makes it so that it shows the ID on the tree.
    @Override
    public String toString(){
        return getID();
    }
    
    //Makes the usergroup accept visitors
    @Override
    public void accept(Visitor v){
        v.visitGroup(this);
        for (UserComponent c : children){
            c.accept(v);
        }
    }
}
