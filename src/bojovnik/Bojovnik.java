package bojovnik;

import kocka.Kostka;

import java.security.PublicKey;

public class Bojovnik {

    protected String name;

    protected int health;

    protected int maxHealth;

    protected int attack;

    protected int defense;

    protected Kostka kostka;

    private String message;

    public Bojovnik(String name, int health, int attack, int defense, Kostka kostka) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.kostka = kostka;
    }

    public boolean alive() {
        return (this.health > 0);
//        if (health > 0){
//            return true;
//        } else {
//            return false;
//        }
    }

    protected String grafickyUzivatel(int aktual, int maximal) {
        String s = "[";
        int celkom = 20;
        double pocet = Math.round(((double)aktual / maximal) * celkom);
        if ((pocet == 0) && (alive())) {
            pocet = 1;
        }
        for (int i = 0; i < pocet; i++) {
            s += "█";
        }
        s = String.format("%1$-"+ (celkom + 1) + "s", s);
//        for (int i = 0; i < celkom - pocet; i++) {
//            s += " ";
//        }
        s += "]";
        return s;
    }

    public String grafickyZivot() {
        return grafickyUzivatel(this.health, this.maxHealth);
    }

    public void attackHim(Bojovnik rival) {
        int attacks = this.attack + kostka.hod();
        setMessage(String.format("%s utoci s uderom za %s hp", this.name, attacks));
        rival.defendMe(attacks);
    }

    public void defendMe(int attack) {
        int injury = attack - (this.defense + this.kostka.hod());
        if (injury > 0) {
            this.health -= injury;
            this.message = String.format("%s utrpel poskodenie %s hp", name, injury);
            if (this.health <= 0) {
                this.health = 0;
                this.message += " a zomrel";
            }
        } else {
            this.message = String.format("%s odrazil utok", name);
        }
        setMessage(this.message);
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
