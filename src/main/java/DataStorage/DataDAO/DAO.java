package DataStorage.DataDAO;

import java.sql.Connection;

public abstract class DAO<T> {
    protected Connection connection;

    public DAO(Connection connection) {this.connection = connection;}

    public abstract void create(T objet);
    public abstract void delete(int id);
    public abstract void update(T objet);
    public abstract T find(int id);
}
