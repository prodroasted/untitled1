package afleveringfravaer;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.OptionalInt;

public class FravaersSystem {
    /**
     * Fraværstallene udskrives på skærmen
     *
     * @param fravaer
     */
    public void udskrivFravaer(int[][] fravaer) {
        // TODO opgave 1
        for (int row = 0; row < fravaer.length; row++) {
            for (int col = 0; col < fravaer[row].length; col++) {
                System.out.print(fravaer[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
     * elevnr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public int samletFravaer(int[][] fravaer, int elevNr) {
        // TODO opgave 2
        int samlet = 0;
        for (int i = 0; i < fravaer[elevNr].length; i++) {
            samlet += fravaer[elevNr][i];
        }
        return samlet;
    }

    /**
     * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
     * elevNr.
     *
     * @param fravaer
     * @param elevNr
     * @return
     */
    public double gennemsnit(int[][] fravaer, int elevNr) {
        // TODO opgave 3
        double snit = 0.0;
        int nysamlet = 0;
        for (int i = 0; i < fravaer[elevNr].length; i++) {
            nysamlet += fravaer[elevNr][i];
        }
        snit = nysamlet / (double) fravaer[elevNr].length;
        return snit;
    }

    /**
     * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
     *
     * @param fravaer
     * @return
     */
    public int antalUdenFravaer(int[][] fravaer) {
        // TODO opgave 4
        int moedt = 0;
        for (int i = 0; i < fravaer.length; i++) {
            if (Arrays.stream(fravaer[i]).sum() == 0) {
                moedt++;
            }
        }
        return moedt;
    }

    /**
     * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
     * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer
     * for en af disse.
     *
     * @param fravaer
     * @return
     */
    public int mestFravaer(int[][] fravaer) {
        // TODO opgave 5
        int elev = -1, fravaerende = 0, sidstefravaerende = 0;
        for (int i = 0; i < fravaer.length; i++) {
            for (int j = 0; j < fravaer[i].length; j++) {
                fravaerende += fravaer[i][j];
            }
            if (fravaerende > sidstefravaerende) {
                elev = i + 1;
            }
            sidstefravaerende = fravaerende;
            fravaerende = 0;
        }
        return elev;
    }

    /**
     * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
     * måneder.
     *
     * @param fravaer
     * @param elevNr
     */
    public void nulstil(int[][] fravaer, int elevNr) {
        // TODO opgave 6
        for (int i = 0; i < fravaer.length; i++) {
            for (int j = 0; j < fravaer[i].length; j++) {
                if (fravaer[i].length > 0) {
                    fravaer[elevNr][j] = 0;
                }
            }
        }
    }
}