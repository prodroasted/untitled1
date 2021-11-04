package Arrays.model;

import java.io.Console;
import java.time.temporal.ValueRange;
import java.util.ArrayList;

public class MethodsArrayList {

    /**
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
            int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }

    /**
     * @param list
     * @return sums the mumbers in the list using a forEach loop
     */
    public int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }

    /**
     * @param list
     * @return index at the first even number
     */
    public int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;

    }

    public int min(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int num : list) {
            min = num < min ? num : min;
        }
        return min;
    }

    public double average(ArrayList<Integer> list) {
        int sum = 0;
        double average = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
            average = (double) sum / list.size();
        }
        return average;
    }

    public int countzero(ArrayList<Integer> list) {
        int zero = 0;
        for (int i = 0; i < list.size(); i++) {
            var cur = list.get(i);
            if (cur == 0) {
                zero++;
            }
        }
        return zero;
    }

    public void swapEvenWithZero(ArrayList<Integer> list) {
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            if (temp % 2 == 0)
            {
                list.set(i, 0);
            }
        }
    }

    public ArrayList<Integer> newlist(ArrayList<Integer> list){
        ArrayList<Integer> rl = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 2 == 0){
                rl.add(list.get(i));
            }
        }
        return rl;
    }

}