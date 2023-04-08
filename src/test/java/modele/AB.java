package modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AB {
    private int year;
    private boolean isLeap;

    @Parameters(name = "P{index} | {0} | {1}")
    public static final Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2016, true }, { 2020, true }, { 2024, true }, { 2028, true }, { 2017, false }, { 2018, false },
                { 2019, false }, { 2023, false }
        });
    }

    public AB(int year, boolean isLeap) {
        this.year = year;
        this.isLeap = isLeap;
    }

    @Test
    public void test() {
        assertEquals(isLeap, new Date(year).anneeEstBissextile());
    }
}