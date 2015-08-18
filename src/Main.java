import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ChessGame game = new ChessGame();
		Scanner scan = new Scanner(System.in);
		game.printBoard();
		while(true)
		{
			game.putPiece(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
			game.printBoard();
		}
	}

}
