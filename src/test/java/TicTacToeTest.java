import org.example.TicTacToe;
import org.example.Cell;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    void testBoardInitialization(){
        //Instantiation de l'objet
        TicTacToe ticTacToe = new TicTacToe();

        //Récupération du tableau de cellule
        Cell[][] board = ticTacToe.getBoard();

        //Vérifier les dimensions du plateau
        assertEquals(3, ticTacToe.getSize(), "La taille doit être 3");
        assertEquals(3, board.length, "Il doit y avoir 3 lignes");
        assertEquals(3, board[0].length, "Il doit y avoir 3 colonnes");

        //vérification de l'initialisation des cellules
        for (Cell[] row : board) {
            for (Cell cell : row) {
                assertNotNull(cell, "Chaque Cell doit être initialisé");
                assertEquals("   ", cell.getRepresentation(), "Chaque Cell doit être initialement vide");
            }
        }
    }

}
