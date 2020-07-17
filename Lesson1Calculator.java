package com.example.lesson1calculator;

import java.util.Scanner;

public class Lesson1Calculator {
    public static void main(String[] args) {
        System.out.print("式を入力してね　>");
        int[] number = new int[15];
        String[] symbol = new String[15];
        //数値と記号の入力を受けとる

        int i = 0;
        do{
            String numberString = new Scanner(System.in).nextLine();
            number[i] = Integer.parseInt(numberString);
            //計算記号を入力
            String symbol2 =
                    new Scanner(System.in).nextLine();
            symbol[i] = symbol2;
            i++;
        }while (!(symbol[i-1].equals("=")));

        i = 0;
        while (!(symbol[i].equals("="))){
            if (symbol[i].equals("*")) number[i + 1] = number[i] * number[i + 1];
            else if (symbol[i].equals("/")) number[i + 1] = number[i] / number[i + 1];
            i++;
        }

        //掛けると割るを先にして+-の計算をする

        i = 0;
        while(!symbol[i].equals("=")){
            if(symbol[i].equals("+") || symbol[i].equals("-")){
                int m = i+1;
                while(!(symbol[m].equals("+") || symbol[m].equals("-")
                        || symbol[m].equals("="))) m++;
                if (symbol[i].equals("+")) number[m] = number[i] + number[m];
                else number[m] = number[i] - number[m];
            }
            i++;
        }
        System.out.println(number[i]);

    }
}
