package ysp_211126;


public class Solution {
	public int solution(int [][]board)    {
        int max = 0;
        if(board.length > 1 && board[0].length > 1) {
	        for (int i = 1; i < board.length; i++) {
				for (int j = 1; j < board[i].length; j++) {
					if(board[i][j] == 1) {
						board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]),board[i-1][j-1])+1;
					}
					max = Math.max(max, board[i][j]);
				}
			}
        }
        else {
        	for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if(board[i][j] == 1) {
						max = 1;
						break;
					}
				}
			}
        }
        
        return max*max;
    }
	 
	public static void makeMax(int [][]board, int i, int j) {
		if(board[i][j] != 0 && board[i+1][j] != 0 && board[i][j+1] != 0 && board[i+1][j+1] != 0) {
			if( board[i][j] == board[i+1][j] && board[i+1][j] == board[i][j+1]) {
				board[i+1][j+1] = board[i][j] + 1;
			}
			else {
				board[i+1][j+1] = Math.max(board[i+1][j], board[i][j+1]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int[][] board1 = {{0,0,1,1},{1,1,1,1}};
		int[][] board2 = {	{0,1,1,1,1,1,0,0,0,1,1},
							{1,1,1,1,1,0,0,0,1,1,1},
							{0,0,1,1,0,0,1,1,1,1,0},
							{0,0,1,1,1,1,1,1,0,0,0},
							{1,1,1,1,1,1,1,1,1,1,1},
							{0,0,1,1,1,1,1,0,1,1,1},
							{1,1,1,1,1,1,1,0,0,1,1},
							{1,0,1,1,1,1,1,0,1,1,1},
							{1,0,1,1,1,1,1,0,1,1,1}
						};
		int[][] board3 = {	{1,1,1,1,1},
							{1,1,1,1,1},
							{1,1,1,1,1},
							{1,1,1,1,1},
							{1,1,1,1,1},};
		int[][] board4 = {	{1,1,1,1,0,0},
							{1,1,1,1,0,0},
							{1,0,1,1,0,0},
							{1,1,1,1,0,1},
							{1,1,1,0,0,1},
							{1,1,1,1,1,1}};
		int[][] board5 = {	{1,1,1,1,1},
							{1,1,1,1,1},
							{1,1,1,1,1},
							{1,1,1,1,1},
							{1,1,1,1,1},
							{1,1,1,1,1}};
		
		int[][] board6 = {	{1,1,1},
							{1,0,1},
							{1,1,1}};
		
		int[][] board7 = {	{0,1,0,1},
							{1,0,1,0}};
		
		int[][] board8 = {{1,1,1,1},
						  {0,1,1,1},
						  {0,1,1,1},};	
		int[][] board9 = {{1},
						  {0}};	
		
		int[][] board10 = {{0,1,1,1,1,1,0},
							{0,0,1,1,1,0,0},{0,1,1,1,1,1,0}
							};
		
		int[][] board11 = {{0,0}};
		
		Solution s = new Solution();
		System.out.println("the answer is "+s.solution(board));
		System.out.println("the answer is "+s.solution(board1));
		System.out.println("the answer is "+s.solution(board2));
		System.out.println("the answer is "+s.solution(board3));
		System.out.println("the answer is "+s.solution(board4));
		System.out.println("the answer is "+s.solution(board5));
		System.out.println("the answer is "+s.solution(board6));
		System.out.println("the answer is "+s.solution(board7));
		System.out.println("the answer is "+s.solution(board8));
		System.out.println("the answer is "+s.solution(board9));
		System.out.println("the answer is "+s.solution(board10));
		System.out.println("the answer is "+s.solution(board11));
	}

}
