package com.telemis.exercice;

import com.telemis.exercice.game.Player;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.ScoreManager;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class Launcher {
    private static final Logger LOGGER = Logger.getLogger(Launcher.class);

    private static Random random = new Random();

    public static void main(String[] args) {
        Player player1 = new Player("Joueur 1");
        Player player2 = new Player("Joueur 2");
        Player player3 = new Player("Joueur 3");

//        for (int i = 1; i < 6; ++i) {
//            LOGGER.info("FRAME " + i);
//
//            joueur1.initializeNewFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur1.launch(generateRandomlyFallenPinsNumber(joueur1.getCurrentFrame().getStandingPins()));
//            }
//
//            joueur2.initializeNewFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur2.launch(generateRandomlyFallenPinsNumber(joueur2.getCurrentFrame().getStandingPins()));
//            }
//
//            joueur3.initializeNewFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur3.launch(generateRandomlyFallenPinsNumber(joueur3.getCurrentFrame().getStandingPins()));
//            }
//        }
//
//        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculate(joueur1.getFrames());
//        List<ScoreContainer> scoreJoueur2 = ScoreManager.calculate(joueur2.getFrames());
//        List<ScoreContainer> scoreJoueur3 = ScoreManager.calculate(joueur3.getFrames());
//
//        ScoreManager.displayScore(scoreJoueur1);
//        ScoreManager.displayScore(scoreJoueur2);
//        ScoreManager.displayScore(scoreJoueur3);

        player1.initializeNewFrame();
        player1.launch(8);
        player1.launch(1);
        player1.launch(1);

        player1.initializeNewFrame();
        player1.launch(8);
        player1.launch(7);

        player1.initializeNewFrame();
        player1.launch(1);
        player1.launch(2);
        player1.launch(1);

        player1.initializeNewFrame();
        player1.launch(15);

        player1.initializeNewFrame();
        player1.launch(1);
        player1.launch(2);
        player1.launch(1);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(player1.getFrames());

        player2.initializeNewFrame();
        player2.launch(15);

        player2.initializeNewFrame();
        player2.launch(8);
        player2.launch(1);
        player2.launch(2);

        player2.initializeNewFrame();
        player2.launch(1);
        player2.launch(2);
        player2.launch(12);

        player2.initializeNewFrame();
        player2.launch(6);
        player2.launch(4);
        player2.launch(1);

        player2.initializeNewFrame();
        player2.launch(15);
        player2.launch(8);
        player2.launch(2);
        player2.launch(3);

        List<ScoreContainer> scoreJoueur2 = ScoreManager.calculer(player2.getFrames());

        ScoreManager.displayScore(scoreJoueur1);
        ScoreManager.displayScore(scoreJoueur2);
    }

    private static int generateRandomlyFallenPinsNumber(int borneSuperieure) {
        return random.nextInt(borneSuperieure);
    }
}
