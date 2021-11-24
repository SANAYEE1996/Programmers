package ysp_211014;

public class Solution {
	public int solution(int n) {
        int answer = 0;
        if(isSoSu(n-1)) {
        	return n-1;
        }
        else {
        	for(int i = 1; i < n; i++) {
        		if(n%i == 1) {
        			answer = i;
        			break;
        		}
        	}
        }
        return answer;
    }
	
	public boolean isSoSu(int n) {
		boolean sosu = true;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				sosu = false;
			}
		}
		return sosu;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(10));
		System.out.println(s.solution(12));

	}

}
