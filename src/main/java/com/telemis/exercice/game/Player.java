package com.telemis.exercice.game;

import com.telemis.exercice.game.frame.FiveLaunchesFrame;
import com.telemis.exercice.game.frame.Frame;
import com.telemis.exercice.game.frame.ThreeLaunchesFrame;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 * <p/>
 * Classe représentant un joueur.
 */
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

    /**
     * Renvoie la frame courante, c'est-à-dire la frame dans laquelle le joueur est en train de jouer.
     *
     * @return la frame courante
     */
    public Frame getCurrentFrame() {
        if (frames.isEmpty()) {
            throw new IllegalStateException("Aucune frame initialisée pour le joueur " + name + ", veillez initialiser une frame");
        }

        return frames.get(frames.size() - 1);
    }

    /**
     * Initialise une nouvelle frame pour le joueur. Le nombre de frame existante ne peut dépasser 5. Dans le cas ou la frame initialisée est une des 4
     * premières frames, la frame créée sera une frame permettant un maximum de 3 lancers. Dans le cas ou la frame initialisée est la cinquième frame, la frame
     * créée sera une frame permattant un maximum de 5 lancers.
     */
    public void initializeNewFrame() {
        int currentNumberOfFrames = frames.size();

        if (currentNumberOfFrames == 5) {
            throw new IllegalStateException("Nombre de frames maximum (5) déjà atteint pour le joueur " + name);
        }

        if (currentNumberOfFrames == 4) {
            this.frames.add(new FiveLaunchesFrame());
        } else {
            this.frames.add(new ThreeLaunchesFrame());
        }

        LOGGER.info(StringUtils.EMPTY);
        LOGGER.info("Initialise la frame " + getCurrentFrame() + " pour le joueur " + name + ", toutes les quilles sont debout");
    }

    /**
     * Donne le résultat du lancé suivant pour ce joueur.
     *
     * @param fallenPins donne le nombre de quilles abattues par ce launch
     */
    public void launch(int fallenPins) {
        LOGGER.info("Lancé de " + name + " ! Nombre de quilles abattues : " + fallenPins);
        getCurrentFrame().addLaunch(new Launch(fallenPins));
        LOGGER.info("Etat de la frame : " + getCurrentFrame());
    }

    @Override
    /**
     * @see Object#toString()
     */
    public String toString() {
        return "Joueur{" + "name='" + name + '\'' + ", frames=" + frames + '}';
    }
}
