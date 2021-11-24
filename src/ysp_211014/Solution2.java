package ysp_211014;

public class Solution2 {
	
	public int solution(int[][] sizes) {
        int answer = 0;
        int[] a = new int[2];
        int temp = 0;
        int max0 = 0;
        int max1 = 0;
        for(int i = 0; i < sizes.length; i++) {
        	a = sizes[i];
        	if(a[0] < a[1]) {
        		temp = a[0];
        		a[0] = a[1];
        		a[1] = temp;
        	}
        	if(max0 < a[0]) {
        		max0 = a[0];
        	}
        	if(max1 < a[1]) {
        		max1 = a[1];
        	}
        }
        answer = max0*max1;
        return answer;
    }

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.solution(null));
	}

}
