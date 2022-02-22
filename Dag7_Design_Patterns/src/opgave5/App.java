package opgave5;

public class App {
    public static void main(String[] args) {

        Saelger s = new Saelger("Hansen");
        Indkoeber i = new Indkoeber("Jensen");
        BogTitel anders = new BogTitel("Anders And", 6);
        BogTitel java = new BogTitel("Java", 8);
        Kunde k1 = new Kunde("Læsehæst1");
        Kunde k2 = new Kunde("Læsehæst2");
        Kunde k3 = new Kunde("Læsehæst3");

        anders.addObserver(s);
        anders.addObserver(i);
        java.addObserver(i);

        java.etKoeb(k1);
        java.etKoeb(k2);
        java.etKoeb(k3);

        anders.etKoeb(k1);
        anders.etKoeb(k2);
        anders.etKoeb(k3);
    }

}
