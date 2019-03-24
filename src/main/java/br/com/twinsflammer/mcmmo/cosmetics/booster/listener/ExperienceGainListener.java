package br.com.twinsflammer.mcmmo.cosmetics.booster.listener;

import br.com.twinsflammer.api.util.ActionBar;
import br.com.twinsflammer.mcmmo.cosmetics.Cosmetics;
import br.com.twinsflammer.mcmmo.cosmetics.booster.data.manager.BoosterManagerImpl;
import com.gmail.nossr50.config.experience.ExperienceConfig;
import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;
import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.util.player.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ExperienceGainListener implements Listener {

    @EventHandler
    public void onReceiveExperience(McMMOPlayerXpGainEvent event) {
        Player player = event.getPlayer();

        PrimarySkillType skillType = event.getSkill();
        float bonusExperience = this.getBonusExperience(player, event.getRawXpGained());

        event.setRawXpGained(bonusExperience);
        this.sendExperienceGainInformationToActionBar(player, skillType, bonusExperience);
    }

    private float getBonusExperience(Player player, float exp) {
        BoosterManagerImpl boosterManager = Cosmetics.getInstance().getBoosterApplication().getManager();

        return boosterManager.getBonusExperienceByPlayer(player, exp);
    }

    private void sendExperienceGainInformationToActionBar(Player player, PrimarySkillType skillType, float experienceGained) {
        McMMOPlayer mcMMOPlayer = UserManager.getPlayer(player);

        String skillName = skillType.getName();
        int skillLevel = mcMMOPlayer.getSkillLevel(skillType);
        int skillXpLevel = mcMMOPlayer.getSkillXpLevel(skillType);
        int cachedXpToLevel = mcMMO.getFormulaManager().getCachedXpToLevel(skillXpLevel, ExperienceConfig.getInstance().getFormulaType());

        ActionBar.sendActionBarMessage(player, String.format("§a%s: %s (%s/%s) +%s XP", skillName, skillLevel, skillXpLevel, cachedXpToLevel, (int) experienceGained));
    }
}
