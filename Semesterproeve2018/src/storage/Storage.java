package storage;

import application.model.Arrangement;
import application.model.Tutor;
import application.model.Uddannelse;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Tutor> tutorer = new ArrayList<>();
    private static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    //----------------------------------------------------------------------------

    public static void addTutor (Tutor tutor){
        tutorer.add(tutor);
    }

    public static ArrayList<Tutor> getTutorer(){
        return new ArrayList<>(tutorer);
    }

    //----------------------------------------------------------------------------

    public static void addUddannelse(Uddannelse uddannelse){
        uddannelser.add(uddannelse);
    }

    public static ArrayList<Uddannelse> getUddannelser(){
        return new ArrayList<>(uddannelser);
    }

    //----------------------------------------------------------------------------

    public static void addArragement (Arrangement arrangement){
        arrangementer.add(arrangement);
    }

    public static ArrayList<Arrangement> getArrangementer(){
        return new ArrayList<>(arrangementer);
    }

    //----------------------------------------------------------------------------

}
