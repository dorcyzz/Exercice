package com.telemis.exercice;

import com.telemis.exercice.game.Joueur;
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
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");
        Joueur joueur3 = new Joueur("Joueur 3");

//        for (int i = 1; i < 6; ++i) {
//            LOGGER.info("FRAME " + i);
//
//            joueur1.initialiseNouvelleFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur1.lancer(genererNombreQuillesAbattues(joueur1.getFrameCourante().getQuilleDebout()));
//            }
//
//            joueur2.initialiseNouvelleFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur2.lancer(genererNombreQuillesAbattues(joueur2.getFrameCourante().getQuilleDebout()));
//            }
//
//            joueur3.initialiseNouvelleFrame();
//            for (int j = 0; j < 3; ++j) {
//                joueur3.lancer(genererNombreQuillesAbattues(joueur3.getFrameCourante().getQuilleDebout()));
//            }
//        }
//
//        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(joueur1.getFrames());
//        List<ScoreContainer> scoreJoueur2 = ScoreManager.calculer(joueur2.getFrames());
//        List<ScoreContainer> scoreJoueur3 = ScoreManager.calculer(joueur3.getFrames());
//
//        ScoreManager.displayScore(scoreJoueur1);
//        ScoreManager.displayScore(scoreJoueur2);
//        ScoreManager.displayScore(scoreJoueur3);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(8);
        joueur1.lancer(1);
        joueur1.lancer(1);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(8);
        joueur1.lancer(7);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(1);
        joueur1.lancer(2);
        joueur1.lancer(1);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(15);

        joueur1.initialiseNouvelleFrame();
        joueur1.lancer(1);
        joueur1.lancer(2);
        joueur1.lancer(1);

        List<ScoreContainer> scoreJoueur1 = ScoreManager.calculer(joueur1.getFrames());

        joueur2.initialiseNouvelleFrame();
        joueur2.lancer(15);

        joueur2.initialiseNouvelleFrame();
        joueur2.lancer(8);
        joueur2.lancer(1);
        joueur2.lancer(2);

        joueur2.initialiseNouvelleFrame();
        joueur2.lancer(1);
        joueur2.lancer(2);
        joueur2.lancer(12);

        joueur2.initialiseNouvelleFrame();
        joueur2.lancer(6);
        joueur2.lancer(4);
        joueur2.lancer(1);

        joueur2.initialiseNouvelleFrame();
        joueur2.lancer(15);
        joueur2.lancer(8);
        joueur2.lancer(2);
        joueur2.lancer(3);

        List<ScoreContainer> scoreJoueur2 = ScoreManager.calculer(joueur2.getFrames());

        ScoreManager.displayScore(scoreJoueur1);
        ScoreManager.displayScore(scoreJoueur2);
    }

    private static int genererNombreQuillesAbattues(int borneSuperieure) {
        return random.nextInt(borneSuperieure);
    }
}
