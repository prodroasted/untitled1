package opgave5;

import java.util.ArrayList;

public class BogTitel implements Subject {

    private String titel;
    private int antal;


    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<Kunde> kunder = new ArrayList<>();

    public BogTitel(String titel, int antal){
        this.titel = titel;
        this.antal = antal;
    }

    public String getTitel() {
        return titel;
    }

    public int getAntal() {
        return antal;
    }

    public void inkoebTilLager (int antal){
        this.antal += antal;
    }

    public void etKoeb (Kunde k){
        System.out.println(k.getNavn() + " Har nu købt " + getTitel());
        this.addKunde(k);
        this.antal--;
        this.notifyObservers();
    }

    @Override
    public void addObserver (Observer o){
        if (!this.observers.contains(o)){
            observers.add(o);
        }
    }

    @Override
    public void removeObserver (Observer o){
        if (observers.contains(o)){
            observers.remove(o);
        }
    }

    public void notifyObservers(){
        this.observers.forEach(o -> o.update(this));
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void addKunde (Kunde k){
        if (!kunder.contains(k)){
            kunder.add(k);
            k.addBog(this);
        }
    }

    public void removeKunde(Kunde k){
        if (kunder.contains(k)){
            kunder.remove(k);
            k.removeBog(this);
        }
    }

    public ArrayList<Kunde> getKunder() {
        return kunder;
    }
}
