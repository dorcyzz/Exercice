package com.telemis.exercice;

import com.telemis.exercice.score.ScoreManagerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FrameTest.class,
        PlayerTest.class,
        LancerTest.class,
        ScoreManagerTest.class
})
public class TestSuite {
}
