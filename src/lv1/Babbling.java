package lv1;

public class Babbling {
	
	private final String[] init = {"aya", "ye", "woo", "ma"};
	
	public int solution(String[] babbling) {
        int answer = 0;
        for(String s : babbling) {
        	if(isBabbling(s,-1)) {
        		answer++;
        	}
        }
        return answer;
    }
	
	private boolean isBabbling(String s, int notIndex) {
		for(int i = 0; i < 4; i++) {
			if(i != notIndex && s.startsWith(init[i])) {
				s = s.substring(init[i].length());
				return isBabbling(s,i);
			}
		}
		return "".equals(s);
	}
	
	public static void main(String[] args) {
		Babbling s = new Babbling();
		System.out.println(s.solution(new String[] {"aya", "yee", "u", "maa"}));
		System.out.println(s.solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
	}
}
