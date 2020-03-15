package ru.league.arrkaddiy.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.league.arrkaddiy.calc.Task3.CheckCorrectValue;
import ru.league.arrkaddiy.custom.anatation.After;
import ru.league.arrkaddiy.custom.anatation.Before;
import ru.league.arrkaddiy.custom.anatation.Test;
import ru.league.arrkaddiy.custom.asserts.CustomAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CorrectValueTest {

    private static final Logger log = LoggerFactory.getLogger(CorrectValueTest.class);

    private String solution;
    private CheckCorrectValue correctValue;

    @Before
    public void beforeTest() {
        solution = valueGenerator();
        correctValue = new CheckCorrectValue();
        log.debug("Before test: Solution - '{}'", solution);
    }

    @After
    public void afterTest() {
        solution = null;
        correctValue = null;
        log.debug("After test");
    }

    @Test
    public void testCorrectValue() {
        log.debug("Test CorrectValue");
        CustomAssert.assertNotNull(solution);
        CustomAssert.assertNotNull(correctValue);
        CustomAssert.assertTrue(correctValue.checkCorrectValue(solution));
    }

    @Test
    public void testIsLastElementAnCorrect() {
        log.debug("Test IsLastElementAnCorrect");
        CustomAssert.assertNotNull(solution);
        CustomAssert.assertNotNull(correctValue);
        CustomAssert.assertTrue(correctValue.isLastElementAnCorrect(solution.substring(solution.length()-1)));
    }

    private String valueGenerator() {
        List<String> solutions = new ArrayList<String>() {
            {
                add("2+4-3");
                add("-6+1");
                add("-4-2--2");
                add("10+100-10-0");
            }
        };
        return solutions.get(new Random().nextInt(solutions.size()));
    }
}
