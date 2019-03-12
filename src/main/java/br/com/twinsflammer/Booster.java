package br.com.twinsflammer;

import org.bukkit.plugin.java.JavaPlugin;

public class Booster extends JavaPlugin {

    public static final double DEFAULT_MULTIPLIER = 2.0D;

    private static Booster INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
    }
}
