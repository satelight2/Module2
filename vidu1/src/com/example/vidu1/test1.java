package com.example.vidu1;

import java.util.Scanner;

public class test1 {
    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên không âm (tối đa 3 chữ số): ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("Vui lòng nhập số từ 0 đến 999.");
        } else {
            String words = convertNumberToWords(number);
            System.out.println(words);
        }
    }

    public static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        String result = "";

        // Hàng trăm
        int hundreds = number / 100;
        if (hundreds > 0) {
            result += units[hundreds] + " hundred ";
            number %= 100;
        }

        // Hàng chục và hàng đơn vị
        if (number > 0) {
            if (number < 10) {
                result += units[number];
            } else if (number < 20) {
                result += teens[number - 10];
            } else {
                result += tens[number / 10] + " " + units[number % 10];
            }
        }

        return result.trim();
    }
}
