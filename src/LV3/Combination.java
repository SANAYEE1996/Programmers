package LV3;

import java.util.ArrayList;
import java.util.Collections;

public class Combination {
public static long make(int n) {
		
		int cnt = 0;
		
		int[] pand = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191};
		
		
		int flag = 0;
		for(int i = 0; i < pand.length-1; i++) {
			if(pand[i] <= n && n <= pand[i+1]) {
				cnt = i+1;
				flag = n - pand[i];
				break;
			}
		}
		
		int[] arr = {4,13};
		int[] numbers = new int[cnt];
		ArrayList<String> all = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		comRep(0, 2, cnt, arr, numbers, all, sb);
		
		Collections.sort(all);
		
		
		return Long.parseLong(all.get(flag));
		
	}
	
	public static void comRep(int cnt, int n, int r, int[] arr, 
						int[] numbers, ArrayList<String> all, StringBuilder sb) {
		if(cnt == r) {
			sb.setLength(0);
			for(int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]);
			}
			all.add(sb.toString());
			return;
		}
		
		for(int i=0;i<n;i++) {
			numbers[cnt] = arr[i];
			comRep(cnt+1, n, r, arr, numbers, all, sb);
		}
	}

}
