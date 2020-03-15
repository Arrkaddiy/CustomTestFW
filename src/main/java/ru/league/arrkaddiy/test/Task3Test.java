package ru.league.arrkaddiy.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.league.arrkaddiy.calc.Task3.Task3;
import ru.league.arrkaddiy.custom.anatation.After;
import ru.league.arrkaddiy.custom.anatation.Before;
import ru.league.arrkaddiy.custom.anatation.Test;
import ru.league.arrkaddiy.custom.asserts.CustomAssert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task3Test {

    private static final Logger log = LoggerFactory.getLogger(Task3Test.class);

    private Task3 task3;
    private String solution;

    private Map<String, Integer> mapValue = new HashMap<String, Integer>() {
        {
            put("100-2+3-2+4", 103);
            put("10+100-10-0", 100);
            put("-4-2--2", -4);
            put("-6+1-2--1", -6);
        }
    };

    @Before
    public void beforeTest() {
        task3 = new Task3();
        solution = valueGenerator();
        log.debug("Before test: Solution - '{}'", solution);
    }

    @Test
    public void testTask3() {
        log.debug("Test task3");
        CustomAssert.assertNotNull(task3);
        CustomAssert.assertNotNull(solution);
        CustomAssert.assertEquals(task3.equationSolution(solution), mapValue.get(solution));
    }

    @After
    public void afterClass() {
        task3 = null;
        solution = null;
        log.debug("After test");
    }

    private String valueGenerator() {
        return (String) mapValue.keySet().toArray()[new Random().nextInt(mapValue.size() - 1)];
    }
}
