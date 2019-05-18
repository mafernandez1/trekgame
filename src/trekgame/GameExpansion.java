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
public class GameExpansion {

    private final Human user;
    private final Computer computer;
    private int numberOfGamesPlayed;
    private boolean keepPlaying;
    private final Scanner scan;

    public GameExpansion() {
        user = new Human();
        computer = new Computer();
        scan = new Scanner(System.in);
        keepPlaying = true;
    }

    public void startGame() {
        System.out.print("Please type your name: ");
        user.setName(scan.nextLine());

        while (keepPlaying) {
            user.makeChoice();
            computer.makeChoice();
            displayChoices();
            result();
            playAgain();
        }
        displayScore();
    }

    private void displayChoices() {
        System.out.println(user.getName() + " has selected " + user.getChoice());
        System.out.println(computer.getName() + " has selected " + computer.getChoice());
    }

    private void result() {
        switch (user.getChoice().beats(computer.getChoice())) {
            case WIN:
                System.out.println(user.getName() + " has beaten " + computer.getName());
                user.augmentScore();
                break;
            case LOSS:
                System.out.println(computer.getName() + " has beaten " + user.getName());
                computer.augmentScore();
                break;
            case TIE:
                System.out.println("Tie!");
                break;
        }
        numberOfGamesPlayed++;
    }

    private void playAgain() {
        System.out.print("Do you want to play again? Y/N: ");
        String option = scan.nextLine();
        option = option.toLowerCase();
        while (!option.equals("n") && !option.equals("y")) {
            System.out.print("Invalid option, please type again: ");
            option = scan.nextLine();
            option = option.toLowerCase();
        }
        switch (option) {
            case "y":
                keepPlaying = true;
                break;
            case "n":
                keepPlaying = false;
                break;
        }
    }

    private void displayScore() {
        int ties = numberOfGamesPlayed - user.getScore() - computer.getScore();
        System.out.println("GAME STATS: " + user.getName());
        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |\n",
                "WINS", "LOSSES", "TIES", "GAMES PLAYED");
        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |\n",
                user.getScore(), computer.getScore(), ties, numberOfGamesPlayed);
    }
}
