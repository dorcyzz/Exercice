package com.telemis.exercice.game;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
// TODO javadoc + comment
public class Lancer {

    private final int fallenQuilles;

    public Lancer(final int fallenQuille) {
        if (fallenQuille < 0) {
            throw new IllegalStateException("Nombre de quille abattue ne peut être négatif");
        }

        this.fallenQuilles = fallenQuille;
    }

    public int getFallenQuilles() {
        return fallenQuilles;
    }

    @Override
    public String toString() {
        return "Lancer{" + "fallenQuilles=" + fallenQuilles + '}';
    }
}
