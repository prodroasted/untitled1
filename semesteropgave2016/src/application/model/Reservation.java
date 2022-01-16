package application.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDate dato;
    private LocalTime startTid;
    private Bane bane;
    private Medlem makker, booker;

    public Reservation(LocalDate dato, LocalTime startTid, Medlem makker, Medlem booker, Bane bane) {
        this.dato = dato;
        this.startTid = startTid;
        this.booker = booker;

        this.setMakker(makker);
        this.setBane(bane);
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    @Override
    public String toString() {
        return "dato=" + dato +
                ", startTid=" + startTid;
    }

    //----------------------------------------------------------------------

    public void setBooker(Medlem booker) {
        if (booker != null && this.booker != booker){
            if (this.booker != null){
                this.booker.removeReservation(this);
            }
            this.booker = booker;
            this.booker.addBookerReservation(this);
        }
    }

    public Medlem getBooker(){
        return this.booker;
    }

    //---------------------------------------------------------------------

    public void setMakker(Medlem makker) {
        if (makker != null && this.makker != makker){
            if (this.makker != null){
                this.makker.removeMakkerReservation(this);
            }
            this.makker = makker;
            this.makker.addMakkerReservation(this);
        }
    }

    public Medlem getMakker(){
        return this.makker;
    }

    //----------------------------------------------------------------------

    public void setBane(Bane bane){
        if (bane != null && this.bane != bane){
            if (this.bane != null){
                this.bane.removeReservation(this);
            }
            this.bane = bane;
            this.bane.addReservation(this);
        }
    }

    public Bane getBane(){
        return this.bane;
    }

}

