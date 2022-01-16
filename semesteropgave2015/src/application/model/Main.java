package application.model;

import application.controller.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Spiller s = new Spiller("Jørgen", 1998);
        Profspiller prof = new Profspiller(50, "Jens", 1999);

        ArrayList<Kamp> h1 = new ArrayList<>();
        ArrayList<Kamp> h2 = new ArrayList<>();

        Kamp k = new Kamp("Jøring", LocalDate.of(1999, 3, 4), LocalTime.of(12, 0));
        Kamp k1 = new Kamp("Albanien", LocalDate.of(1999, 3, 4), LocalTime.of(12, 0));

        h1.add(k);
        h2.add(k1);

        Deltagelse d = k.createDeltager(false, "", s);
        Deltagelse d1 = k.createDeltager(false, "", s);
        Deltagelse d2 = k.createDeltager(true, "Brækket arm", s);
        Deltagelse d3 = k.createDeltager(true, "Syg", s);

        s.addDeltagelse(d);
        s.addDeltagelse(d1);
        s.addDeltagelse(d2);
        s.addDeltagelse(d3);

        prof.addDeltagelse(d);
        prof.addDeltagelse(d1);
        prof.addDeltagelse(d2);
        prof.addDeltagelse(d3);

        System.out.println(s.kampHonorar());
        System.out.println(k.compareTo(k1));
        System.out.println(k.afbud());
        System.out.println(prof.kampHonorar());
        System.out.println(Controller.alleKampe(h1, h2));

    }
}
