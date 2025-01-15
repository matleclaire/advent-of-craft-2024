package gifts;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Santa {

    private final ChildrenRepository childrenRepository;

    public Santa() {
        this.childrenRepository = new ChildrenRepository();
    }

    public Toy chooseToyForChild(String childName){
        var found = childrenRepository.findChild(childName);
        Child child = found.orElseThrow(NoSuchElementException::new);

        if("naughty".equals(child.getBehavior()))
            return child.getWishlist().get(child.getWishlist().size() - 1);

        if("nice".equals(child.getBehavior()))
            return child.getWishlist().get(1);

        if("very nice".equals(child.getBehavior()))
            return child.getWishlist().get(0);

        return null;
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
