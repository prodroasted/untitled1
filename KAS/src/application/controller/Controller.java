package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

        public static Tilmelding createTilmelding(Konference konference, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Ledsager ledsager){
            Tilmelding tilmelding = new Tilmelding(konference,foredragsholder,ankomstDato,afrejseDato, deltager,ledsager);
            Storage.addTilmelding(tilmelding);
            return tilmelding;
        }

        public static Konference createKonference(String navn, String lokation, int pris, LocalDate startDato, LocalDate slutDato){
            Konference konference = new Konference(navn, lokation, pris,startDato,slutDato);
            Storage.addKonference(konference);
            return konference;
        }

        public static void updateKonference(Konference konference, String navn, String lokation, int pris, LocalDate startDato, LocalDate Slutdato){
            konference.setNavn(navn);
            konference.setLokation(lokation);
            konference.setPris(pris);
            konference.setSlutDato(Slutdato);
            konference.setStartDato(startDato);
        }

        public static ArrayList<Konference> getKonference(){
            return Storage.getKonferences();
        }

        public static Udflugt createUdflugt(Konference konference, String navn, boolean frokost, int pris, LocalDate dato){
            Udflugt udflugt = konference.createUdflugt(navn, frokost, pris, dato);
            Storage.addUdflugt(udflugt);
            return udflugt;
        }


        public static Hotel createHotel(String navn, int pris, int prisd){
            Hotel hotel = new Hotel(navn, pris, prisd);
            Storage.addHotel(hotel);
            return hotel;
        }

        public static void updateHotel(Hotel hotel, String navn, int pris, int prisd){
            hotel.setNavn(navn);
            hotel.setPris(pris);
            hotel.setPrisD(prisd);
        }

        public static Tilvalg createTilvalg(Hotel hotel, String navn, int pris){
            Tilvalg tilvalg = hotel.createTilvalg(navn, pris);
            Storage.addTilvalg(tilvalg);
            return tilvalg;
        }

        public static ArrayList<Tilvalg> getTilvalg(){return Storage.getTilvalg();}

        public static void updateTilvalg (Tilvalg tilvalg, String navn, int pris){
            tilvalg.setNavn(navn);
            tilvalg.setPris(pris);
        }

        public static void deleteHotel (Hotel hotel){Storage.removeHotel(hotel);}

        public static ArrayList<Hotel> getHotels()
        {return Storage.getHotels();}

    public static ArrayList<Udflugt> getUdflugter(){return Storage.getUdflugter();}

        public static Deltager createDeltager(String navn, String adresse, String by, String land, String firmaNavn, int mobilnr, DeltagerType deltagerType){
            Deltager deltager = new Deltager(navn, adresse, by, land, mobilnr, firmaNavn, deltagerType);
            Storage.addDeltager(deltager);
            return deltager;
        }

        public static Ledsager createLedsager(String navn){
            Ledsager ledsager = new Ledsager(navn);
            Storage.addLedsagere(ledsager);
            return ledsager;
        }

        public static void deleteDeltager (Deltager deltager){Storage.removeDeltager(deltager);}

        public static ArrayList<Deltager> getDeltager(){return Storage.getDeltagers();}

        public static void updateDeltager (Deltager deltager, String navn, String adresse, String firmaNavn, int mobilnr){
            deltager.setNavn(navn);
            deltager.setAdresse(adresse);
            deltager.setFirmaNavn(firmaNavn);
            deltager.setMobilNr(mobilnr);
        }



        public static void initStorage(){
            Konference k1 = Controller.createKonference("Himmmel og Hav","Odense",1500, LocalDate.of(2021,12,18), LocalDate.of(2021,12,20));
            Konference k2 = Controller.createKonference("Grønt er godt", "Århus", 1000, LocalDate.of(2021, 12, 20), LocalDate.of(2021, 12, 24));
            Udflugt u1 = Controller.createUdflugt(k1,"Byrundtur, Odense",true,125, LocalDate.of(2021,12,18));
            Udflugt u2 = Controller.createUdflugt(k1,"Egeskov",false,75,LocalDate.of(2021,12,19));
            Udflugt u3 = Controller.createUdflugt(k1,"Trapholt Museum, Kolding",true,200,LocalDate.of(2021,12,20));

            Hotel h1 = Controller.createHotel("Den Hvide Ged",1050,1250);
            Tilvalg tilvalg1 = h1.createTilvalg("Wifi",50);
            Hotel h2 = Controller.createHotel("Høtel Fønøx",700,800);
            Tilvalg tilvalg2 = h2.createTilvalg("Bad",200);
            Tilvalg tilvalg3 = h2.createTilvalg("Wifi",75);

            Hotel h3 = Controller.createHotel("Pension Tusindfryd",500,600);
            Tilvalg tilvalg4 = h3.createTilvalg("Morgenmad",100);

            k1.addHotel(h1);
            k1.addHotel(h2);
            k1.addHotel(h3);

            Deltager d1 = Controller.createDeltager("Finn Madsen", "stengade 32","Århus","DK","Lego",4, DeltagerType.FIRMA);
            Tilmelding t1 = Controller.createTilmelding(k1,false,LocalDate.of(2021,12,18),LocalDate.of(2021,12,20),d1,null);

            Deltager d2 = Controller.createDeltager("Niels Petersen", "stengade 32","Århus","DK","Lego",5, DeltagerType.FIRMA);
            Tilmelding t2 = Controller.createTilmelding(k1,false,LocalDate.of(2021,12,18),LocalDate.of(2021,12,20),d2,null);
            t2.setHotel(h1);

            Deltager d3 = Controller.createDeltager("Peter Saksild", "stengade 32","Århus","DK","Lego",6, DeltagerType.FIRMA);
            Ledsager l1 = Controller.createLedsager("Mie Saksild");
            Tilmelding t3 = Controller.createTilmelding(k1,false,LocalDate.of(2021,12,18),LocalDate.of(2021,12,20),d3,l1);
            t3.setHotel(h1);
            t3.addTilvalg(tilvalg1);
            t3.addUdflugt(u2);
            t3.addUdflugt(u3);

            Deltager d4 = Controller.createDeltager("Lone Jensen", "stengade 32","Århus","DK","Lego",7, DeltagerType.FIRMA);
            Ledsager l2 = Controller.createLedsager("Jan Madsen");
            Tilmelding t4 = Controller.createTilmelding(k1,true,LocalDate.of(2021,12,18),LocalDate.of(2021,12,20),d4,l2);
            t4.setHotel(h1);
            t4.addTilvalg(tilvalg1);
            t4.addUdflugt(u2);
            t4.addUdflugt(u1);
        }

        public static void init(){
            initStorage();
        }
    }

