package com.example.who_wants_to_be_a_millionaire;
public class PrizeManager {
    private static PrizeManager instance;
    private int totalPrizeMoney;

    private PrizeManager() {
        totalPrizeMoney = 0;
    }

    public static PrizeManager getInstance() {
        if (instance == null) {
            instance = new PrizeManager();
        }
        return instance;
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public void addPrizeMoney(int amount) {
        this.totalPrizeMoney= amount;
    }
}
