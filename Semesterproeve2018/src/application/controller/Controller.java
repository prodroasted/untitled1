package application.controller;

import application.model.Arrangement;
import application.model.Hold;
import application.model.Tutor;
import application.model.Uddannelse;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    //------------------------------------------------------------------------------------------

    public static Tutor createTutor (String navn, String email){
        Tutor tutor = new Tutor(navn, email);
        Storage.addTutor(tutor);
        return tutor;
    }

    public static ArrayList<Tutor> getTutorer(){
        return Storage.getTutorer();
    }

    public static void addTutorToHold(Tutor tutor, Hold hold){
        hold.addTutorer(tutor);
    }

    //------------------------------------------------------------------------------------------

    public static Uddannelse createUddannelse (String navn){
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.addUddannelse(uddannelse);
        return uddannelse;
    }

    public static ArrayList<Uddannelse> getUddannelser(){
        return Storage.getUddannelser();
    }

    //------------------------------------------------------------------------------------------

    public static Hold createHold (String betegnelse, String holdLeder, Uddannelse uddannelse){
        return uddannelse.createHold(betegnelse, holdLeder);
    }

    public static ArrayList<Hold> holdUdenTutor(){
        ArrayList<Hold> holdList = new ArrayList<>();

        for (Uddannelse u : getUddannelser()){
            for (Hold h : u.getHolds()){
                if (h.getTutorer().isEmpty()){
                    holdList.add(h);
                }
            }
        }
        return holdList;
    }


    //------------------------------------------------------------------------------------------

    public static Arrangement createArragement (String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris){
        Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
        Storage.addArragement(arrangement);
        return arrangement;
    }

    public static ArrayList<Arrangement> getArragement(){
        return Storage.getArrangementer();
    }

    public static void addArragementToTutor (Arrangement arrangement, Tutor tutor){
        if (!tutor.harTidsoverLap(arrangement)){
            tutor.addArragement(arrangement);
        } else{
            throw new RuntimeException(String.format("%s Kan ikke tage ansvar for %s, da der er tidsoverlap med et andet arragement.", tutor.getNavn(), arrangement.getTitel()));
        }
    }

    //------------------------------------------------------------------------------------------

    public static void tutorOversigtTilFil(String filnavn){
        try {
            PrintWriter writer = new PrintWriter(filnavn);

            writer.println(String.format("%-20s %-10s %-10s %-25s %-20s", "Tutor", "Uddannelse", "Betegnelse", "E-mail", "holdLeder"));
            writer.println("-".repeat(93));

            for (Uddannelse u : getUddannelser()){
                for (String string : u.tutorOversigt()){
                    writer.println(string);
                }
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------------

    public static void initStorage(){

        //------------------------------------------------------------------------------------------

        Uddannelse u1 = createUddannelse("DMU");
        Uddannelse u2 = createUddannelse("FINØ");

        Hold h1 = createHold("1dmE17S", "Margrethe Dybdahl", u1);
        Hold h2 = createHold("1dmE17T", "Kristial Dorland", u1);
        Hold h3 = createHold("1dmE17U", "Kell Ørhøj", u2);
        Hold h4 = createHold("1fiE17B", "Karen Jensen", u2);


        Tutor t1 = createTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor t2 = createTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor t3 = createTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor t4 = createTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor t5 = createTutor("Mads Miller", "mmm@students.eaaa.dk");

        Arrangement a1 = createArragement("Rusfest",
                LocalDate.of(2017, 8, 31),
                LocalTime.of(23, 30),
                LocalTime.of(17, 30),
                250);
        Arrangement a2 = createArragement("Foldbold",
                LocalDate.of(2017, 8, 30),
                LocalTime.of(14, 0),
                LocalTime.of(17, 30),
                100);
        Arrangement a3 = createArragement("Brætspil",
                LocalDate.of(2017, 8, 29),
                LocalTime.of(12, 0),
                LocalTime.of(16, 30),
                25);
        Arrangement a4 = createArragement("Mindeparken",
                LocalDate.of(2017, 8, 30),
                LocalTime.of(18, 0),
                LocalTime.of(22, 0),
                25);

        //------------------------------------------------------------------------------------------

        addTutorToHold(t1, h1);
        addTutorToHold(t4, h1);
        addTutorToHold(t2, h3);
        addTutorToHold(t3, h3);
        addTutorToHold(t5, h4);

        addArragementToTutor(a1, t1);
        addArragementToTutor(a1, t2);
        addArragementToTutor(a1, t5);
        addArragementToTutor(a2, t3);
        addArragementToTutor(a3, t4);
        addArragementToTutor(a3, t3);
        addArragementToTutor(a4, t5);
        addArragementToTutor(a4, t1);
    }
}
