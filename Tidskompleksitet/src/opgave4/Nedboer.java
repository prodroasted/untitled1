package opgave4;

import java.util.Arrays;

public class Nedboer {
    private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };
    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */
    
    public int bedsteTreFerieUger() {
        // TODO return -1 kun indsat så der ikke er compile fejl
        int bedsteTre = 0;
        int sum;
        int min = Integer.MAX_VALUE;

        for (int i = 2; i < nedboerPrUge.length; i++) {

            sum = nedboerPrUge[i-2] + nedboerPrUge[i-1] + nedboerPrUge[i];

            if (sum < min){
                min = sum;
                bedsteTre = i - 2;
            }
        }
        return bedsteTre;
    }

    
    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */
    
    public int bedsteFerieUgerStart(int antal) {
        int min = Integer.MAX_VALUE;
        int bedsteUge = 0;

        for(int i = antal - 1; i < nedboerPrUge.length; i++){
            int sum = 0;
            for (int j = i - antal + 1; j <= i; j++){
                sum += nedboerPrUge[j];
            }
            if (sum < min){
                min = sum;
                bedsteUge = i - antal;
            }
        }
        return bedsteUge;
    }
    
    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        // TODO return -1 kun indsat så der ikke er compile fejl
        return -1;
    }

}
