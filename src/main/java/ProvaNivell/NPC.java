package ProvaNivell;

import java.util.ArrayList;

public abstract class NPC {
    private ArrayList<Item> llistaItems= new ArrayList<>();
    private int impost, desgast;
    private String ciutat;

    public NPC(String ciutat){
        this.ciutat = ciutat;
    }

    public ArrayList<Item> getLlistaItems() {
        return llistaItems;
    }

    public void setLlistaItems(ArrayList<Item> llistaItems) {
        this.llistaItems = llistaItems;
    }

    public int getImpost() {
        return impost;
    }

    public void setImpost(int impost) {
        this.impost = impost;
    }

    public int getDesgast() {
        return desgast;
    }

    public void setDesgast(int desgast) {
        this.desgast = desgast;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }
}
