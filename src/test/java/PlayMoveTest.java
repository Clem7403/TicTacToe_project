import org.example.Player;
import org.example.TicTacToe;
import org.example.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayMoveTest {
    @Test
    public void testPlayMove() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player = new Player("X");

        Point point = new Point(0, 0);

        assertTrue(ticTacToe.playMove(point,player));
        assertEquals(player, ticTacToe.getBoard()[0][0].getOwner());
        assertFalse(ticTacToe.playMove(point, player));
    }
}
