package com.telemis.exercice.game;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by sebastien.vandamme on 18/09/2014.
 */
public class Joueur {

	private static final Logger LOGGER = Logger.getLogger(Joueur.class);

	private String nom;

	private final List<Frame> frames = new LinkedList<>();

	public Joueur(String nom) {
		super();

		this.nom = nom;
	}

	public List<Frame> getFrames() {
		return Collections.unmodifiableList(this.frames);
	}

	public Frame getFrameCourante() {
		if(frames.isEmpty() ){
			throw new IllegalStateException("Aucune frame initialisée pour le joueur " + nom + ", veillez initialiser une frame");
		}

		return frames.get(frames.size() - 1);
	}

	public void initialiseNouvelleFrame() {
		if (frames.size() == 5) {
			throw new IllegalStateException("Nombre de frames maximum (5) déjà atteint pour le joueur " + nom);
		}

		this.frames.add(new Frame());
		LOGGER.info("Initialise la frame " + getFrameCourante() + " pour le joueur " + nom + ", toutes les quilles sont debout");
	}

	/**
	 * donne le r�sultat du lancer suivant pour ce joueur
	 * 
	 * @param quillesAbattues donne le nombre de quilles abattues par ce lancer
	 */
	public void lancer(int quillesAbattues) {
		LOGGER.info("Lancé de " + nom + " ! Nombre de quilles abattues : " + quillesAbattues);
		getFrameCourante().addLancer(new Lancer(quillesAbattues));
		LOGGER.info("Etat de la frame : " + getFrameCourante());
	}

	@Override
	public String toString() {
		return "Joueur{" +
				"nom='" + nom + '\'' +
				", frames=" + frames +
				'}';
	}
}
