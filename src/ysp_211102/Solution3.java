package ysp_211102;

public class Solution3 {
	public int solution(int[] numbers, int target) {
        int sum = 0;
        int[] gogo = new int[1];
        plus(numbers, target, 0, sum, gogo);
        minus(numbers, target, 0, sum, gogo);
        return gogo[0];
    }
	
	public static void plus(int[] numbers, int target, int flag, int sum,int[] gogo) {
		sum += numbers[flag];
		if(flag == numbers.length-1 && sum == target) {
			gogo[0]++;
		}
		else if(flag < numbers.length-1){
			plus(numbers, target, flag+1, sum,gogo);
			minus(numbers, target, flag+1, sum,gogo);
		}
	}
	
	public static void minus(int[] numbers, int target, int flag, int sum,int[] gogo) {
		sum -= numbers[flag];
		if(flag == numbers.length-1 && sum == target) {
			gogo[0]++;
		}
		else if(flag < numbers.length-1){
			plus(numbers, target, flag+1, sum,gogo);
			minus(numbers, target, flag+1, sum,gogo);
		}
	}
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] a = {1,1,1,1,1};
		System.out.println(s.solution(a, 3));

	}

}
