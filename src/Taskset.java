public class Taskset {
    public static void convert(int a) {
        System.out.format("%.3f", (3.785f*a));
        System.out.println("");
    }

    public static void fitCalc(int a, int b) {
        System.out.println(b*a);
    }

    public static void containers(int a, int b, int c) {
        System.out.println(20*a+50*b+100*c);
    }

    public static void triangleType(int a, int b, int c) {
        if ((a+b>c) && (a+c>b) && (c+b>a)) {
            if ((a == b) && (b == c)) {
                System.out.println("This triangle is equilateral");
            }
            else if ((a == b) || (a == c) || (b == c)) {
                System.out.println("This triangle is isosceles");
            }
            else {
                System.out.println("This triangle is versatile");
            }
        }
        else {
            System.out.println("Not a triangle");
        }

    }

    public static void ternaryEvaluation(int a, int b) {
        String answer = (a > b) ? String.format("%d", a) : String.format("%d", b);
        System.out.println(answer);
    }

    public static void howManyItems(float a, float b, float c) {
        float p = a/(2*b*c);
        int t = (int) p;
        System.out.println(t);
    }

    public static void factorial(int a) {
        int t = a;
        for (int i = 2; i < a; a -= 1) {
           t = t * (a-1);
        }
        System.out.println(t);
    }

    public static void gcd(int a, int b) {
        while (a - b != 0) {
            int rez = a - b;
            if (b > rez) {
                a = b;
                b = rez;
            }
            else {
                a = rez;
            }
            //System.out.println(b);
        }
        System.out.println(b);
    }

    public static void ticketSaler(int a, int b) {
        float rez = 0.72f*a*b;
        System.out.println((int) rez);
    }

    public static void tables(int a, int b) {
        if (a < 2 * b) {
            int rez = 0;
            System.out.println(rez);
        }
        else {
            int rez = (a - 2 * b) / 2;
            System.out.println(rez+1);
        }
        //System.out.println(rez);
    }

    public static void main(String[] args) {
        //System.out.println("Hello and welcome!");

        convert(5);
        convert(3);
        convert(8);
        System.out.println();

        fitCalc(15, 1);
        fitCalc(24, 2);
        fitCalc(41, 3);
        System.out.println();

        containers(3, 4, 2);
        containers(5, 0, 2);
        containers(4, 1, 4);
        System.out.println();

        triangleType(5, 5, 5);
        triangleType(5, 4, 5);
        triangleType(3, 4, 5);
        triangleType(5, 1, 1);
        System.out.println();

        ternaryEvaluation(8, 4);
        ternaryEvaluation(1, 11);
        ternaryEvaluation(5, 9);
        System.out.println();

        howManyItems(22f, 1.4f, 2f);
        howManyItems(45f, 1.8f, 1.9f);
        howManyItems(100f, 2f, 2f);
        System.out.println();

        factorial(3);
        factorial(5);
        factorial(7);
        System.out.println();

        gcd(48, 18);
        gcd(52, 8);
        gcd(259, 28);
        System.out.println();

        ticketSaler(70, 1500);
        ticketSaler(24, 950);
        ticketSaler(53, 1250);
        System.out.println();

        tables(5, 2);
        tables(31, 20);
        tables(123, 58);

    }
}