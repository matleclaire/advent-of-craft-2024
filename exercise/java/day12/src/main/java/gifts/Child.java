package gifts;

public class Child {

    private final String name;
    private final String behavior;
    private Wishlist wishlist;

    public Child(String name, String behavior) {
        this.name = name;
        this.behavior = behavior;
        this.wishlist = new Wishlist();
    }

    public String getBehavior() {
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
