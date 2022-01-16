package storage;

import application.model.Bane;
import application.model.Medlem;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Bane> baner = new ArrayList<>();
    private static ArrayList<Medlem> makkere = new ArrayList<>();
    private static ArrayList<Medlem> bookere = new ArrayList<>();

    //-----------------------------------------------------------------

    public static void addBane (Bane bane){
        baner.add(bane);
    }

    public static ArrayList<Bane> getBaner (){
        return new ArrayList<>(baner);
    }

    //-----------------------------------------------------------------

    public static void addMakker (Medlem makker){
        makkere.add(makker);
    }

    public static ArrayList<Medlem> getMakkere(){
        return new ArrayList<>(makkere);
    }

    //-----------------------------------------------------------------

    public static void addBooker(Medlem booker){
        bookere.add(booker);
    }

    public static ArrayList<Medlem> getBookere(){
        return new ArrayList<>(bookere);
    }

    //-----------------------------------------------------------------

}
