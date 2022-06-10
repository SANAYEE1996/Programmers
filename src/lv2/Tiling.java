package lv2;

public class Tiling {
	
	public int solution(int n) {
		if(n % 2 == 1) {
			return 0;
		}
		long[] arr= new long[2500];
		arr[0] = 3;
		arr[1] = 11;
		arr[2] = 41;
		for(int i = 3; i < 2500; i++) {
			arr[i] = ( ((arr[i-1]%1000000007)*4)%1000000007 - arr[i-2]%1000000007 + 1000000007)%1000000007;
			
		}
		return (int)arr[n/2-1]%1000000007;
    }


}
