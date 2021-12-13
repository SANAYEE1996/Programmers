package ysp_211213;


public class Solution {
	public int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[m][n];
        for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][0]-1][puddles[i][1]-1] = -1;
		}
        int a = 1;
        for(int i = 1; i < map[0].length; i++) {
        	if(map[0][i] == -1) a = -1;
        	map[0][i] = a;
        }
        a = 1;
        for (int i = 0; i < map.length; i++) {
        	if(map[i][0] == -1) a = -1;
        	map[i][0] = a;
		}
        long up = 0;
        long left = 0;
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(map[i][j] == -1) continue;
        		up = map[i-1][j];
        		left = map[i][j-1];
        		if(up == -1 && left == -1) {
        			map[i][j] = -1;
        		}
        		else if(up == -1 && left != -1) {
        			map[i][j] = left;
        		}
        		else if(up != -1 && left == -1) {
        			map[i][j] = up;
        		}
        		else {
        			map[i][j] = (left + up)%1000000007;
        		}
        	}
        }
        int answer = (int)map[m-1][n-1] %1000000007;
        if(answer == -1) return 0;
        return answer;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] puddles = {{2,2}};
		
		System.out.println("the answer is : " +s.solution(4, 3, puddles));

	}

}

/*
 * for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
 * 
 * **/
