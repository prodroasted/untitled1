package serie;

import java.util.ArrayList;

public class episode {
    private int number;
    private ArrayList<String> guestActors = new ArrayList<>();
    private int lengthMinutes;

    public episode(int number, ArrayList<String> guestActors, int lengthMinutes){
        this.number = number;
        this.guestActors = guestActors;
        this.lengthMinutes = lengthMinutes;
    }

    public int getNumber() {
        return number;
    }

    public int getLengthMinutes(){
        return lengthMinutes;
    }
    public ArrayList<String> getGuestActors(){
        return guestActors;
    }
}
