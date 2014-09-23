package com.telemis.exercice.score.calculator.calculators;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.score.ScoreContainer;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactory;
import com.telemis.exercice.score.calculator.enums.ScoreCalculatorType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe permettant de calculer le score d'une frame lors d'un spare.
 */
public class SpareScoreCalculator implements ScoreCalculator {
    private static final String SPARE_SYMBOL = "/";

    private static final SpareScoreCalculator INSTANCE = new SpareScoreCalculator();

    private SpareScoreCalculator() {
        super();
    }

    public static SpareScoreCalculator getInstance() {
        return INSTANCE;
    }

    @Override
    /**
     * @see com.telemis.exercice.score.calculator.calculators.ScoreCalculator#calculate(java.util.List, int, int)
     */
    public ScoreContainer calculate(List<Frame> frames, int framePosition) {
        ScoreCalculator scoreCalculator = ScoreCalculatorFactory.createScoreCalculator(ScoreCalculatorType.NORMAL);
        ScoreContainer container = scoreCalculator.calculate(frames, framePosition);
        int frameScore = container.getFrameScore();

        completeSpareRepresentation(container, frames.get(framePosition).getLancers().size());

        List<Lancer> nextFrameLancers = frames.get(framePosition + 1).getLancers();

        for (int i = 0; i < 2; ++i) {
            final int fallenPins = nextFrameLancers.get(i).getFallenPins();
            frameScore += fallenPins;
        }

        container.setFrameScore(frameScore);

        return container;
    }

    private void completeSpareRepresentation(ScoreContainer container, int lancersSize) {
        container.getLancersScores().set(lancersSize - 1, SPARE_SYMBOL);

        if (container.getLancersScores().size() == 2) {
            container.getLancersScores().add(StringUtils.EMPTY);
        }
    }

}
