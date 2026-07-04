package minitwitter;

import java.util.Arrays;
import java.util.List;

// Visitor to count percentages of positive messages
public class PositiveMessagesVisitor implements Visitor {
    private static final List<String> POSITIVE_WORDS = Arrays.asList(
        "good", "great", "excellent", "awesome", "fantastic",
        "wonderful", "amazing", "love", "happy", "best"
    );

    private int totalMessages = 0;
    private int positiveMessages = 0;

    //Visits user and checks messages to see if they contain anything in the list
    @Override
    public void visitUser(User u) {
        for (String message : u.getFeed()) {
            totalMessages++;
            if (isPositive(message)) {
                positiveMessages++;
            }
        }
    }

    @Override
    public void visitGroup(UserGroup g) {}

    //Checks if a string contains a positive word using enhanced for loop
    private boolean isPositive(String message) {
        String lower = message.toLowerCase();
        for (String word : POSITIVE_WORDS) {
            if (lower.contains(word)) {
                return true;
            }
        }
        return false;
    }
    //Calculates the percentage for positive words
    public double getPositivePercentage() {
        if (totalMessages == 0) {
            return 0.0;
        }
        return (positiveMessages * 100.0) / totalMessages;
    }
}
