package kocka;

public class KostkaApp {

    public static void main(String[] args) {

        Kostka sest = new Kostka();
        Kostka deset = new Kostka(10);

        System.out.println(sest);
        for (int i = 0; i < 10; i++){
            System.out.print(sest.hod() +" ");
        }

        System.out.println("\n\n"+ deset);
        for (int i = 0; i < 10; i++){
            System.out.print(sest.hod() +" ");
        }

    }
}
