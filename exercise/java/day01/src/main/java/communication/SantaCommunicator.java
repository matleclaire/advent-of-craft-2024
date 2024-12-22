package communication;

public class SantaCommunicator {
    private final int numberOfDaysToRest;
    private final int numberOfDaysBeforeChristmas;

    public SantaCommunicator(int numberOfDaysToRest, int numberOfDaysBeforeChristmas) {
        this.numberOfDaysToRest = numberOfDaysToRest;
        this.numberOfDaysBeforeChristmas = numberOfDaysBeforeChristmas;
    }

    public String composeMessage(Reindeer reindeer) {
        var daysBeforeReturn = daysBeforeReturn(reindeer.numbersOfDaysForComingBack(), this.numberOfDaysBeforeChristmas);

        return "Dear " + reindeer.name() + ", please return from " + reindeer.currentLocation() +
                " in " + daysBeforeReturn + " day(s) to be ready and rest before Christmas.";
    }

    public boolean isOverdue(Reindeer reindeer, Logger logger) {
        if (daysBeforeReturn(reindeer.numbersOfDaysForComingBack(), this.numberOfDaysBeforeChristmas) <= 0) {
            logger.log("Overdue for " + reindeer.name() + " located " + reindeer.currentLocation() + ".");
            return true;
        }
        return false;
    }

    private int daysBeforeReturn(int numbersOfDaysForComingBack, int numberOfDaysBeforeChristmas) {
        return numberOfDaysBeforeChristmas - numbersOfDaysForComingBack - numberOfDaysToRest;
    }
}
