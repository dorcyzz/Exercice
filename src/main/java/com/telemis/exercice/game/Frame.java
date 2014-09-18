package com.telemis.exercice.game;

import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class Frame {

	public static final int NOMBRE_TOTAL_QUILLES = 15;
    private int quilleDebout = NOMBRE_TOTAL_QUILLES;
    private static final Logger LOGGER = Logger.getLogger(Frame.class);
    private final List<Lancer> lancers = new LinkedList<>();

	// private int score = 0;
	private boolean spare = false;

	private boolean strike = false;

	public Frame() {
		super();

	}

    //TODO 4 lancers si derniere frame
    public void addLancer(Lancer lancer) {
        if (this.lancers.size() >= 4) {
            throw new IllegalStateException("Nombre de lancer maximum (3) déjà atteint pour le joueur");
        }

		this.lancers.add(lancer);

		this.quilleDebout -= lancer.getQuilleAbattue();

		if (this.quilleDebout < 0) {
			this.quilleDebout = 0;
		}

		if (this.quilleDebout == 0) {
			if (lancers.size() == 1) {
				strike = true;
			} else {
				spare = true;
			}
		}

		// this.score = calculerScore();
	}

	// public int calculerScore() {
	// int totalScore = 0;
	//
	// for (Lancer lancer : this.lancers) {
	// totalScore += lancer.getQuilleAbattue();
	// }
	//
	// return totalScore;
	// }

	public List<Lancer> getLancers() {
		return Collections.unmodifiableList(this.lancers);
	}

	public int getQuilleDebout() {
		return this.quilleDebout;
	}

	public boolean isSpare() {
		return spare;
	}

	public boolean isStrike() {
		return strike;
	}

	@Override
	public String toString() {
		return "Frame{" + "lancers=" + lancers + ", quilleDebout=" + quilleDebout + ", spare=" + spare + ", strike=" + strike + '}';
	}
}
