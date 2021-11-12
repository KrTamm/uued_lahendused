package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;


public class Lesson3 {

    public static void main(String[] args) {
        System.out.println();
    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int p = x;
        while (x >= 2) {
            p = (x - 1) * p;
            x--;
        }
        return p;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String newS = "";
        char ch;
        for (int i = a.length() - 1; i >= 0; i--) {
            ch = a.charAt(i);
            newS = newS + ch;
        }
        return newS;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        int count = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                count++;
            }
        }
        return count == 2;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int sumX = 0;
        int n1 = 0;
        int n2 = 1;
        while (n2 < x) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            if (n2 % 2 == 0) {
                sumX += n2;
            }
        }
        return sumX;
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        Map<Character, String> map = new HashMap<>();
        map.put('h', "....");
        map.put('o', "---");
        map.put('l', ".-..");
        map.put('e', ".");
        map.put('s', "...");
        String answer = "";
        for (int i = 0; i < text.length(); i++) {
            answer += map.get(text.charAt(i));
            if (i + 1 < text.length()) {
                answer += " ";
            }
        }
        return answer;
    }
}
