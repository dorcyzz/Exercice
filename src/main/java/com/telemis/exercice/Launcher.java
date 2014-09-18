package com.telemis.exercice;

import java.util.Random;
import org.apache.log4j.Logger;
import com.telemis.exercice.game.Joueur;

/**
 * Created by sebastien.vandamme on 18/09/2014.
 */
public class Launcher {
	private static final Logger LOGGER = Logger.getLogger(Launcher.class);

	private static Random random = new Random();

	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("John");
		Joueur joueur2 = new Joueur("Bob");
		Joueur joueur3 = new Joueur("Dexter");

		for (int i = 1; i < 6; ++i) {
			LOGGER.info("FRAME " + i);

			joueur1.initialiseNouvelleFrame();
			for (int j = 0; j < 3; ++j) {
				joueur1.lancer(genererNombreQuillesAbattues(joueur1.getFrameCourante().getQuilleDebout()));
			}

			joueur2.initialiseNouvelleFrame();
			for (int j = 0; j < 3; ++j) {
				joueur2.lancer(genererNombreQuillesAbattues(joueur2.getFrameCourante().getQuilleDebout()));
			}

			joueur3.initialiseNouvelleFrame();
			for (int j = 0; j < 3; ++j) {
				joueur3.lancer(genererNombreQuillesAbattues(joueur3.getFrameCourante().getQuilleDebout()));
			}
		}
	}

	private static int genererNombreQuillesAbattues(int borneSuperieure) {
		return random.nextInt(borneSuperieure);
	}
}
