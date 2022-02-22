package opgave4;

import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {

        Set<Kunde> kunder = new TreeSet<>();

        kunder.add(new Kunde("Henrik", 23004032));
        kunder.add(new Kunde("Søren", 40933245));
        kunder.add(new Kunde("Tobi", 39234542));
        kunder.add(new Kunde("Andrea", 22911815));
        System.out.println(kunder);

        kunder.clear();
        Kunde.setComparator(new ComparatorTlf());
        kunder.add(new Kunde("Henrik", 23004032));
        kunder.add(new Kunde("Søren", 40933245));
        kunder.add(new Kunde("Tobi", 39234542));
        kunder.add(new Kunde("Andrea", 22911815));
        System.out.println(kunder);

        kunder.clear();
        Kunde.setComparator(new ComparatorNavn());
        kunder.add(new Kunde("Henrik", 23004032));
        kunder.add(new Kunde("Søren", 40933245));
        kunder.add(new Kunde("Tobi", 39234542));
        kunder.add(new Kunde("Andrea", 22911815));
        System.out.println(kunder);
    }
}
