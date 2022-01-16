package application.model;

public class Profspiller extends Spiller {
    private double kampHonorar;

    public Profspiller (double kampHonorar, String navn, int aargang){
        super(navn, aargang);
        this.kampHonorar = kampHonorar;
    }

    public double getKampHonorar() {return kampHonorar;}

    @Override
    public double kampHonorar(){
        double honorar = getKampHonorar();
        double afbud = 0.0;
        for (Deltagelse d : getDeltagelser()) {
            for (int i = 0; i < getDeltagelser().size(); i++) {
                honorar += getDeltagelser().size() * 10;
                if (d.isAfbrud()) {
                    afbud++;
                }
            }
        }
        return honorar / afbud;
    }
}
