package bojovnik;

import kocka.Kostka;

public class BojovnikApp {

    public static void main(String[] args) {

        Kostka kostka = new Kostka(10);
        Bojovnik bojovnik = new Bojovnik("Zalgoren", 100, 20, 10, kostka);

        System.out.printf("Zivot: %s\n", bojovnik.grafickyZivot());

        Bojovnik rival = new Bojovnik("Shadow", 60, 18, 15, kostka);
        rival.attackHim(bojovnik);
        System.out.println(rival.getMessage());
        System.out.println(bojovnik.getMessage());

        System.out.printf("Zivot: %s\n", bojovnik.grafickyZivot());


    }
}
