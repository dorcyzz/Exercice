package com.telemis.exercice.game;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
// TODO javadoc + comment
public class Player {

    private static final Logger LOGGER = Logger.getLogger(Player.class);

    private final String name;

    private final List<Frame> frames = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(this.frames);
    }

    public Frame getCurrentFrame() {
        if (frames.isEmpty()) {
            throw new IllegalStateException("Aucune frame initialisée pour le joueur " + name + ", veillez initialiser une frame");
        }

        return frames.get(frames.size() - 1);
    }

    public void initializeNewFrame() {
        int currentNumberOfFrames = frames.size();

        if (currentNumberOfFrames == 5) {
            throw new IllegalStateException("Nombre de frames maximum (5) déjà atteint pour le joueur " + name);
        }

        if (currentNumberOfFrames == 4) {
            this.frames.add(new FourLaunchFrame());
        } else {
            this.frames.add(new ThreeLaunchFrame());
        }

        LOGGER.info("Initialise la frame " + getCurrentFrame() + " pour le joueur " + name + ", toutes les quilles sont debout");
    }

    /**
     * donne le résultat du launch suivant pour ce joueur
     *
     * @param fallenPins donne le nombre de quilles abattues par ce launch
     */
    public void launch(int fallenPins) {
        LOGGER.info("Lancé de " + name + " ! Nombre de quilles abattues : " + fallenPins);
        getCurrentFrame().addLancer(new Lancer(fallenPins));
        LOGGER.info("Etat de la frame : " + getCurrentFrame());
    }

    @Override
    public String toString() {
        return "Joueur{" + "name='" + name + '\'' + ", frames=" + frames + '}';
    }
}
