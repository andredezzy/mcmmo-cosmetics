package br.com.twinsflammer.mcmmo.cosmetics.booster.inventory;

import br.com.twinsflammer.api.inventory.InventoryBuilder;
import br.com.twinsflammer.api.inventory.item.Item;
import org.bukkit.Material;

public class SkillChooserInventory extends InventoryBuilder {

    public static final Item SWORD;
    public static final Item MINING;
    public static final Item AXE;
    public static final Item EXCAVATION;
    public static final Item STUNT;
    public static final Item PLANTATION;
    public static final Item HERBALISM;

    static {
        SWORD = new Item(Material.DIAMOND_SWORD)
                .name("§aEspada");
        MINING = new Item(Material.DIAMOND_PICKAXE)
                .name("§aMineração");
        AXE = new Item(Material.DIAMOND_AXE)
                .name("§aMachado");
        EXCAVATION = new Item(Material.DIAMOND_SPADE)
                .name("§aEscavação");
        STUNT = new Item(Material.DIAMOND_BOOTS)
                .name("§aAcrobacia");
        PLANTATION = new Item(Material.SEEDS)
                .name("§aPlantação");
        HERBALISM = new Item(Material.BREWING_STAND_ITEM)
                .name("§aHerbalismo");
    }

    public SkillChooserInventory() {
        super(4, "Escolha a habilidade:");

        this._build();
    }

    private void _build() {
        this.setItem(11, SWORD);
        this.setItem(12, MINING);
        this.setItem(13, AXE);
        this.setItem(14, EXCAVATION);
        this.setItem(15, STUNT);
        this.setItem(21, PLANTATION);
        this.setItem(23, HERBALISM);
    }
}
