package application.model;

import java.util.ArrayList;

public class Hold {

    private String betegnelse;
    private String holdLeder;
    private Uddannelse uddannelse;
    private ArrayList<Tutor> tutorer = new ArrayList<>();

    public Hold (String betegnelse, String holdLeder, Uddannelse uddannelse){
        this.betegnelse = betegnelse;
        this.holdLeder = holdLeder;
        this.uddannelse = uddannelse;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldLeder() {
        return holdLeder;
    }

    //--------------------------------------------------------

    public void addTutorer (Tutor tutor){
        if (!tutorer.contains(tutor)){
            tutorer.add(tutor);
        }
    }

    public void removeTutor (Tutor tutor){
        if (tutorer.contains(tutor)){
            tutorer.remove(tutor);
        }
    }

    public ArrayList<Tutor> getTutorer(){
        return new ArrayList<>(tutorer);
    }

    //--------------------------------------------------------

    public Uddannelse getUddannelse(){
        return this.uddannelse;
    }

    public void setUddannelse (Uddannelse uddannelse){
        if (uddannelse != null && this.uddannelse != uddannelse){
            if (this.uddannelse != null){
                this.uddannelse.removeHold(this);
            }
            this.uddannelse = uddannelse;
            uddannelse.addHold(this);
        }
    }

    //--------------------------------------------------------

    public double arragementPris(){
        double pris = 0.0;
        for (Tutor t : tutorer){
            pris += t.arragementPris();
        }
        return pris;
    }

    //-------------------------------------------------------

    public boolean harTidsoverLap (Arrangement arrangement){
        boolean found = false;
        int i = 0;

        while (i < this.tutorer.size() && !found){
            Tutor tutor = this.tutorer.get(i);

            if (tutor.harTidsoverLap(arrangement)){
                found = true;
            } else{
                i++;
            }
        }
        return found;
    }

    //-------------------------------------------------------


    @Override
    public String toString() {
        return " " + betegnelse + " " +
                " " + holdLeder + " " +
                " " + uddannelse + " " +
                " " + tutorer;
    }
}
