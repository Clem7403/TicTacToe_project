import org.example.games.model.materiel.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CellTest {

    @Test
    void testGetRepresentation() {
        Cell cell = new Cell();
        assertEquals("   ", cell.getRepresentation(), "La cellule doit retourner trois espaces");
    }
}
