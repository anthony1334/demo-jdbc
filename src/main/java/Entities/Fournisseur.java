package Entities;

public class Fournisseur {
    int id;
    String nom;

    public Fournisseur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }
    public String getSqlId(){
        return "'"+this.id +"'";
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public String getSqlNom(){
        return "'"+this.nom +"'";
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur " +
                "id=" + id +
                ", nom= " + nom ;
    }
}
