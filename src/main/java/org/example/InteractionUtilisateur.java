package org.example;
import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner = new Scanner(System.in);

    public Point getMove(View view, TicTacToe ticTacToe, Player player) {
        int x, y;

        while(true){
            view.displayBoard(ticTacToe);
            view.showMessage("C'est au tour de " + player.getRepresentation());
            view.showMessage("Entrer la ligne (1-3) : ");
            x = scanner.nextInt() - 1;
            view.showMessage("Entrer la colonne (1-3) : ");
            y = scanner.nextInt() - 1;

            if(x < 0 || x >= ticTacToe.getSize() || y < 0 || y >= ticTacToe.getSize()){
                view.showMessage("Coordonnées en dehors du plateau !");
                continue;
            }
            if(ticTacToe.getBoard()[x][y].getOwner() != null){
                view.showMessage("Case déjà occupée ! !");
                continue;
            }
            return new Point(x, y);
        }
    }
    public int getMenuChoice(View view){
        System.out.println("TicTacToe le jeu des vrais héros !");
        System.out.println("Choisissez le mode de jeu :");
        System.out.println("1. Humain vs Humain");
        System.out.println("2. Humain vs IA");
        System.out.println("3. IA vs IA");
        System.out.print("Votre choix : ");
        return scanner.nextInt();
    }
}
