import java.util.ArrayList;

public class ChessGame {
	private int[][] board;
	
	public ChessGame()
	{
		board = new int[8][8];
		board[0][0] = 5;
		board[0][1] = 3;
		board[0][2] = 2;
		board[0][3] = Integer.MAX_VALUE;
		board[0][4] = 20;
		board[0][5] = 2;
		board[0][6] = 3;
		board[0][7] = 5;
		for (int i = 0; i < 8; i++)
		{
			board[1][i] = 1;
		}
		for (int i = 2; i < 6; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				board[i][j] = 0;
			}
		}
		
		board[7][0] = -5;
		board[7][1] = -3;
		board[7][2] = -2;
		board[7][3] = -Integer.MAX_VALUE;
		board[7][4] = -20;
		board[7][5] = -2;
		board[7][6] = -3;
		board[7][7] = -5;
		for (int i = 0; i < 8; i++)
		{
			board[6][i] = -1;
		}
	}
	public void putPiece(int oldX, int oldY, int newX, int newY)
	{
		if(validMove(oldX, oldY, newX, newY))
		{
		board[newX][newY] = board[oldX][oldY];
		board[oldX][oldY] = 0;
		}
	}
	
	public boolean validMove(int oldX, int oldY, int newX, int newY)
	{
		// new position out of Board
		if (newX < 0 || newX > 7 || newY < 0 || newY > 7)
			return false;
		
		
		int piece = board[oldX][oldY];
		switch (piece)
		{
		case 1: 
			return (newX - oldX > 0 && ((newX - oldX < 3 && board[newX][newY] == 0) || (newX-oldX < 2 && board[newX][newY] != 0)));
		}
		return false;
	}
	
	public void printBoard()
	{
		String[][] strBoard = new String[8][8];
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				int current = board[i][j];
				switch(current) 
				{
				case 1: strBoard[i][j] = "W PW";
				break;
				case 2: strBoard[i][j] = "W RU";
				break;
				case 3: strBoard[i][j] = "W KN";
				break;
				case 5: strBoard[i][j] = "W TW";
				break;
				case 20: strBoard[i][j] = "W QU";
				break;
				case Integer.MAX_VALUE: strBoard[i][j] = "W KI";
				break;
				case -1: strBoard[i][j] = "B PW";
				break;
				case -2: strBoard[i][j] = "B RU";
				break;
				case -3: strBoard[i][j] = "B KN";
				break;
				case -5: strBoard[i][j] = "B TW";
				break;
				case -20: strBoard[i][j] = "B QU";
				break;
				case -Integer.MAX_VALUE: strBoard[i][j] = "B KI";
				break;
				case 0: strBoard[i][j] = "-";
				break;
				}
			}
		}
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				System.out.print(strBoard[i][j] + '\t');
			}
			System.out.println();
		}
	}
}
