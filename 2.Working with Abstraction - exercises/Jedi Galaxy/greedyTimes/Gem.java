package greedyTimes;

import java.util.Locale;

public class Gem {

    private String gem;
    private int amount;

    public Gem(String gem, int amount) {
        this.gem = gem;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getGem() {
        return gem;
    }

    public void setGem(String gem) {
        this.gem = gem;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("##%s - %d",gem,amount);
    }
}
