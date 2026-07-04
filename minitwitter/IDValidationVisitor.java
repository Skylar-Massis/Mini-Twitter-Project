package minitwitter;

import java.util.HashSet;
import java.util.Set;


// Visitor to add in the ID Validation feature
public class IDValidationVisitor implements Visitor {
    private final Set<String> seenIds = new HashSet<>();
    private boolean valid = true;

    @Override
    public void visitUser(User u) {
        checkId(u.getID());
    }

    @Override
    public void visitGroup(UserGroup g) {
        checkId(g.getID());
    }
    // Checks if the ID is valid or not
    private void checkId(String id) {
        if (id == null || id.contains(" ")) {
            valid = false;
        }
        if (!seenIds.add(id)) {
            valid = false;
        }
    }

    public boolean isValid() {
        return valid;
    }
}
