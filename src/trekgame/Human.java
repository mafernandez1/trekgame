/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trekgame;

import java.util.Scanner;

/**
 *
 * @author misaf
 */
public class Human extends Player {

    private final Scanner scanner;

    public Human() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void makeChoice() {
        System.out.println("Available moves");
        System.out.println("1. ROCK");
        System.out.println("2. PAPER");
        System.out.println("3. SCISSORS");
        System.out.println("4. LIZARD");
        System.out.println("5. SPOCK");
        System.out.print("Please select: ");
        onlyNumbers();
        int option = scanner.nextInt();
        while (option < 1 || option > 5) {
            System.out.print("Invalid move, please select again: ");
            onlyNumbers();
            option = scanner.nextInt();
        }
        switch (option) {
            case 1:
                setChoice(Choice.ROCK);
                break;
            case 2:
                setChoice(Choice.PAPER);
                break;
            case 3:
                setChoice(Choice.SCISSORS);
                break;
            case 4:
                setChoice(Choice.LIZARD);
                break;
            case 5:
                setChoice(Choice.SPOCK);
                break;
        }
    }

    private void onlyNumbers() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid move, please select again: ");
            scanner.next();
        }
    }

}
