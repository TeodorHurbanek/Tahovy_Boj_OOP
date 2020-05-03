package mag;

import bojovnik.Bojovnik;
import kocka.Kostka;

public class Mag extends Bojovnik {

    private int mana;
    private int maxMana;
    private int magickyUtok;

    public Mag(String name, int health, int attack, int defense, Kostka kostka, int mana, int magickyUtok) {
        super(name, health, attack, defense, kostka);
        this.mana = mana;
        this.maxMana = mana;
        this.magickyUtok = magickyUtok;
    }

    @Override
    public void attackHim(Bojovnik rival) {
        //mana is unfull
        if (this.mana < this.maxMana) {
            this.mana += 10;
            if (this.mana > this.maxMana) {
                this.mana = this.maxMana;
            }
            super.attackHim(rival);
        } else {
            int attack = this.magickyUtok + kostka.hod();
            setMessage(String.format("%s pouzil magiu za %s hp", this.name, attack));
            rival.defendMe(attack);
            this.mana = 0;
        }
    }

    public String grafickaMana() {
        return grafickyUzivatel(this.mana, this.maxMana);
    }
}
