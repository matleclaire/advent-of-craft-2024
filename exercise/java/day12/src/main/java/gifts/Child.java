package gifts;

import java.util.Optional;

public class Child {

    private final String name;
    private final Behavior behavior;
    private Wishlist wishlist;

    private Child(String name, Behavior behavior, Wishlist wishlist) {
        this.name = name;
        this.behavior = behavior;
        this.wishlist = wishlist;
    }

    public static Optional<Child> createChild(String name, Behavior behavior, Toy... toys) {
        if (toys == null || toys.length != 3) {
            return Optional.empty();
        }
        return Optional.of(new Child(name, behavior, new Wishlist(toys)));

    }

    public Behavior getBehavior() {
        return behavior;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public String getName() {
        return name;
    }

    public void setWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice) {
        wishlist.setWishList(firstChoice, secondChoice, thirdChoice);
    }

}
