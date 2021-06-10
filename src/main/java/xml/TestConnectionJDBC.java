package xml;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionJDBC {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta2", "root", "root");
            System.out.println(connection);
            Statement stat = connection.createStatement();
            stat.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (4,'La Maison de la peinture')");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
