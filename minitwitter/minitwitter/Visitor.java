package minitwitter;

//Interface for visitors
public interface Visitor {
    void visitUser(User u);
    void visitGroup(UserGroup g);
}
