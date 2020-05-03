import arena.Arena;
import bojovnik.Bojovnik;
import kocka.Kostka;
import mag.Mag;

public class MainApp {

    public static void main(String[] args) {

        Kostka kostka = new Kostka();
        Bojovnik ronaldo = new Bojovnik("Ronaldo", 100, 20, 10, kostka);
        Bojovnik gandalf = new Mag("Gandalf", 60, 15, 12, kostka, 30, 45);
        Arena arena = new Arena(ronaldo, gandalf, kostka);

        arena.fight();
    }
}
