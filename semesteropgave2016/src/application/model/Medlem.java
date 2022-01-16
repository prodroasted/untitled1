package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {
    private String navn;
    private String mobilNr;
    private String mail;

    private ArrayList<Reservation> bookerReservationer = new ArrayList<>();
    private ArrayList<Reservation> makkerReservationer = new ArrayList<>();

    public Medlem(String navn, String mobilNr, String mail) {
        this.navn = navn;
        this.mobilNr = mobilNr;
        this.mail = mail;
    }

    public Reservation createReservation(LocalDate dato, LocalTime startTid, Medlem makker, Bane bane){
        Reservation reservation = new Reservation(dato, startTid, makker, this, bane);
        this.bookerReservationer.add(reservation);
        return reservation;
    }


    public void addBookerReservation(Reservation reservation) {
        if (!bookerReservationer.contains(reservation)) {
            bookerReservationer.add(reservation);
            reservation.setBooker(this);
        }
    }

    public boolean removeReservation(Reservation reservation){
        return this.bookerReservationer.remove(reservation);
    }

    public ArrayList<Reservation> getBookerReservationer(){
        return new ArrayList<>(bookerReservationer);
    }

    //-----------------------------------------------------------------------------

    public void addMakkerReservation (Reservation reservation){
        if (!makkerReservationer.contains(reservation)){
            makkerReservationer.add(reservation);
            reservation.setMakker(this);
        }
    }

    public boolean removeMakkerReservation (Reservation reservation){
        return this.makkerReservationer.remove(reservation);
    }

    public ArrayList<Reservation> getMakkerReservationer() {
        return new ArrayList<>(makkerReservationer);
    }

    //-----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "navn='" + navn + '\'' +
                ", mobilNr='" + mobilNr + '\'' +
                ", mail='" + mail + '\'';
    }
}
