package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.score.ScoreContainer;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
public interface ScoreCalculator {

    public ScoreContainer calculer(List<Frame> frames, int currentTotalScore, int framePosition);

}
