package ru.league.arrkaddiy.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.league.arrkaddiy.calc.Task3.ReplaceSolution;
import ru.league.arrkaddiy.custom.anatation.After;
import ru.league.arrkaddiy.custom.anatation.Before;
import ru.league.arrkaddiy.custom.anatation.Test;
import ru.league.arrkaddiy.custom.asserts.CustomAssert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ReplaceSolutionTest {

    private static final Logger log = LoggerFactory.getLogger(ReplaceSolutionTest.class);

    private String solution;
    private ReplaceSolution replaceSolution;

    private Map<String, String[]> mapValue = new HashMap<String, String[]>() {
        {
            put("100-2+3-2+4", new String[]{"100", "-", "2", "+", "3", "-", "2", "+", "4"});
            put("-6+1-2--1", new String[]{"-", "6", "+", "1", "-", "2", "-", "-", "1"});
            put("-4-2--2", new String[]{"-", "4", "-", "2", "-", "-", "2"});
            put("10+100-10-0", new String[]{"10", "+", "100", "-", "10", "-", "0"});
        }
    };

    @Before
    public void beforeTest() {
        solution = valueGenerator();
        replaceSolution = new ReplaceSolution();
        log.debug("Before test: Solution - '{}'", solution);
    }

    @Test
    public void testReplace() {
        log.debug("Test Replace");
        CustomAssert.assertNotNull(solution);
        CustomAssert.assertNotNull(replaceSolution);
        String[] replace = replaceSolution.replace(solution);
        String[] expected = mapValue.get(solution);
        for (int i = 0; i < expected.length - 1; i++) {
            CustomAssert.assertEquals(replace[i], expected[i]);
        }

    }

    @After
    public void afterTest() {
        solution = null;
        replaceSolution = null;
        log.debug("After test");
    }

    private String valueGenerator() {
        return (String) mapValue.keySet().toArray()[new Random().nextInt(mapValue.size() - 1)];
    }
}
