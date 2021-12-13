package ysp_211213;


public class Solution2 {
	public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w*2+1;
        
        int firstValue = stations[0];
        if(firstValue-w-1 > 0) {
        	if((firstValue-w-1) % range != 0) {
            	answer += 1;
            }
            answer += (firstValue-w-1)/range;
        }
        int differ = 0;
        for (int i = 0; i < stations.length-1; i++) {
			differ = (stations[i+1] - w) - (stations[i]+w) -1;
			if(differ > 0) {
				if(differ % range != 0) {
					answer += 1;
				}
				answer += differ/range;
			}
		}
        
        int lastValue = stations[stations.length-1];
        if(lastValue + w < n) {
        	if((n - (lastValue + w)) % range != 0) {
            	answer += 1;
            }
            answer += (n - (lastValue + w)) / range;
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int n = 11;
		int[] stations = {4,11};
		int w = 1;
		
		int n2 = 16;
		int[] stations2 = {9};
		int w2 = 2;
		
		int n3 = 13;
		int[] stations3 = {3,11};
		int w3 = 1;
		
		int n4 = 37;
		int[] stations4 = {3,11,15,17,24,35};
		int w4 = 2;
		
		System.out.println("the answer is : " +s.solution(n, stations, w));
		System.out.println("the answer is : " +s.solution(n2, stations2, w2));
		System.out.println("the answer is : " +s.solution(n3, stations3, w3));
		System.out.println("the answer is : " +s.solution(n4, stations4, w4));
	}

}
