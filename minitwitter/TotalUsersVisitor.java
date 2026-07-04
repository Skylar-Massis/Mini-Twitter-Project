package minitwitter;


public class TotalUsersVisitor implements Visitor {
    public int total = 0;

    @Override public void visitUser(User u) {
        total++; 
    }
    
    @Override public void visitGroup(UserGroup g) { }
}
