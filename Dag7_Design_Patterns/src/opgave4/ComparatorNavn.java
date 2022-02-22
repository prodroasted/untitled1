package opgave4;

import java.util.Comparator;

public class ComparatorNavn implements Comparator<Kunde> {

    @Override
    public int compare (Kunde k1, Kunde k2){
        return k1.getNavn().compareTo(k2.getNavn());
    }
}
