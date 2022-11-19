package lv1;

public class Cola {
	public int solution(int a, int b, int n) {
        int answer = 0;
        while(n/a != 0) {
        	answer += (n/a)*b;
        	n = n%a + (n/a)*b;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Cola s = new Cola();
		System.out.println(s.solution(2, 1, 20));
		System.out.println(s.solution(3, 1, 20));
	}
}
