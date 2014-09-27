package com.telemis.exercice.game.frame;

import com.telemis.exercice.game.Lancer;
import com.telemis.exercice.game.enums.ScoreType;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe représentant une frame pouvant contenir 5 lancers.
 */
public class FiveLaunchFrame extends Frame {

    public FiveLaunchFrame() {

    }

    void checkMaximumLaunch() {
        if (this.getLancers().size() >= 5) {
            throw new IllegalStateException("Nombre de lancer maximum (5) déjà atteint pour le joueur");
        }
    }

    @Override
    public void addLancer(Lancer lancer) {
        super.addLancer(lancer);

        if (ScoreType.NORMAL != getScoreType() && getStandingPins() == 0) {
            setStandingPins(Frame.TOTAL_NUMBER_OF_PINS);
        }
    }
}
