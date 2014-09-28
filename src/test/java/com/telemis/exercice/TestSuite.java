package com.telemis.exercice;

import com.telemis.exercice.game.FiveLaunchFrameTest;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FiveLaunchFrameTest.ThreeLaunchFrameTest.class,
        FiveLaunchFrameTest.class,
        FiveLaunchFrameTest.PlayerTest.class,
        FiveLaunchFrameTest.LancerTest.class,
        ScoreCalculatorFactoryTest.class,
        IntegrationTestNormalScenario.class,
        IntegrationTestSpareScenario.class,
        IntegrationTestStrikeScenario.class
})
public class TestSuite {
}
