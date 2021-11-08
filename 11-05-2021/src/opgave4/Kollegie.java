package opgave4;

import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String adresse;
    private ArrayList<Bolig> boligs = new ArrayList<>();

    public Kollegie (String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public ArrayList<Bolig> getBoligs (){
        return new ArrayList<>(boligs);
    }

    public Bolig createBolig (int kvm, String adresse, int prisPrMaaned){
        Bolig bolig = new Bolig(kvm, adresse, prisPrMaaned);
        boligs.add(bolig);
        return bolig;
    }

   // public double gennemsnitligAntalDage (){

  //  }


   // public int getAntalLejeaftaler (){
       // return
   // }

    public void addBolig(Bolig bolig){
        if (!boligs.contains(bolig)){
            boligs.add(bolig);
        }
    }

    public void removeBolig(Bolig bolig){
        if(boligs.contains(bolig)){
            boligs.remove(bolig);
        }
    }

    public String getNavn (){
        return navn;
    }

    public void setNavn (String navn){
        this.navn = navn;
    }

    public String getAdresse (){
        return adresse;
    }

    public void setAdresse (String adresse){
        this.adresse = adresse;
    }
}
