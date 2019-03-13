package br.com.twinsflammer.mcmmo.cosmetics.booster;

import br.com.twinsflammer.mcmmo.cosmetics.booster.manager.BoosterManager;

public class BoosterApplication {

    public static final float DEFAULT_MULTIPLIER = 2.0F;

    private BoosterManager boosterManager;

    public void Booster() {
        this.boosterManager = new BoosterManager();
    }

    public BoosterManager getManager() {
        return boosterManager;
    }
}
