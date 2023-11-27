package ProvaNivell;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mercader extends NPC implements AfegirItem{
    private ArrayList<Item> arrayItems = new ArrayList<>();
    private static final float IMPOST = 0.04F;
    private static final int TAMANYARRAY = 7;
    private int cont;

    public Mercader(String ciutat) {
        super(ciutat);
        cont = 0;
    }

    public ArrayList<Item> getArrayItems() {
        return arrayItems;
    }

    public void setArrayItems(ArrayList<Item> arrayItems) {
        this.arrayItems = arrayItems;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    @Override
    public void afegirItem(Item item) {
        if(cont<TAMANYARRAY){
            float preu = item.getPreu() + (item.getPreu()*IMPOST);
            item.setPreu(preu);
            arrayItems.add(item);
            cont++;
            System.out.println("Ítem " + item.getNom() + " afegit.");
        }
        else{
            System.out.println("Aquest mercader no li caben més Ítems a l'inventari.");
        }
    }
}
