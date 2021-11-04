package opgave4;

import java.util.ArrayList;

public class SwimmerApp {

    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        ArrayList<Swimmer> swimmers = new ArrayList<Swimmer>();
        swimmers.add(s1);
        swimmers.add(s2);
        swimmers.add(s3);

        TrainingPlan A = new TrainingPlan('A', 16, 10);
        TrainingPlan B = new TrainingPlan('B', 10, 6);

        Swimmer d = A.createSwimmer("Jens", 1930, lapTimes, "HE-Svømmeklub");

        System.out.println(A.getSwimmers().contains(d));

        for (Swimmer s : A.getSwimmers())
            System.out.println(s.getName() + "");

        A.removeSwimmer(d);

        for (Swimmer s : A.getSwimmers())
            System.out.println(s.getName() + "");

        System.out.println(A.getSwimmers().contains(d));

    }
}

