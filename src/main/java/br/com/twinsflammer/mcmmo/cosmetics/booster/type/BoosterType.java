package br.com.twinsflammer.mcmmo.cosmetics.booster.type;

public enum BoosterType {

    ZEUS("twinsflammer.mcmmo.multiplier.zeus", 1.5F),
    HERMES("twinsflammer.mcmmo.multiplier.hermes", 1F),
    PERSEU("twinsflammer.mcmmo.multiplier.perseu", 0.75F);

    private String permission;
    private float multiplier;

    BoosterType(String permission, float multiplier) {
        this.permission = permission;
        this.multiplier = multiplier;
    }

    public String getPermission() {
        return permission;
    }

    public float getMultiplier() {
        return multiplier;
    }
}
