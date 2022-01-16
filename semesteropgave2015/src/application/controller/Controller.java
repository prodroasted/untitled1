package application.controller;

import application.model.Deltagelse;
import application.model.Kamp;
import application.model.Profspiller;
import application.model.Spiller;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Spiller createSpiller(String navn, int aargang){
        Spiller spiller = new Spiller(navn, aargang);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid){
        Kamp kamp = new Kamp(sted, dato, tid);
        Storage.addKamp(kamp);
        return kamp;
    }

    public static ArrayList<Kamp> getKamp(){
        return Storage.getKamp();
    }

    public static Profspiller createProf(double kampHonorar, String navn, int aargang){
        Profspiller profspiller = new Profspiller(kampHonorar, navn, aargang);
        Storage.addProf(profspiller);
        return profspiller;
    }

    public static Deltagelse createDeltagelse(boolean afbrud, String begrundelse, Spiller spiller, Kamp kamp){
        Deltagelse deltagelse = kamp.createDeltager(afbrud, begrundelse, spiller);
        Storage.addDeltagelse(deltagelse);
        return deltagelse;
    }

    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2){
        ArrayList<Kamp> resulat = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < list1.size() && i2 < list2.size()){
            if (list1.get(i1).compareTo(list2.get(i2)) <= 0){
                resulat.add(list1.get(i1));
                i1++;
            } else{
                resulat.add(list2.get(i2));
                i2++;
            }
        } while (i1 < list1.size()){
            resulat.add(list1.get(i1));
            i1++;
        } while (i2 < list2.size()){
            resulat.add(list2.get(i2));
            i2++;
        }
        return resulat;
    }

    public static void updateSpillerDeltagelse(Spiller spiller, Deltagelse deltagelse){
        if (spiller != null && deltagelse != null){
            spiller.addDeltagelse(deltagelse);
            deltagelse.setSpiller(spiller);
        }
    }

    public static void initStorage(){


        Spiller s1 = Controller.createSpiller("Jane Jensen", 1999);
        Spiller s2 = Controller.createSpiller("Lene Hansen", 2000);
        Spiller s3 = Controller.createSpiller("Mette Pedersen", 1999);

        Profspiller p1 = createProf(50.0, "Sofia Kjeldsen", 1999);
        Profspiller p2 = createProf(55.0, "Maria Nielsen", 2000);

        Kamp k1 = Controller.createKamp("Herning", LocalDate.of(2015, 1, 26), LocalTime.of(10, 30));
        Kamp k2 = Controller.createKamp("Ikast", LocalDate.of(2015, 1, 27), LocalTime.of(13, 30));

        Deltagelse d1 = Controller.createDeltagelse(true, "Jane melder afbud til kampen i Herning da Moster Oda har fødselsdag",s1, k1);
        Deltagelse d2 = Controller.createDeltagelse(true, "Sofia melder afbud til kampen i Ikast da hun er i daarlig form", p1, k2);
        Deltagelse d3 = Controller.createDeltagelse(false, "", s1, k1);
        Deltagelse d4 = Controller.createDeltagelse(false, "", s1, k2);

        s1.addDeltagelse(d1);
        s1.addDeltagelse(d4);
        s2.addDeltagelse(d3);
        s2.addDeltagelse(d4);
        s3.addDeltagelse(d3);
        s3.addDeltagelse(d4);

        p1.addDeltagelse(d3);
        p1.addDeltagelse(d2);
        p2.addDeltagelse(d3);
        p2.addDeltagelse(d4);
    }
}
