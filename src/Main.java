import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Student student = new Student("ola", "loza");
        Student student1 = new Student("igor", "bodnar");
        Ocena ocena = new Ocena(40, 10, "laboratoria");
        Ocena ocena1 = new Ocena(6, 30, "laboratoria");
        Ocena ocena2 = new Ocena(10, 30, "laboratoria");
        student.dodajPunkty(ocena);
        student.dodajPunkty(ocena1);
        student.dodajPunkty(ocena2);
        System.out.println(student.ZnajdzIndeksLaboreZNajmniejszaIloscaPunktow());


    }
}
