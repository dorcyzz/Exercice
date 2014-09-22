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
        super();

        this.name = name;
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(this.frames);
    }

    public Frame getFrameCourante() {
        if (frames.isEmpty()) {
            throw new IllegalStateException("Aucune frame initialisée pour le joueur " + name + ", veillez initialiser une frame");
        }

        return frames.get(frames.size() - 1);
    }

    public void initializeNewFrame() {
        if (frames.size() == 5) {
            throw new IllegalStateException("Nombre de frames maximum (5) déjà atteint pour le joueur " + name);
        }

        if (frames.size() == 4) {
            this.frames.add(new Frame(true));
        } else {
            this.frames.add(new Frame(false));
        }

        LOGGER.info("Initialise la frame " + getFrameCourante() + " pour le joueur " + name + ", toutes les quilles sont debout");
    }

    /**
     * donne le résultat du lancer suivant pour ce joueur
     *
     * @param quillesAbattues donne le nombre de quilles abattues par ce lancer
     */
    public void lancer(int quillesAbattues) {
        LOGGER.info("Lancé de " + name + " ! Nombre de quilles abattues : " + quillesAbattues);
        getFrameCourante().addLancer(new Lancer(quillesAbattues));
        LOGGER.info("Etat de la frame : " + getFrameCourante());
    }

    @Override
    public String toString() {
        return "Joueur{" + "name='" + name + '\'' + ", frames=" + frames + '}';
    }
}
