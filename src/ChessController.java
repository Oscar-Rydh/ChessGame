public class ChessController{
    private int[][] board;
    
    public ChessController(){
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
        for (int i = 0; i < 8; i++)
        {
            board[6][i] = -1;
        }
        board[7][0] = -5;
        board[7][1] = -3;
        board[7][2] = -2;
        board[7][3] = -Integer.MAX_VALUE;
        board[7][4] = -20;
        board[7][5] = -2;
        board[7][6] = -3;
        board[7][7] = -5;
    }
    
    
    public void makeMove(int oldX, int oldY, int newX, int newY){
        if((oldX > -1 && oldX < 8 && newX > -1 && newX < 8 && oldY > -1 && oldY < 8 && newY > -1 && newY < 8) && validMove(oldX,oldY,newX,newY)){
            board[newX][newY] = board[oldX][oldY];
            board[oldX][oldY] = 0;
        }
    }
    
    public boolean validMove(int oldRow, int oldColomn, int newRow, int newColomn){
        int piece = board[oldRow][oldColomn];
       
            if(piece == 1) 
                if((newRow > oldRow && newRow - oldRow < 3 && newColomn == oldColomn && board[newRow][newColomn] == 0) || 
                    (newRow > oldRow && newColomn > oldColomn && newColomn - oldColomn < 2 && board[newRow][newColomn] < 0))
                return true;
            
            if (piece == 5)
            	if(((newRow - oldRow) > 0 && (newColomn - oldColomn) == 0) ||  ((newRow - oldRow) < 0 && (newColomn - oldColomn) == 0) || 
                ((newColomn - oldColomn) < 0 && (newRow - oldRow) == 0) || ((newColomn - oldColomn) < 0 && (newRow - oldRow) == 0)
                && board[newRow][newColomn] <= 0)
             	return true;
            
            if(piece == 3)
                if((newRow - oldRow == 2 && newColomn - oldColomn == 1 && board[newRow][newColomn] <= 0) ||
                    (newRow - oldRow == 1 && newColomn - oldColomn == 2 && board[newRow][newColomn] <= 0) ||
                    (newRow - oldRow == 2 && newColomn - oldColomn == -1 && board[newRow][newColomn] <= 0) ||
                    (newRow - oldRow == 1 && newColomn - oldColomn == -2 && board[newRow][newColomn] <= 0) ||
                    (newRow - oldRow == -2 && newColomn - oldColomn == -1 && board[newRow][newColomn] <= 0) ||
                    (newRow - oldRow == -1 && newColomn - oldColomn == -2 && board[newRow][newColomn] <= 0) ||
                    (newRow - oldRow == -2 && newColomn - oldColomn == 1 && board[newRow][newColomn] <= 0) ||
                    (newRow - oldRow == -1 && newColomn - oldColomn == 2 && board[newRow][newColomn] <= 0))
                    return true;
            
            if(piece == 2)
                if((((newRow - oldRow) == (newColomn-oldColomn)) || ((oldRow - newRow) == (newColomn-oldColomn)) ||
                   ((newRow - oldRow) == (oldColomn-newColomn)) || ((oldRow - newRow) == (oldColomn-newColomn))) 
                   && board[newRow][newColomn] <= 0)
                    return true;
            
            if (piece == Integer.MAX_VALUE)
                if(((newRow - oldRow) < 2 || ((oldRow - newRow) < -2) ||
                   ((newColomn-oldColomn) < 2 || ((oldColomn-newColomn) < -2))) 
                   && board[newRow][newColomn] <= 0)
                   return true;
            
            if(piece == 20)
                if(((((newRow - oldRow) == (newColomn-oldColomn)) || ((oldRow - newRow) == (newColomn-oldColomn)) ||
                        ((newRow - oldRow) == (oldColomn-newColomn)) || ((oldRow - newRow) == (oldColomn-newColomn)) || 
                   ((newRow - oldRow) > 0 && (newColomn - oldColomn) == 0) ||  ((newRow - oldRow) < 0 && (newColomn - oldColomn) == 0) || 
                   ((newColomn - oldColomn) > 0 && (newRow - oldRow) == 0) || ((newColomn - oldColomn) < 0 && (newRow - oldRow) == 0))
                   && board[newRow][newColomn] <= 0))
                	return true;
        
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
