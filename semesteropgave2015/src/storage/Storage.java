package storage;

import application.model.Deltagelse;
import application.model.Kamp;
import application.model.Profspiller;
import application.model.Spiller;

import java.util.ArrayList;

public class Storage {

    public static ArrayList<Kamp> kampe = new ArrayList<>();
    public static ArrayList<Spiller> spillere = new ArrayList<>();
    public static ArrayList<Deltagelse> deltagelses = new ArrayList<>();
    public static ArrayList<Profspiller> profspillere = new ArrayList<>();

    public static void addKamp(Kamp kamp){
        kampe.add(kamp);
    }

    public static ArrayList<Kamp> getKamp(){
        return new ArrayList<>(kampe);
    }

    public static void addSpiller(Spiller spiller) {
        spillere.add(spiller);
    }

    public static ArrayList<Spiller> getSpiller(){
        return new ArrayList<>(spillere);
    }

    public static void addDeltagelse(Deltagelse deltagelse){
        deltagelses.add(deltagelse);
    }

    public static void addProf (Profspiller profspiller){
        profspillere.add(profspiller);
    }
}
