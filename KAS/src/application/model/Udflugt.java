package application.model;

import java.time.LocalDate;

public class Udflugt {
    private String navn;
    private boolean frokost;
    private int pris;
    private LocalDate dato;

    Udflugt(String navn, boolean frokost, int pris, LocalDate dato){
        this.navn = navn;
        this.frokost = frokost;
        this.pris = pris;
        this.dato = dato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isFrokost() {
        return frokost;
    }

    public void setFrokost(boolean frokost) {
        this.frokost = frokost;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Udflugt: " +
                ", navn: " + navn + " " +
                ", frokost: " + frokost + " " +
                ", pris: " + pris;
    }


}