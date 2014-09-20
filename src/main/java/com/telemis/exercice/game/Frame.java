package com.telemis.exercice.game;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class Frame {
    public static final int TOTAL_NUMBER_OF_QUILLES = 15;
    private int standingQuilles = TOTAL_NUMBER_OF_QUILLES;
    private static final Logger LOGGER = Logger.getLogger(Frame.class);
    private final List<Lancer> lancers = new ArrayList<>();

    private boolean spare;

    private boolean strike;

    private boolean lastFrame;

    public Frame(boolean lastFrame) {
        super();

        this.lastFrame = lastFrame;
    }

    public void addLancer(Lancer lancer) {
        if ((this.lastFrame && this.lancers.size() >= 4) || (!this.lastFrame && this.lancers.size() >= 3)) {
            throw new IllegalStateException("Nombre de lancer maximum déjà atteint pour le joueur (3 ou 4 dans le cas de la dernière frame)");
        }

        this.lancers.add(lancer);

        this.standingQuilles -= lancer.getFallenQuille();

        if (this.standingQuilles < 0) {
            this.standingQuilles = 0;
        }

        if (this.standingQuilles == 0) {
            if (lancers.size() == 1) {
                strike = true;
            } else {
                spare = true;
            }
        }
    }

    public List<Lancer> getLancers() {
        return Collections.unmodifiableList(this.lancers);
    }

    public int getStandingQuilles() {
        return this.standingQuilles;
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public boolean isLastFrame() {
        return lastFrame;
    }

    @Override
    public String toString() {
        return "Frame{" + "lancers=" + lancers + ", standingQuilles=" + standingQuilles + ", spare=" + spare + ", strike=" + strike + '}';
    }
}
