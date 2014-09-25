package com.telemis.exercice.game.frame;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe représentant une frame pouvant contenir 4 lancers.
 */
public class FourLaunchFrame extends Frame {

    public FourLaunchFrame() {

    }

    void checkMaximumLaunch() {
        if (this.getLancers().size() >= 4) {
            throw new IllegalStateException("Nombre de lancer maximum (4) déjà atteint pour le joueur");
        }
    }
}
