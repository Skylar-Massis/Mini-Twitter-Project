package minitwitter;

public class TotalMessagesVisitor implements Visitor {
    public int total = 0;

    @Override
    public void visitUser(User u) {
        total += u.getFeed().size();
    }

    @Override
    public void visitGroup(UserGroup g) { }
}