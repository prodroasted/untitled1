package application.model;

public class Deltagelse {
    private boolean afbrud;
    private String begrundelse;
    private Spiller spiller;

    public Deltagelse (boolean afbrud, String begrundelse, Spiller spiller){
        this.afbrud = afbrud;
        this.begrundelse = begrundelse;
        this.spiller = spiller;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    public boolean isAfbrud() {
        return afbrud;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public void setSpiller(Spiller spiller) {
        if (this.spiller != spiller) {
            Spiller oldspiller = this.spiller;
            if (oldspiller != null){
                oldspiller.removeDeltagelse(this);
            }
            this.spiller = spiller;
            if (spiller != null){
                spiller.addDeltagelse(this);
            }
        }
    }

    @Override
    public String toString() {
        return "afbrud: " + afbrud + " " +
                "begrundelse: " + begrundelse + " " +
                "spiller: " + spiller;
    }
}
