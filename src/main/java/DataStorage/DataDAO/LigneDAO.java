package DataStorage.DataDAO;

import DataStorage.Ligne;
import DataStorage.Produit;

import java.sql.*;

public class LigneDAO extends DAO<Ligne> {
    public LigneDAO(Connection connection) {super(connection);}

    @Override
    public void create(Ligne object) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("INSERT INTO ligne(qte, date, produit, client) VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, object.getQte());
            preparedStatement.setDate(2, object.getDate());
            preparedStatement.setInt(3, object.getIdProduit());
            preparedStatement.setInt(4, object.getIdClient());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("DELETE FROM ligne WHERE id_ligne=?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Ligne object) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("UPDATE ligne SET qte=?, date=? WHERE id_ligne=?;");
            preparedStatement.setInt(1, object.getQte());
            preparedStatement.setDate(2, object.getDate());
            preparedStatement.setInt(3, object.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ligne find(int id) {
        Ligne ligne = new Ligne();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultat = statement.executeQuery("SELECT * FROM ligne AS l JOIN produit AS p ON l.produit = p.id_produit WHERE l.id_ligne=" + id + ";");
            if (resultat.first()) {
                ligne.setId(resultat.getInt("id_ligne"));
                ligne.setQte(resultat.getInt("qte"));
                ligne.setDate(resultat.getDate("date"));

                Produit produit = new Produit();
                ligne.setProduit(produit.find(resultat.getInt("id_produit")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ligne;
    }

}
