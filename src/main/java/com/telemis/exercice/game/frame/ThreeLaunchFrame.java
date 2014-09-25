package com.telemis.exercice.game.frame;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe représentant une frame pouvant contenir 3 lancers.
 */
public class ThreeLaunchFrame extends Frame {

    public ThreeLaunchFrame() {

    }

    void checkMaximumLaunch() {
        if (this.getLancers().size() >= 3) {
            throw new IllegalStateException("Nombre de lancer maximum (3) déjà atteint pour le joueur");
        }
    }
}
