import java.util.*;
import java.util.stream.Collectors;

public class Taskset5 {
    public static boolean sameLetterPattern(String a, String b) {

        ArrayList<Integer> listA = stringPattern(a);
        ArrayList<Integer> listB = stringPattern(b);
        return listA.equals(listB);//равенство списков ключей H.M.
    }

    private static ArrayList<Integer> stringPattern(String str) {
        char[] arr1 = str.toCharArray();
        ArrayList<Integer> listA = new ArrayList<>();
        HashMap<Character, Integer> mapA = new HashMap<>();
        int counter = 0;
        for (char c : arr1) {
            if (mapA.containsKey(c)) {
                listA.add(mapA.get(c));
                //System.out.println(mapA.get(c));
            } else {
                mapA.put(c, counter);
                listA.add(counter);
                counter += 1;
            }//если хешмап содержит такой символ, то несем в список соотв ключ
        }
        return listA;
    }

    public static StringBuilder spiderVsFly(String a, String b){
        char[] charArr = a.toCharArray();
        int spiderRad = (int) charArr[0] - 65;
        int spiderRing = Integer.parseInt(String.valueOf(charArr[1]));
        int[] spiderPos = new int[] {spiderRad, spiderRing};
        charArr = b.toCharArray();
        int flyRad = (int) charArr[0] - 65;
        int flyRing = Integer.parseInt(String.valueOf(charArr[1]));
        int[] flyPos = new int[] {flyRad, flyRing};
        // коорд А1

        StringBuilder path = new StringBuilder();

        if (spiderPos[0] - flyPos[0] > 2 || flyPos[0] - spiderPos[0] > 2) {
            for (int i = spiderPos[1]; i > 0; i--) {
                path.append((char) (spiderPos[0] + 65));
                path.append(i); //меняем только кольцо
                path.append('-');//через центр так как с такой разницей короче
            }
            for (int i = 0; i <= flyPos[1]; i++) {
                path.append((char) (flyPos[0] + 65));//коорд мухи и снова меняем кольца
                path.append(i);
                path.append('-');
            }
        } else {//разница по радианам 2 1 0
            if (spiderPos[1] > flyPos[1]) { //выше по кольцу
                for (int i = spiderPos[1]; i >= flyPos[1]; i--) {
                    path.append((char) (spiderPos[0] + 65));
                    path.append(i); //спускаемся
                    path.append('-');
                }
                for (int i = spiderPos[0]; i != flyPos[0];) {
                    if (spiderPos[0] - flyPos[0] > 0) {
                        i--; // меняем радиану
                    } else {
                        i++;
                    }
                    path.append((char) (i + 65));
                    path.append(flyPos[1]);
                    path.append('-');
                }
            } else { //ниже по кольцу
                for (int i = spiderPos[0]; i != flyPos[0];) {
                    path.append((char) (i + 65));
                    path.append(spiderPos[1]);//по радиалам
                    path.append('-');
                    if (spiderPos[0] - flyPos[0] > 0) {
                        i--;
                    } else {
                        i++;
                    }
                }
                for (int i = spiderPos[1]; i <= flyPos[1]; i++) {
                    path.append((char) (flyPos[0] + 65));
                    path.append(i); //снова по кольцу
                    path.append('-');
                }
            }
        }
        path.delete(path.length()-1, path.length());

        return path;
        //жесть a little
    }

    public static int digitsCount(long a) {
        int count = 0;
        a = a / 10;
        if (a != 0) {
            count += 1;
            count += digitsCount(a);//смотрим из бесконечности?
        } else {
            count += 1;
        }
        return count;
    }

    public static int totalPoints(String[] a, String b) {
        int score = 0;
        char[] arrMain = b.toCharArray();
        //перебор данных слов
        for (String s : a) {
            char[] word = s.toCharArray();
            char[] main = Arrays.copyOf(arrMain, arrMain.length);
            Arrays.sort(word);
            Arrays.sort(main);//чтобы сравнивать посимвольно
            //System.out.println((Arrays.toString(word) +" "+ Arrays.toString(main)));
            boolean needToAdd = true;
            for (char c : word) {
                boolean equalLetters = false;
                for (int i = 0; i < main.length; i++) {
                    if (c == main[i]) {
                        main[i] = '_';//буквы просто должны совпасть
                        equalLetters = true;
                    }
                }//если использовано несколько одинаковых, чего нет в main, то флаг не станет тру
                if (!equalLetters) {needToAdd = false;}
            }
            if (needToAdd) {
                score += s.length() - 2;
                if (s.length() == 6) {
                    score += 50;
                }//анаграммы зачтутся и так
            }
        }
        return score;
    }

    public static Integer[][] sumsUP(int[] a) {
        ArrayList<Integer[]> list = new ArrayList<>();
        //пошел двойной перебор каждый с каждым
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {//!только вперёд
                if (a[i] + a[j] == 8) {
                    list.add(new Integer[] {a[i], a[j]});//проверку больше меньше?
                }
            }
        }
//1st
        Integer[][] rez = new Integer[list.size()][2];
        rez = list.toArray(rez);
        return rez;
    }

    public static String takeDownAverage(String[] a){
        List<Integer> list = new ArrayList<>();
        for (String s : a) {
            list.add(Integer.valueOf(s.substring(0, s.length()-1)));
        }

        float sum = (float) list.stream().reduce(0, Integer::sum);
        float average = sum / (float) list.size() - 5;
        float out = (average*(list.size() + 1) - sum);// i m in!!!
        return Math.round(out) + "%";
    }

    public static String caesarCipher(String choice, String message, int a) {
        message = message.toUpperCase();
        char[] charM = message.toCharArray();
        boolean mode;
        mode = !Objects.equals(String.valueOf(choice), "decode");
//A65 Z90

        if (mode) {//encode
            for (int i = 0; i < charM.length; i++) {
                if (charM[i] >= 65 && charM[i] <= 90) {//A-Z
                    if (charM[i] + a > 90) {//посимв замена
                        charM[i] = (char) (charM[i] + a - 26);
                    } else {
                        charM[i] = (char) (charM[i] + a);
                    }
                }
            }
        }
        else {//просто в обратную сторону
            for (int i = 0; i < charM.length; i++) {
                if (charM[i] >= 65 && charM[i] <= 90) {
                    if (charM[i] - a < 65) {
                        charM[i] = (char) (charM[i] - a + 26);
                    } else {
                        charM[i] = (char) (charM[i] - a);
                    }
                }
            }
        }
        return String.valueOf(charM);
    }

    public static int setSetup(int n, int k) {
        int rez = n - k + 1;//первый множитель верхнего факториала
        if (k > 1) {//делаем пока n > n-k+1
            //System.out.println(rez);
            rez = rez*setSetup(n, k-1);
        }
        return rez;
    }

    public static StringBuilder timeDifference(String c1, String dateC1, String c2) {
        HashMap<String, Integer> cities = new HashMap<>();
        cities.put("Los Angeles", -8 * 60);
        cities.put("New York", -5 * 60);
        cities.put("Caracas", -5 * 60 + 30);
        cities.put("Buenos Aires", -3 * 60);
        cities.put("London", 0);
        cities.put("Rome", 60);
        cities.put("Moscow", 3 * 60);
        cities.put("Tehran", 3 * 60 + 30);
        cities.put("New Delhi", 5 * 60 + 30);
        cities.put("Beijing", 8 * 60);
        cities.put("Canberra", 10 * 60);
        HashMap<String, Integer> months = new HashMap<>();
        months.put("January", 0);//n days
        months.put("February", 31);
        months.put("March", 59);
        months.put("April", 90);
        months.put("May", 120);
        months.put("June", 151);
        months.put("July", 181);
        months.put("August", 212);
        months.put("September", 242);
        months.put("October", 273);
        months.put("November", 303);
        months.put("December", 334);

        int diff = cities.get(c2) - cities.get(c1);

        String[] dateAndTime = dateC1.split(" ");
        String[] timeOnly = dateAndTime[3].split(":");

        long min = 0;

        min += (months.get(dateAndTime[0]) + Integer.parseInt(dateAndTime[1].replaceAll(",",""))) * 1440L;
        min += Integer.parseInt(dateAndTime[2]) * 525600L;
        min += Integer.parseInt(timeOnly[0]) * 60L;
        min += Integer.parseInt(timeOnly[1]);
        min += diff;

        int year = (int) (min / 525600L);
        min = min % 525600L;
        int month = 1;
        int day = (int) min / 1440;
        min = min % 1440L;
        int hours = (int) min / 60;
        min = min % 60;


        Set<Map.Entry<String, Integer>> monthsSet = months.entrySet().stream()
                .sorted((x,y)->y.getValue().compareTo(x.getValue()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (Map.Entry<String, Integer> entry : monthsSet) {
            if (entry.getValue() <= day){
                month = entry.getValue() / 28 + 1;
                day -= entry.getValue();
                break;
            }
        }
        // 2 мапы. города и разность времени + месяцы и номер первого дня в каждом
        // приводим всё в минуты. вычитаем разницу, делим и приводим к норм виду
        StringBuilder rez = new StringBuilder();
        rez.append(year);
        rez.append('-');
        rez.append(month);
        rez.append('-');
        rez.append(day);
        rez.append(' ');
        if (hours<10) rez.append('0');
        rez.append(hours);
        rez.append(':');
        if (min<10) rez.append('0');
        rez.append(min);
        return rez;
    }


    public static boolean isNew(int a) {
        String b = String.valueOf(a);
        char[] digits = b.toCharArray();
        boolean newA = true; //min digit + n * 0 + 23999...
//условие - впереди есть цифры меньше
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] < digits[i-1]) {//
                if ((i != 1 || digits[i] != '0') && (i != 2 || digits[i-1] != '0')) {
                    newA = false; // 30909 i=3, + and prev. + if оба  не 0
                }
            }
        }
        return newA;
    }

    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println();

        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println();

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(54));
        System.out.println(digitsCount(111111));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289999999999L));
        System.out.println();

        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println();

        System.out.println(Arrays.deepToString(sumsUP(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.deepToString(sumsUP(new int[] {1, 2, 3, 7, 9})));
        System.out.println(Arrays.deepToString(sumsUP(new int[] {10, 9, 7, 2, 8})));
        System.out.println(Arrays.deepToString(sumsUP(new int[] {1, 6, 5, 4, 8, 2, 3, 7})));
        System.out.println();

        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        System.out.println();

        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println();

        System.out.println(setSetup(5,3));
        System.out.println(setSetup(7,3));
        System.out.println();

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println();

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
        System.out.println(isNew(30909));
        System.out.println();
    }

}

//        return year + "-" + timeFormat(month) + "-" + timeFormat(day) +
//                " " + timeFormat(hours) + ":" + timeFormat((int) min);


//                if ((i != 1 || digits[i] != '0') & (i != 2 || digits[i-1] != '0')) {