package br.com.twinsflammer.mcmmo.cosmetics.booster;

import br.com.twinsflammer.api.inventory.InventoryBuilder;
import br.com.twinsflammer.mcmmo.cosmetics.Cosmetics;
import br.com.twinsflammer.mcmmo.cosmetics.booster.data.database.BoosterDao;
import br.com.twinsflammer.mcmmo.cosmetics.booster.data.database.BoosterSchema;
import br.com.twinsflammer.mcmmo.cosmetics.booster.data.database.IDao;
import br.com.twinsflammer.mcmmo.cosmetics.booster.data.manager.BoosterManager;
import br.com.twinsflammer.mcmmo.cosmetics.booster.inventory.SkillChooserInventory;
import br.com.twinsflammer.mcmmo.cosmetics.booster.listener.ExperienceGainListener;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoosterApplication {

    public static final float DEFAULT_MULTIPLIER = 2.0F;
    public static final InventoryBuilder SKILL_CHOOSER_INVENTORY;

    static {
        SKILL_CHOOSER_INVENTORY = new SkillChooserInventory();
    }

    private BoosterManager boosterManager;
    private IDao dao;

    public BoosterApplication() {
        this.boosterManager = new BoosterManager();
        this.dao = new BoosterDao();

        this.init();
    }

    private void init() {
        try (PreparedStatement statement = this.dao.getConnection().prepareStatement(BoosterSchema.CREATE_SCHEMA_SQL)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cosmetics cosmeticsInstance = Cosmetics.getInstance();
        cosmeticsInstance.getServer().getPluginManager().registerEvents(new ExperienceGainListener(), cosmeticsInstance);
    }

    public BoosterManager getManager() {
        return boosterManager;
    }

    public IDao getDao() {
        return dao;
    }
}
