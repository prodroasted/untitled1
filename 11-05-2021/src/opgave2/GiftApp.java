package opgave2;

public class GiftApp {
    public static void main(String[] args) {

        Person p = new Person("Henning", 12);
        Person p1 = new Person("Dennis", 20);

        Gift g = new Gift("Tillykke med fødselsdagen Henning", p);
        Gift e = new Gift("Hej tillykke med din tyve-års", p1);


        g.setPrice(3000);
        e.setPrice(2000);
        p1.addGifts(g);
        p1.addGifts(e);

        System.out.println(p1.getGiftPrice());
        System.out.println(g.getPerson());

    }
}
