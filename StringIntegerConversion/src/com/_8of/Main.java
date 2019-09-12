package com._8of;

public class Main {

    private static int convertToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int number = 0;

        for (int i = chars.length - 1; i>= 0; i--) {
            char c = chars[i];
            if (c == '-') {
                number *= -1;
                break;
            }
            int tenth = chars.length - 1 - i;
            if (tenth > 0) {
                tenth = (int) Math.pow(10, tenth);
            } else {
                tenth = 1;
            }
            int num = c - '0';
            number += tenth * num;
        }
        return number;
    }

    private static String convertToString(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        int current = num < 0 ? -num : num;

        while (current > 0) {
            int remainer = current % 10;
            sb.insert(0, remainer);
            current = current / 10;
        }

        if (num < 0) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToInt("-1"));
        System.out.println(convertToInt("0"));
        System.out.println(convertToInt("1"));
        System.out.println(convertToInt("137"));
        System.out.println(convertToInt("-31"));

        System.out.println();

        System.out.println(convertToString(-1));
        System.out.println(convertToString(0));
        System.out.println(convertToString(1));
        System.out.println(convertToString(137));
        System.out.println(convertToString(-31));
    }
}
