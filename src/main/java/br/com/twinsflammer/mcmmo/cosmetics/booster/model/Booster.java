package br.com.twinsflammer.mcmmo.cosmetics.booster.model;

import br.com.twinsflammer.mcmmo.cosmetics.booster.type.BoosterType;

public class Booster {

    private int id;
    private int userId;
    private BoosterType boosterType;
    private long timeLimit;

    public Booster(int id, int userId, BoosterType boosterType, long timeLimit) {
        this.id = id;
        this.userId = userId;
        this.boosterType = boosterType;
        this.timeLimit = timeLimit;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public BoosterType getBoosterType() {
        return boosterType;
    }

    public long getTimeLimit() {
        return timeLimit;
    }
}
