package gifts;

public class Child {

    private final String name;
    private final Behavior behavior;
    private Wishlist wishlist;

    public Child(String name, Behavior behavior) {
        this.name = name;
        this.behavior = behavior;
        this.wishlist = new Wishlist();
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
