package br.com.twinsflammer.mcmmo.cosmetics.booster.inventory;

import br.com.twinsflammer.api.inventory.InventoryBuilder;

public class SkillChooserInventory extends InventoryBuilder {

    public SkillChooserInventory() {
        super(4, "Escolha a habilidade:");
        this.build();
    }

    private void build() {
        this.setItem(11, SkillItemReference.SWORDS.getItemReference());
        this.setItem(12, SkillItemReference.MINING.getItemReference());
        this.setItem(13, SkillItemReference.AXES.getItemReference());
        this.setItem(14, SkillItemReference.EXCAVATION.getItemReference());
        this.setItem(15, SkillItemReference.ACROBATICS.getItemReference());
        this.setItem(22, SkillItemReference.HERBALISM.getItemReference());
    }
}
