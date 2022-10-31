import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();

        Scanner input = new Scanner(System.in);

        //pick who wants to go first, 'x' or 'o' and plays first move. Automatic alternating of player: x and o
        System.out.println("\n"+game);
        System.out.print("Player 1! To start game, please pick lowercase x or o: ");
        String playerStr = input.next();
        char player = playerStr.charAt(0);

        //checks to make sure first players picks the appropriate symbol for play
        while (!game.isValidPlayer(player)) {
            System.out.print("HEY Player 1, PLEASE pick lowercase x or o this time: ");
            playerStr = input.next();
            player = playerStr.charAt(0);
        }

        //once picked appropriate symbol, continue to play first move
        game.setNextPlayer(player);
        System.out.print("Enter move row (0-2): ");
        int row = input.nextInt();
        System.out.print("Enter move column (0-2): ");
        int column = input.nextInt();

        try {
            game.playNextMove(player, row, column);
        } catch (TicTacToeException e) {
            System.out.println(e);
        }

        //While the game is not over, players alternate playing a move until a winner is declared.
        while (!game.isGameWon()) {
            System.out.println("\n"+game);
            System.out.print("Next player: "+ "'"+game.getNextPlayer()+"'"+"\nEnter move row(0-2): ");
            row = input.nextInt();
            System.out.print("Enter move column (0-2): ");
            column = input.nextInt();

            try {
                game.playNextMove(game.getNextPlayer(), row, column);
            } catch (TicTacToeException e) {
                System.out.println(e);
            }
        }

        //Game is over, display results
        System.out.println("\n"+game);
        if (game.getWinner() == 't') {
            System.out.println("\n"+"We have a tie! Both players are winners and losers!");
        }
        else {
            System.out.println("\n"+"Congratulations player " +game.getWinner()+ "! You win!");
        }
        System.out.print("Game is over");


    }


}