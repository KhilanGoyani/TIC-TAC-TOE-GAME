import java.util.*;
class TicTacToe
{
	static char [][] board;
	TicTacToe()                                            
	{
		board =new char[3][3];
		initBoard();
	}
	void initBoard()                                   
	     // creating board
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j] = ' ';
			}
		}
	}
	static void dispBoard()                                
	 // printing board
	{
		System.out.println("-------------");
		for(int i=0;i<board.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	static void placeMark(int row,int col,char mark)       
	 // placing symbols
	{
		if((row>=0) && (row<=2) && (col>=0) && (col<=2))
		{
			board[row][col] = mark;
		}
		else
		{
			System.out.println("Invalid Position");
		}
	}
	static boolean checkColWin()                          
	 // check column win condition
	{
		for(int j=0;j<=2;j++)
		{
			if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
			{
				return true;
			}
		}
		return false;
	}
	static boolean checkRowWin()                        
	   // check row win condition
	{
		for(int i=0;i<=2;i++)
		{
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
			{
				return true;
			}
		}
		return false;
	}
	static boolean checkCrossWin()                   
	     // check cross win condition
	{
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] != ' ' && board[0][2]== board[1][1] && board[1][1] == board[2][0])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	static boolean checkDraw()
	{
		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				if(board[i][j] == ' ')
				{
					return false;
				}
			}
		}
		return true;
	}
}
class HumanPlayer                                          
// class making for play with players
{
	String name;
	char mark;
	HumanPlayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	void makeMove()                                        
	// creating move
	{
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		do
		{
			System.out.println("Enter the row and column");
			row = sc.nextInt();
			col = sc.nextInt();
		}while(!isvalidMove(row,col));
		
		TicTacToe.placeMark(row,col,mark);
	}
	boolean isvalidMove(int row,int col)                   
	 // check move is valid or not
	{
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
			if(TicTacToe.board[row][col] == ' ')
			{
				return true;
			}
		}
		return false;
	}
}
class LaunchGame
{
	public static void main(String[]args)
	{
		TicTacToe t = new TicTacToe();
		System.out.println("-------------------------");
		System.out.println("----- LET'S PLAY!!! -----");
		System.out.println("-------------------------");
		t.dispBoard();
		HumanPlayer p1 = new HumanPlayer("Player-1",'X');
		HumanPlayer p2 = new HumanPlayer("Player-2",'O');
		
		HumanPlayer cp;                               
		
		          //reference
		cp=p1;
		
		while(true)
		{
			System.out.println(cp.name + " turn");
			cp.makeMove();
			TicTacToe.dispBoard();
			if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkCrossWin())
			{
				System.out.println(cp.name + " has won");
				System.out.println("Game  Over!!");
				break;
			}
			else if(TicTacToe.checkDraw())
			{
				System.out.println("Game is Draw!!");
				break;
			}
			else
			{
				if(cp ==p1)
				{
					cp =p2;
				}
				else
				{
					cp=p1;
				}
			}
		}
	}
}
