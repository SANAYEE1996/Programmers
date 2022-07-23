package ysp_220112;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution04 {
	
	public int getAnswer(int[] arr) {
		int sum = 0;
		int max = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(sum <= 0) {
				sum = 0;
				max = (arr[i] > max) ? arr[i] : max;
				continue;
			}
			max = (sum > max) ? sum : max;
		}
		
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] exam = input.split(" ");
		int[] arr = new int[exam.length];
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(exam[i]);
		Solution04 s = new Solution04();
		System.out.println(s.getAnswer(arr));
	}
}
