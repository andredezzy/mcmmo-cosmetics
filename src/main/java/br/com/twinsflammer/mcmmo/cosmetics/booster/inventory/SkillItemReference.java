package br.com.twinsflammer.mcmmo.cosmetics.booster.inventory;

import br.com.twinsflammer.api.inventory.item.Item;
import br.com.twinsflammer.mcmmo.cosmetics.booster.inventory.consumer.SkillChooserInventoryConsumer;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Optional;

public enum SkillItemReference {

    SWORDS(PrimarySkillType.SWORDS, new Item(Material.DIAMOND_SWORD).name("§aEspadas").setConsumer(Constants.SKILL_CHOOSER_INVENTORY_CONSUMER)),
    MINING(PrimarySkillType.MINING, new Item(Material.DIAMOND_PICKAXE).name("§aMineração").setConsumer(Constants.SKILL_CHOOSER_INVENTORY_CONSUMER)),
    AXES(PrimarySkillType.AXES, new Item(Material.DIAMOND_AXE).name("§aMachados").setConsumer(Constants.SKILL_CHOOSER_INVENTORY_CONSUMER)),
    EXCAVATION(PrimarySkillType.EXCAVATION, new Item(Material.DIAMOND_SPADE).name("§aEscavação").setConsumer(Constants.SKILL_CHOOSER_INVENTORY_CONSUMER)),
    ACROBATICS(PrimarySkillType.ACROBATICS, new Item(Material.DIAMOND_BOOTS).name("§aEspad1a").setConsumer(Constants.SKILL_CHOOSER_INVENTORY_CONSUMER)),
    HERBALISM(PrimarySkillType.HERBALISM, new Item(Material.SEEDS).name("§aHerbalismo").setConsumer(Constants.SKILL_CHOOSER_INVENTORY_CONSUMER));

    private PrimarySkillType skillType;
    private Item itemReference;

    SkillItemReference(PrimarySkillType skillType, Item itemReference) {
        this.skillType = skillType;
        this.itemReference = itemReference;
    }

    public PrimarySkillType getSkillType() {
        return skillType;
    }

    public Item getItemReference() {
        return itemReference;
    }

    public static Optional<SkillItemReference> getReference(ItemStack itemStack) {
        return Arrays.stream(values())
                .filter(it -> it.getItemReference().build().clone().isSimilar(itemStack))
                .findFirst();
    }

    private static class Constants {
        public static final SkillChooserInventoryConsumer SKILL_CHOOSER_INVENTORY_CONSUMER = SkillChooserInventoryConsumer.getSingleton();
    }
}
