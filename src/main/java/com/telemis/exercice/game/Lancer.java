package com.telemis.exercice.game;

/**
 * Created by sebastien.vandamme on 18/09/2014.
 */
public class Lancer {
	private final int quilleAbattue;

	public Lancer(final int quilleAbattue) {
		if(quilleAbattue < 0){
			throw new IllegalStateException("Nombre de quille abattue ne peut être négatif");
		}

		this.quilleAbattue = quilleAbattue;
	}

	public int getQuilleAbattue() {
		return quilleAbattue;
	}

	@Override
	public String toString() {
		return "Lancer{" +
				"quilleAbattue=" + quilleAbattue +
				'}';
	}
}
