import java.util.ArrayList;

public class Student {
    String imie;
    String nazwisko;
    ArrayList<Ocena> punktyUcznia;

    public Student(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        punktyUcznia = new ArrayList<>();
    }

    public void dodajOcene(Ocena ocena) {
        punktyUcznia.add(ocena);
    }

    private int znajdzIndexLabZNajmniejszaIloscaPunktow() {
        int index = 0;
        double minPunkt = Double.MAX_VALUE;
        for (int i = 0; i < punktyUcznia.size(); i++) {
            if (punktyUcznia.get(i).getTypZadania().equals("laboratoria")) {
                if (punktyUcznia.get(i).getPunkt() < minPunkt) {
                    minPunkt = punktyUcznia.get(i).getPunkt();
                    index = i;
                }
            }
        }
        return index;
    }

    private double sumaPunktow() {
        int index = znajdzIndexLabZNajmniejszaIloscaPunktow();
        double suma = 0.0;
        double minPunkt = punktyUcznia.get(index).getPunkt();
        for (Ocena ocena : punktyUcznia) {
            suma += ocena.getPunkt();
        }
        return suma - minPunkt;
    }

    public void wystawOcene() {
        double punkty = sumaPunktow();
        double maxPunkty = sumaMaxPunktow();
        double wynik = (punkty / maxPunkty) * 100;
        if (wynik < 60) {
            System.out.println(wynik + "% to ocena 2");
        } else if (wynik >= 60 && wynik <= 68) {
            System.out.println(wynik + "% to ocena 3");
        } else if (wynik > 68 && wynik <= 76) {
            System.out.println(wynik + "% to ocena 3,5");
        } else if (wynik > 76 && wynik <= 84) {
            System.out.println(wynik + "% to ocena 4");
        } else if (wynik > 84 && wynik <= 92) {
            System.out.println(wynik + "% to ocena 4,5");
        } else {
            System.out.println(wynik + "% to ocena 5");
        }
    }

    private double sumaMaxPunktow() {
        int index = znajdzIndexLabZNajmniejszaIloscaPunktow();
        double minPunkt = punktyUcznia.get(index).getMaxPunkt();
        double suma = 0.0;
        for (Ocena ocena : punktyUcznia) {
            suma += ocena.getMaxPunkt();
        }
        return suma - minPunkt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", punktyUcznia=" + punktyUcznia +
                '}';
    }
}


