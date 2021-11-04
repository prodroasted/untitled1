import java.sql.SQLOutput;
import java.util.ArrayList;

public class opgave1 {
    public static void main(String[] args) {

        ArrayList<String> opgave = new ArrayList<>();

        opgave.add("Pax");
        opgave.add("Fido");
        opgave.add("Molly");
        opgave.add("Pluto");
        opgave.add("Juno");

        System.out.println(opgave);

        opgave.add(2, "King");
        System.out.println(opgave);

        opgave.remove(1);
        opgave.add(4, "Trine");
        opgave.add("Bella");

        System.out.println(opgave);
        System.out.println(opgave.size());

        for (int i = 0; i < opgave.size(); i++){
            if (opgave.get(i).length() == 5) {
                System.out.println(opgave.get(i));
            }
        }

        System.out.println("-----------------------------");

        for (int i = opgave.size() -1; i >= 0; i--){
            System.out.println(opgave.get(i));
        }

        System.out.println("-----------------------------");

        for (int i = 0; i < opgave.size(); i++){
            if (i % 2 == 0){
                System.out.println(opgave.get(i));
            }
        }

    }
}
