package com.telemis.exercice.game.frame;

import com.telemis.exercice.game.Launch;
import com.telemis.exercice.game.enums.ScoreType;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe représentant une frame pouvant contenir 5 lancers.
 */
public class FiveLaunchesFrame extends Frame {

    public FiveLaunchesFrame() {

    }

    /**
     * @see com.telemis.exercice.game.frame.Frame#checkMaximumLaunchesAuthorized()
     */
    void checkMaximumLaunchesAuthorized() {
        if (this.getLaunches().size() >= 5) {
            throw new IllegalStateException("Nombre de lancer maximum (5) déjà atteint pour le joueur");
        }
    }

    @Override
    /**
     * @see com.telemis.exercice.game.frame.Frame#addLaunch(com.telemis.exercice.game.Launch)
     * @param lancer le lancer effectué
     */
    public void addLaunch(Launch launch) {
        super.addLaunch(launch);

        if (ScoreType.NORMAL != getScoreType() && getStandingPins() == 0) {
            setStandingPins(Frame.TOTAL_NUMBER_OF_PINS);
        }
    }
}
