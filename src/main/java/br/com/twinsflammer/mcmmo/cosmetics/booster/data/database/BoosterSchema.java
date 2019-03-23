package br.com.twinsflammer.mcmmo.cosmetics.booster.data.database;

public class BoosterSchema {

    public static final String SCHEMA_NAME = "booster";

    public static final String ACTIVATED_SKILL_TYPE_COLUMN_NAME = "activated_skill_type";
    public static final String BOOSTER_TYPE_COLUMN_NAME = "booster_type";
    public static final String TIME_LIMIT_COLUMN_NAME = "time_limit";

    public static final String CREATE_SCHEMA_SQL = "CREATE TABLE IF NOT EXISTS " + SCHEMA_NAME +
            " ( id INT PRIMARY KEY AUTO_INCREMENT , user_id INT NOT NULL , " +
            BOOSTER_TYPE_COLUMN_NAME + " varchar NOT NULL , " +
            TIME_LIMIT_COLUMN_NAME + " BIGINT NOT NULL )";
}
