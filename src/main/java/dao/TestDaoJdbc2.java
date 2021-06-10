package dao;

import Entities.Fournisseur;

public class TestDaoJdbc2 {
    public static void main(String[] args) {
        FournisseurDaoJdbc2 fournisseurDaoJdbc2 = new FournisseurDaoJdbc2();
        Fournisseur fournisseur2 = new Fournisseur(18,"France de matériaux2");
        fournisseurDaoJdbc2.insert(fournisseur2);
        fournisseurDaoJdbc2.extraire();
        fournisseurDaoJdbc2.update("France de matériaux2","France matériaux2");
        fournisseurDaoJdbc2.delete(fournisseur2);
        fournisseurDaoJdbc2.extraire();
        Fournisseur fournisseur3 = new Fournisseur(19,"L'Espace Création2");
        fournisseurDaoJdbc2.insert(fournisseur3);
    }
}
