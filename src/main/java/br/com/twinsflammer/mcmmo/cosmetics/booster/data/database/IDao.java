package br.com.twinsflammer.mcmmo.cosmetics.booster.data.database;

import br.com.twinsflammer.mcmmo.cosmetics.booster.model.Booster;

import java.sql.Connection;
import java.util.Optional;
import java.util.stream.Stream;

public interface IDao {

    /**
     * @return all the boosters as a stream. The stream may be lazily or eagerly evaluated based
     * on the implementation. The stream must be closed after use.
     * @throws Exception if any error occurs.
     */
    Stream<Booster> getAll();

    /**
     * @param id unique identifier of the booster.
     * @return an optional with booster if a booster with unique identifier <code>id</code>
     * exists, empty optional otherwise.
     * @throws Exception if any error occurs.
     */
    Optional<Booster> getById(int id);

    /**
     * @param booster the booster to be added.
     * @return true if booster is successfully added, false if booster already exists.
     * @throws Exception if any error occurs.
     */
    boolean add(Booster booster);

    /**
     * @param booster the booster to be updated.
     * @return true if booster exists and is successfully updated, false otherwise.
     * @throws Exception if any error occurs.
     */
    boolean update(Booster booster);

    /**
     * @param booster the booster to be deleted.
     * @return true if booster exists and is successfully deleted, false otherwise.
     * @throws Exception if any error occurs.
     */
    boolean delete(Booster booster);
    /**
     * @return created dao connection
     */
    Connection getConnection();
}
