package opgave4;

import java.util.Comparator;

public class Kunde implements Comparable<Kunde>{

    private String navn;
    private int tlf;
    private static Comparator<Kunde> comparator = new ComparatorNavn();

    public Kunde (String navn, int tlf){
        this.navn = navn;
        this.tlf = tlf;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public static Comparator<Kunde> getComparator() {
        return comparator;
    }

    public static void setComparator(Comparator<Kunde> comparator) {
        Kunde.comparator = comparator;
    }

    @Override
    public String toString() {
        return " navn: " + navn + '\'' +
                " tlf: " + tlf;
    }

    @Override
    public int compareTo (Kunde k){
        return comparator.compare(this, k);
    }
}
