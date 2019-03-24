package br.com.twinsflammer.mcmmo.cosmetics.booster.data.manager;

import org.bukkit.entity.Player;

public interface BoosterManager {

    /**
     * Calculate bonus experience by player.
     *
     * @param player the player
     * @param exp    the initial exp
     * @return the calculated bonus experience
     */
    float getBonusExperienceByPlayer(Player player, float exp);
}
