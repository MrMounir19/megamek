package megamek.server;

import junit.framework.TestCase;
import megamek.common.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

@RunWith(JUnit4.class)
public class ServerTest {

    Server server;
    Game game = new Game();
    Player mounir = new Player(1, "Mounir");
    Player rinoum =  new Player(2, "Rinoum");


    @Before
    public void setup() throws IOException {
        server = new Server("123", 12, false, "");
        game.addPlayer(1, mounir);
        game.addPlayer(2, rinoum);
        server.setGame(game);
    }
    
    @Test
    public void testForceVictoryPlayer() {
        server.forceVictory(mounir);
        TestCase.assertEquals(server.getGame().getVictoryPlayerId(), 1);
    }

    @Test
    public void testEloUpdate() {
        mounir.setTeam(1);
        rinoum.setTeam(2);
        TestCase.assertEquals(1500.0, mounir.getElo());
        TestCase.assertEquals(1500.0, rinoum.getElo());
        server.getGame().setVictoryPlayerId(1);
        server.getGame().setVictoryTeam(1);
        server.getGame().setForceVictory(true);

        server.updateElos();
        TestCase.assertEquals(1510.0, mounir.getElo());
        TestCase.assertEquals(1490.0, rinoum.getElo());
    }

}
