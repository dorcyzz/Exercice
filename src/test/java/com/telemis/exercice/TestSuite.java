package com.telemis.exercice;

import com.telemis.exercice.score.ScoreManagerTest;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by sebastien.vandamme@gmail.com on 18/09/2014.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ThreeLaunchFrameTest.class,
        FourLaunchFrameTest.class,
        PlayerTest.class,
        LancerTest.class,
        ScoreManagerTest.class,
        ScoreCalculatorFactoryTest.class
})
public class TestSuite {
}
