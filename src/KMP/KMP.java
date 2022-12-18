package KMP;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        String string = "Personal data";
        String word = "abcabd";
        System.out.println(getFirstEntry(string, word));
    }

    public static int[] prefixFunction(String s) { //ищем длину совпавших букв в суффиксе и префиксе (разной длины) в подстроках паттерна
        int[] p = new int[s.length()]; //p - массив на кол-во букв в искомом слове (паттерне)
        int k = 0;
        for (int i = 1; i < s.length(); i++) { //идем по паттерну
            while (k > 0 && s.charAt(k) != s.charAt(i)) //пока к>0 и паттерн[k] 1= паттерн[i]
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i)) //если символы сравнялись
                ++k;
            p[i] = k;
            System.out.println(p[i]);
        }
        return p;
    }

    public static int getFirstEntry(String s, String pattern) {
        int m = pattern.length(); //m=длина искомого слова (патерна)
        if (m == 0)
            return 0;
        int[] p = prefixFunction(pattern);  //ищем длину совпавших букв в суффиксе и префиксе (разной длины) в подстроках паттерна и записываем е в ячейки p
        System.out.println(Arrays.toString(p));
        for (int i = 0, k = 0; i < s.length(); i++)
            while (true) {
                if (pattern.charAt(k) == s.charAt(i)) {
                    k++;
                    if (k == m) {
                        return i + 1 - m;
                    }
                    break;
                }
                if (k == 0) {
                    break;
                }
                k = p[k - 1];
            }
        return -1;
    }
}