package greedyTimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {

    private List<Gold> gold;
    private List<Gem> gemList;
    private List<Cash> cashList;
    private int capacity;

    public Bag(int capacity) {
        this.capacity = capacity;
        this.gold = new ArrayList<>();
        this.gemList = new ArrayList<>();
        this.cashList = new ArrayList<>();
    }

    public void addGold(Gold gold) {
        if (goldBalance() + gold.getAmount() <= capacity) {
            this.gold.add(gold);
        }
    }

    public void addGem(Gem gem) {
        if (gemBalance() + gem.getAmount() <= goldBalance() && gemBalance() + gem.getAmount() <= capacity) {
            boolean there = gemList.stream().anyMatch(a->a.getGem().equals(gem.getGem()));
            if(!there) {
                this.gemList.add(gem);
            }else {
                gemList.stream().filter(a->a.getGem().equals(gem.getGem())).forEach(a->a.setAmount(gem.getAmount()+a.getAmount()));
            }
        }
    }

    public void addCash(Cash cash) {
        if (cashBalance() + cash.getAmount() <= gemBalance() && cashBalance() + cash.getAmount() <= capacity) {
            boolean there = cashList.stream().anyMatch(a->a.getCurrency().equals(cash.getCurrency()));
            if(!there) {
                this.cashList.add(cash);
            }else {
                cashList.stream().filter(a->a.getCurrency().equals(cash.getCurrency())).forEach(a->a.setAmount(cash.getAmount()+a.getAmount()));
            }
        }
    }

    private int cashBalance() {
        int cashBalance = 0;
        cashBalance = cashList.stream().mapToInt(Cash::getAmount).sum();
        return cashBalance;
    }

    private int gemBalance() {
        int gemBalance = 0;
        gemBalance = gemList.stream().mapToInt(Gem::getAmount).sum();

        return gemBalance;
    }

    private int goldBalance() {
        int goldBalance = 0;
        goldBalance = gold.stream().mapToInt(Gold::getAmount).sum();
        return goldBalance;
    }

    public String getStats() {
        StringBuilder sb = new StringBuilder();
        if (goldBalance() != 0) {
            sb.append("<Gold> $").append(goldBalance()).append("\n");
            sb.append("##Gold - ").append(goldBalance()).append("\n");
        }
        if (!gemList.isEmpty()) {
            gemList = gemList.stream().sorted(Comparator.comparing(Gem::getGem).reversed().thenComparingInt(Gem::getAmount)).collect(Collectors.toList());
            sb.append("<Gem> $").append(gemBalance()).append("\n");
            for (Gem gem : gemList) {
                sb.append(gem).append("\n");
            }
        }
        if (!cashList.isEmpty()) {
            cashList = cashList.stream().sorted(Comparator.comparing(Cash::getCurrency).reversed().thenComparingInt(Cash::getAmount)).collect(Collectors.toList());
            sb.append("<Cash> $").append(cashBalance()).append("\n");
            for (Cash cash : cashList) {
                sb.append(cash).append("\n");
            }
        }
        return sb.toString();
    }
}
