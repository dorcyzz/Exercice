package com.telemis.exercice.game;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
// TODO javadoc + comment
public class FourLaunchFrame extends Frame {

    public FourLaunchFrame() {

    }

    void checkMaximumLaunch() {
        if (this.getLancers().size() >= 4) {
            throw new IllegalStateException("Nombre de lancer maximum (4) déjà atteint pour le joueur");
        }
    }
}
