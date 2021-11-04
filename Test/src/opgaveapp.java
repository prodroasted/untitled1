import java.util.Scanner;

public class opgaveapp {
    public static void main(String[] args) {
        opgave2 s = new opgave2("Lille Frække Frederik", "Bamse", 148);
        opgave2 e = new opgave2("Lonely", "Post Malone", 150);
        Scanner scan = new Scanner(System.in);

        s.printSong();
        e.printSong();

        s.setBpm(102);
        s.printSong();

        System.out.println("Skrive din ønskede Titel");
        String titel = scan.nextLine();

        System.out.println("Skriv din ønskede kunstner");
        String kunstner = scan.nextLine();

        System.out.println("indtast din ønskede bpm");
        int bpm = scan.nextInt();

        opgave2 ny = new opgave2(titel, kunstner, bpm);
        ny.printSong();

    }
}
