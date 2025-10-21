package org.example;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public void makeMove(TicTacToe ticTacToe) {
        int moveX;
        int moveY;

        while(true){
            ticTacToe.display();
            System.out.println("C'est au tour de " + getRepresentation());
            System.out.print("Entrer la ligne (1-3) : ");
            moveX = scanner.nextInt();
            System.out.print("Entrer la colonne (1-3) : ");
            moveY = scanner.nextInt();

            moveX -= 1;
            moveY -= 1;

            if(moveX < 0 || moveX >= ticTacToe.getSize() || moveY < 0 || moveY >= ticTacToe.getSize()){
                System.out.println("La ligne n'est pas valide !");
                continue;
            }
            if(ticTacToe.getBoard()[moveX][moveY].getOwner() != null){
                System.out.println("Erreur, la case est déjà occupée !");
                continue;
            }

            ticTacToe.getBoard()[moveX][moveY].setOwner(this);
            break;
        }
    }
}
