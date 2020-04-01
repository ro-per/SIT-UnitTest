package stubs;

public class Reeks {
    private String reeksNaam;

    public Reeks() {
        this.reeksNaam = null;
    }

    public Reeks(String reeksNaam) {
        this.reeksNaam = reeksNaam;
    }

    public String getReeksNaam() {
        return reeksNaam;
    }

    public void setReeksNaam(String reeksNaam) {
        this.reeksNaam = reeksNaam;
    }

    public String toString() {
        return this.reeksNaam;
    }
}
