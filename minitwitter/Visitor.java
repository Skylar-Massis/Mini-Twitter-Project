package minitwitter;


public interface Visitor {
    void visitUser(User u);
    void visitGroup(UserGroup g);
}
