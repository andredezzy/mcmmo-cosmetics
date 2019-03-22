package br.com.twinsflammer.mcmmo.cosmetics.booster.data.manager;

import br.com.twinsflammer.mcmmo.cosmetics.booster.BoosterApplication;
import br.com.twinsflammer.mcmmo.cosmetics.booster.type.BoosterType;
import org.bukkit.entity.Player;

public class BoosterManager {

    public float getBonusExperienceByPlayer(Player player, float exp){
        float defaultBonus = exp * BoosterApplication.DEFAULT_MULTIPLIER;

        for (BoosterType boosterType : BoosterType.values()) {
            if(player.hasPermission(boosterType.getPermission())) {
                return defaultBonus + (exp * boosterType.getMultiplier());
            }
        }

        return defaultBonus;
    }
}
