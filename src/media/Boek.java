package media;

import stubs.Auteur;
import stubs.Reeks;

import java.util.ArrayList;
import java.util.List;

public class Boek extends Medium {
    private String ISBN;
    private List<Auteur> auteurs;

    public Boek(String titel, String iSBN) {
        super(titel);
        ISBN = iSBN;
        auteurs = new ArrayList<>();
    }

    public Boek(String titel, Reeks reeks, String iSBN) {
        super(titel, reeks);
        ISBN = iSBN;
        auteurs = new ArrayList<>();
    }

    public String getISBN() {
        return ISBN;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public void addAuteur(Auteur auteur) {
        if (!auteurs.contains(auteur)) auteurs.add(auteur);
    }

    public boolean heeftAuteur(Auteur auteur) {
        return auteurs.contains(auteur);
    }

    public String toString() {
        return "media.Boek [ISBN=" + ISBN + ", auteurs=" + auteurs + "]" + super.toString();
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Boek other = (Boek) obj;
        if (ISBN == null) {
            if (other.ISBN != null)
                return false;
        } else if (!ISBN.equals(other.ISBN))
            return false;
        return true;
    }
}
