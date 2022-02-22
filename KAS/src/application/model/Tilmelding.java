package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {
    private boolean foredragsholder;
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private Hotel hotel;
    private ArrayList<Tilvalg> alleTilvalg = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private Deltager deltager;
    private Ledsager ledsager;
    private Konference konference;
    private int tilmeldingsNr;
    private static int tilmeldingsCounter = 0;

    public Tilmelding(Konference konference, boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato,Deltager deltager, Ledsager ledsager) {
        this.foredragsholder = foredragsholder;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.ledsager = ledsager;
        this.setDeltager(deltager);
        this.setKonference(konference);
        tilmeldingsCounter++;
        this.tilmeldingsNr = tilmeldingsCounter;
    }



    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    public Hotel getHotel() {
        return hotel;
    }


    public Ledsager getLedsager() {
        return ledsager;
    }

    public Konference getKonference() {
        return konference;
    }

    public void setKonference(Konference konference) {
        if (this.getKonference() != konference) {
            Konference oldKonference = this.konference;
            if (oldKonference != null) {
                oldKonference.removeTilmelding(this);
            }
            this.konference = konference;
            if (konference != null) {
                konference.addTilmelding(this);
            }
        }
    }

    public void setDeltager(Deltager deltager) {
        if (this.getDeltager() != deltager) {
            Deltager oldDeltager = this.deltager;
            if (oldDeltager != null) {
                oldDeltager.removeTilmelding(this);
            }
            this.deltager = deltager;
            if (deltager != null) {
                deltager.addTilmelding(this);

            }
        }
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void setLedsager(Ledsager ledsager) {
        if (this.ledsager != null) {
            this.ledsager = ledsager;
        }
    }

    public void removeLedsager() {
        this.ledsager = null;
    }


    public boolean isForedragsholder() {
        return foredragsholder;
    }

    @Override
    public String toString() {
        return "Tilmelding: " +
                "\n" + "Foredragsholder: " + foredragsholder +
                "\n" + "ankomstDato:" + ankomstDato +
                "\n" + "afrejseDato: " + afrejseDato +
                "\n" + "hotel: " + hotel +
                "\n" + "deltager: " + deltager +
                "\n" + "ledsager: " + ledsager +
                "\n" + "konference: " + konference +
                "\n" + "tilmeldingsnummer: " + tilmeldingsNr;
    }

    public void setHotel(Hotel hotel) {
        if (this.getHotel() != hotel) {
            Hotel oldHotel = this.hotel;
            if (oldHotel != null) {
                oldHotel.removeTilmelding(this);
            }
            this.hotel = hotel;
            if (hotel != null) {
                hotel.addTilmelding(this);
            }
        }
    }

    public int tilmeldingDage() {
        long daysBetween = ChronoUnit.DAYS.between(ankomstDato, afrejseDato);
        int dage = 1+Math.toIntExact(daysBetween);
        return dage;
    }

    public String navnpåTilmeldte(Deltager deltager) {
        return deltager.getNavn();
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);

        }
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }

    public void addTilvalg(Tilvalg tilvalg) {
        if (!alleTilvalg.contains(tilvalg)) {
            alleTilvalg.add(tilvalg);

        }
    }

    public void removeTilvalg(Tilvalg tilvalg) {
        if (alleTilvalg.contains(tilvalg)) {
            alleTilvalg.remove(tilvalg);
        }
    }

    public int samletPrisKonference(){
        int sum = 0;
        if(this.isForedragsholder()){
            return 0;
        }
        sum = konference.getPris() * tilmeldingDage();
        return sum;
    }


    public int samletPrisUdflugt() {
        int sum = 0;
        for (Udflugt pris : udflugter) {
            sum += pris.getPris();
        }
        return sum;
    }

    public int samletPrisTilvalg() {
        int sum = 0;
        for(Tilvalg pris : alleTilvalg){
            sum += pris.getPris();
        }
        return sum*(tilmeldingDage()-1);
    }

    public int samletPrisHotel(){
        int sum = 0;
        if(hotel != null){
            if(this.getLedsager() != null){
                sum = hotel.getPrisD();
            }
            if(this.getLedsager() == null){
                sum = hotel.getPris();
            }
        }
        return sum*(tilmeldingDage()-1);
    }

    public int SamletTotalPris(){
        int sum = 0;
        sum += samletPrisHotel() + samletPrisKonference() + samletPrisTilvalg() + samletPrisUdflugt();
        return sum;
    }

    public ArrayList<Ledsager> getUdflugter(){
        ArrayList<Ledsager> udflugtMedLedsagere = new ArrayList<>();
        if(ledsager != null){
            udflugtMedLedsagere.add(ledsager);
        }
        return udflugtMedLedsagere;
    }




    public int getTilmeldingsNr() {
        return tilmeldingsNr;
    }

    public void printTilmelding(){
        System.out.println("Tilmelding: " +
                "\n" + "Foredragsholder: " + foredragsholder +
                "\n" + "ankomstDato:" + ankomstDato +
                "\n" + "afrejseDato: " + afrejseDato +
                "\n" + "hotel: " + hotel +
                "\n" + "deltager: " + deltager +
                "\n" + "ledsager: " + ledsager +
                "\n" + "konference: " + konference +
                "\n" + "tilmeldingsnummer: " + tilmeldingsNr);
    }

}
