package br.com.twinsflammer.mcmmo.cosmetics.booster;

import br.com.twinsflammer.mcmmo.cosmetics.Main;
import br.com.twinsflammer.mcmmo.cosmetics.booster.listener.ExperienceGainListener;
import br.com.twinsflammer.mcmmo.cosmetics.booster.manager.BoosterManager;

public class BoosterApplication {

    public static final float DEFAULT_MULTIPLIER = 2.0F;

    private BoosterManager boosterManager;

    public BoosterApplication() {
        this.boosterManager = new BoosterManager();
        this._init();
    }

    private void _init(){
        Main mainInstance = Main.getInstance();

        mainInstance.getServer().getPluginManager().registerEvents(new ExperienceGainListener(), mainInstance);
    }

    public BoosterManager getManager() {
        return boosterManager;
    }
}
