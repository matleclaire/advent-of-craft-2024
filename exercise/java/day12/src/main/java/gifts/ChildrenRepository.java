package gifts;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChildrenRepository {

    private final List<Child> children;

    public ChildrenRepository() {
        this.children = new ArrayList<>();
    }

    public Optional<Child> findByName(String childName) {
        Optional<Child> found = Optional.empty();
        for (Child currentChild : children) {
            if (currentChild.getName().equals(childName)) {
                found = Optional.of(currentChild);
            }
        }
        return found;
    }

    public void add(Child child) {
        children.add(child);
    }
}
