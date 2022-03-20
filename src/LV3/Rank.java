package LV3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rank {

	public static void gogo(int[][] map, int length) {
		int[] exam = new int[map[0].length];
		int[] target = new int[map[0].length];
		for(int i = 0; i < length; i++) {
			exam = map[i];
			for (int j = 0; j < length; j++) {
				for(int k = 0; k < length; k++) {
					if(exam[k] == -1) {
						target = map[k];
						change(exam,target, -1);
					}
					else if(exam[k] == 1) {
						target = map[k];
						change(exam,target, 1);
					}
				}
			}
		}
	}
	
	public static void change(int[] exam ,int[] target, int flag) {
		if(flag == 1) {
			for (int i = 0; i < target.length; i++) {
				if(target[i] == 1) {
					exam[i] = 1;
				}
			}
		}
		else {
			for (int i = 0; i < target.length; i++) {
				if(target[i] == -1) {
					exam[i] = -1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st;
		int count = Integer.parseInt(input.split(" ")[1]);
		int r = Integer.parseInt(input.split(" ")[0]);
		int[][] problem = new int[count][2];
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			problem[i][0] = Integer.parseInt(st.nextToken());
			problem[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] map = new int[r][r];
		int chan = 0;
		int def = 0;
		for(int i = 0; i < problem.length; i++) {
			chan = problem[i][0];
			def = problem[i][1];
			map[chan-1][def-1] = 1;
			map[def-1][chan-1] = -1;
		}
		gogo(map,r);
		int answer = 0;
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			cnt = 0;
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0) {
					cnt++;
				}
			}
			if(cnt == 1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
