package application.model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private int pris;
    private int prisD;
    private ArrayList<Tilvalg> alleTilvalg = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    /**
     * initlialiserer et hotel, med navn og dagspris.
     *
     * @param navn
     * @param pris
     */
    public Hotel(String navn, int pris, int prisD) {
        this.navn = navn;
        this.pris = pris;
        this.prisD = prisD;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getPrisD() {
        return prisD;
    }

    public void setPrisD(int prisD) {
        this.prisD = prisD;
    }

    /**
     * tilføjer et tilvalg til hotellet
     *
     */
    public Tilvalg createTilvalg(String navn, int pris) {
        Tilvalg tilvalg = new Tilvalg(navn, pris);
        alleTilvalg.add(tilvalg);
        return tilvalg;
    }

    public void removeTilvalg(Tilvalg tilvalg){
        if(alleTilvalg.contains(tilvalg)){
            alleTilvalg.remove(tilvalg);
        }
    }

    /**
     * viser en liste over hotellets mulige tilvalg
     * @return
     */
    public ArrayList<Tilvalg> getTilvalg () {
        return alleTilvalg;
    }

    @Override
    public String toString () {
        return  "Hotel: " + navn +
                ", Pris: " + pris +
                ", prisD: " + prisD;
    }

    /**
     * Returnerer den samlede pris for hotellet, inklusiv alle tilvalg.
     * @return
     */
    public int samletPrisHotel () {
        int sum = this.pris;
        for (Tilvalg pris : alleTilvalg) {
            sum += pris.getPris();
        }
        return sum;
    }
    public int samletPrisDHotel () {
        int sum = this.prisD;
        for (Tilvalg pris : alleTilvalg) {
            sum += pris.getPris();
        }
        return sum;
    }


    public void addTilmelding(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }

    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
            tilmelding.setHotel(this);
        }
    }

    public ArrayList<Tilmelding> getTilmeldinger(){
        return tilmeldinger;
    }

    public ArrayList<String> getDeltagerePåHotel(){
        ArrayList<String> deltagerePåHotel = new ArrayList<>();
        for(Tilmelding t: tilmeldinger){
            deltagerePåHotel.add(t.getDeltager().getNavn());
        }
        return deltagerePåHotel;
    }

    public ArrayList<String> getLedsagerePåHotel(){
        ArrayList<String> LedsagerePåHotel = new ArrayList<>();
        for(Tilmelding t: tilmeldinger){
            if (t.getLedsager() != null){
                LedsagerePåHotel.add(t.getLedsager().getNavn());

            }
        }
        return LedsagerePåHotel;
    }

    public ArrayList<String> getHotelGæster(){
        ArrayList<String> hotelGæster = new ArrayList<>();
        for(Tilmelding g: tilmeldinger){
            if(g.getDeltager() != null){
                hotelGæster.add(g.getDeltager().getNavn() + ", TilmeldingsNr: " + g.getTilmeldingsNr());
                if(g.getLedsager() !=null){
                    hotelGæster.add(g.getLedsager().getNavn() + ", TilmeldingsNr: " + g.getTilmeldingsNr());
                }
            }
        }
        return hotelGæster;

    }



}