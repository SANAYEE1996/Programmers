package ysp_211127;

import java.util.Arrays;

public class Solution2 {
	public int[][] solution(int r, int c) {
        int[][] map = new int[r][c];
        int[] number = new int[r*c];
        for (int i = 0; i < number.length; i++) {
			number[i] = i+1;
		}
        System.out.println(Arrays.toString(number));
        int max = number.length-1;
        left(map, 0, map[0].length-1, number, 0,max);
        for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
        
        return map;
    }
	
	public static void left(int[][] map, int x, int y, int[] number, int flag, int max) {
		if(flag < max) {
			for (int i = y; i >= 0; i--) {
				map[x][i] = number[flag];
				if(i > 0 && map[x][i-1] == 0) {
					flag++;
				}
				else{
					if(flag <= max) {
						if(map[x+1][i] == 0) {
							down(map, x, i, number, flag,max);
						}
						else if(map[x-1][i] == 0) {
							up(map, x, i, number, flag, max);
						}
					}
					break;
				}
			}
		}
	}
	
	public static void down(int[][] map, int x, int y, int[] number, int flag, int max) {
		if(flag < max) {
			for (int i = x; i <= map.length-1; i++) {
				map[i][y] = number[flag];
				if(i < map.length-1 && map[i+1][y] == 0) {
					flag++;
				}
				else {
					if(flag <= max) {
						right(map, i, y, number, flag,max);
					}
					break;
				}
			}
		}
	}
	
	public static void right(int[][] map, int x, int y, int[] number, int flag, int max) {
		if(flag < max) {
			for (int i = y; i <= map[0].length-1; i++) {
				map[x][i] = number[flag];
				if(i < map[0].length-1 && map[x][i+1] == 0) {
					flag++;
				}
				else {
					if(flag <= max) {
						if(map[x-1][i] == 0) {
							left(map, x-1, i, number, flag+1,max);
						}
						else if(map[x+1][i] == 0) {
							left(map, x+1, i, number, flag+1,max);
						}
					}
					break;
				}
			}
		}
	}
	
	public static void up(int[][] map, int x, int y, int[] number, int flag, int max) {
		if(flag < max) {
			for (int i = x; i >= 0; i--) {
				map[i][y] = number[flag];
				if(i > 0 && map[i-1][y] == 0) {
					flag++;
				}
				else {
					if(flag <= max) {
						right(map, i, y, number, flag,max);
					}
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		
		System.out.println(s.solution(5, 4));
		System.out.println(s.solution(3, 5));

	}

}
