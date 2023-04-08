package modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CT {
    private int day, month, year, result;
    private static final Date current = new Date(2, 2, 2002);

    @Parameters(name = "P{index} | 0{0}/0{1}/200{2} | 02/02/2002 | {3}")
    public static final Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 3, 3, 3, 1 }, { 1, 3, 3, 1 }, { 1, 1, 3, 1 }, { 1, 1, 1, -1 }, { 3, 1, 1, -1 }, { 3, 3, 1, -1 },
                { 2, 3, 3, 1 }, { 2, 1, 3, 1 }, { 2, 2, 3, 1 }, { 2, 2, 1, -1 }, { 2, 2, 2, 0 }, { 1, 2, 2, -1 },
                { 3, 2, 2, 1 }, { 1, 2, 3, 1 }, { 1, 2, 1, -1 }, { 3, 3, 2, 1 }, { 1, 3, 2, 1 }, { 1, 1, 2, -1 }
        });
    }

    public CT(int day, int month, int year, int result) {
        this.day = day;
        this.month = month;
        this.year = 2000 + year;
        this.result = result;
    }

    @Test
    public void test() {
        assertEquals(result, new Date(day, month, year).compareTo(current));
    }
}