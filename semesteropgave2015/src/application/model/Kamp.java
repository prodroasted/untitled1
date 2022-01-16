package application.model;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Kamp implements Comparable<Kamp> {
    private String sted;
    private LocalDate dato;
    private LocalTime tid;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Kamp (String sted, LocalDate dato, LocalTime tid){
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public Deltagelse createDeltager (boolean afbud, String begrundelse, Spiller spiller){
        Deltagelse deltagelse = new Deltagelse(afbud, begrundelse, spiller);
        if (!deltagelser.contains(deltagelse)){
            this.deltagelser.add(deltagelse);
        }
        return deltagelse;
    }

    public void addDeltagelse(Deltagelse deltagelse){
        if (!deltagelser.contains(deltagelse)){
            deltagelser.add(deltagelse);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse){
        if (deltagelser.contains(deltagelse)){
            deltagelser.remove(deltagelse);
        }
    }

    public ArrayList<Deltagelse> getDeltagelser (){
        return new ArrayList<>(deltagelser);
    }

    public ArrayList<String> afbud (){
        ArrayList<String> s =  new ArrayList<String>();
        for (Deltagelse d : deltagelser) {
                if (d.isAfbrud()) {
                    String afbud = d.getSpiller() + " " + d.getBegrundelse();
                    s.add(afbud);
                }
            }
        return s;
    }

    public void spillerHonorar(String tekstFil) {
        try {
            PrintWriter printWriter = new PrintWriter(tekstFil);
            Scanner scan = new Scanner(System.in);
            scan.next();
            for (Deltagelse d : deltagelser){
                if (d.isAfbrud()){
                    scan.next();
                }
                printWriter.flush();
                printWriter.close();
                scan.close();
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int compareTo(Kamp k) {
        int comp = this.dato.compareTo(k.getDato());
        if (comp == 0) {
            comp = this.tid.compareTo(k.getTid());
            if (comp == 0){
                comp = this.sted.compareTo(k.getSted());
            }
        }
        return comp;
    }

    @Override
    public String toString() {
        return "sted: " + sted + " " +
                "dato: " + dato + " " +
                "tid: " + tid;
    }
}
