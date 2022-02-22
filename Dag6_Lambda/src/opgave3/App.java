package opgave3;

import java.util.*;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,23,2,40,502,341,32,4,6));
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("-----------------------------------------------------------------------");

        HashMap<Integer, Integer> map = new HashMap<>(Map.of(
                2, 4,
                3,9,
                4, 16,
                5, 25,
                6, 36));

        Iterator<Integer> itrMap = map.keySet().iterator();

        while(itrMap.hasNext()){
            int next = itrMap.next();
            System.out.printf("(%d, %d)%n", next, map.get(next));
        }
    }
}
