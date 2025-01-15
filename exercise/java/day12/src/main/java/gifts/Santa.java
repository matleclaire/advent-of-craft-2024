package gifts;

import java.util.NoSuchElementException;

public class Santa {

    private final ChildrenRepository childrenRepository;

    public Santa() {
        this.childrenRepository = new ChildrenRepository();
    }

    public Toy chooseToyForChild(String childName) {
        return childrenRepository.findByName(childName)
                .map(Child::chooseToy)
                .orElseThrow(NoSuchElementException::new);
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
