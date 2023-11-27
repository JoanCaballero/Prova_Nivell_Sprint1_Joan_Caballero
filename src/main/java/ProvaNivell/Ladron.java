package ProvaNivell;

import java.util.ArrayList;

public class Ladron extends NPC implements AfegirItem{
    private ArrayList<Item> arrayItems = new ArrayList<>();
    private static final int DESGAST = 25;
    private static final int TAMANYARRAY = 3;
    private int cont;

    public Ladron(String ciutat) {
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
            int desgast = item.getDesgast() + DESGAST;
            item.setDesgast(desgast);
            arrayItems.add(item);
            cont++;
            System.out.println("Ítem " + item.getNom() + " afegit.");
        }
        else{
            System.out.println("Aquest ladron no li caben més Ítems a l'inventari.");
        }
    }
}
