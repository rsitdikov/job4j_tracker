package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11, player = 1, max = 3, select;
        Scanner input = new Scanner(System.in);
        do {
            player ^= 1;
            System.out.println("На столе осталось спичек: " + matches + ".");
            if (matches < 3) {
                max = matches;
            }
            do {
                System.out.print("Игрок " + (player + 1) + " укажите количество спичек (от 1 до "
                        + max + "): ");
                select = Integer.valueOf(input.nextLine());
            } while (select < 1 || select > max);
                System.out.println();
                matches -= select;
        } while (matches > 0);
        System.out.println("Выиграл игрок " + (player + 1));
    }
}
