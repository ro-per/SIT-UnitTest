package media;

import stubs.Reeks;

public abstract class Medium {
    private String titel;
    private Reeks reeks;

    public Medium(String titel) {
        this.titel = titel;
        this.reeks = null;
    }

    public Medium(String titel, Reeks reeks) {
        this.titel = titel;
        this.reeks = reeks;
    }

    public String getTitel() {
        return titel;
    }

    public Reeks getReeks() {
        return reeks;
    }

    public void setReeks(Reeks reeks) {
        this.reeks = reeks;
    }

    public String toString() {
        return "media.Medium [titel=" + titel + ", reeks=" + reeks + "]";
    }

    public boolean heeftTitel(String t) {
        return titel.equalsIgnoreCase(t);
    }

    public boolean behoortTotReeks(Reeks reeks) {
        return this.reeks.equals(reeks);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titel == null) ? 0 : titel.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Medium other = (Medium) obj;
        if (titel == null) {
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel))
            return false;
        return true;
    }
}
