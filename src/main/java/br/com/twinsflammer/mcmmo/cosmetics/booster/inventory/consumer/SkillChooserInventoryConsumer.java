package br.com.twinsflammer.mcmmo.cosmetics.booster.inventory.consumer;

import br.com.twinsflammer.mcmmo.cosmetics.Cosmetics;
import br.com.twinsflammer.mcmmo.cosmetics.booster.BoosterApplication;
import br.com.twinsflammer.mcmmo.cosmetics.booster.data.database.IDao;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class SkillChooserInventoryConsumer implements Consumer<InventoryClickEvent> {

    private IDao boosterDao;

    public SkillChooserInventoryConsumer() {
        Cosmetics cosmeticsInstance = Cosmetics.getInstance();
        this.boosterDao = cosmeticsInstance.getBoosterApplication().getDao();
    }

    @Override
    public void accept(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        // TODO
    }
}
