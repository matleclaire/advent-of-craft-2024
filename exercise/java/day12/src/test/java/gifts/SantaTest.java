package gifts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

class SantaTest {

    private static final Toy PLAYSTATION = new Toy("playstation");
    private static final Toy BALL = new Toy("ball");
    private static final Toy PLUSH = new Toy("plush");


    @Test
    void given_naughty_child_when_distributing_gifts_then_child_receives_third_choice() {
        Optional<Child> bobby = Child.createChild("bobby", Behavior.NAUGHTY, PLAYSTATION, PLUSH, BALL);
        Santa santa = new Santa();
        santa.addChild(bobby.get());
        Toy got = santa.chooseToyForChild("bobby");

        Assertions.assertEquals(BALL, got);
    }

    @Test
    void given_nice_child_when_distributing_gifts_then_child_receives_second_choice() {
        Optional<Child> bobby = Child.createChild("bobby", Behavior.NICE, PLAYSTATION, PLUSH, BALL);
        Santa santa = new Santa();
        santa.addChild(bobby.get());
        Toy got = santa.chooseToyForChild("bobby");

        Assertions.assertEquals(PLUSH, got);
    }

    @Test
    void given_very_nice_child_when_distributing_gifts_then_child_receives_first_choice() {
        Optional<Child> bobby = Child.createChild("bobby", Behavior.VERY_NICE, PLAYSTATION, PLUSH, BALL);
        Santa santa = new Santa();
        santa.addChild(bobby.get());
        Toy got = santa.chooseToyForChild("bobby");

        Assertions.assertEquals(PLAYSTATION, got);
    }

    @Test
    void given_non_existing_child_when_distributing_gifts_then_exception_thrown() {
        Santa santa = new Santa();
        Optional<Child> bobby = Child.createChild("bobby", Behavior.VERY_NICE, PLAYSTATION, PLUSH, BALL);
        santa.addChild(bobby.get());

        Assertions.assertThrows(NoSuchElementException.class, () -> santa.chooseToyForChild("alice"));
    }
}
