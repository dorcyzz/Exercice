package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactory;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 *
 * Classe permettant de calculer le score d'une frame lors d'un spare.
 */
//TODO quid si spare dans dernière frame ?
public class SpareScoreCalculator implements ScoreCalculator {
    private static final String SPARE_SYMBOL = "/";

    private static final SpareScoreCalculator INSTANCE = new SpareScoreCalculator();

    private SpareScoreCalculator() {
    }

    public static SpareScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, com.telemis.exercice.game.frame.Frame)
     */
    public ScoreContainer calculate(List<Frame> frames, Frame frame) {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.NORMAL);
        ScoreContainer container = scoreCalculator.calculate(frames, frame);
        int frameScore = container.getFrameScore();

        completeRepresentation(container, frame.getLancers().size());

        List<Lancer> nextFrameLancers = frames.get(frames.indexOf(frame) + 1).getLancers();

        for (int i = 0; i < 2; ++i) {
            final int fallenPins = nextFrameLancers.get(i).getFallenPins();
            frameScore += fallenPins;
        }

        container.setFrameScore(frameScore);

        return container;
    }

    private void completeRepresentation(ScoreContainer container, int lancersSize) {
        container.getLancersScores().set(lancersSize - 1, SPARE_SYMBOL);

        if (container.getLancersScores().size() == 2) {
            container.getLancersScores().add(StringUtils.EMPTY);
        }
    }
}
