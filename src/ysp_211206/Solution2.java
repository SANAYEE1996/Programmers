package ysp_211206;


public class Solution2 {
	
	
	public int solution(int n) {
        int[] count = new int[1];
        if(n > 1) {
        	for (int i = 0; i < n; i++) {
    			int[][] map = new int[n][n];
    			fill(map, 0, i,n);
    			for (int j = 0; j < n; j++) {
    				if(map[1][j] == 0) {
    					int[][] copy = new int[n][n];
    					copy(map,copy);
    					fill(copy, 1, j,n);
    					gogo(copy, 2, n,count);
    				}
    			}
    		}
        }
        else {
        	return 1;
        }
        return count[0];
    }
	
	public static void copy(int[][] map, int[][] copy) {
		for(int i = 0; i < map.length; i++) {
			copy[i] = map[i].clone();
		}
	}
	
	public static void gogo(int[][] map, int x,int n,int[] count) {
		if(x < n-1) {
			for (int j = 0; j < n; j++) {
				if(map[x][j] == 0) {
					int[][] copy = new int[n][n];
					copy(map,copy);
					fill(copy, x, j,n);
					gogo(copy, x+1, n,count);
				}
			}
		}
		else {
			for (int j = 0; j < n; j++) {
				if(map[x][j] == 0) {
					count[0]++;
				}
			}
		}
	}
	
	public static void fill(int[][] map, int x, int y,int n) {
		for(int i = 0; i < n; i++) {
			map[x][i] = 1;
		}
		for(int i = 0; i < n; i++) {
			map[i][y] = 1;
		}
		int j = y;
		for(int i = x; i < n; i++, j++) {
			if(j < n) {
				map[i][j] = 1;
			}
			else {
				break;
			}
		}
		j = y;
		for(int i = x; i >= 0; i--, j--) {
			if(j >= 0) {
				map[i][j] = 1;
			}
			else {
				break;
			}
		}
		j = y;
		for(int i = x; i < n; i++, j--) {
			if(j >= 0) {
				map[i][j] = 1;
			}
			else {
				break;
			}
		}
		j = y;
		for(int i = x; i >= 0; i--, j++) {
			if(j < n) {
				map[i][j] = 1;
			}
			else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println("the answer is : " +s.solution(1));
		System.out.println("the answer is : " +s.solution(2));
		System.out.println("the answer is : " +s.solution(3));
		System.out.println("the answer is : " +s.solution(4));
		System.out.println("the answer is : " +s.solution(5));
		System.out.println("the answer is : " +s.solution(6));
		System.out.println("the answer is : " +s.solution(7));
		System.out.println("the answer is : " +s.solution(8));
		System.out.println("the answer is : " +s.solution(9));
		System.out.println("the answer is : " +s.solution(10));
		System.out.println("the answer is : " +s.solution(11));
		System.out.println("the answer is : " +s.solution(12));
	}

}
