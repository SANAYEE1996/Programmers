package LV3;

public class Solution {
	public int solution(int n) {
        
        return (int) Math.sqrt(n);
    }
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println("the answer is : " +s.solution(2));
		System.out.println("the answer is : " +s.solution(5));
			
	} 

}
