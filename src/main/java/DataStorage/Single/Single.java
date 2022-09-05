package DataStorage.Single;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Single {
    private static Connection conn;

    public static Connection getInstance() {
        if (conn == null) {
            try {
                String pwd = "1234";
                String user = "postgres";
                String url = "jdbc:postgresql://localhost:5432/fact_db";
                conn = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Connexion Etablie !");
        } else {
            System.out.println("Connexion Existante !");
        }
        return conn;
    }
}
