package xml;

import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection=null;
        Statement stat = null;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta2", "root", "root");
            System.out.println(connection);
            stat = connection.createStatement();
            stat.executeUpdate("UPDATE FOURNISSEUR SET NOM='La Maison des Peintures' WHERE NOM ='La Maison de la Peinture' ");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally {

                try {
                    stat.close();
                    connection.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }

        }

    }
}
