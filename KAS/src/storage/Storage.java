package storage;

import application.model.*;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Deltager> deltagers = new ArrayList<>();
    private static ArrayList<Hotel> hotels = new ArrayList<>();
    private static ArrayList<Konference> konferences = new ArrayList<>();
    private static ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private static ArrayList<Tilvalg> alleTilvalg = new ArrayList<>();
    private static ArrayList<Udflugt> alleUdflugter = new ArrayList<>();


    //--------------------------------------------------------------------------------------------

    public static ArrayList<Deltager> getDeltagers(){return new ArrayList<Deltager>(deltagers);}

    public static void addDeltager(Deltager deltager){deltagers.add(deltager);}

    public static void removeDeltager(Deltager deltager){deltagers.remove(deltager);}

    //--------------------------------------------------------------------------------------------

    public static ArrayList<Hotel> getHotels(){return new ArrayList<Hotel>(hotels);}

    public static void addHotel(Hotel hotel){hotels.add(hotel);}

    public static void removeHotel(Hotel hotel){hotels.remove(hotel);}
    //--------------------------------------------------------------------------------------------

    public static ArrayList<Konference> getKonferences(){return new ArrayList<Konference>(konferences);}

    public static void addKonference(Konference konference){konferences.add(konference);}

    public static void removeKonference(Konference konference){konferences.remove(konference);}

    //--------------------------------------------------------------------------------------------

    public static ArrayList<Ledsager> getLedsagere(){return new ArrayList<Ledsager>(ledsagere);}

    public static void addLedsagere(Ledsager ledsager){ledsagere.add(ledsager);}

    public static void removeLedsagere(Ledsager ledsager){ledsagere.remove(ledsager);}

    //--------------------------------------------------------------------------------------------

    public static ArrayList<Tilmelding> getTilmeldinger(){return new ArrayList<Tilmelding>(tilmeldinger);}

    public static void addTilmelding(Tilmelding tilmelding){tilmeldinger.add(tilmelding);}

    public static void removeTilmelding(Tilmelding tilmelding){tilmeldinger.remove(tilmelding);}

    //--------------------------------------------------------------------------------------------

    public static ArrayList<Tilvalg> getTilvalg(){return new ArrayList<Tilvalg>(alleTilvalg);}

    public static void addTilvalg(Tilvalg tilvalg){alleTilvalg.add(tilvalg);}

    public static void removeTilvalg(Tilvalg tilvalg){alleTilvalg.remove(tilvalg);}

    //--------------------------------------------------------------------------------------------

    public static ArrayList<Udflugt> getUdflugter(){return new ArrayList<Udflugt>(alleUdflugter);}

    public static void addUdflugt(Udflugt udflugt){alleUdflugter.add(udflugt);}

    public static void removeUdflugt(Udflugt udflugt){alleUdflugter.remove(udflugt);}

}