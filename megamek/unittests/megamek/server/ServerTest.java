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
    public void TestForceVictoryPlayer() {
        server.forceVictory(mounir);
        TestCase.assertEquals(server.getGame().getVictoryPlayerId(), 1);
    }

}
