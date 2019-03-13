package br.com.twinsflammer.mcmmo.cosmetics.booster.manager;

import br.com.twinsflammer.mcmmo.cosmetics.booster.BoosterApplication;
import br.com.twinsflammer.mcmmo.cosmetics.booster.type.BoosterType;
import org.bukkit.entity.Player;

public class BoosterManager {

    public double getBonusExperienceByPlayer(Player player, double exp){
        double defaultBonus = exp * BoosterApplication.DEFAULT_MULTIPLIER;

        for (BoosterType boosterType : BoosterType.values()) {
            if(player.hasPermission(boosterType.getPermission())) {
                return defaultBonus + (exp * boosterType.getMultiplier());
            }
        }

        return defaultBonus;
    }
}
