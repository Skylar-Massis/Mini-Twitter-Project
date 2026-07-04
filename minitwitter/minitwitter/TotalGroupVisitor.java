package minitwitter;

//Class that counts the number of groups
public class TotalGroupVisitor implements Visitor{
    public int total = 0;

    @Override public void visitUser(User u) {}
    @Override public void visitGroup(UserGroup g) {
        total++;
    }
}
