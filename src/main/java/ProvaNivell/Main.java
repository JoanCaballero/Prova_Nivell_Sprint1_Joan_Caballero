package ProvaNivell;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
        public static Scanner sca = new Scanner(System.in);
        public static int opcio, opcioVendedor;
        public static ArrayList<NPC> arrayNPC = new ArrayList<>();
        public static boolean acabat = false, acabatVenedor = false, correcte = false;
        public static void main(String[] args) {
            do {
                System.out.println("""
                        Que vols fer?:
                        Introdueix 1 si vols crear un venedor.
                        Introdueix 2 si vols afegir un Ítem a un venedor.
                        Introdueix 3 si vols consultar els items d'un venedor.
                        Introdueix 4 si vols realitzar una venta.
                        Introdueix 5 si vols sortir.""");
                opcio = sca.nextInt();
                switch (opcio) {
                    case 1 -> {
                        sca.nextLine();
                        crearVenedor();
                        acabatVenedor = false;
                    }
                    case 2 -> {
                        afegirItem();
                        acabatVenedor = false;
                    }
                    case 3 -> consultarItemsVenedor();
                    case 4 -> {
                        realitzarVenda();
                        acabatVenedor = false;
                    }
                    case 5 -> {
                        System.out.println("Fins Aviat!");
                        acabat = true;
                    }
                    default -> System.out.println("Introdueix un valor vàlid.");
                }
            }while(!acabat);
        }

        public static void crearVenedor(){
            System.out.println("En quina ciutat està ubicat aquest Venedor?");
            String ciutat = sca.nextLine();
            do{
                System.out.println("""
                    Quin dels tipus de Venedor és?
                    1.- Campesino
                    2.- Ladrón
                    3.- Mercader""");
                opcioVendedor = sca.nextInt();
                switch (opcioVendedor) {
                    case 1 -> {
                        Campesino campesino = new Campesino(ciutat);
                        System.out.println("Nou venedor de tipus Campesino creat.");
                        arrayNPC.add(campesino);
                        acabatVenedor = true;
                    }
                    case 2 -> {
                        Ladron ladron = new Ladron(ciutat);
                        System.out.println("Nou venedor de tipus Ladron creat.");
                        arrayNPC.add(ladron);
                        acabatVenedor = true;
                    }
                    case 3 -> {
                        Mercader mercader = new Mercader(ciutat);
                        System.out.println("Nou venedor de tipus Mercader creat.");
                        arrayNPC.add(mercader);
                        acabatVenedor = true;
                    }
                    default -> System.out.println("Introdueix un valor vàlid.");
                }
            }while(!acabatVenedor);
        }

        public static void afegirItem(){
            Item item = crearItem();
            sca.nextLine();
            System.out.println("En quina ciutat està ubicat aquest Venedor?");
            String ciutat = sca.nextLine();

            try {
                do{
                    System.out.println("""
                        Quin dels tipus de Venedor és?
                        1.- Campesino
                        2.- Ladrón
                        3.- Mercader""");
                    opcioVendedor = sca.nextInt();
                    switch(opcioVendedor){
                        case 1:
                            if (identificarCampesino(ciutat) != null) {
                                Objects.requireNonNull(identificarCampesino(ciutat)).afegirItem(item);
                                acabatVenedor = true;
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        case 2:
                            if (identificarLadron(ciutat) != null) {
                                Objects.requireNonNull(identificarLadron(ciutat)).afegirItem(item);
                                acabatVenedor = true;
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        case 3:
                            if (identificarMercader(ciutat) != null) {
                                Objects.requireNonNull(identificarMercader(ciutat)).afegirItem(item);
                                acabatVenedor = true;
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        default:
                            System.out.println("Introdueix un valor vàlid.");
                    }
                }while(!acabatVenedor);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        public static Campesino identificarCampesino(String ciutat){
            for(NPC npc : arrayNPC){
                if(esCampesino(npc)){
                    if(npc.getCiutat().equalsIgnoreCase(ciutat)){
                        return (Campesino) npc;
                    }
                }
            }
            return null;
        }
        public static Ladron identificarLadron(String ciutat){
            for(NPC npc : arrayNPC){
                if(esLadron(npc)){
                    if(npc.getCiutat().equalsIgnoreCase(ciutat)){
                        return (Ladron) npc;
                    }
                }
            }
            return null;
        }
        public static Mercader identificarMercader(String ciutat){
            for(NPC npc : arrayNPC){
                if(esMercader(npc)){
                    if(npc.getCiutat().equalsIgnoreCase(ciutat)){
                        return (Mercader) npc;
                    }
                }
            }
            return null;
        }
        public static boolean esCampesino(NPC npc){
            return npc instanceof Campesino;
        }
        public static boolean esLadron(NPC npc){
            return npc instanceof Ladron;
        }
        public static boolean esMercader(NPC npc) {
            return npc instanceof Mercader;
        }
        public static Item crearItem() {
            sca.nextLine();
            System.out.println("Quin nom té l'ítem?");
            String nom = sca.nextLine();
            System.out.println("De quin tipus es aquest ítem?");
            String tipus = sca.nextLine();
            float preu = 0;
            do {
                try {
                    System.out.println("Quin preu té aquest item?");
                    preu = sca.nextFloat();
                    correcte = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!correcte);
            correcte = false;
            int desgast = 0;
            do {
                try {
                    System.out.println("Quin desgast té aquest ítem?");
                    desgast = sca.nextInt();
                    correcte = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!correcte);
            return new Item(nom, tipus, preu, desgast);
        }

        public static void consultarItemsVenedor(){
            sca.nextLine();
            System.out.println("En quina ciutat està ubicat aquest Venedor?");
            String ciutat = sca.nextLine();
            try {
                do{
                    System.out.println("""
                        Quin dels tipus de Venedor és?
                        1.- Campesino
                        2.- Ladrón
                        3.- Mercader""");
                    opcioVendedor = sca.nextInt();
                    switch(opcioVendedor){
                        case 1:
                            if (identificarCampesino(ciutat) != null) {
                                System.out.println(Objects.requireNonNull(identificarCampesino(ciutat)).getArrayItems().toString());
                                acabatVenedor = true;
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        case 2:
                            if (identificarLadron(ciutat) != null) {
                                System.out.println(Objects.requireNonNull(identificarLadron(ciutat)).getArrayItems().toString());
                                acabatVenedor = true;
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        case 3:
                            if (identificarMercader(ciutat) != null) {
                                System.out.println(Objects.requireNonNull(identificarMercader(ciutat)).getArrayItems().toString());
                                acabatVenedor = true;
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        default:
                            System.out.println("Introdueix un valor vàlid.");
                    }
                }while(!acabatVenedor);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        public static void realitzarVenda(){
            sca.nextLine();
            System.out.println("Quin nom té l'item?");
            String nomItem = sca.nextLine();
            System.out.println("En quina ciutat està ubicat aquest Venedor?");
            String ciutat = sca.nextLine();
            ArrayList<Item> arrayItems;
            try {
                do{
                    System.out.println("""
                        Quin dels tipus de Venedor és?
                        1.- Campesino
                        2.- Ladrón
                        3.- Mercader""");
                    opcioVendedor = sca.nextInt();
                    switch(opcioVendedor){
                        case 1:
                            if (identificarCampesino(ciutat) != null) {
                                arrayItems = Objects.requireNonNull(identificarCampesino(ciutat)).getArrayItems();
                                try {
                                    for (Item item : arrayItems) {
                                        if (item.getNom().equalsIgnoreCase(nomItem)) {
                                            System.out.println("Realitzada la venda de l'item amb nom: " + item.getNom());
                                            arrayItems.remove(item);
                                            acabatVenedor = true;
                                        } else {
                                            throw new Exception("No s'ha trobat cap ítem amb aquest nom en aquest venedor. Consulta la llista abans el proper cop");
                                        }
                                    }
                                }catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        case 2:
                            if (identificarLadron(ciutat) != null) {
                                arrayItems = Objects.requireNonNull(identificarLadron(ciutat)).getArrayItems();
                                try{
                                    for(Item item : arrayItems){
                                        if(item.getNom().equalsIgnoreCase(nomItem)){
                                            System.out.println("Realitzada la venda de l'item amb nom: " + nomItem);
                                            arrayItems.remove(item);
                                            acabatVenedor = true;
                                        }
                                        else{
                                            throw new Exception("No s'ha trobat cap ítem amb aquest nom en aquest venedor. Consulta la llista abans el proper cop");
                                        }
                                    }
                                }catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        case 3:
                            if (identificarMercader(ciutat) != null) {
                                arrayItems = Objects.requireNonNull(identificarMercader(ciutat)).getArrayItems();
                                try {
                                    for (Item item : arrayItems) {
                                        if (item.getNom().equalsIgnoreCase(nomItem)) {
                                            System.out.println("Realitzada la venda de l'item amb nom: " + nomItem);
                                            arrayItems.remove(item);
                                        }
                                        else{
                                            throw new Exception("No s'ha trobat cap ítem amb aquest nom en aquest venedor. Consulta la llista abans el proper cop");
                                        }
                                    }
                                }catch(Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            else{
                                throw new Exception("Venedor no identificat.");
                            }
                            break;
                        default:
                            System.out.println("Introdueix un valor vàlid.");
                    }
                }while(!acabatVenedor);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

}

