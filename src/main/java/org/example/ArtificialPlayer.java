package org.example;
import java.security.SecureRandom;

public class ArtificialPlayer extends Player {
    private SecureRandom random = new SecureRandom();

    public ArtificialPlayer(String representation) {
        super(representation);
    }

    @Override
    public void makeMove(TicTacToe ticTacToe, View view, InteractionUtilisateur UI) {
        int x, y;
        view.showMessage("L'IA (" + getRepresentation() + ") réfléchit...");

        while (true) {
            x = random.nextInt(ticTacToe.getSize());
            y = random.nextInt(ticTacToe.getSize());

            if (ticTacToe.getBoard()[x][y].getOwner() == null) {
                ticTacToe.getBoard()[x][y].setOwner(this);
                break;
            }
        }
    }
}
