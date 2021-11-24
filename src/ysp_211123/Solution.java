package ysp_211123;

import java.util.Arrays;

public class Solution {
	
	public int solution(int N, int[][] road, int K) {
        int answer = 0;  
        int[][] map = new int[N][N];
        int[] city = new int[N];
        city[0] = 1;
        
        for(int i = 0; i < road.length; i++) {
        	if(map[road[i][1]-1][road[i][0]-1] == 0) {
        		map[road[i][1]-1][road[i][0]-1] = road[i][2];
        	}
        	else {
        		map[road[i][1]-1][road[i][0]-1] = Math.min(map[road[i][0]-1][road[i][1]-1], road[i][2]);
        	}
        	if(map[road[i][0]-1][road[i][1]-1] == 0) {
        		map[road[i][0]-1][road[i][1]-1] = road[i][2];
        	}
        	else {
        		map[road[i][0]-1][road[i][1]-1] = Math.min(map[road[i][0]-1][road[i][1]-1], road[i][2]);
        	}
        }
        
        for (int i = 0; i < map[0].length; i++) {
        	System.out.println(Arrays.toString(map[i]));
			if(0 < map[0][i] && map[0][i] <= K) {
				city[i] = 1;
				gogo(map, K, map[i], map[0][i], city);
			}
		}
        
        System.out.println(Arrays.toString(city));
        for (int i : city) {
			answer += i;
		}
        
        
        
        return answer;
    }
	
	public static void gogo(int[][] map, int K, int[] purpose, int time, int[] city) {
		for (int i = 0; i < purpose.length; i++) {
			if(0 < purpose[i] + time && purpose[i] + time <= K) {
				city[i] = 1;
				gogo(map, K, map[i], purpose[i] + time, city);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int[][] road3 = {{1,2,1},{1,3,1},{1,4,1},{1,5,1},{1,6,2}};
		System.out.println("the answer is : " +s.solution(5, road, 3));
		System.out.println("the answer is : " +s.solution(6, road2, 4));
		System.out.println("the answer is : " +s.solution(6, road3, 1));

	}

}
