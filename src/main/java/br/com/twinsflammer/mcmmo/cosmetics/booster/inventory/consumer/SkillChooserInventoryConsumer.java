package br.com.twinsflammer.mcmmo.cosmetics.booster.inventory.consumer;

import br.com.twinsflammer.api.permissions.PermissionsManager;
import br.com.twinsflammer.api.permissions.data.User;
import br.com.twinsflammer.mcmmo.cosmetics.Cosmetics;
import br.com.twinsflammer.mcmmo.cosmetics.booster.data.database.IDao;
import br.com.twinsflammer.mcmmo.cosmetics.booster.model.Booster;
import br.com.twinsflammer.mcmmo.cosmetics.util.OptionalConsumer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SkillChooserInventoryConsumer implements Consumer<InventoryClickEvent> {

    private IDao boosterDao;

    public SkillChooserInventoryConsumer() {
        Cosmetics cosmeticsInstance = Cosmetics.getInstance();
        this.boosterDao = cosmeticsInstance.getBoosterApplication().getDao();
    }

    @Override
    public void accept(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        Optional<User> optionalUser = Optional.of(PermissionsManager.getUser(player.getName()));
        optionalUser.ifPresent(user -> {
            Stream<Booster> boostersByUserId = this.boosterDao.getAllByUserId(user.getId());
            OptionalConsumer.of(boostersByUserId
                    .filter(it -> /* TODO filter clicked item by booster's activated skill type */ false).findFirst())
                    .ifPresent(it -> {/* TODO if has any booster activated to item's skill reference */})
                    .ifNotPresent(() -> {/* TODO if has not || */});
        });
    }
}
