package afleveringfravaer;

public class AfproevFravaersSystem {

    public static void main(String[] args) {
        int[][] fravaer21S = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0 }};

        FravaersSystem fraværsSystem = new FravaersSystem();
        fraværsSystem.udskrivFravaer(fravaer21S);
        System.out.println("***************************");
        System.out.println("Den ønskede elevens samlet fravær er " + fraværsSystem.samletFravaer(fravaer21S, 0));
        System.out.println("Gennemsnittet for den ønskede elevs fravær er " + fraværsSystem.gennemsnit(fravaer21S, 0));
        System.out.println("Antallet af elever uden fravær er " + fraværsSystem.antalUdenFravaer(fravaer21S));
        System.out.println("Eleven med mest fravær er " + fraværsSystem.mestFravaer(fravaer21S));

        System.out.println("******************************");
        fraværsSystem.nulstil(fravaer21S, 2);
        fraværsSystem.udskrivFravaer(fravaer21S);

        //TODO opgave 7

    }
}
