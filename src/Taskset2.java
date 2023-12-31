import java.util.Arrays;
import java.util.Random;

public class Taskset2 {

    public static void dublicateChars(String b) {
        String a = b.toLowerCase();
        boolean rez = false;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if(a.charAt(i) == a.charAt(j) && (i != j))
                {
                    rez = true;
                    break;
                }
            }
            if (rez) {
                break;
            }
            //i++;
        }
        System.out.println(rez);
    }

    public static void getInitials(String c) {
        String rez = "";
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) >= 'A' && c.charAt(i) <= 'Z') {
                rez = rez + c.charAt(i);
            }
        }
        System.out.println(rez);
    }

    public static void differenceEvenOdd(int[] nums) {
        int rez = 0;
        for (int a : nums) {
            if (a % 2 == 0) {
                rez += a;
            }
            else {
                rez -= a;
            }
        }
        System.out.println(Math.abs(rez));
    }

    public static void equalToAvg(int[] nums) {
        boolean rez = false;
        float s = 0;
        for (int a : nums) {
            s += a;
        }
        float s_a = (s / nums.length);
        for (int a : nums) {
            if (a == s_a) {
                rez = true;
                break;
            }
        }
        System.out.println(rez);
    }

    private static String indexMult(int[] nums) {
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i] * i;
        }
        //System.out.println(Arrays.toString(newArr));
        return Arrays.toString(newArr);
    }

    public static void reverse(String a) {
        StringBuilder rez = new StringBuilder();
        for (int i = a.length()-1; i >= 0; i = i - 1) {
            char chr = a.charAt(i);
            rez.append(chr);
        }
        System.out.println(rez);
    }

    public static void Tribonacci(int a) {
        int b = 0, c = 0, d = 1, e = 0;
        while (e < a-3) {
            int sum = b + c + d;
            b = c;
            c = d;
            d = sum;
            e ++;
        }
        System.out.println(d);
    }

    public static void pseudoHash(int a) {
        Random r = new Random();
        String str = "abcdef";
        StringBuilder rez = new StringBuilder();
        for (int i = 0; i < a; i ++) {
            boolean choose = r.nextBoolean();
            if (choose) {
                int index = (int) (Math.random() * 6);
                char chr = str.charAt(index);//буквы
                rez.append(chr);
            }
            else {
                int chr = (int) (Math.random() * 10);//цифры
                rez.append(chr);
            }
        }
        System.out.println(rez);
    }

    public static void botHelper(String a) {
        boolean rez = false;
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) == 'h') || (a.charAt(i) == 'H')) {
                if ((a.charAt(i+1) == 'e') && (a.charAt(i+2) == 'l') && (a.charAt(i+3) == 'p')) {
                    rez = true;
                }
            }
        }
        if (rez) {
            System.out.println("Calling for a staff member");
        }
        else {
            System.out.println("Keep waiting");
        }
    }

    public static boolean isAnagram(String a, String b) {
        //boolean rez = false;

        char[] arr_a = a.toCharArray();
        char[] arr_b = b.toCharArray();

        Arrays.sort(arr_a);
        Arrays.sort(arr_b);

        //System.out.println(rez);
        return Arrays.equals(arr_a, arr_b);
    }

    public static void main(String[] args)
    {
        dublicateChars("Donald");
        dublicateChars("orange");
        System.out.println();

        getInitials("Ryan Gosling");
        getInitials("Barack Obama");
        System.out.println();

        int[] first3 = {44, 32, 86, 19};
        differenceEvenOdd(first3);
        int[] second3 = {22, 50, 16, 63, 31, 55};
        differenceEvenOdd(second3);
        System.out.println();

        int[] first4 = {1, 2, 3, 4, 5};
        equalToAvg(first4);
        int[] second4 = {1, 2, 3, 4, 6};
        equalToAvg(second4);
        System.out.println();

        int[] first5 = {1, 2, 3};
        System.out.println(indexMult(first5));
        int[] second5 = {3, 3, -2, 408, 3, 31};
        System.out.println(indexMult(second5));
        System.out.println();

        reverse("Hello World");
        reverse("The quick brown fox.");
        System.out.println();

        Tribonacci(7);
        Tribonacci(11);
        System.out.println();

        pseudoHash(5);
        pseudoHash(10);
        pseudoHash(0);
        System.out.println();

        botHelper("Hello, I'm under water, please help me!!");
        botHelper("Two pepperoni pizzas please");
        System.out.println();

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }
}