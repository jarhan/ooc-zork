package gamePlay;

import java.util.Scanner;

public class ZorkGame {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Zork Game ❤️");
        System.out.println("In this game, you have to pass all 3 floors to clear the game.");
        System.out.println("Now, you are in the first floor. GOOD LUCK HAVE FUN \uD83C\uDF40");

        System.out.print("You: ");
        String[] commandLine = scanner.nextLine().split("\\s+");

    }
}