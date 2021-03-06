package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe permettant de calculer un score.
 */
public interface ScoreCalculator {

    /**
     * Méthode permettant de calculer le score d'une frame.
     *
     * @param frames       la liste des frames de la partie
     * @param currentFrame la frame à calculer
     * @return un objet ScoreContainer contenant les informations sur le score de la frame
     */
    public ScoreContainer calculate(List<Frame> frames, Frame currentFrame);

}
