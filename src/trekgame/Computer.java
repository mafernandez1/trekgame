/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trekgame;

import java.util.Random;

/**
 *
 * @author misaf
 */
public class Computer extends Player {

    private final Random random;
    private static final int MAX_CHOICE = 5;

    public Computer() {
        random = new Random();
        setName("Computer");
    }

    @Override
    public void makeChoice() {

        switch (random.nextInt(MAX_CHOICE) + 1) {
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

}
