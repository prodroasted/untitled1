package application.model;

import java.util.ArrayList;

public class Tutor {

    private String navn;
    private String email;
    private Hold hold;
    private ArrayList<Arrangement> arrangements = new ArrayList<>();

    public Tutor (String navn, String email){
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    //-----------------------------------------------------

    public void addArragement (Arrangement arrangement){
        if (!arrangements.contains(arrangement)){
            arrangements.add(arrangement);
        }
    }

    public void removeArragement (Arrangement arrangement){
        if (arrangements.contains(arrangement)){
            arrangements.remove(arrangement);
        }
    }

    public ArrayList<Arrangement> getArrangements(){
        return new ArrayList<>(arrangements);
    }

    //-----------------------------------------------------

    public Hold getHold(){
        return this.hold;
    }

    public void setHold (Hold hold){
        if (hold != null && this.hold != hold){
            if (this.hold != null){
                this.hold.removeTutor(this);
            }
            this.hold = hold;
            hold.addTutorer(this);
        }
    }

    //-----------------------------------------------------

    public double arragementPris(){
        double pris = 0.0;
        for (Arrangement a : arrangements) {
                pris += a.getPris();

            }
        return pris;
    }

    public boolean harTidsoverLap(Arrangement arrangementTarget) {
        for (Arrangement arrangement : this.arrangements){
            if (arrangement.getDate().compareTo(arrangementTarget.getDate()) == 0
                &&
                    arrangement.getStartTid().compareTo(arrangementTarget.getStartTid()) <= 0
                &&
                    arrangement.getSlutTid().compareTo(arrangementTarget.getSlutTid()) >= 0){
                return true;
            }
        }
        return false;
    }

    //-----------------------------------------------------


    @Override
    public String toString() {
        return " " + navn + " " +
                " " + email + " ";
    }
}
