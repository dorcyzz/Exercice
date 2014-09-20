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
//                joueur1.lancer(genererNombreQuillesAbattues(joueur1.getFrameCourante().getStandingQuilles()));
//            }
//
//            joueur2.initializeNewFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur2.lancer(genererNombreQuillesAbattues(joueur2.getFrameCourante().getStandingQuilles()));
//            }
//
//            joueur3.initializeNewFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur3.lancer(genererNombreQuillesAbattues(joueur3.getFrameCourante().getStandingQuilles()));
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
        player1.lancer(8);
        player1.lancer(1);
        player1.lancer(1);

        player1.initializeNewFrame();
        player1.lancer(8);
        player1.lancer(7);

        player1.initializeNewFrame();
        player1.lancer(1);
        player1.lancer(2);
        player1.lancer(1);

        player1.initializeNewFrame();
        player1.lancer(15);

        player1.initializeNewFrame();
        player1.lancer(1);
        player1.lancer(2);
        player1.lancer(1);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(player1.getFrames());

        player2.initializeNewFrame();
        player2.lancer(15);

        player2.initializeNewFrame();
        player2.lancer(8);
        player2.lancer(1);
        player2.lancer(2);

        player2.initializeNewFrame();
        player2.lancer(1);
        player2.lancer(2);
        player2.lancer(12);

        player2.initializeNewFrame();
        player2.lancer(6);
        player2.lancer(4);
        player2.lancer(1);

        player2.initializeNewFrame();
        player2.lancer(15);
        player2.lancer(8);
        player2.lancer(2);
        player2.lancer(3);

        List<ScoreContainer> scoreJoueur2 = ScoreManager.calculer(player2.getFrames());

        ScoreManager.displayScore(scoreJoueur1);
        ScoreManager.displayScore(scoreJoueur2);
    }

    private static int genererNombreQuillesAbattues(int borneSuperieure) {
        return random.nextInt(borneSuperieure);
    }
}
