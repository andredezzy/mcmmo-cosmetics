package br.com.twinsflammer.mcmmo.cosmetics.booster.model;

import br.com.twinsflammer.mcmmo.cosmetics.booster.type.BoosterType;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;

public class Booster {

    private int id;
    private int userId;
    private PrimarySkillType activatedSkillType;
    private BoosterType boosterType;
    private long timeLimit;

    public Booster(int id, int userId, PrimarySkillType activatedSkillType, BoosterType boosterType, long timeLimit) {
        this.id = id;
        this.userId = userId;
        this.activatedSkillType = activatedSkillType;
        this.boosterType = boosterType;
        this.timeLimit = timeLimit;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public PrimarySkillType getActivatedSkillType() {
        return activatedSkillType;
    }

    public BoosterType getBoosterType() {
        return boosterType;
    }

    public long getTimeLimit() {
        return timeLimit;
    }
}
