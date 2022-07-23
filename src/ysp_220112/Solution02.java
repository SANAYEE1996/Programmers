package ysp_220112;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution02 {
	
	public String getAnswer(String wholeText, String searchText, int differCount) {
		int length = searchText.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= differCount; i++) {
			if(wholeText.substring(i, i+length).equals(searchText)) {
				sb.append(i+1);
				sb.append(",");
			}
		}
		if(sb.toString().equals("") || sb.toString() == null) return "X";
		return sb.toString().substring(0,sb.toString().length()-1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String wholeText = br.readLine();
		String searchText = br.readLine();
		int differCount = wholeText.length() - searchText.length();
		Solution02 s = new Solution02();
		if(differCount < 0) System.out.println("X");
		else System.out.println(s.getAnswer(wholeText, searchText, differCount));
	}

}
