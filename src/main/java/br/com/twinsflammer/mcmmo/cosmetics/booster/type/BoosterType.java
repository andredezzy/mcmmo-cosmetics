package br.com.twinsflammer.mcmmo.cosmetics.booster.type;

public enum BoosterType {

    ZEUS("twinsflammer.mcmmo.multiplier.zeus", 1.5D),
    HERMES("twinsflammer.mcmmo.multiplier.hermes", 1D),
    PERSEU("twinsflammer.mcmmo.multiplier.perseu", 0.75D);

    private String permission;
    private double multiplier;

    BoosterType(String permission, double multiplier) {
        this.permission = permission;
        this.multiplier = multiplier;
    }

    public String getPermission() {
        return permission;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
