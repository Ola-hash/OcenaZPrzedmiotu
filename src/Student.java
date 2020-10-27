import java.util.ArrayList;
import java.util.Collections;

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

    public int znajdzIndexLabZNajmniejszaIloscaPunktow() {
        int index = 0;
        double minPunkt = Double.MAX_VALUE;
        for (int i = 0; i < punktyUcznia.size(); i++) {
            if (punktyUcznia.get(i).typZadania.equals("laboratoria")) {
                if (punktyUcznia.get(i).getPunkt() < minPunkt) {
                    minPunkt = punktyUcznia.get(i).getPunkt();
                    index = i;
                }
            }
        }
        return index;
    }

    public double ocenaZaSprawdziany() {
        double suma = 0.0;
        for (int i = 0; i < punktyUcznia.size(); i++) {
            if (punktyUcznia.get(i).typZadania.equals("sprawdziany"))
                suma += punktyUcznia.get(i).getPunkt();
        }
        return suma;
    }

    public double ocenaZaLaboratoria() {
        int index = znajdzIndexLabZNajmniejszaIloscaPunktow();
        double minPunkt = 0.0;
        double suma = 0.0;
        for (Ocena ocena : punktyUcznia) {
            minPunkt = punktyUcznia.get(index).getPunkt();
            suma += ocena.getPunkt();
        }
        return suma - minPunkt;
    }


    public void wystawOcene() {
        double punkty = ocenaZaLaboratoria() + ocenaZaSprawdziany();
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

    public double sumaMaxPunktow() {
        int index = znajdzIndexLabZNajmniejszaIloscaPunktow();
        double minPunkt = 0.0;
        double suma = 0.0;
        for (Ocena ocena : punktyUcznia) {
            minPunkt = punktyUcznia.get(index).getMaxPunkt();
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


