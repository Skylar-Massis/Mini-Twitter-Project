package minitwitter;

//Visitor to implement the last updated user feature
public class LastUpdatedUserVisitor implements Visitor {
    private User lastUpdatedUser;

    @Override
    public void visitUser(User u) {
        if (lastUpdatedUser == null || u.getLastUpdateTime() > lastUpdatedUser.getLastUpdateTime()) {
            lastUpdatedUser = u;
        }
    }

    @Override
    public void visitGroup(UserGroup g) { }

    public User getLastUpdatedUser() {
        return lastUpdatedUser;
    }
}