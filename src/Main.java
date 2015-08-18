import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ChessController game = new ChessController();
		Scanner scan = new Scanner(System.in);
		game.printBoard();
		while(true)
		{
			game.makeMove(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
			game.printBoard();
		}
	}

}
