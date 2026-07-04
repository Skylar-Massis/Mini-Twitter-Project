package minitwitter;

//This class is used to lookup users which is used in some methods.
public class UserLookupVisitor implements Visitor {
    private final String targetId;
    private User found;
    
    public UserLookupVisitor(String targetId) {
        this.targetId = targetId;
    }

    public User getFound() {
        return found;
    }

    @Override
    public void visitUser(User u) {
        if (u.getID().equals(targetId)) {
            found = u;
        }
    }

    @Override
    public void visitGroup(UserGroup g) { }
}
