package gifts;

import java.util.NoSuchElementException;

public class Santa {

    private final ChildrenRepository childrenRepository;

    public Santa() {
        this.childrenRepository = new ChildrenRepository();
    }

    public Toy chooseToyForChild(String childName) {
        var found = childrenRepository.findChild(childName);
        Child child = found.orElseThrow(NoSuchElementException::new);

        if ("naughty".equals(child.getBehavior()))
            return child.getWishlist().getThirdChoice();

        if ("nice".equals(child.getBehavior()))
            return child.getWishlist().getSecondChoice();

        if ("very nice".equals(child.getBehavior()))
            return child.getWishlist().getFirstChoice();

        return null;
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
