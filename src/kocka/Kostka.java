package kocka;

import java.util.Random;

public class Kostka {

    private int pocetSten;
    private Random random;

    public Kostka(){
        this.pocetSten = 6;
        this.random = new Random();
    }

    public Kostka(int pocetSten){
        this.pocetSten = pocetSten;
        this.random = new Random();
    }

    public int vratPocetSten(){
        return this.pocetSten;
    }

    public int hod(){
        return this.random.nextInt(this.pocetSten) + 1;
    }

    @Override
    public String toString(){
        return String.format("Kostka s %s stenami", this.pocetSten);
    }
}
