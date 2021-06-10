package xml;

import Entities.Fournisseur;
import org.mariadb.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class TestSelect {
    public static void main(String[] args) {
        Connection connection=null;
        Statement stat = null;
        ResultSet curseur= null;

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta2", "root", "root");
            stat = connection.createStatement();
            curseur = stat.executeQuery("SELECT * FROM FOURNISSEUR ");

            ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
            while (curseur.next()) {
                int id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");

                Fournisseur fournisseurCourant = new Fournisseur(id, nom);
                fournisseurs.add(fournisseurCourant);

            }
            for (Fournisseur fournisseur : fournisseurs) {
                System.out.println(fournisseur);
            }
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if(curseur != null){
                curseur.close();
                }
                stat.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }



    }
}

