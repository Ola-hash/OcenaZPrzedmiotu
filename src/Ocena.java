import java.util.Objects;

public class Ocena {
    private double punkt;
    private double maxPunkt;
    private String typZadania;

    public Ocena(double punkt, double maxPunkt, String typZadania) {
        this.punkt = punkt;
        this.maxPunkt = maxPunkt;
        this.typZadania = typZadania;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "punkt=" + punkt +
                ", maxPunkt=" + maxPunkt +
                ", typZadania='" + typZadania + '\'' +
                '}';
    }

    public double getPunkt() {
        return punkt;
    }

    public double getMaxPunkt() {
        return maxPunkt;
    }

    public String getTypZadania() {
        return typZadania;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ocena)) return false;
        Ocena ocena = (Ocena) o;
        return Double.compare(ocena.punkt, punkt) == 0 &&
                Double.compare(ocena.maxPunkt, maxPunkt) == 0 &&
                Objects.equals(typZadania, ocena.typZadania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(punkt, maxPunkt, typZadania);
    }
}
