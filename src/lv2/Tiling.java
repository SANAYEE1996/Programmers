package lv2;

public class Tiling {
	
	public long comb(long n, long r) {
		long up = 1;
		long down = 1;
		if(n-r <= r) {
			for(long i = n; i >= r+1; i--) {
				up = (up*i)%1000000007;
			}
			for(long i = n-r; i >= 1; i--) {
				down = (down*i)%1000000007;
			}
			return up/down;
		}
		else {
			for(long i = n; i >= n-r+1; i--) {
				up = (up*i)%1000000007;
			}
			for(long i = r; i >= 1; i--) {
				down = (down*i)%1000000007;
			}
			return up/down;
		}
	}
	
	public long firstStage(int cnt) {
		Tiling t = new Tiling();
		long value = 0;
		
		for(int i = cnt; i >= 0; i--) {
			value +=( ((long) Math.pow(2, i))%1000000007 * (t.comb((long) cnt, (long) i)) );
		}
		
		return value;
	}
	
	public long secondStage(int n, int cnt) {
		Tiling t = new Tiling();
		long value = 0;
		int fourMax = n/4;
		int one = 0;

		int twoMax = 0;
		if(n % 4 == 2) {
			twoMax = n/cnt+1;
		}
		else if(n % 4 == 0) {
			twoMax = n/cnt;
		}
		System.out.println(fourMax + "  " + twoMax);
		for(int i = 1; i <= fourMax; i++) {
			for(int j = twoMax; j >= 0; j --) {
				System.out.println("4's 밑 : " +i + " // 2's 밑 : " + j + " // 1's 밑 : " +one);
				value += ((long)(Math.pow(2, i)%1000000007 ) * 
						  (long)(Math.pow(2, j)%1000000007 ) * 
						  (long)(Math.pow(1, one)%1000000007 ) *
						  (long)(t.comb((long) cnt-1, (long) j)%1000000007) * 
						  (long)(t.comb((long) cnt-1, (long) one)%1000000007));
				one++;
			}
			one = 0;
			twoMax -= 2;
		}
		
		
		
		return value;
	}
	
	public int solution(int n) {
		int cnt = n/2;
		int answer = 0;
		if(n % 2 == 1) {
			return 0;
		}
		else if(n == 2) {
			return 3;
		}
		else {
			System.out.println("firstStage : " + firstStage(cnt));
			answer += firstStage(cnt);
			answer += secondStage(n, cnt);
			return answer;
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
