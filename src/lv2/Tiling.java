package lv2;

public class Tiling {
	
	public long comb(long n, long r) {
		long up = 1;
		long down = 1;
		if(n-r <= r) {
			for(long i = n; i >= r+1; i--) {
				up *= i;
			}
			for(long i = n-r; i >= 1; i--) {
				down *= i;
			}
			return up/down;
		}
		else {
			for(long i = n; i >= n-r+1; i--) {
				up *= i;
			}
			for(long i = r; i >= 1; i--) {
				down *= i;
			}
			return up/down;
		}
	}
	
	public int solution(int n) {
		long answer = 0;
		long jaeGob = 0;
		long cnt = n/2;
		long under = cnt + 1;
		//System.out.println("시작 n : " +under + " 시작 r : " +(cnt-1));
        if(n%2 == 1){
            return 0;
        }
        else if(n == 2) {
        	return 1;
        }
        else{
        	jaeGob = (long) Math.pow(2, cnt);
        	
        	for(long i = cnt-1; i >= 1; i--) {
        		answer += comb(under,i);
        		under++;
        	}
        	//System.out.println("제곱 : " +jaeGob + " 조합들 : " +answer);
            return (int) (jaeGob + answer*2 + 1)%1000000007;
        }
    }
 
	public static void main(String[] args) {
		Tiling s = new Tiling();
		
		System.out.println("test case input 2 : " +s.solution(2) + "\n");
		System.out.println("test case input 4 : " +s.solution(4) + "\n");
		System.out.println("test case input 6 : " +s.solution(6) + "\n");
		System.out.println("test case input 8 : " +s.solution(8) + "\n");
		
		System.out.println(s.comb(6, 1));
		System.out.println(s.comb(6, 2));
		System.out.println(s.comb(6, 3));
		System.out.println(s.comb(6, 4));
		System.out.println(s.comb(6, 5));
		System.out.println(s.comb(6, 6));

	}

}
