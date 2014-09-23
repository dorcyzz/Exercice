package com.telemis.exercice.game;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
// TODO javadoc + comment
public class Lancer {

    private final int fallenPins;

    public Lancer(final int fallenPins) {
        if (fallenPins < 0) {
            throw new IllegalStateException("Nombre de quille abattue ne peut être négatif");
        }

        this.fallenPins = fallenPins;
    }

    public int getFallenPins() {
        return fallenPins;
    }

    @Override
    public String toString() {
        return "Lancer{" + "fallenPins=" + fallenPins + '}';
    }
}
