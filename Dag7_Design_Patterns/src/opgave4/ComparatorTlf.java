package opgave4;

import java.util.Comparator;

public class ComparatorTlf implements Comparator<Kunde> {

    @Override
    public int compare (Kunde k1, Kunde k2){
        return k1.getTlf() - k2.getTlf();
    }
}
