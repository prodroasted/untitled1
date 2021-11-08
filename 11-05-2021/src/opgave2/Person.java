package opgave2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private final ArrayList<Gift> gifts = new ArrayList<>();


    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public ArrayList<Gift> getGifts(){
        return new ArrayList<>(gifts);
    }

    public void addGifts(Gift gift) {
        if (!gifts.contains(gift)){
            gifts.add(gift);
        }
    }

    public void removeGift (Gift gift){
        if (gifts.contains(gift)){
            removeGift(gift);
        }
    }

    public double getGiftPrice(){
        double price = 0.0;
        for(int i = 0; i < gifts.size(); i++){
            price += gifts.get(i).getPrice();
        }
        return price;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString (){
        String s = "Navn: " + this.name + " Alder: " + this.age;
        return s;
    }
}
