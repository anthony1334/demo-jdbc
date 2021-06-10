package dao;

import Entities.Fournisseur;
import org.mariadb.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJdbc2 implements FournisseurDao {
    Connection connection=null;
    Statement stat = null;
    ResultSet curseur= null;

    @Override
    //Methode pour récupérer tous les fournisseurs
    public List<Fournisseur> extraire(){


        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta2", "root", "root");
            stat = connection.prepareStatement("SELECT * FROM FOURNISSEUR ");
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


        return null;
    }


    //Methode pour inserer un fournisseur en base
    public void insert(Fournisseur fournisseur){
        Connection connection=null;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta2", "root", "root");

            PreparedStatement stat = connection.prepareStatement("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (?,?)");
            stat.setInt(1,fournisseur.getId());
            stat.setString(2, fournisseur.getNom());
            String nom = fournisseur.getNom();
            if(fournisseur.getNom().contains("'")){
                nom = nom.replaceAll("'","'' ");
            }
            stat.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //Méthode pour modifier le nom d 'un fournisseur par un autre
    public int update(String ancienNom, String nouveauNom){
        Connection connection=null;
        PreparedStatement stat = null;
        int nb= 0;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta2", "root", "root");

            stat = connection.prepareStatement("UPDATE FOURNISSEUR SET NOM=? WHERE NOM =?");
            stat.setString(1,nouveauNom);
            stat.setString(2,ancienNom);
            nb= stat.executeUpdate();


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
        return nb ;
    }
    //Méthode pour supprimer un fournisseur en base
    public boolean delete(Fournisseur fournisseur){

        Connection connection=null;
        PreparedStatement stat = null;

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta2", "root", "root");
            System.out.println(connection);
            stat = connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID =?" );
            stat.setInt(1,fournisseur.getId());
            stat.executeUpdate();

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
        return true;
    }

}
