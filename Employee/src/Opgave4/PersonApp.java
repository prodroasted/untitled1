package Opgave4;

public class PersonApp {
    public static void main(String[] args) {
        Person c1 = new Person("Kenneth", "Longsleve Street", 200.0, "Grønskov");
        c1.printPerson();
        c1.setAdress("Avenue Central");
        c1.setname("Bent");
        c1.setMonthlySalary(300.0);
        c1.setFacility("Julenberg");
        c1.printPerson();
    }
}
