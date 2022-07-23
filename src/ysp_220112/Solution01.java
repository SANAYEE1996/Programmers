package ysp_220112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution01 {
	
	boolean isAlright(String value) {
		if(value.length() == 1) return true;
		int val = Integer.parseInt(value.substring(0, value.length()-1));
		if(val == 0 || Integer.parseInt(value) > 255) return false;
		return true;
	}
	
	public void gogo(ArrayList<String> list, int startIndex, String start, String input) {
		String nextWhole = input.substring(startIndex);
		for(int i = 1; i <=3; i++) {
			if(nextWhole.length() - i <= 6 && nextWhole.length() - i >= 2 && isAlright(nextWhole.substring(0, i))) {
				gogo02(list, i, nextWhole.substring(0, i), nextWhole, start +"."+ nextWhole.substring(0, i));
			}
		}
	}
	
	public void gogo02(ArrayList<String> list, int startIndex, String start, String input, String exam) {
		String nextWhole = input.substring(startIndex);
		for(int i = 1; i <=3; i++) {
			if(nextWhole.length() - i <= 3 && nextWhole.length() - i >= 1 && isAlright(nextWhole.substring(0, i))) {
				gogo03(list, i, nextWhole.substring(0, i), nextWhole, exam + "."+nextWhole.substring(0, i));
			}
		}
	}
	
	public void gogo03(ArrayList<String> list, int startIndex, String start, String input, String exam) {
		String nextWhole = input.substring(startIndex);
		if(isAlright(nextWhole)) {
			list.add(exam+ "."+ nextWhole);
		}
	}
	
	public String getString(String input) {
		ArrayList<String> list = new ArrayList<>();
		for(int i = 1; i <= 3; i++) {
			if(input.length() - i <= 9 && input.length() - i >= 3 && isAlright(input.substring(0, i))) {
				gogo(list, i, input.substring(0, i), input);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append(s);
			sb.append(",");
		}
		return sb.toString().substring(0,sb.toString().length()-1);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Solution01 s = new Solution01();
		if(input.length() > 12 || input.length() < 4) System.out.println("X");
		else System.out.println(s.getString(input));
	}
}
