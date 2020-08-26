package com.gerardo.romannumerals.conversor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class RomanConversorToDecimal {

    private final String number;
    private final int value;
    private final Class exceptionClass;

    public RomanConversorToDecimal(String number, int value, Class exceptionClass) {
        this.number = number;
        this.value = value;
        this.exceptionClass = exceptionClass;
    }


    @Test
    public void execute() {
        try {
            assertThat(new RomanConversor().toDecimal(number)).isEqualTo(this.value);
            assertFalse(exceptionClass != null);
        }
        catch (Exception e) {
            assertTrue(exceptionClass != null);
        }
    }


    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {"-1", null, Exception.class},
                {"0", null, Exception.class},
                {"4000", null, Exception.class},
                {"5000", null, Exception.class},
                {"I", 1, null},
                {"II", 2, null},
                {"III",3, null},
                {"X", 10,  null},
                {"XI", 11, null},
                {"XX", 20, null},
                {"XXX", 30, null},
                {"C", 100, null},
                {"CX", 110, null},
                {"CXI", 111, null},
                {"CC", 200, null},
                {"CCC", 300, null},
                {"M", 1000, null},
                {"MC", 1100, null},
                {"MM", 2000, null},
                {"MMM", 3000, null},
                {"MMMDCLXXIII", 3673, null}
        };
    }
}
