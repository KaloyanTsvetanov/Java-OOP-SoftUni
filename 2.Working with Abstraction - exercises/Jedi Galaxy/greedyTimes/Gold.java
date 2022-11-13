package greedyTimes;

public class Gold {

    private final String gold = "Gold";
    private int amount;

    public Gold(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d",gold,amount);
    }
}
