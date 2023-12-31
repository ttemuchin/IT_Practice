import java.util.*;
import java.util.stream.Collectors;

public class Taskset4 {
    public static StringBuilder nonRepetable(String a) {
        StringBuilder rez = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if (j == rez.length()) {
                    rez.append(a.charAt(i));
                }
                if (a.charAt(i) == rez.charAt(j)) {
                    break;
                }
            }
        }

        return rez;
    }
/*    public static ArrayList<String> generateBrackets(int a) {
        ArrayList<String> rez = new ArrayList<>();
        String one_str = "(".repeat(a) + ")".repeat(a);
        rez.add(one_str);
        System.out.println(one_str);
        int norm = 0;
        for (int i = 2 * a; i > 0; i -= 1) {
            char b = one_str.charAt(i-1);
            System.out.println("i= " + i);
            System.out.println(b);
            if (b == '(') {
                norm -= 1;
                System.out.println(norm);
                if (norm == 0) {
                    int left = a - (i+1)/2;
                    System.out.println("слева вставим "+ left);
                    int right = 2*a-i-1-left;
                    System.out.println("справа вставим "+ right);

                    rez.add(one_str.substring(0, i) + ")" + "(".repeat(left) + ")".repeat(right));
                    //norm += 1;
                }
            }
            else {
                norm += 1;
            }
        }

        return rez;
    }*/

    public static String new_str(String a, int b) {
        int bal = 0;
        for (int i = 2 * b; i > 0; i -= 1) {
            //System.out.println("i= " + i);
            //System.out.println(bal);
            if (a.charAt(i-1) == '(') {
                bal -= 1;
               // System.out.println(bal);
                if (bal != 0) {
                    int left = b - (i-1+bal)/2;
                   // System.out.println(i+"слева вставим "+ left);
                    int right = 2*b-i-left;
                   // System.out.println("справа вставим "+ right);

                    //System.out.println(a.substring(0, i-1) + ")" + "(".repeat(left) + ")".repeat(right));
                    return (a.substring(0, i-1) + ")" + "(".repeat(left) + ")".repeat(right));
                    //norm += 1;
                }
            }
            else {
                bal += 1;
            }
        }
        return "";
    }
    public static ArrayList<String> generateBrackets(int a) {
        ArrayList<String> rez = new ArrayList<>();
        String one_str = "(".repeat(a) + ")".repeat(a);
        while (!one_str.isEmpty()) {
            rez.add(one_str);
            one_str = new_str(one_str, a);
        }
        return rez;
    }

    public static ArrayList<String> binarySystem(int a) {
        //0000 - 1111=2+4+8+1=15 0 do 2^a-1
        ArrayList<String> rez = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, a); i++) {
            String b = Integer.toBinaryString(i);
            if (b.length() < a) {
                b = "0".repeat(a - b.length()) + b;
            }
            boolean cond = true;
            for (int j = 0; j < b.length()-1; j++) {
                if (b.charAt(j) == '0') {
                    if (b.charAt(j+1) == '0') {
                        cond = false;
                    }
                }
            }
            if (cond) {
                rez.add(b);
            }
        }
        return rez;
    }

    public static String alphabeticRow(String a) {
        StringBuilder rez = new StringBuilder();
        ArrayList<String> rezList = new ArrayList<>();
        a = a + "__";
        String alphabet = "abcdefghijklmnopqrstuvwxyz--";

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (a.charAt(i) == alphabet.charAt(j) && a.charAt(i+1) == alphabet.charAt(j+1)) {
                    rez.append(a.charAt(i));
                    if (a.charAt(i+2) != alphabet.charAt(j+2)) {
                        rez.append(a.charAt(i+1));
                        rezList.add(String.valueOf(rez));
                        rez = new StringBuilder();
                    }
                }
            }
        }

        alphabet = "zyxwvutsrqponmlkjihgfedcba--";

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (a.charAt(i) == alphabet.charAt(j) && a.charAt(i+1) == alphabet.charAt(j+1)) {
                    rez.append(a.charAt(i));
                    if (a.charAt(i+2) != alphabet.charAt(j+2)) {
                        rez.append(a.charAt(i+1));
                        rezList.add(String.valueOf(rez));
                        rez = new StringBuilder();
                    }
                }
            }
        }

        String mainRez = "";
        for (String longest: rezList) {
            if (mainRez.length() < longest.length())
                mainRez = longest;
        }
        return mainRez;
    }

    public static StringBuilder countChars(String a) {
        StringBuilder rez = new StringBuilder();
        StringBuilder newA = new StringBuilder();
        a = a + "_";
        int count = 1;
        for (int p = 0; p < a.length()-1; p++) {
            if (a.charAt(p) == a.charAt(p + 1)) {
                count++;
            }
            else {
                newA.append(count);
                newA.append(a.charAt(p));
                count = 1;
            }
        }
       // System.out.println(newA);

        for (int i = 1; i < newA.length(); i++) {
            for (int j = 0; j < newA.length(); j += 2) {
                if (Character.digit(newA.charAt(j), 10) == i){
                    rez.append(newA.charAt(j + 1));
                    rez.append(i);
                }
            }
        }

        return rez;
    }
     /*   //char[] b = a.toCharArray();
        //Arrays.sort(b);
        String rez = "";
        while (!a.isEmpty()) {
            HashMap<Character, Integer> chrAndCount = new HashMap<>();
            int count = 1;
            for (int i = 0; i < a.length() - 1; i++) {
                if (a.charAt(i) == a.charAt(i + 1)) {
                    count++;
                    chrAndCount.put(a.charAt(i), count);

                } else {
                    chrAndCount.put(a.charAt(i), count);
                    count = 1;
                }
            }

    *//*        Set<Character> keys = chrAndCount.keySet();
            ArrayList<Integer> values = new ArrayList<>(chrAndCount.values());
            System.out.println(keys);
            System.out.println(values);*//*

            ArrayList<Integer> helpList = new ArrayList<>();
            LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<Character, Integer> entry : chrAndCount.entrySet()) {
                helpList.add(entry.getValue());
            }
            Collections.sort(helpList);
            for (int i : helpList) {
                for (Map.Entry<Character, Integer> entry : chrAndCount.entrySet()) {
                    if (entry.getValue().equals(i)) {
                        sortedMap.put(entry.getKey(), i);
                        //System.out.println(entry.getKey());

                    }
                }
            }
            System.out.println(sortedMap);

            for (Map.Entry<Character, Integer> entry : chrAndCount.entrySet()) {
                String p;
                p = Character.toString(entry.getKey()).repeat(entry.getValue());
                a = a.replace(p, "");
                if (rez.isEmpty()) {
                    rez = entry.getValue() + Character.toString(entry.getKey());
                }
                else {
                    for (int i = 0; i < rez.length(); i += 2) {
                        if (rez.charAt(i) <= entry.getValue())//!!!
                            rez = rez.substring(0, i + 1) + entry.getValue() + entry.getKey() + rez.substring(i + 2);
                    }
                }
                System.out.println(a);
            }
        }
        //System.out.println(a);
       // System.out.println(rez);
        return rez;*/

    public static StringBuilder convertToNum(String a) {
        StringBuilder rez = new StringBuilder();
        String[] words = a.split(" ");
        HashMap<String, Integer> wordAndNum = new HashMap<>();
        wordAndNum.put("on", 1);
        wordAndNum.put("tw", 2);
        wordAndNum.put("th", 3);
        wordAndNum.put("fo", 4);
        wordAndNum.put("fi", 5);
        wordAndNum.put("si", 6);
        wordAndNum.put("se", 7);
        wordAndNum.put("ei", 8);
        wordAndNum.put("ni", 9);

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0,2);
        }
        //System.out.println(Arrays.toString(words));

        for (int i = words.length-1; i >= 0; i--) {
            for (Map.Entry<String, Integer> entry : wordAndNum.entrySet()) {
                if (Objects.equals(entry.getKey(), words[i])) {
                    rez.append(entry.getValue());
                }
            }
        }

        return new StringBuilder(rez).reverse();
    }

    public static String uniqueSubstring(String a) { //1 test and its okey
        String rez = "";
        StringBuilder unique = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (unique.indexOf(String.valueOf(a.charAt(i))) == -1) {
                unique.append(a.charAt(i));
            }
            else {
                if (rez.length() < unique.length())
                    rez = String.valueOf(unique);
            }
        }
        return rez;
    }

    public static int shortestWay(int[][] a) {
        int sum = 100000000;
        //turns = 2*(a.length-1)
        //проверка что 2ичное число содержит по н-1 0 и единиц
        for (int i = 0; i < Math.pow(2, 2*(a.length-1)); i++) {
            String iBin = Integer.toBinaryString(i);
            String code = "0".repeat(2*(a.length-1)-iBin.length()) + iBin;
            char[] sortCode = code.toCharArray();
            Arrays.sort(sortCode);
            if (sortCode[sortCode.length/2] == '1' && sortCode[sortCode.length/2-1] == '0') {
                char[] path = code.toCharArray();
                int x = 0;
                int y = 0;
                int testSum = a[0][0];
                //System.out.println(code);
                for (char c : path) {
                    if (c == '0') {
                        x++;
                        testSum += a[x][y];
                    }
                    if (c == '1') {
                        y++;
                        testSum += a[x][y];
                    }
                }
                if (testSum < sum)
                    sum = testSum;
            }
        }

        return sum;
    }

    public static String numericOrder(String a) {
        String[] words = a.split(" ");
        //ArrayList<String> rez = new ArrayList<>();
        String[] rez = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            int intValue;
            String cleanWord;
            for (int j = 0; j < words[i].length(); j++) {
                try {
                    intValue = Integer.parseInt(String.valueOf(words[i].charAt(j)));
                    cleanWord = words[i].replace(String.valueOf(words[i].charAt(j)), "");
                    //System.out.println(intValue);
                    //System.out.println(cleanWord);
                    rez[intValue-1] = cleanWord;
                } catch (NumberFormatException ignored) {}

            }
        }
        return (Arrays.stream(rez).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static char[] switchNums(String a, String b){
        char[] exchange = a.toCharArray();
        char[] mainNum = b.toCharArray();
        int changed = 0;
        Arrays.sort(exchange);
        //System.out.println(exchange);
        for (int i = 0; i < mainNum.length; i++) {
            if (changed != exchange.length) {
                if (mainNum[i] < exchange[exchange.length-changed-1]) {
                    mainNum[i] = exchange[exchange.length-changed-1];
                    changed ++;
                    //System.out.println(mainNum);
                }
            }
        }

        return mainNum;
    }

    public static void main(String[] args) {
        System.out.println(nonRepetable("abracadabra"));
        System.out.println(nonRepetable("paparazzi"));
        System.out.println();

        System.out.println(generateBrackets(5));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println();

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println();

        System.out.println(alphabeticRow("abcdjvwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println();

        System.out.println(countChars("aaabbcdd"));
        System.out.println(countChars("vvvvaajaaaaa"));
        System.out.println();

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println();

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println();

        int[][] first8 = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(shortestWay(first8));
        int[][] second8 = {{2,7,3}, {1,4,8}, {4,5,9}};
        System.out.println(shortestWay(second8));
        System.out.println();

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println();

        System.out.println(switchNums("519","723"));
        System.out.println(switchNums("491","3912"));
        System.out.println(switchNums("6274","71259"));
        System.out.println();
    }
}
