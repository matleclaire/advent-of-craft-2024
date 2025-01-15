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

        if (Behavior.NAUGHTY.equals(child.getBehavior()))
            return child.getWishlist().getThirdChoice();

        if (Behavior.NICE.equals(child.getBehavior()))
            return child.getWishlist().getSecondChoice();

        if (Behavior.VERY_NICE.equals(child.getBehavior()))
            return child.getWishlist().getFirstChoice();

        return null;
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
