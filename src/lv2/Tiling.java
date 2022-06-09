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
		long value = 0;
		
		for(int i = cnt; i >= 0; i--) {
			value +=( ((long) Math.pow(2, i))%1000000007 * (comb((long) cnt, (long) i)) );
		}
		
		return value;
	}
	
	
	
	public long secondStage(int n, int cnt) {
		long value = 0;
		int fourMax = n/4;

		int twoMax = n/2-2;
		
		System.out.println("조합 밑 지수 : "+cnt);
		for(int i = 1; i <= fourMax; i++) {
			System.out.println("4의 최대 개수 : "+fourMax+" // 2의 최대 개수 : " +twoMax);
			value += twoMaxMultiple(twoMax, i, cnt);
			twoMax -= 2;
		}
		System.out.println("두번째 단계 통과한 값 : " +value );
		return value;
	}
	
	public long twoMaxMultiple(int twoMax, int i, int cnt) {
		int one = 0;
		int value = 0;
		for(int j = twoMax; j >= 0; j --) {
			System.out.println("4's 밑 : " +i + " // 2's 밑 : " + j + " // 1's 밑 : " +one);
			System.out.println("4가 블록인 경우의 수 : "+(long)(Math.pow(2, i)%1000000007 ));
			System.out.println("2가 블록인 경우의 수 : "+(long)(Math.pow(2, j)%1000000007 ));
			System.out.println("1이 블록인 경우의 수 : "+(long)(Math.pow(1, one)%1000000007 ));
			System.out.println("2가 블록인 조합의 수 : "+(long)(comb((long) cnt-1, (long) j)%1000000007));
			System.out.println("1이 블록인 조합의 수 :"+(long)(comb((long) cnt-1, (long) one)%1000000007));
			value += ((long)(Math.pow(2, i)%1000000007 ) * 
					  (long)(Math.pow(2, j)%1000000007 ) * 
					  (long)(Math.pow(1, one)%1000000007 ) *
					  (long)(comb((long) cnt-1, (long) j)%1000000007) * 
					  (long)(comb((long) cnt-1, (long) one)%1000000007));
			one++;
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
			
			System.out.println("\nfirstStage : " + firstStage(cnt));
			answer += firstStage(cnt);
			answer += secondStage(n, cnt);
			return answer;
		}
    }


}
