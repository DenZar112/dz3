package com.company;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        /*Задание 1:Написать программу, которая загадывает случайное число
         от 0 до 9 и пользователю дается 3 попытки угадать это число.
         При каждой попытке компьютер должен сообщить,
         больше ли указанное пользователем число, чем загаданное, или меньше.
         После победы или проигрыша выводится запрос – «Повторить игру еще раз?
         1 – да / 0 – нет»(1 – повторить, 0 – нет).
         */
        InputStream inputStream = System.in;
        System.out.println("Привет! Давай сыграем с тобой в игру. " +
                "Угадай число от 0 до 9. " +
                "У тебя есть на это 3 попытки:");

        gameNumber();
        System.out.println();

        int userAnswer1;

        do {
            System.out.println("«Повторить игру еще раз?\n" +
                    "Введите: 1 – да / 0 – нет»(1 – повторить, 0 – нет).");

            Scanner scanner1 = new Scanner(System.in);
            userAnswer1 = scanner1.nextInt();

            if (userAnswer1 == 1){
                gameNumber();
            }else{
                System.out.println("конец игры");

            }


        }while(userAnswer1 != 0);

    }

    public static int randomNumber(){
        Random random = new Random();
        int x = random.nextInt(10);

        return x;
    }

    public static int gameNumber(){
        Scanner scanner = new Scanner(System.in);
        int tryCount = 0;
        int maxTryCount = 3;
        int answer = randomNumber();
        do {

            System.out.println("Введите число: ");
            int userAnswer = scanner.nextInt();

                if (userAnswer == answer){
                    System.out.println("Поздравляю! Вы угадали! " + "Правильный ответ: " + answer);
                    break;
                }else if (userAnswer > answer){
                    System.out.println("Вы ввели слишком большое число.");
                    tryCount++;
                    System.out.println("У Вас осталось " + (maxTryCount - tryCount) + " попытки(а)");


                    //count++;
                }else if (userAnswer < answer){
                    System.out.println("Вы ввели слишком маленькое число.");
                    tryCount++;
                    System.out.println("У Вас осталось " + (maxTryCount - tryCount) + " попытки(а)");
                }
                if(tryCount == maxTryCount){
                    System.out.println("Ваши попытки закончились, вы проиграли!"
                            + "правильный ответ был: " + answer);

            }


        }while (tryCount != 3);

        return answer;

    }



}
