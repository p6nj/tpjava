package modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DL {
    private Date today, tomorrow;

    @Parameters(name = "P{index} | {0} | {1}")
    public static final Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new Date(1, 1, 2001), new Date(2, 1, 2001) }, { new Date(31, 1, 2001), new Date(1, 2, 2001) },
                { new Date(28, 2, 2001), new Date(1, 3, 2001) }, { new Date(28, 2, 2000), new Date(29, 2, 2000) },
                { new Date(29, 2, 2000), new Date(1, 3, 2000) }, { new Date(31, 12, 2001), new Date(1, 1, 2002) }
        });
    }

    public DL(Date today, Date tomorrow) {
        this.today = today;
        this.tomorrow = tomorrow;
    }

    @Test
    @After
    public void test() {
        assertEquals(tomorrow.toString(), today.dateDuLendemain().toString());
    }
}