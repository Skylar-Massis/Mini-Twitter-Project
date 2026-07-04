package minitwitter;

//This is the visitor interface which is used to implement the visitor design principle.
public interface Visitor {
    void visitUser(User u);
    void visitGroup(UserGroup g);
}
