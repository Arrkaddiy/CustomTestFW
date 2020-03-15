package ru.league.arrkaddiy.custom.asserts;

public class CustomAssert {

    public static void assertTrue(Boolean var1) {
        if (!var1) throw new CustomAssertException("Exception, expected [true] but was [false]");
    }

    public static void assertEquals(Object var1, Object var2) {
        if (!var1.equals(var2)) throw new CustomAssertException("Exception, expected : '"
                + var1 + "' equals '" + var2 + "' - [true] but was [false]");
    }

    public static void assertNotNull(Object var1) {
        if (var1 == null) throw new CustomAssertException("Exception, expected Not Null");
    }
}
