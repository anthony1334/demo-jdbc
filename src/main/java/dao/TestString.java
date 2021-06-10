package dao;

public class TestString {
    public static void main(String[] args) {
        String ancienNom = "toto";
        String nouveauNom = "titi";
        String requete = "UPDATE FOURNISSEUR SET NOM='"+ ancienNom + "' WHERE NOM ='" + nouveauNom+ "'" ;
        System.out.println(requete);
    }
}
