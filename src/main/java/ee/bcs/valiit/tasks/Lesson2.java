package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        System.out.println(Arrays.toString(yl3(5)));
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] someNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            someNumbers[i] = i + 1;
        }
        return someNumbers;
    }


    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0

    public static int[] decreasingArray(int n) {
        if (n < 0) {
            int neg = -n;
            int[] someNumbers = new int[neg + 1];
            for (int i = -n; i >= 0; i--) {
                someNumbers[i] = n + i;
            }
            return someNumbers;
        } else {
            int[] someNumbers = new int[n + 1];
            for (int i = n; i >= 0; i--) {
                someNumbers[i] = n - i;
            }
            return someNumbers;
        }
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] someNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            someNumbers[i] = 3;
        }
        return someNumbers;
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public int[] sampleArray() {
        return new int[]{1, 2, 3, 4, 5};
    }

    // TODO tagasta n esimest arvu alates 1-st
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public int[] firstN(int n) {
        int[] someNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            someNumbers[i] = i + 1;
        }
        return someNumbers;
    }
}
