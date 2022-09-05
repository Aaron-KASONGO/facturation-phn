package DataStorage.DataDAO;

import DataStorage.Client;
import DataStorage.Ligne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientDAO extends DAO<Client>{
    public ClientDAO(Connection connection) {super(connection);}

    @Override
    public void create(Client object) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("INSERT INTO client(nom, prenom, adresse, numero) VALUES(?, ?, ?, ?);");
            preparedStatement.setString(1, object.getNom());
            preparedStatement.setString(2, object.getPrenom());
            preparedStatement.setString(3, object.getAdresse());
            preparedStatement.setString(4, object.getNumero());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("DELETE FROM client WHERE id_client=?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client object) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement("UPDATE client SET nom=?, prenom=?, adresse=?, numero=? WHERE id_client=?;");
            preparedStatement.setString(1, object.getNom());
            preparedStatement.setString(2, object.getPrenom());
            preparedStatement.setString(3, object.getAdresse());
            preparedStatement.setString(4, object.getNumero());
            preparedStatement.setInt(5,object.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Client findById(int id) {
        Client client = new Client();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultat = statement.executeQuery("SELECT * FROM client WHERE id_client=" + id + ";");
            if (resultat.first()) {
                client.setId(resultat.getInt("id_client"));
                client.setNom(resultat.getString("nom"));
                client.setPrenom(resultat.getString("prenom"));
                client.setAdresse(resultat.getString("adresse"));
                client.setNumero(resultat.getString("numero"));
            }
            while (resultat.next()) {
                Ligne nLigne = new Ligne();
                client.addLigne(nLigne.find(resultat.getInt("id_ligne")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client find(int id) {
        Client client = new Client();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultat = statement.executeQuery("SELECT * FROM client AS c JOIN ligne AS l ON c.id_client = l.client WHERE c.id_client=" + id + ";");
            if (resultat.first()) {
                client.setId(resultat.getInt("id_client"));
                client.setNom(resultat.getString("nom"));
                client.setPrenom(resultat.getString("prenom"));
                client.setAdresse(resultat.getString("adresse"));
                client.setNumero(resultat.getString("numero"));

                Ligne ligne = new Ligne();
                client.addLigne(ligne.find(resultat.getInt("id_ligne")));
            }
            while (resultat.next()) {
                Ligne nLigne = new Ligne();
                client.addLigne(nLigne.find(resultat.getInt("id_ligne")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<Client>();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultat = statement.executeQuery("SELECT * FROM client AS c JOIN ligne AS l ON c.id_client = l.client;");

            while (resultat.next()) {
                Client client = new Client();
                client.setId(resultat.getInt("id_client"));
                client.setNom(resultat.getString("nom"));
                client.setPrenom(resultat.getString("prenom"));
                client.setAdresse(resultat.getString("adresse"));
                client.setNumero(resultat.getString("numero"));

                Ligne ligne = new Ligne();
                client.addLigne(ligne.find(resultat.getInt("id_ligne")));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Client> findA() {
        List<Client> clients = new ArrayList<Client>();
        Statement statement = null;
        ResultSet resultat = null;
        try {
            statement = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultat = statement.executeQuery("SELECT * FROM client;");

            while (resultat.next()) {
                Client client = new Client();
                client.setId(resultat.getInt("id_client"));
                client.setNom(resultat.getString("nom"));
                client.setPrenom(resultat.getString("prenom"));
                client.setAdresse(resultat.getString("adresse"));
                client.setNumero(resultat.getString("numero"));

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

}
