package lv2;

public class Tiling {
	
	public int n2(int n) {
        int answer = 0;
        int sum = 0;
		int a = 0;
        int b = 1;
		
		
		if (n == 1) {
            answer = 1;
        }
		else if(n == 2) {
			answer = 2;
		}
        else {
            for (int i = 2; i <= n; i++) {
                sum = (a + b)%1000000007;
                a = b;
                b = sum;
            }
            answer = (a + b)%1000000007;
        }
        return answer;
    }
	
	public int solution(int n) {
		int answer = 0;
        if(n%2 == 1){
            return 0;
        }
        else{
            return answer;
        }
    }
 
	public static void main(String[] args) {
		Tiling s = new Tiling();
		
		System.out.println("test case input 1 : " +s.solution(1));
		System.out.println("test case input 2 : " +s.solution(2));
		System.out.println("test case input 3 : " +s.solution(3));
		System.out.println("test case input 4 : " +s.solution(4));

	}

}
