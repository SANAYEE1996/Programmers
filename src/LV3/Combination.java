package LV3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Combination {
	
public static long make(int n) {
		
		int cnt = 0;
		
		int[] pand = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191};
		
		
		int flag = 1;
		for(int i = 0; i < pand.length-1; i++) {
			if(pand[i] <= n && n < pand[i+1]) {
				cnt = i+1;
				flag = n - pand[i];
				break;
			}
		}
		
		int[] arr = {4,13};
		int[] numbers = new int[cnt];
		ArrayList<BigInteger> all = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		comRep(0, 2, cnt, arr, numbers, all, sb);
		
		
		Collections.sort(all);
		
		
		
		return all.get(flag).longValue();
		
	}
	
	public static void comRep(int cnt, int n, int r, int[] arr, 
						int[] numbers, ArrayList<BigInteger> all, StringBuilder sb) {
		if(cnt == r) {
			sb.setLength(0);
			for(int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]);
			}
			
			all.add(new BigInteger(sb.toString()));
			return;
		}
		
		for(int i=0; i < n; i++) {
			numbers[cnt] = arr[i];
			comRep(cnt+1, n, r, arr, numbers, all, sb);
		}
	}
	
	public long solution(int n) {
        
        return make(n);
    }
	
	public static void main(String[] args) {
		Combination s = new Combination();
		
		System.out.println("the answer is : " +s.solution(1));
		System.out.println("the answer is : " +s.solution(2));
		System.out.println("the answer is : " +s.solution(3));
		System.out.println("the answer is : " +s.solution(4));
		System.out.println("the answer is : " +s.solution(5));
		System.out.println("the answer is : " +s.solution(6));
		System.out.println("the answer is : " +s.solution(5000));
	}

}
