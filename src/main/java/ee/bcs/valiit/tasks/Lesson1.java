package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {

            System.out.println("vali meetod, mida tahad tööle panna");
            System.out.println("1 - min");
            System.out.println("2 - max");
            System.out.println("3 - absoluutväärtus");
            System.out.println("4 - paaris/paaritu arv");
            System.out.println("5 - min3");
            System.out.println("6 - max3");
            System.out.println("0 - välja");

            int chooseMethod = scanner.nextInt();
            if (chooseMethod == 1) {
                System.out.println("sisesta esimene number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("nendest kõige väiksem number on: " + min(a, b));
            }
            else if (chooseMethod == 2) {
                System.out.println("sisesta esimene number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("nendest kõige suurem number on: " + max(a, b));
            }
            else if (chooseMethod == 3) {
                System.out.println("sisesta number");
                int a = scanner.nextInt();
                System.out.println("selle numbri absoluutväärtus on: " + abs(a));
            }
            else if (chooseMethod == 4) {
                System.out.println("sisesta number");
                int a = scanner.nextInt();
                if (a % 2 == 0) {
                    System.out.println("see number on paaris");
                } else {
                    System.out.println("see number on paaritu");
                }
            }
            else if (chooseMethod == 5) {
                System.out.println("sisesta esimene number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("sisesta kolmas number");
                int c = scanner.nextInt();
                System.out.println("nendest kõige väiksem number on: " + min3(a, b, c));
            }
            else if (chooseMethod == 6) {
                System.out.println("sisesta esimene number");
                int a = scanner.nextInt();
                System.out.println("sisesta teine number");
                int b = scanner.nextInt();
                System.out.println("sisesta kolmas number");
                int c = scanner.nextInt();
                System.out.println("nendest kõige suurem number on: " + max3(a, b, c));
            } else if (chooseMethod == 0) {
                running = false;
            }
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        return "\"\\\"\\\\\"\"";
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {

        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -(a);
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

}
