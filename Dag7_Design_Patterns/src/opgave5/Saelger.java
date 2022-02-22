package opgave5;

import java.util.HashSet;
import java.util.Set;

public class Saelger implements Observer {

    private String navn;

    public Saelger(String navn){
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public void update (Subject s){
        Set<String> titels = new HashSet<>();

        for (Kunde k : ((BogTitel) s).getKunder()){
            for (BogTitel b : k.getBøger()){
                if (!b.getTitel().equals(((BogTitel) s).getTitel())) {
                    titels.add(b.getTitel());
                }
            }
        }
        System.out.println("Kunder har ogsaa købt: ");
        System.out.println(titels);
    }
}
