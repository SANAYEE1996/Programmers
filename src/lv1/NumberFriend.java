package lv1;

public class NumberFriend {
	public String solution(String X, String Y) {
        String answer = "";
        int[] xArray = new int[10];
        int[] yArray = new int[10];
        for(int i = 0; i < X.length(); i++) {
        	xArray[X.charAt(i) - 48]++;
        }
        for(int i = 0; i < Y.length(); i++) {
        	yArray[Y.charAt(i) - 48]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
        	sb.append(attachAllNumber(i, Math.min(xArray[i], yArray[i])));
        }
        
        answer = sb.toString();
        return "".equals(answer) ? "-1" : isAllZero(answer) ? "0" : answer;
    }
	
	private String attachAllNumber(int n, int count) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++) {
			sb.append(n);
		}
		return sb.toString();
	}
	
	private boolean isAllZero(String s) {
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) != '0') {
				return false;
			}
		}
		return true;
	}
	
}
