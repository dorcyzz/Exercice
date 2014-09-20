package com.telemis.exercice.game;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class Lancer {
    private final int fallenQuille;

    public Lancer(final int fallenQuille) {
        if (fallenQuille < 0) {
            throw new IllegalStateException("Nombre de quille abattue ne peut être négatif");
		}

        this.fallenQuille = fallenQuille;
    }

    public int getFallenQuille() {
        return fallenQuille;
    }

	@Override
	public String toString() {
		return "Lancer{" +
                "fallenQuille=" + fallenQuille +
                '}';
	}
}
