package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära arvamise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println("Paku üks number.");
        //System.out.println(i);
        int guesscount = 0;
        int guessN = scanner.nextInt();
        while (guessN != i) {
            if (guessN < i) {
                System.out.println("Pakutud number on väiksem.");
                guesscount++;
                System.out.println("Palun sisesta suurem number.");
                guessN = scanner.nextInt();
            } else {
                System.out.println("Pakutud number on suurem.");
                guesscount++;
                System.out.println("Palun sisesta väiksem number.");
                guessN = scanner.nextInt();
            }
        }
        if (guesscount == 0) {
            System.out.println("Palju õnne! Hämmastav, aga esimese katsega.");
        } else {
            System.out.println("Tubli! Õige number oli " + i + "! Sul läks " + (guesscount + 1) + " katset arvamisega.");
        }
    }
}