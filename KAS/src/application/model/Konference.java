package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String lokation;
    private int pris;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();

    /**
     * Initialiserer en Konference, som tilmeldingerne kan sættes til.
     * prisen er "pris per dag"
     *
     * @param navn
     * @param lokation
     * @param pris
     * @param startDato
     * @param slutDato
     */
    public Konference(String navn, String lokation, int pris, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.lokation = lokation;
        this.pris = pris;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    /**
     * @param tilmelding
     */
    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setKonference(this);
        }
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.setKonference(null);
        }
    }

    public void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }


    public Udflugt createUdflugt(String UdflugtNavn, boolean frokost, int pris, LocalDate dato) {
        Udflugt udflugt = new Udflugt(UdflugtNavn, frokost, pris, dato);
        udflugter.add(udflugt);
        return udflugt;
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }

    public void removeHotel(Hotel hotel) {
        if (hoteller.contains(hotel)) {
            hoteller.remove(hotel);
        }
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public ArrayList<String> getForedragsholdere() {
        ArrayList<String> foredragsholdere = new ArrayList<>();
        for (Tilmelding vilTale : tilmeldinger) {
            if (vilTale.isForedragsholder()) {
                foredragsholdere.add(vilTale.navnpåTilmeldte(vilTale.getDeltager()));
            }
        }
        return foredragsholdere;
    }

    public ArrayList<String> getLedsagere() {
        ArrayList<String> listeAfLedsagere = new ArrayList<>();
        for (Tilmelding L : tilmeldinger) {
            if (L.getLedsager() != null) {
                listeAfLedsagere.add(L.getLedsager().getNavn());
            }
        }
        return listeAfLedsagere;
    }

    public ArrayList<Deltager> getDeltagere() {
        ArrayList<Deltager> listeAfDeltagere = new ArrayList<>();
        for (Tilmelding D : tilmeldinger) {
            listeAfDeltagere.add(D.getDeltager());
        }
        return listeAfDeltagere;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public ArrayList<Hotel> getHoteller() {
        return hoteller;
    }

    public ArrayList<String> getHotelGæster() {
        ArrayList<String> hotelGæster = new ArrayList<>();
        for (Hotel h : hoteller) {
            if (h.getDeltagerePåHotel() != null) {
                hotelGæster.add(h.getNavn() + h.getDeltagerePåHotel() + h.getLedsagerePåHotel());
            }
        }
        return hotelGæster;
    }

    public String toNavn() {
        return "Navn: " + getDeltagere();
    }

    @Override
    public String toString() {
        return "Konference: " + navn;
    }

    public int getPris() {
        return pris;
    }

    public ArrayList<String> getDeltagereTilKonf() {
        ArrayList<String> deltagereTilKonf = new ArrayList<>();
        for (Tilmelding t : tilmeldinger) {
            if (t.isForedragsholder()) {
                deltagereTilKonf.add(t.getDeltager().getNavn() + "(Foredragsholder)" + "\n");
            } else {
                deltagereTilKonf.add(t.getDeltager().getNavn() + "\n");
            }
        }
        return deltagereTilKonf;
    }

    public ArrayList<Ledsager> ledsagerePåUdflugter() {
        ArrayList<Ledsager> ledsagerePåUdflugter = new ArrayList<>();
        for (Tilmelding l : tilmeldinger) {
            if(l.getLedsager() != null){
                if(l.getUdflugter() != null){
                    ledsagerePåUdflugter.add(l.getLedsager());
                }
            }
        }
        return ledsagerePåUdflugter;

    }

}