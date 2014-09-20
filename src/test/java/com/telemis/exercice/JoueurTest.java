package com.telemis.exercice;

import com.telemis.exercice.game.Frame;
import com.telemis.exercice.game.Joueur;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
public class JoueurTest {

	private Joueur joueur;

	@Before
	public void setup() {
		this.joueur = new Joueur("Joueur test");
	}

	@Test(expected = IllegalStateException.class)
	public void testGetFrameCouranteWithoutInitialisation() throws Exception {
		this.joueur.getFrameCourante();
	}

	@Test
	public void testGetFrameCourante() throws Exception {
		this.joueur.initialiseNouvelleFrame();
		Frame frame1 = this.joueur.getFrameCourante();
		assertNotNull(frame1);
		this.joueur.initialiseNouvelleFrame();
		Frame frame2 = this.joueur.getFrameCourante();
		assertNotNull(frame2);

		assertNotEquals(frame1, frame2);
		assertNotSame(frame1, frame2);
	}

	@Test
	public void testInitialiseNouvelleFrameFiveTimes() throws Exception {
		for (int i = 0; i < 5; ++i) {
			this.joueur.initialiseNouvelleFrame();
		}
	}

	@Test(expected = IllegalStateException.class)
	public void testInitialiseNouvelleFrameMoreThanFiveTimes() throws Exception {
		for (int i = 0; i < 6; ++i) {
			this.joueur.initialiseNouvelleFrame();
		}
	}

	@Test
	public void testInitialiseNouvelleFrame() throws Exception {
		assertEquals(0, this.joueur.getFrames().size());
		this.joueur.initialiseNouvelleFrame();
		assertEquals(1, this.joueur.getFrames().size());
		this.joueur.initialiseNouvelleFrame();
		assertEquals(2, this.joueur.getFrames().size());
		this.joueur.initialiseNouvelleFrame();
		assertEquals(3, this.joueur.getFrames().size());
		this.joueur.initialiseNouvelleFrame();
		assertEquals(4, this.joueur.getFrames().size());
		this.joueur.initialiseNouvelleFrame();
		assertEquals(5, this.joueur.getFrames().size());
	}

	@Test(expected = IllegalStateException.class)
	public void testLancerWithoutInitialisation() throws Exception {
		this.joueur.lancer(5);
	}

	@Test(expected = IllegalStateException.class)
	public void testMoreThanThreeLancer() throws Exception {
		this.joueur.initialiseNouvelleFrame();
		this.joueur.lancer(5);
		this.joueur.lancer(0);
		this.joueur.lancer(8);
		this.joueur.lancer(3);
	}

	@Test
	public void testLancer() throws Exception {
		this.joueur.initialiseNouvelleFrame();
		assertEquals(15, this.joueur.getFrameCourante().getQuilleDebout());
		this.joueur.lancer(5);
		assertEquals(10, this.joueur.getFrameCourante().getQuilleDebout());
		this.joueur.lancer(0);
		assertEquals(10, this.joueur.getFrameCourante().getQuilleDebout());
		this.joueur.lancer(8);
		assertEquals(2, this.joueur.getFrameCourante().getQuilleDebout());

		this.joueur.initialiseNouvelleFrame();
		assertEquals(15, this.joueur.getFrameCourante().getQuilleDebout());
		this.joueur.lancer(5);
		assertEquals(10, this.joueur.getFrameCourante().getQuilleDebout());
		this.joueur.lancer(10);
		assertEquals(0, this.joueur.getFrameCourante().getQuilleDebout());
		this.joueur.lancer(8);
		assertEquals(0, this.joueur.getFrameCourante().getQuilleDebout());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testGetFramesIsNotModifiableAdd() {
		List<Frame> frames = this.joueur.getFrames();
        frames.add(new Frame(false));
    }

	@Test(expected = UnsupportedOperationException.class)
	public void testGetFramesIsNotModifiableSet() {
		List<Frame> frames = this.joueur.getFrames();
        frames.set(1, new Frame(false));
    }

	@Test(expected = UnsupportedOperationException.class)
	public void testGetFramesIsNotModifiableClear() {
		List<Frame> frames = this.joueur.getFrames();
		frames.clear();
	}
}
