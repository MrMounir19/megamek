package megamek.common;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class GameTest {

    Game game = new Game();
    Player mounir = new Player(1, "Mounir");
    Player rinoum =  new Player(2, "Rinoum");

    @Before
    public void setup() {
        game.addPlayer(1, mounir);
        game.addPlayer(2, rinoum);
    }

    @Test
    public void testGetVictoryPlayerId() {
        TestCase.assertEquals(game.getVictoryPlayerId(), IPlayer.PLAYER_NONE);
        game.setVictoryPlayerId(1);
        TestCase.assertEquals(game.getVictoryPlayerId(), 1);
    }

    @Test
    public void testGetVictoryTeamId() {
        TestCase.assertEquals(game.getVictoryTeam(), IPlayer.TEAM_NONE);
        game.setVictoryTeam(2);
        TestCase.assertEquals(game.getVictoryTeam(), 2);
    }

    @Test
    public void testIsPlayerVictor() {
        game.setVictoryPlayerId(1);
        TestCase.assertTrue(game.isPlayerVictor(mounir));
        TestCase.assertFalse(game.isPlayerVictor(rinoum));
    }


}