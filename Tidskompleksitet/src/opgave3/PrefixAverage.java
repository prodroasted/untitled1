package opgave3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PrefixAverage {

    public static double[] prefixAverage(int[] inputTal){
        double [] tempArr = new double[inputTal.length];
        int sum = 0;

        for (int i = 0; i < inputTal.length; i++){
            sum += inputTal[i];
            tempArr[i] = sum/(i+1.0);
        }
        return tempArr;
    }

    public static void main(String[] args) {
        int[] inputTal = {5,10,5,6,4,9,8};

        System.out.println(Arrays.toString(inputTal));
        System.out.println(Arrays.toString(prefixAverage(inputTal)));

    }

}
