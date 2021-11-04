import java.sql.SQLOutput;
import java.util.Scanner;

public class ArrangementApp {
    public static void main(String[] args) {
        Arrangement a = new Arrangement("Koncert", false, 0, 50);

        Arrangement b = new Arrangement("Travis Scott", true, 400, 300);

        Arrangement c = new Arrangement("Post Malone", true, 200, 100);

        Scanner scan = new Scanner(System.in);

        System.out.println(a.addDeltager("Kent"));
        System.out.println(a.addDeltager("Kent"));
        System.out.println(a.addDeltager("Kent"));
        System.out.println(a.addDeltager("Kent"));
        System.out.println(a.deltager);
        System.out.println(a);
        System.out.println(a.antalTilmeldte());
        System.out.println(a.typeAfArrangement(200));

        System.out.println("*************************");

        System.out.println(b.addDeltager("Kent"));
        System.out.println(b.addDeltager("Kent"));
        System.out.println(b.addDeltager("bent"));
        System.out.println(b.deltager);
        System.out.println(b);
        System.out.println(b.antalTilmeldte());
        System.out.println(b.antalTilmeldteMedNavn("eent"));

        System.out.println("*************************");

        System.out.println(c.addDeltager("Kent"));
        System.out.println(c.addDeltager("Kent"));

        System.out.println(c.deltager);
        System.out.println(c);
        System.out.println(c.antalTilmeldte());

        System.out.println("*************************");

        System.out.println("Indtast navnet paa din koncert");
        String navn = scan.nextLine();

        System.out.println("Indtast om koncerten er offentlig med flase eller true");
        boolean offentlig = scan.nextBoolean();

        System.out.println("Indtast prisen for din koncert");
        int pris = scan.nextInt();

        System.out.println("Indtast maximum antal pladser til din koncert");
        int maxAntal = scan.nextInt();

        Arrangement sc = new Arrangement(navn, offentlig, pris, maxAntal);
        System.out.println(sc);
    }
}
