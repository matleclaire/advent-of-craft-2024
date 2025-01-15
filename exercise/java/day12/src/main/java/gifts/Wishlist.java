package gifts;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    List<Toy> wishlist;

    public Wishlist() {
        this.wishlist = new ArrayList<>();
    }

    public Toy getFirstChoice() {
        return wishlist.get(0);
    }

    public Toy getSecondChoice() {
        return wishlist.get(1);
    }

    public Toy getThirdChoice() {
        return wishlist.get(2);
    }

    public void setWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice) {
        this.wishlist = List.of(firstChoice, secondChoice, thirdChoice);
    }
}
