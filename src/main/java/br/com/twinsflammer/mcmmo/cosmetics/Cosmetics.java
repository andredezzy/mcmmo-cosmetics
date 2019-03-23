package br.com.twinsflammer.mcmmo.cosmetics;

import br.com.twinsflammer.mcmmo.cosmetics.booster.BoosterApplication;
import org.bukkit.plugin.java.JavaPlugin;

public class Cosmetics extends JavaPlugin {

    private static Cosmetics INSTANCE;
    
    private BoosterApplication boosterApplication;

    public static Cosmetics getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.boosterApplication = new BoosterApplication();
    }

    public BoosterApplication getBoosterApplication() {
        return boosterApplication;
    }
}
