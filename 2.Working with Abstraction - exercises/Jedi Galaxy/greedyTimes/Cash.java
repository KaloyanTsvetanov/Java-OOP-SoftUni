package greedyTimes;

public class Cash {

    private String currency;
    private int amount;

    public Cash(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("##%S - %d",currency,amount);
    }
}
