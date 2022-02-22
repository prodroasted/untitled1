package application.controller;

import application.model.*;

import java.time.LocalDate;

public class ControllerTestApp {

        public static void main(String[] args) {
            Konference k1 = Controller.createKonference("Himmmel og Hav","Odense",1500, LocalDate.of(2021,12,18), LocalDate.of(2021,12,20));
            Udflugt u1 = k1.createUdflugt("Byrundtur, Odense",true,125, LocalDate.of(2021,12,18));
            Udflugt u2 = k1.createUdflugt("Egeskov",false,75,LocalDate.of(2021,12,19));
            Udflugt u3 = k1.createUdflugt("Trapholt Museum, Kolding",true,200,LocalDate.of(2021,12,20));

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
            Tilmelding t3 = Controller.createTilmelding(k1,false,LocalDate.of(2021,12,18),LocalDate.of(2021,12,20),d2,l1);
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


            System.out.println(t1.SamletTotalPris());
            System.out.println(t2.SamletTotalPris());
            System.out.println(t3.SamletTotalPris());
            System.out.println(t4.SamletTotalPris());

            System.out.println();


        }
    }

