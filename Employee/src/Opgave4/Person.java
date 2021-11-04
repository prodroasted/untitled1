package Opgave4;

public class Person {
    private String name;
    private String adress;
    private double monthlySalary;
    private double feriepenge;
    private double yearly;
    private String facility;

    public Person(String inputName, String inputadress, double inputMonthlySalary, String inputFacility){

        name = inputName;
        adress = inputadress;
        monthlySalary = inputMonthlySalary;
        feriepenge = monthlySalary / 2.5;
        yearly = monthlySalary * 12;
        facility = inputFacility;
    }

    public void setname(String inputName){name = inputName;}

    public String getName(){return name;}

    public void setAdress(String inputadress){adress = inputadress;}

    public String getAdress(){return adress;}

    public void setMonthlySalary(double inputMonthylySalary){monthlySalary = inputMonthylySalary;}

    public double getMonthlySalary(){return monthlySalary;}

    public void setFacility(String inputFacility){
        facility = inputFacility;
    }

    public void printPerson(){
        System.out.println("*****************************");
        System.out.println("Employee's name " + name);
        System.out.println("Employee's adress " + adress);
        System.out.println("Employee's Salary " + monthlySalary);
        System.out.println("Employee's Yearly Pay " + yearly + feriepenge);
        System.out.println("The Employee currently works at " + facility);
        System.out.println();
    }
}


