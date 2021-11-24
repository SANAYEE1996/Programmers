package ysp_211023;

public class Solution2 {
	
	public int solution(int[] sortedArray, int findValue) {
        int answer = 0;
        for(int i = 0; i < sortedArray.length; i++) {
        	if(sortedArray[i] == findValue) {
        		answer = i;
        		break;
        	}
        	else if(sortedArray[i] > findValue) {
        		answer = -1;
        		break;
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[] a = {1, 2, 5, 7, 10, 15, 18, 20};
		int[] b = {1, 2, 5, 7, 10, 15, 18, 20};
		int[] c = {1,2,3,4,5,6,7,8,9};
		System.out.println(s.solution(a, 15));
		System.out.println(s.solution(b, 17));
		System.out.println(s.solution(c, 2));

	}

}

/*
 * 9/2 = 4
 * c[4] = 5
 * 5 > 2
 * 4/2 = 2
 * c[2] = 3
 * 3 > 2
 * 3/2 = 1
 * c[1] = 2
 * 
 * */
