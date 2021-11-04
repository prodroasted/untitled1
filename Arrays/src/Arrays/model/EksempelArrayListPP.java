package Arrays.model;

import java.util.ArrayList;
import java.util.Arrays;

public class EksempelArrayListPP {

	public static void main(String[] args) {
		ArrayList<String> list;
		list = new ArrayList<>();


		list.add("Pia"); // add tilføjer bagest i listen
		list.add("Hans");
		list.add("Viggo");
		list.add("Jens");
		list.add("Børge");
		list.add("Bent");
		list.add("Ib");

		list.set(2, "Jane");
		list.set(2, "Hansi");
		list.remove(1);

		int size = list.size(); // size returnerer listens størrelse
		System.out.println("Listen indeholder " + size + " elementer");
		System.out.println(list);

		System.out.println("-------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("------------------------------------");
		for (String s : list) {
			System.out.println(s);

		}
	}
}
