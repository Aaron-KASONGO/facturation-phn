package DataStorage.DataDAO;

import DataStorage.Produit;

import java.sql.*;

public class ProduitDAO extends DAO<Produit> {
    public ProduitDAO(Connection connection) {super(connection);}

    @Override
    public void create(Produit object) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("INSERT INTO produit(designation, prix) VALUES(?, ?);");
            preparedStatement.setString(1, object.getDesignation());
            preparedStatement.setDouble(2, object.getPrix());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("DELETE FROM produit WHERE id_produit=?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Produit object) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("UPDATE ligne SET desgination=?, prix=? WHERE id_produit=?;");
            preparedStatement.setString(1, object.getDesignation());
            preparedStatement.setDouble(2, object.getPrix());
            preparedStatement.setInt(3, object.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produit find(int id) {
        Produit produit = new Produit();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultat = statement.executeQuery("SELECT * FROM produit WHERE id_produit=" + id + ";");
            if (resultat.first()) {
                produit.setId(resultat.getInt("id_produit"));
                produit.setDesignation(resultat.getString("designation"));
                produit.setPrix(resultat.getDouble("prix"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }

    public Produit find(String prod) {
        Produit produit = new Produit();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultat = statement.executeQuery("SELECT * FROM produit WHERE designation='" + prod + "';");
            if (resultat.first()) {
                produit.setId(resultat.getInt("id_produit"));
                produit.setDesignation(resultat.getString("designation"));
                produit.setPrix(resultat.getDouble("prix"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }

}
