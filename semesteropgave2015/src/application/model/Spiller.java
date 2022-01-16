package application.model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private int aargang;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller (String navn, int aargang){
        this.navn = navn;
        this.aargang = aargang;
    }

    public String getNavn() {
        return navn;
    }

    public int getAargang() {
        return aargang;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse (Deltagelse deltagelse){
        if (!deltagelser.contains(deltagelse)){
            deltagelser.add(deltagelse);
            deltagelse.setSpiller(this);
        }
    }

    public void removeDeltagelse (Deltagelse deltagelse){
        if (deltagelser.contains(deltagelse)){
            deltagelser.remove(deltagelse);
            deltagelse.setSpiller(null);
        }
    }

    public double kampHonorar(){
        double honorar = 0.0;
        for (Deltagelse d : deltagelser) {
            if (!d.isAfbrud()) {
                honorar++;
            }
        }
        return honorar * 10;
    }

    @Override
    public String toString() {
        return "navn: " + navn + " " +
                "aargang: " + aargang;
    }
}

