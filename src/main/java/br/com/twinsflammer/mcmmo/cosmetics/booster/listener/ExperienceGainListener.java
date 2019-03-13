package br.com.twinsflammer.mcmmo.cosmetics.booster.listener;

import br.com.twinsflammer.mcmmo.cosmetics.Main;
import br.com.twinsflammer.mcmmo.cosmetics.booster.manager.BoosterManager;
import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ExperienceGainListener implements Listener {

    @EventHandler
    public void onReceiveExperience(McMMOPlayerXpGainEvent event) {
        Player player = event.getPlayer();
        float experienceGained = event.getRawXpGained();

        BoosterManager boosterManager = Main.getInstance().getBoosterApplication().getManager();

        float bonusExperienceGained = boosterManager.getBonusExperienceByPlayer(player, experienceGained);

        event.setRawXpGained(bonusExperienceGained);
    }
}
