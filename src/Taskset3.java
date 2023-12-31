import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Taskset3 {
    public static StringBuilder replaceVovels(String a) {
        StringBuilder rez = new StringBuilder();
        char[] vovels = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};
        //char[] inputed = a.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < vovels.length; j++) {
                if (vovels[j] == a.charAt(i)) {
                    rez.append('*');
                    break;
                }
                if (j == vovels.length-1){
                    rez.append(a.charAt(i));
                }
            }
        }
        return rez;
    }

    public static void stringTransform(String a) {
        StringBuilder rez = new StringBuilder();
        String b = "Double";
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == a.charAt(i-1)) {
                rez.append(b);
                String c = a.substring(i, i+1).toUpperCase();
                rez.append(c);
                i++;
            }
            else {
                rez.append(a.charAt(i-1));
            }
        }
        rez.append(a.charAt(a.length()-1));
        System.out.println(rez);
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[] box = {a, b, c};
        int[] hole = {w, h};
        Arrays.sort(box);
        Arrays.sort(hole);
        //System.out.println(Arrays.toString(box));

        return (box[0] <= hole[0]) && (box[1] <= hole[1]);
    }

    public static boolean numCheck(int a) {
        int sumSq = 0;
        int b = a;
        for (int i = 1; a > 0; i++) {
            //int dec = (int) Math.pow(10, i);
            int digit = a % 10;
            a = a / 10;
            //System.out.println(a);
            sumSq = sumSq + (digit*digit);
           // System.out.println(sumSq);
        }

        return b % 2 == sumSq % 2;
    }

    public static int countRoots(int[] arr) {
        int d = (int) Math.sqrt(arr[1]*arr[1]-4*arr[0]*arr[2]);
        float x1 = (float) (-arr[1] + d) / 2;
        float x2 = (float) (-arr[1] - d) / 2;
        //System.out.println(x1);
        //System.out.println(x2);

        if ((d<0) || ((x1 % 1 != 0) && (x2 % 1 != 0))) {
            return 0;
        }
        else if (d == 0){
            return 1;
        }
        else if ((x1 % 1 == 0) && (x2 % 1 == 0)) {
            return 2;                               //дискр больше 0,
        }
        else if (((x1 % 1 != 0) && (x2 % 1 == 0)) || ((x2 % 1 != 0) && (x1 % 1 == 0))) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static String salesData(String[][] data) {
        String[] rez = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            //int shops = 0;
            for (int j = 1; j < data[i].length; j++) {
                if (j == 4) {
                    rez[i] = data[i][0];
                }
            }
        }//return
        return (Arrays.stream(rez).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.joining(", ")));
    }

    public static boolean validSplit(String a) {
        //for (char ch : a.toCharArray()) {
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            if (b[i] == ' ') {
                if (b[i-1] != b[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean waveForm(int[] a) {
        for (int i = 1; i < a.length-1; i++) {
            if ((((a[i-1] > a[i]) && (a[i] > a[i+1]))) || (((a[i-1] < a[i]) && (a[i] < a[i+1])))) {
                return false;
            }
        }
        return true;
    }

    public static char commonVovel(String a){
        char[] b = a.toLowerCase().toCharArray();
        char[] vovels = {'a', 'e', 'i', 'o', 'u', 'y'};
        Arrays.sort(b);
        StringBuilder delNotVovels = new StringBuilder();
        for (char c : b) {
            for (char vovel : vovels) {
                if (vovel == c) {
                    delNotVovels.append(c);
                    break;
                }
            }
        }
        //System.out.println(delNotVovels);

        int max = 0;
        int count = 0;
        char rez = ' ';
        for (int i = 0; i < delNotVovels.length()-1; i++) {
            if (delNotVovels.charAt(i) == delNotVovels.charAt(i+1)) {
                count++;
                if (count > max) {
                    max = count;
                    rez = delNotVovels.charAt(i);
                }
            }
            else {
                count = 0;
            }
        }
        return rez;
    }

    public static int[][] dataScience(int[][] a) {
        int[][] rez = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++){
                if (i!=j){
                    rez[i][j] = a[i][j];
                }
                else {
                    int average = 0;
                    for (int m = 0; m < a.length; m++) {
                        if (m!=i) {
                            average += a[m][i];
                            //System.out.println(average);
                        }
                    }
                    rez[i][j] = Math.round((float) average / (a.length-1));
                }
            }
        }
        return rez;
    }

    public static void main(String[] args)
    {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println();

        stringTransform("hello");
        stringTransform("bookkeeper");
        System.out.println();

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println();

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println();

        int[] first5 = {1, -3, 2};
        System.out.println(countRoots(first5));
        int[] second5 = {2, 5, 2};
        System.out.println(countRoots(second5));
        int[] third5 = {1, -6, 9};
        System.out.println(countRoots(third5));
        System.out.println();

        String [][] first6 = {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"}, {"Pear", "Shop2", "Shop4"}};
        System.out.println(salesData(first6));
        String  [][] second6 = {{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"}, {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}};
        //System.out.println(Arrays.toString(salesData(second6)));
        System.out.println(salesData(second6));
        System.out.println();

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println();

        int[] first8 = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(first8));
        int[] second8 = {1, 2, 3, 4, 5};
        System.out.println(waveForm(second8));
        int [] third8 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(third8));
        System.out.println();

        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words"));
        System.out.println();

        int [][] first10 = {{1, 2, 3, 4, 5}, {6, 7, 8, 29, 10}, {
            5, 5, 5, 5, 35}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}};
        System.out.println(Arrays.deepToString(dataScience(first10)));
        int [][] second10 = {{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {
                48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}};
        System.out.println(Arrays.deepToString(dataScience(second10)));


    }
}
