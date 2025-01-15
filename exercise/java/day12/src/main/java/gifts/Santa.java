package gifts;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Santa {

    private final List<Child> childrenRepository;
    public Santa() {
        this.childrenRepository = new ArrayList<>();
    }

    public Toy chooseToyForChild(String childName){
        var found = findChild(childName);
        Child child = found.orElseThrow(NoSuchElementException::new);

        if("naughty".equals(child.getBehavior()))
            return child.getWishlist().get(child.getWishlist().size() - 1);

        if("nice".equals(child.getBehavior()))
            return child.getWishlist().get(1);

        if("very nice".equals(child.getBehavior()))
            return child.getWishlist().get(0);

        return null;
    }

    private Optional<Child> findChild(String childName) {
        Optional<Child> found = Optional.empty();
        for (Child currentChild : childrenRepository) {
            if (currentChild.getName().equals(childName)) {
                found = Optional.of(currentChild);
            }
        }
        return found;
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
