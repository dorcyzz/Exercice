package com.telemis.exercice;

import org.junit.Test;
import com.telemis.exercice.game.Lancer;
import static org.junit.Assert.assertEquals;

public class LancerTest {

	@Test(expected = IllegalStateException.class)
	public void testCreateLancerNegative() throws Exception {
		new Lancer(-1);
	}

	@Test
	public void testCreateLancerZero() throws Exception {
		Lancer lancer = new Lancer(0);
		assertEquals(0, lancer.getQuilleAbattue());
	}

	@Test
	public void testCreateLancer() throws Exception {
		Lancer lancer = new Lancer(8);
		assertEquals(8, lancer.getQuilleAbattue());
	}
}
