package application.model;

public class Tilvalg {
    private String navn;
    private int pris;
    private Tilmelding tilmelding;

    /**
     * initialiserer et Tilvalg, med navn og pris.
     * fx. wifi, til 40 kr
     * @param navn
     * @param pris
     */
    Tilvalg(String navn, int pris){
        this.navn = navn;
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + ". Pris kr. " + pris;
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
}
