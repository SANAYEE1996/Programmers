package LV3;

import java.util.Arrays;

public class Island_Connect {
	public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] map = new int[n][n];
        
        for(int[] i : costs) {
        	map[i[0]][i[1]] = i[2];
        	map[i[1]][i[0]] = i[2];
        }
        
        for(int[] i : map) {
        	System.out.println(Arrays.toString(i));
        }
        
        int value = 0;
        for(int i = 0; i < map.length; i++) {
        	for(int j = 0; j < map[i].length; j++) {
        		if(i == j) continue;
        		value = map[i][j];
        		
        		
        	}
        }
        
        System.out.println();
        
        for(int[] i : map) {
        	System.out.println(Arrays.toString(i));
        }
        
        return answer;
    }
	
	public static void gogo(int[] now, int[] depart, int n, int departIndex) {
		
		int min = 9999999;
		for(int i = 0; i < n; i++) {
			if(now[i] != 0 && depart[i] != 0) {
				if(depart[i] < min) {
					min = depart[i];
				}
			}
		}
		now[departIndex] = min;
	}
	
	

	public static void main(String[] args) {
		Island_Connect s = new Island_Connect();
		
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println("the answer is : " +s.solution(4, costs));
		

	}

}
