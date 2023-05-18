package megamek.common;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;

@RunWith(JUnit4.class)
public class PlayerTest {
    @Test
    public void TestSetElo() {
        Player mounir = new Player(0, "Mounir");
        TestCase.assertEquals(mounir.getElo(), 1500.0);
        mounir.setElo(2000.0);
        TestCase.assertEquals(mounir.getElo(), 2000.0);
    }

    @Test
    public void TestAddElo() {
        Player mounir = new Player(0, "Mounir");
        TestCase.assertEquals(mounir.getElo(), 1500.0);
        mounir.addElo(100.0);
        TestCase.assertEquals(mounir.getElo(), 1600.0);
    }
}
