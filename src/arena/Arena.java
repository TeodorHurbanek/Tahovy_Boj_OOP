package arena;

import bojovnik.Bojovnik;
import kocka.Kostka;
import mag.Mag;

public class Arena {

    private Bojovnik bojovnik1;
    private Bojovnik bojovnik2;
    private Kostka kostka;

    public Arena(Bojovnik bojovnik1, Bojovnik bojovnik2, Kostka kostka) {
        this.bojovnik1 = bojovnik1;
        this.bojovnik2 = bojovnik2;
        this.kostka = kostka;
    }

    private void printArena() {
        System.out.println(" _______  _______  _______  _        _______ \n" +
                "(  ___  )(  ____ )(  ____ \\( (    /|(  ___  )\n" +
                "| (   ) || (    )|| (    \\/|  \\  ( || (   ) |\n" +
                "| (___) || (____)|| (__    |   \\ | || (___) |\n" +
                "|  ___  ||     __)|  __)   | (\\ \\) ||  ___  |\n" +
                "| (   ) || (\\ (   | (      | | \\   || (   ) |\n" +
                "| )   ( || ) \\ \\__| (____/\\| )  \\  || )   ( |\n" +
                "|/     \\||/   \\__/(_______/|/    )_)|/     \\|\n" +
                "                                             ");
        System.out.println("Bojovnici: \n");
        printBojovnik(bojovnik1);
        System.out.println();
        printBojovnik(bojovnik2);
        System.out.println();
    }

    private void printMessage(String message) {
        System.out.println(message);
       try {
           Thread.sleep(500);
       }catch (InterruptedException ex){
           System.out.println("Chyba, neprodarilo sa uspat vlakno!");
       }
    }

    private void printBojovnik(Bojovnik b) {
        System.out.println(b);
        System.out.print("Zivot: ");
        System.out.println(b.grafickyZivot());
        if (b instanceof Mag) {
            System.out.print("Mana: ");
            System.out.print(((Mag)b).grafickaMana());
        }
    }

    public void fight() {
        Bojovnik b1 = bojovnik1;
        Bojovnik b2 = bojovnik2;

        System.out.println("Vytajte v arene!");
        System.out.printf("Dnes sa utkaju %s vs %s! \n\n", bojovnik1, bojovnik2);

        boolean startBojovnik2 = (kostka.hod() <= kostka.vratPocetSten() / 2);
        if (startBojovnik2) {
            b1 = bojovnik2;
            b2 = bojovnik1;
        }
        System.out.printf("Zacinat bude bojovnik %s! \n\nZapas moze zacat!\n", b1);


        while (b1.alive() && b2.alive()) {
            b1.attackHim(b2);
            printArena();
            printMessage(b1.getMessage());
            printMessage(b2.getMessage());
            System.out.println();
            if (b2.alive()) {
                b2.attackHim(b1);
                printArena();
                printMessage(b2.getMessage());
                printMessage(b1.getMessage());
            }
            System.out.println();
        }
    }
}
