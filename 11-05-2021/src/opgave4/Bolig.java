package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMaaned;
    private ArrayList<Lejeaftale> lejeaftales = new ArrayList<>();
    private Kollegie kollegie;

    public Bolig (int kvm, String adresse, int prisPrMaaned){
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMaaned = prisPrMaaned;
    }

    public Kollegie getKollegie(){
        return kollegie;
    }

    public void setKollegie (Kollegie kollegie){
        if (this.kollegie != kollegie){
            this.kollegie = kollegie;
            kollegie.addBolig(this);
        }
    }

    public void removeKollegie (Kollegie kollegie){
        if (this.kollegie != null){
            kollegie.removeBolig(this);
            this.kollegie = null;
        }
    }

    public ArrayList<Lejeaftale> getLejeaftales (){
        return new ArrayList<>(lejeaftales);
    }

    public Lejeaftale createLejeaftale (LocalDate fraDato){
        Lejeaftale lejeaftale = new Lejeaftale(fraDato, this);
        lejeaftales.add(lejeaftale);
        return lejeaftale;
    }

    public void removeLejeaftale (Lejeaftale lejeaftale) {
        if (lejeaftales.contains(lejeaftale)) {
            removeLejeaftale(lejeaftale);
        }
    }

    public int getKvm (){
        return kvm;
    }

    public void setKvm (int kvm){
        this.kvm = kvm;
    }

    public String getAdresse (){
        return adresse;
    }

    public void setAdresse (String adresse){
        this.adresse = adresse;
    }

    public int getPrisPrMaaned (){
        return prisPrMaaned;
    }

    public void setPrisPrMaaned (int prisPrMaaned){
        this.prisPrMaaned = prisPrMaaned;
    }

}
