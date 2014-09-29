package com.telemis.exercice;

import com.telemis.exercice.game.Player;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.ScoreManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
public class Launcher {

    private static final Logger LOGGER = Logger.getLogger(Launcher.class);

    private static final Random random = new Random();

    public static void main(String[] args) {
        //playScenario1();
        //playScenario2();
        playScenario3();
    }

    private static void playScenario1() {
        Player player1 = new Player("Joueur 1");

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
        player1.launch(Frame.TOTAL_NUMBER_OF_PINS);

        player1.initializeNewFrame();
        player1.launch(1);
        player1.launch(2);
        player1.launch(1);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(player1.getFrames());
        LOGGER.info(StringUtils.EMPTY);
        ScoreManager.displayScore(scoreJoueur1);
    }

    private static void playScenario2() {
        Player player2 = new Player("Joueur 2");
        player2.initializeNewFrame();
        player2.launch(Frame.TOTAL_NUMBER_OF_PINS);

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
        player2.launch(Frame.TOTAL_NUMBER_OF_PINS);
        player2.launch(8);
        player2.launch(2);
        player2.launch(3);

        List<ScoreContainer> scoreJoueur2 = ScoreManager.calculer(player2.getFrames());
        LOGGER.info(StringUtils.EMPTY);
        ScoreManager.displayScore(scoreJoueur2);
    }

    private static void playScenario3() {
        Player player1 = new Player("Joueur 1");
        Player player2 = new Player("Joueur 2");
        Player player3 = new Player("Joueur 3");

        for (int i = 1; i < 6; ++i) {
            LOGGER.info(StringUtils.EMPTY);
            LOGGER.info("FRAME " + i);

            player1.initializeNewFrame();
            for (int j = 0; j < 3; ++j) {
                player1.launch(generateRandomlyFallenPinsNumber(player1.getCurrentFrame().getStandingPins()));
            }

            player2.initializeNewFrame();
            for (int j = 0; j < 3; ++j) {
                player2.launch(generateRandomlyFallenPinsNumber(player2.getCurrentFrame().getStandingPins()));
            }

            player3.initializeNewFrame();
            for (int j = 0; j < 3; ++j) {
                player3.launch(generateRandomlyFallenPinsNumber(player3.getCurrentFrame().getStandingPins()));
            }
        }

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(player1.getFrames());
        List<ScoreContainer> scoreJoueur2 = ScoreManager.calculer(player2.getFrames());
        List<ScoreContainer> scoreJoueur3 = ScoreManager.calculer(player3.getFrames());

        LOGGER.info(StringUtils.EMPTY);
        LOGGER.info("Score joueur1");
        ScoreManager.displayScore(scoreJoueur1);
        LOGGER.info("Score joueur2");
        ScoreManager.displayScore(scoreJoueur2);
        LOGGER.info("Score joueur3");
        ScoreManager.displayScore(scoreJoueur3);
    }

    private static int generateRandomlyFallenPinsNumber(int borneSuperieure) {
        return random.nextInt(borneSuperieure + 1);
    }
}
