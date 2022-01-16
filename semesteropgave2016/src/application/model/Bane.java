package application.model;

import java.net.DatagramPacket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private String baneInfo;
    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Bane (int nummer, String baneInfo){
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    public ArrayList<Reservation> getReservationer (){
        return new ArrayList<>(this.reservationer);
    }

    public void addReservation (Reservation reservation){
        if (!reservationer.contains(reservation)){
            reservationer.add(reservation);
        }
    }

    public void removeReservation (Reservation reservation){
            reservationer.remove(reservation);
    }

    public boolean isLedig(LocalDate dato, LocalTime tid){
        for (Reservation r : this.reservationer){
            if (r.getDato() == dato && r.getStartTid() == tid){
                return false;
            }
        }
        return true;
    }

    public ArrayList<LocalTime> getLedigeTiderPaaDag(LocalDate dato) {
        ArrayList<LocalTime> ledigeTider = new ArrayList<>();
        for (int i = 6; i <= 22; i++) {
                ledigeTider.add(LocalTime.of(i, 0));
        }
        for (Reservation r : this.reservationer) {
            if (dato == r.getDato())
            ledigeTider.add(r.getStartTid());
            }
        return ledigeTider;
        }
    }
