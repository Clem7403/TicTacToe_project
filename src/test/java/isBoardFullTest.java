import org.example.Player;
import org.example.TicTacToe;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class isBoardFullTest {
    @Test
    public void testIsBoardFull() {
        TicTacToe ticTacToe = new TicTacToe();
        Player player = new Player("X");

        assertFalse(ticTacToe.isBoardFull());

        for(int i =0; i<ticTacToe.getSize();i++){
            for(int j =0; j<ticTacToe.getSize();j++){
                ticTacToe.getBoard()[i][j].setOwner(player);
            }
        }
        assertTrue(ticTacToe.isBoardFull());
    }
}
