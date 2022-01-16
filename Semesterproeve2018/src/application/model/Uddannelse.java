package application.model;

import java.util.ArrayList;

public class Uddannelse {

    private String navn;
    private ArrayList<Hold> holds = new ArrayList<>();

    public Uddannelse (String navn){
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    //------------------------------------------------------------


    public ArrayList<Hold> getHolds(){
        return new ArrayList<>(this.holds);
    }

    public Hold createHold(String betegnelse, String holdLeder) {
        Hold hold = new Hold(betegnelse, holdLeder, this);
        addHold(hold);
        return hold;
    }

    public void addHold(Hold hold){
        if (!this.holds.contains(hold)){
            this.holds.add(hold);
            hold.setUddannelse(this);
        }
    }

    //------------------------------------------------------------

    public boolean removeHold (Hold hold){
        boolean found = this.holds.contains(hold);

        if (found){
            this.holds.remove(hold);
                hold.setUddannelse(null);
        }
        return found;
    }

    public ArrayList<String> tutorOversigt(){
        ArrayList<String> oversigt = new ArrayList<>();

        for (Hold h : holds){
            for (Tutor t : h.getTutorer()){
                oversigt.add(String.format("%-20s %-10s %-10s %-25s %-20s",t.getNavn(), this.getNavn(), h.getBetegnelse(), t.getEmail(), h.getHoldLeder()));
            }
        }
        return oversigt;
    }

    //------------------------------------------------------------


    @Override
    public String toString() {
        return " " + navn + " " +
                " " + holds;
    }
}
