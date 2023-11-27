package ProvaNivell;

public class Item {
    private String nom, tipus;
    private int desgast;
    private float preu;

    public Item(String nom, String tipus, float preu, int desgast){
        this.nom = nom;
        this.tipus = tipus;
        this.preu = preu;
        this.desgast = desgast;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public int getDesgast() {
        return desgast;
    }

    public void setDesgast(int desgast) {
        this.desgast = desgast;
    }

    @Override
    public String toString() {
        return ("ÍTEM:\nNom: " + nom + "\nTipus: " + tipus + "\nPreu: " + preu + "\nDesgast: " + desgast + "\n");
    }
}
