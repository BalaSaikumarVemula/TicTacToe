import java.util.Scanner;
class TicTacToe
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        char[][] board=new char[3][3];
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board.length;j++)
                board[i][j]=' ';
        char player='X';
        boolean gameOver=false;
        int moves=0;
        printBoard(board);
        while (!gameOver) {
            System.out.print("Player "+player+", enter row and column (0-2): ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            if (row<0 || row>2 || col<0 || col>2) 
            {
                System.out.println("Invalid input. Row and column must be between 0 and 2.");
                continue;
            }
            if(board[row][col]==' ') 
            {
                board[row][col]=player;
                moves++;
                printBoard(board);
                if(haveWon(board, player)) 
                {
                    System.out.println("Player "+player+" won!");
                    gameOver=true;
                } 
                else if(moves==9) 
                {
                    System.out.println("It's a draw!");
                    gameOver=true;
                } 
                else 
                {
                    player=(player=='X') ? 'O' : 'X';
                }
            } 
            else 
            {
                System.out.println("Position already taken. Try again.");
            }
        }
        sc.close();
    }
    public static void printBoard(char[][] board) 
    {
        for(int i=0;i<board.length;i++) 
        {
            for(int j=0; j<board.length;j++) 
            {
                System.out.print(board[i][j]);
                if (j<board.length-1)
                  System.out.print(" | ");
            }
            System.out.println();
            if (i<board.length-1)
              System.out.println("--+---+--");
        }
    }
    public static boolean haveWon(char[][] board, char player) 
    {
        for (int i=0;i<3;i++) 
        {
            if ((board[i][0]==player && board[i][1]==player && board[i][2]==player) || 
                (board[0][i]==player && board[1][i]==player && board[2][i]==player))
                return true;
        }
        if ((board[0][0]==player && board[1][1]==player && board[2][2]==player) || 
            (board[0][2]==player && board[1][1]==player && board[2][0] == player)) 
            return true;
        return false;
    }
}
