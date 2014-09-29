package com.telemis.exercice.game;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe représentant un lancer.
 */
public class Launch {

    private final int fallenPins;

    public Launch(final int fallenPins) {
        if (fallenPins < 0) {
            throw new IllegalStateException("Nombre de quille abattue ne peut être négatif");
        }

        this.fallenPins = fallenPins;
    }

    /**
     * Renvoie le nombre de quilles abattues.
     *
     * @return le nombre de quilles abattues
     */
    public int getFallenPins() {
        return fallenPins;
    }

    @Override
    /**
     * @see Object#toString()
     */
    public String toString() {
        return "Lancer{" + "fallenPins=" + fallenPins + '}';
    }
}
