package minitwitter;

//Visitor to count total users
public class TotalUsersVisitor implements Visitor {
    public int total = 0;

    //Increments for every user
    @Override public void visitUser(User u) {
        total++; 
    }
    
    //Doesn't need to use this method for the visitor.
    @Override public void visitGroup(UserGroup g) { }
}
