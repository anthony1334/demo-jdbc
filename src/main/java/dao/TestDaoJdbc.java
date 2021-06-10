package dao;

import Entities.Fournisseur;

public class TestDaoJdbc {
    public static void main(String[] args) {
        FournisseurDao fournisseurDao = new FournisseurDaoJdbc();
        Fournisseur fournisseur = new Fournisseur(8,"France de matériaux");
        fournisseurDao.insert(fournisseur);
        fournisseurDao.extraire();
        fournisseurDao.update("France de matériaux","France matériaux");
        fournisseurDao.extraire();
        fournisseurDao.delete(fournisseur);
        Fournisseur fournisseur2 = new Fournisseur(9,"L'Espace Création");
        fournisseurDao.insert(fournisseur2);


    }
}
