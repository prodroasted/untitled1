package application.controller;

import application.model.Bane;
import application.model.Medlem;
import storage.Storage;

import java.util.ArrayList;

public class controller {

    public static Medlem createMakker (String navn, String mobilNr, String mail){
        Medlem makker = new Medlem(navn, mobilNr, mail);
        Storage.addMakker(makker);
        return makker;
    }

    public static ArrayList<Medlem> getMakker(){
        return Storage.getMakkere();
    }

    public static Medlem createBooker (String navn, String mobilNr, String mail){
        Medlem booker = new Medlem(navn, mobilNr, mail);
        Storage.addBooker(booker);
        return booker;
    }

    public static ArrayList<Medlem> getBookere(){
        return Storage.getBookere();
    }

    public static Bane createBane (int nummer, String baneInfo){
        Bane bane = new Bane(nummer, baneInfo);
        Storage.addBane(bane);
        return bane;
    }

    public static ArrayList<Bane> getBane(){
        return Storage.getBaner();
    }

    public static void initStorage(){

        Medlem m1 = controller.createBooker("Lene Mikkelsen", "12345679", "lm@msn.com");
        Medlem m2 = controller.createMakker("Finn Jensen", "22331144", "fj@msn.com");

        Bane b1 = controller.createBane(1, "Nord/Syd vendt");
        Bane b2 = controller.createBane(2, "Under Egetræet");
        Bane b3 = controller.createBane(3, "Med Tilskuerpladser");

    }
}
