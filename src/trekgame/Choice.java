/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trekgame;

/**
 *
 * @author misaf
 */
public enum Choice {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

    public Decision beats(Choice move) {
        if (this == move) {
            return Decision.TIE;
        }
        switch (this) {
            case ROCK:
                return (move == LIZARD || move == SCISSORS) ? Decision.WIN : Decision.LOSS;
            case PAPER:
                return (move == ROCK || move == SPOCK) ? Decision.WIN : Decision.LOSS;
            case SCISSORS:
                return (move == PAPER || move == LIZARD) ? Decision.WIN : Decision.LOSS;
            case LIZARD:
                return (move == SPOCK || move == PAPER) ? Decision.WIN : Decision.LOSS;
            case SPOCK:
                return (move == ROCK || move == SCISSORS) ? Decision.WIN : Decision.LOSS;
        }

        return Decision.UNKNOWN;
    }
}
