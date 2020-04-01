public class Auteur {
    private String voornaam;
    private String achternaam;


    public Auteur() {
        this.voornaam = "Voornaam";
        this.achternaam = "Achternaam";
    }

    public Auteur(String voornaam, String achternaam) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public String toString() {
        return this.voornaam + " " + this.achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
}
