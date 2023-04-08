package modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JM {
    private int month;
    private int year;
    private int ndays;

    @Parameters(name = "P{index} | {0}/{1} | {2}")
    public static final Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 2021, 31 }, { 3, 2021, 31 }, { 5, 2021, 31 }, { 7, 2021, 31 }, { 8, 2021, 31 }, { 10, 2021, 31 },
                { 12, 2021, 31 }, { 1, 2020, 31 }, { 3, 2020, 31 }, { 5, 2020, 31 }, { 7, 2020, 31 }, { 8, 2020, 31 },
                { 10, 2020, 31 }, { 12, 2020, 31 }, { 4, 2021, 30 }, { 6, 2021, 30 }, { 9, 2021, 30 }, { 11, 2021, 30 },
                { 4, 2020, 30 }, { 6, 2020, 30 }, { 9, 2020, 30 }, { 11, 2020, 30 }, { 2, 2021, 28 }, { 2, 2020, 29 }
        });
    }

    public JM(int month, int year, int ndays) {
        this.month = month;
        this.year = year;
        this.ndays = ndays;
    }

    @Test
    public void test() {
        assertEquals(ndays, new Date(1, month, year).nbJoursDansMois());
    }
}