import java.util.ArrayList;
import java.util.Objects;

public class Arrangement {
    private String navn;
    private Boolean offentlig;
    private int pris;
    private int maxAntal;
    ArrayList<String> deltager = new ArrayList<>();

    public Arrangement (String navn, Boolean offentlig, int pris, int maxAntal){
        this.navn = navn;
        this.offentlig = offentlig;
        this.pris = pris;
        this.maxAntal = maxAntal;
    }

    public void setNavn (String navn){
        this.navn = navn;
    }

    public boolean isOffentlig (){
        return offentlig;
    }

    public int getPris (){
        return pris;
    }

        public String typeAfArrangement(int prisLimit){

        if (offentlig == true && pris == 0) {
            return "Alle er velkomne til dette gratis arrangement";
        } else if (offentlig == true && pris <= prisLimit) {
            return "Alle er velkomne til dette billige arrangement, prisen er 200 kr";
        } else if (offentlig == true && pris > prisLimit) {
            return "Alle er velkomne til dette lidt dyre arrangement, prisen er 500 kr";
        }
        return "Arrangementet er ikke offentligt";
    }

    public int antalTilmeldteMedNavn (String navn){
        int antal = 0;
        for (int i = 0; i < deltager.size(); i++){
            if (Objects.equals(deltager.get(i), navn)){
                antal++;
            }
        }
        return antal;
    }

    public int antalTilmeldte () {
        int antal = 0;
        for (int i = 0; i < deltager.size(); i++){
            antal++;
        }
        return antal;
    }

    public boolean addDeltager(String navn) {
        if (deltager.size() < maxAntal) {
            deltager.add(navn);
            return true;
        }
        return false;
    }

    public int getMaxAntal(){
        return maxAntal;
    }

    public String toString(){
        String s = ("Arrangementets navn: " + navn + '\"' + " Er det offentligt: " + offentlig + '\"' + " Arrangementets pris: " + pris + '\"' + " Arrangementets antal pladser: " + maxAntal);
        return s;
    }
}
