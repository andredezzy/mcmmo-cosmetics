package br.com.twinsflammer.manager;

import br.com.twinsflammer.Booster;
import br.com.twinsflammer.type.BoosterType;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BoosterManager {

    public double getBonusExperienceByPlayer(Player player, double exp){
        double defaultBonus = exp * Booster.DEFAULT_MULTIPLIER;

        for (BoosterType boosterType : BoosterType.values()) {
            if(player.hasPermission(boosterType.getPermission())) {
                return defaultBonus + (exp * boosterType.getMultiplier());
            }
        }

        return defaultBonus;
    }
}
