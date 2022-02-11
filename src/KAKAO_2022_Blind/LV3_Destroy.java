package KAKAO_2022_Blind;


public class LV3_Destroy {
	public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int type = 0;
        int degree = 0;
        
        
        
        int[][] map = new int[board.length][board[0].length];
        
        for (int i = 0; i < skill.length; i++) {
			type = skill[i][0];
			degree = skill[i][5];
			if(type == 1) {
				attack(map, skill[i][1], skill[i][2], skill[i][3], skill[i][4], degree);
			}
			else {
				heal(map, skill[i][1], skill[i][2], skill[i][3], skill[i][4], degree);
			}
		}
        
        int before = 0;
        
        
        
        for(int i = 0; i < map.length; i++) {
        	before = 0;
        	for(int j = 0; j < map[i].length; j++) {
        		if(i == 0) {
        			
        			map[i][j] += before;
        			before = map[i][j];
        			if(map[i][j] + board[i][j] > 0) answer++;
        		}
        		else {
        			
        			map[i][j] += before;
        			before = map[i][j];
        			map[i][j] += map[i-1][j];
        			if(map[i][j] + board[i][j] > 0) answer++;
        		}
        	}
        }
       
        
        
        return answer;
    }
	
	public static void attack(int[][] map, int r1, int c1, int r2, int c2, int degree) {
		map[r1][c1] -= degree;
		if(c2 < map[0].length-1) {
			map[r1][c2+1] += degree;
		}
		if(r2 < map.length-1) {
			map[r2+1][c1] += degree;
		}
		if(c2 < map[0].length-1 && r2 < map.length-1) {
			map[r2+1][c2+1] -= degree;
		}
	}
	
	public static void heal(int[][] map, int r1, int c1, int r2, int c2, int degree) {
		map[r1][c1] += degree;
		if(c2 < map[0].length-1) {
			map[r1][c2+1] -= degree;
		}
		if(r2 < map.length-1) {
			map[r2+1][c1] -= degree;
		}
		if(c2 < map[0].length-1 && r2 < map.length-1) {
			map[r2+1][c2+1] += degree;
		}
	}

	public static void main(String[] args) {

		LV3_Destroy s = new LV3_Destroy();
		
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		
		int[][] board2 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] skill2 = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		
		System.out.println("the answer is : " +s.solution(board, skill));
		System.out.println("the answer is : " +s.solution(board2, skill2));
		
		int[] a = {1,1};
		int[] b = {1,1};
		System.out.println(a.equals(b));

	}

}
