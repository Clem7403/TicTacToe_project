import org.example.Player;
import org.example.Point;
import org.example.TicTacToe;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GetMoveFromPlayerTest {
    @Test
    public void testGetMoveFromPlayer(){
        String input = "";
        Scanner scanner = new Scanner(input);
        TicTacToe ticTacToe = new TicTacToe();
        Player player = new Player("X");
        Point point = ticTacToe.getMoveFromPlayer(player);

        assertEquals(0, point.getX());
        assertEquals(0, point.getY());

    }
}
