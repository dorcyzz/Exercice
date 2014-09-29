package com.telemis.exercice;

import com.telemis.exercice.game.FiveLaunchesFrameTest;
import com.telemis.exercice.game.LaunchTest;
import com.telemis.exercice.game.PlayerTest;
import com.telemis.exercice.game.ThreeLaunchesFrameTest;
import com.telemis.exercice.score.calculator.ScoreCalculatorFactoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by sebastien.vandamme@gmail.com on 20/09/2014.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ThreeLaunchesFrameTest.class,
        FiveLaunchesFrameTest.class,
        PlayerTest.class,
        LaunchTest.class,
        ScoreCalculatorFactoryTest.class,
        IntegrationTestNormalScenario.class,
        IntegrationTestSpareScenario.class,
        IntegrationTestStrikeScenario.class
})
public class TestSuite {
}
