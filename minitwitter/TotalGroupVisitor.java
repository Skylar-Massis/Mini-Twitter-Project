package minitwitter;

public class TotalGroupVisitor implements Visitor{
    public int total = 0;

    @Override public void visitUser(User u) { }
    @Override public void visitGroup(UserGroup g) { total++; }
}
