package megamek.server.victory;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Before;
import org.junit.Test;

@RunWith(JUnit4.class)
public class VictoryResultTest {
    VictoryResult victoryResult = new VictoryResult(false);
    @Before
    public void setup() {
        victoryResult.addPlayerScore(0, 0.0);
        victoryResult.addPlayerScore(1, 5.0);
        victoryResult.addPlayerScore(2, 10.0);

        victoryResult.addTeamScore(3, 10.0);
        victoryResult.addTeamScore(4, 5.0);
        victoryResult.addTeamScore(5, 0.0);
    }
    @Test
    public void testGetWinningPlayer() {
        TestCase.assertEquals(victoryResult.getWinningPlayer(), 2);
    }

    @Test
    public void testGetWinningTeam() {
        TestCase.assertEquals(victoryResult.getWinningTeam(), 3);
    }

    @Test
    public void testAddPlayerScore() {
        TestCase.assertEquals(victoryResult.playerScore.get(0), 0.0);
        TestCase.assertEquals(victoryResult.playerScore.get(1), 5.0);
        TestCase.assertEquals(victoryResult.playerScore.get(2), 10.0);
    }

    @Test
    public void testAddTeamScore() {
        TestCase.assertEquals(victoryResult.teamScore.get(3), 10.0);
        TestCase.assertEquals(victoryResult.teamScore.get(4), 5.0);
        TestCase.assertEquals(victoryResult.teamScore.get(5), 0.0);
    }

    @Test
    public void testIsWinningPlayer() {
        TestCase.assertTrue(victoryResult.isWinningPlayer(2));
    }

    @Test
    public void testIsWinningTeam() {
        TestCase.assertTrue(victoryResult.isWinningTeam(3));
    }

    @Test
    public void testGetPlayerScore() {
        TestCase.assertEquals(victoryResult.getPlayerScore(0), 0.0);
        TestCase.assertEquals(victoryResult.getPlayerScore(1), 5.0);
        TestCase.assertEquals(victoryResult.getPlayerScore(2), 10.0);
        TestCase.assertEquals(victoryResult.getPlayerScore(100), 0.0);
    }

    @Test
    public void testGetTeamScore() {
        TestCase.assertEquals(victoryResult.getTeamScore(3), 10.0);
        TestCase.assertEquals(victoryResult.getTeamScore(4), 5.0);
        TestCase.assertEquals(victoryResult.getTeamScore(5), 0.0);
        TestCase.assertEquals(victoryResult.getTeamScore(100), 0.0);
    }

    @Test
    public void testIsDraw() {
        VictoryResult drawResult = new VictoryResult(false);
        drawResult.addPlayerScore(0, 5.0);
        drawResult.addPlayerScore(1, 10.0);
        drawResult.addPlayerScore(2, 10.0);
        TestCase.assertTrue(drawResult.isDraw());
        TestCase.assertFalse(victoryResult.isDraw());
    }
}
