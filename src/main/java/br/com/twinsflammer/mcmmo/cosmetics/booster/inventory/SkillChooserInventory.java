package br.com.twinsflammer.mcmmo.cosmetics.booster.inventory;

import br.com.twinsflammer.api.inventory.InventoryBuilder;
import br.com.twinsflammer.api.inventory.item.Item;
import br.com.twinsflammer.mcmmo.cosmetics.booster.inventory.consumer.SkillChooserInventoryConsumer;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class SkillChooserInventory extends InventoryBuilder {

    private static final Consumer<InventoryClickEvent> EVENT_CONSUMER;

    public static final Item SWORD;
    public static final Item MINING;
    public static final Item AXE;
    public static final Item EXCAVATION;
    public static final Item STUNT;
    public static final Item PLANTATION;
    public static final Item HERBALISM;

    static {
        EVENT_CONSUMER = new SkillChooserInventoryConsumer();

        SWORD = new Item(Material.DIAMOND_SWORD)
                .name("§aEspada")
                .setConsumer(EVENT_CONSUMER);
        MINING = new Item(Material.DIAMOND_PICKAXE)
                .name("§aMineração")
                .setConsumer(EVENT_CONSUMER);
        AXE = new Item(Material.DIAMOND_AXE)
                .name("§aMachado")
                .setConsumer(EVENT_CONSUMER);
        EXCAVATION = new Item(Material.DIAMOND_SPADE)
                .name("§aEscavação")
                .setConsumer(EVENT_CONSUMER);
        STUNT = new Item(Material.DIAMOND_BOOTS)
                .name("§aAcrobacia")
                .setConsumer(EVENT_CONSUMER);
        PLANTATION = new Item(Material.SEEDS)
                .name("§aPlantação")
                .setConsumer(EVENT_CONSUMER);
        HERBALISM = new Item(Material.BREWING_STAND_ITEM)
                .name("§aHerbalismo")
                .setConsumer(EVENT_CONSUMER);
    }

    public SkillChooserInventory() {
        super(4, "Escolha a habilidade:");

        this.build();
    }

    private void build() {
        this.setItem(11, SWORD);
        this.setItem(12, MINING);
        this.setItem(13, AXE);
        this.setItem(14, EXCAVATION);
        this.setItem(15, STUNT);
        this.setItem(21, PLANTATION);
        this.setItem(23, HERBALISM);
    }
}
