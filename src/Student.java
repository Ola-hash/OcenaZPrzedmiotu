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

    public void dodajPunkty(Ocena ocena) {
        punktyUcznia.add(ocena);
    }

    public void wszystkiePunkty() {
        for (Ocena oceny : punktyUcznia) {
            System.out.println(oceny.getPunkt());
        }
    }

    public void wystawOcene() {
        double punkty = sumaPunktow();
        double maxPunkty = sumaMaxPunktow();
        double wynik = (punkty / maxPunkty) * 100;
        if (wynik < 60) {
            System.out.println("Ocena 2");
        } else if (wynik >= 60 && wynik <= 68) {
            System.out.println("Ocena 3");
        } else if (wynik > 68 && wynik <= 76) {
            System.out.println("Ocena 3,5");
        } else if (wynik > 76 && wynik <= 84) {
            System.out.println("Ocena 4");
        } else if (wynik > 84 && wynik <= 92) {
            System.out.println("Ocena 4,5");
        } else {
            System.out.println("Ocena 5");
        }
    }

    public double sumaPunktow() {
        double suma = 0.0;
        for (Ocena ocena : punktyUcznia) {
            suma += ocena.getPunkt();
        }
        return suma;
    }

    public double sumaMaxPunktow() {
        double suma = 0.0;
        for (Ocena ocena : punktyUcznia) {
            suma += ocena.getMaxPunkt();
        }
        return suma;
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


