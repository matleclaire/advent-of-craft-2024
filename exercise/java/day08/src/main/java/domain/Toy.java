package domain;

import static domain.Toy.State.UNASSIGNED;

public class Toy {
    public enum State {
        UNASSIGNED, IN_PRODUCTION, COMPLETED;
    }
    private final String name;

    private State state;
    public Toy(String name) {
        this.name = name;
        this.state = UNASSIGNED;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public  void assignToElf() {
        if (this.state == State.UNASSIGNED) {
            this.state = State.IN_PRODUCTION;
        }
    }

}
