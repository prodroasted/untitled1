package application.model;

import java.util.ArrayList;

public class Deltager {
    private String navn;
    private String adresse;
    private String by;
    private String land;
    private int mobilNr;
    private String firmaNavn;
    private DeltagerType deltagerType;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public Deltager(String navn, String adresse,String by, String land, int mobilNr, String firmaNavn, DeltagerType deltagerType){
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.land = land;
        this.mobilNr = mobilNr;
        this.firmaNavn = firmaNavn;
        this.deltagerType = deltagerType;
    }

    public void addTilmelding(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.setDeltager(this);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
            tilmelding.setDeltager(null);
        }
    }


    @Override
    public String toString() {
        return "navn: " + navn + " " +
                ", adresse: " + adresse + " " + ", by: " + by + " " + ", land: " + land +
                ", mobilNr=" + mobilNr + " " +
                ", firmaNavn: " + firmaNavn + " " +
                ", deltagerType: " + deltagerType;
    }

    public String getLand() {
        return land;
    }

    public String getBy() {
        return by;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getMobilNr() {
        return mobilNr;
    }

    public void setMobilNr(int mobilNr) {
        this.mobilNr = mobilNr;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public DeltagerType getDeltagerType() {
        return deltagerType;
    }

    public void setDeltagerType(DeltagerType deltagerType) {
        this.deltagerType = deltagerType;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public void setTilmeldinger(ArrayList<Tilmelding> tilmeldinger) {
        this.tilmeldinger = tilmeldinger;
    }

    public boolean erForedragsholder(){
        for(Tilmelding til: tilmeldinger){
            if(til.isForedragsholder()){
                return true;
            }
        }
        return false;
    }

    public int getDeltagersTilmeldingsNr(){
        int tilmeldingsNr = -1;
        for(Tilmelding til: tilmeldinger){
            tilmeldingsNr = til.getTilmeldingsNr();
        }
        return tilmeldingsNr;

    }




}
