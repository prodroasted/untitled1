package opgave5;

import java.util.ArrayList;

public class Kunde {

    private String navn;
    private ArrayList<BogTitel> bøger = new ArrayList<>();

    public Kunde (String navn){
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<BogTitel> getBøger() {
        return bøger;
    }

    public void addBog (BogTitel bog){
        if (!bøger.contains(bog)){
            bøger.add(bog);
        }
    }

    public void removeBog (BogTitel bog){
        if (bøger.contains(bog)){
            bøger.remove(bog);
        }
    }
}
