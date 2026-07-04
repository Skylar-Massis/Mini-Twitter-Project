package minitwitter;

//This is used in order to implement the composite pattern into the design.
public interface UserComponent{
void accept(Visitor v);
String getID();
void setID(String newID);
boolean isLeaf();
@Override
String toString();
}
