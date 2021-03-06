package com.gerardo.romannumerals.conversor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class RomanConversorToRoman {

    private final int number;
    private final String value;
    private final Class exceptionClass;

    public RomanConversorToRoman(int number, String value, Class exceptionClass) {
        this.number = number;
        this.value = value;
        this.exceptionClass = exceptionClass;
    }


    @Test
    public void execute() {
        try {
            assertThat(new RomanConversor().toRoman(number)).isEqualTo(this.value);
            assertFalse(exceptionClass != null);
        }
        catch (Exception e) {
            assertTrue(exceptionClass != null);
        }
    }


    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {-1, null, Exception.class},
                {0, null, Exception.class},
                {4000, null, Exception.class},
                {5000, null, Exception.class},
                {1, "I", null},
                {2, "II", null},
                {3, "III", null},
                {10, "X", null},
                {11, "XI", null},
                {20, "XX", null},
                {30, "XXX", null},
                {100, "C", null},
                {110, "CX", null},
                {111, "CXI", null},
                {200, "CC", null},
                {300, "CCC", null},
                {1000, "M", null},
                {1100, "MC", null},
                {2000, "MM", null},
                {3000, "MMM", null},
                {3673, "MMMDCLXXIII", null}
        };
    }
}
