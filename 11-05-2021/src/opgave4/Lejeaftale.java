package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Lejer> lejers = new ArrayList<Lejer>();
    private Bolig bolig;

    public Lejeaftale(LocalDate fraDato, Bolig bolig) {
        this.fraDato = fraDato;
        this.bolig = bolig;
    }

    public Bolig getBolig (){
        return bolig;
    }

    public ArrayList<Lejer> getLejers() {
        return new ArrayList<>(lejers);
    }

    public void addLejer (Lejer lejer) {
        if (!lejers.contains(lejer)) {
            lejers.add(lejer);
        }
    }

    public void removeLejer (Lejer lejer) {
        if (lejers.contains(lejer)) {
            removeLejer(lejer);
        }
    }

    public LocalDate getFraDato (){
        return fraDato;
    }

    public void setFraDato (LocalDate fraDato){
        this.fraDato = fraDato;
    }

    public LocalDate getTilDato (){
        return null;
    }

    public void setTilDato (LocalDate tilDato){
        this.tilDato = tilDato;
    }
}
