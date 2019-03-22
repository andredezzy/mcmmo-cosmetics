package br.com.twinsflammer.mcmmo.cosmetics.booster.data.database;

import br.com.twinsflammer.api.database.mysql.MySQL;
import br.com.twinsflammer.api.database.mysql.MySQLManager;
import br.com.twinsflammer.mcmmo.cosmetics.booster.model.Booster;
import br.com.twinsflammer.mcmmo.cosmetics.booster.type.BoosterType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class BoosterDao implements IDao {

    private Connection connection;

    public BoosterDao() {
        MySQL mySQL = MySQLManager.getConnection("twins");
        this.connection = mySQL.getConnection();
    }

    @Override
    public Stream<Booster> getAll() {
        try (PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM ?")) {
            statement.setString(1, BoosterSchema.SCHEMA_NAME);

            ResultSet resultSet = statement.executeQuery();

            return StreamSupport.stream(new Spliterators.AbstractSpliterator<Booster>(Long.MAX_VALUE,
                    Spliterator.ORDERED) {

                @Override
                public boolean tryAdvance(Consumer<? super Booster> action) {
                    try {
                        if (!resultSet.next()) return false;
                        action.accept(of(resultSet));

                        return true;
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            }, false).onClose(() -> close(statement, resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Booster> getById(int id) {
        ResultSet resultSet = null;

        try (PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM ? WHERE user_id = ?")) {
            statement.setString(1, BoosterSchema.SCHEMA_NAME);
            statement.setInt(2, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) return Optional.of(of(resultSet));
            else return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean add(Booster booster) {
        if (getById(booster.getId()).isPresent()) return false;

        try (PreparedStatement statement = this.connection.prepareStatement("INSERT INTO ? VALUES (?, ?, ?)")) {
            statement.setString(1, BoosterSchema.SCHEMA_NAME);
            statement.setInt(2, booster.getUserId());
            statement.setString(3, booster.getBoosterType().name());
            statement.setLong(4, booster.getTimeLimit());

            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Booster booster) {
        try (PreparedStatement statement = this.connection.prepareStatement("UPDATE ? SET ? = ?, ? = ? WHERE id = ?")) {
            statement.setString(1, BoosterSchema.SCHEMA_NAME);

            statement.setString(2, BoosterSchema.BOOSTER_TYPE_COLUMN_NAME);
            statement.setString(3, booster.getBoosterType().name());

            statement.setString(4, BoosterSchema.TIME_LIMIT_COLUMN_NAME);
            statement.setLong(5, booster.getTimeLimit());

            statement.setInt(6, booster.getId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Booster booster) {
        try (PreparedStatement statement = this.connection.prepareStatement("DELETE FROM ? WHERE id = ?")) {
            statement.setString(1, BoosterSchema.SCHEMA_NAME);
            statement.setInt(1, booster.getId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    private Booster of(ResultSet resultSet) {
        Booster booster = null;
        try {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");
            String boosterType = resultSet.getString(BoosterSchema.BOOSTER_TYPE_COLUMN_NAME);
            long timeLimit = resultSet.getLong(BoosterSchema.TIME_LIMIT_COLUMN_NAME);

            booster = new Booster(id, userId, BoosterType.valueOf(boosterType), timeLimit);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booster;
    }

    private void close(PreparedStatement statement, ResultSet resultSet) {
        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
