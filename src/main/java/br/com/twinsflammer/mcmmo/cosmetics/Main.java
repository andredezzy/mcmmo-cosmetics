package br.com.twinsflammer.mcmmo.cosmetics;

import br.com.twinsflammer.mcmmo.cosmetics.booster.BoosterApplication;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main INSTANCE;

    public static Main getInstance() {
        return INSTANCE;
    }

    private BoosterApplication boosterApplication;

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.boosterApplication = new BoosterApplication();
    }

    public BoosterApplication getBoosterApplication() {
        return boosterApplication;
    }
}
