package ysp_211127;

public class Solution3 {
	public int solution(int[][] board, int[][] durability) {
        int answer = -1;
        
        int i = 0, j = 0;
        int beforeI = 0;
        int beforeJ = -1;
        int xVector = 0;
        int yVector = 0;
        while (true) {
        	if(i >= board.length || j >= board[0].length || i < 0 || j < 0) {
				break;
			}
        	xVector = i - beforeI;
        	yVector = j - beforeJ;
        	if(board[i][j] == 0) {
        		if(xVector == 0) {
        			if(yVector > 0) {
        				j++;
        			}
        			else {
        				j--;
        			}
        		}
        		else{
        			if(xVector > 0) {
        				i++;
        			}
        			else {
        				i--;
        			}
        		}
        		answer++;
        	}
        	else if(board[i][j] == 1) {
        		if(durability[i][j] > 0) {
        			durability[i][j]--;
        			if(xVector < 0) {
        				j++;
            		}
            		else if(xVector == 0 && yVector < 0){
            			i++;
            		}
        			answer++;
        		}
        	}
			else if(board[i][j] == 2) {
				if(durability[i][j] > 0) {
					durability[i][j]--;
					if(yVector > 0) {
						i++;
	        		}
	        		else if(yVector == 0 && xVector < 0){
	        			j--;
	        		}
        			answer++;
        		}		
			}
			else if(board[i][j] == 3) {
				if(durability[i][j] > 0) {
					durability[i][j]--;
					if(xVector > 0) {
	        			j++;
	        		}
	        		else if(xVector == 0 && yVector < 0){
	        			i--;
	        		}
        			answer++;
        		}
			}
			else if (board[i][j] == 4) {
				if(durability[i][j] > 0) {
					durability[i][j]--;
					if(yVector > 0) {
	        			i--;
	        		}
	        		else if(yVector == 0 && xVector > 0){
	        			j--;
	        		}
        			answer++;
        		}
			}
			else if (board[i][j] == 5) {
				if(durability[i][j] > 0) {
					durability[i][j]--;
					if(xVector == 0 && yVector < 0) {
						
	        		}
					else if(xVector == 0 && yVector > 0) {
	        			
	        		}
					else if(yVector == 0 && xVector < 0) {
	
					}
					else if(yVector == 0 && xVector > 0) {
	        			
	        		}
        			answer++;
        		}
			}
        	
        	beforeI = i;
        	beforeJ = j;
		}
        
        
        return answer;
    }

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		
		int[][] board = {{0, 2, 0}, {1, 0, 5}, {3, 4, 0}};
		int[][] board2 = {{0, 2, 0}, {0, 5, 0}, {0, 0, 0}};
		int[][] board3 = {{0, 0, 2, 0}, {1, 0, 3, 2}, {0, 0, 0, 0}, {3, 0, 0, 4}};
		int[][] board4 = {{5, 5, 5}, {5, 5, 5}, {5, 5, 5}};
		
		int[][] durability = {{0, 2, 0}, {2, 0, 1}, {2, 1, 0}};
		int[][] durability2 = {{0, 2, 0}, {0, 1, 0}, {0, 0, 0}};
		int[][] durability3 = {{0, 0, 2, 0}, {5, 0, 2, 5}, {0, 0, 0, 0}, {5, 0, 0, 5}};
		int[][] durability4 = {{1, 1, 1}, {2, 3, 1}, {2, 1, 6}};
		
		System.out.println(s.solution(board, durability));
		System.out.println(s.solution(board2, durability2));
		System.out.println(s.solution(board3, durability3));
		System.out.println(s.solution(board4, durability4));

	}

}
