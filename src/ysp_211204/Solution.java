package ysp_211204;


public class Solution {
	
	public int solution(String[] drum) {
        int answer = 0;
        
        boolean meetShop = false;
        
        boolean[] flag = new boolean[drum[0].length()];
        String start = drum[0];
        char present = 0;
        int yPoint = 0;
        int xPoint = 0;
        for (int i = 0; i < start.length(); i++) {
			present = start.charAt(i);
			xPoint = i;
			meetShop = false;
			yPoint = 0;
			if(present == '#') {
				yPoint = 1;
				flag[i] = gogo(drum, yPoint, xPoint, meetShop);
			}
			else if(present == '>') {
				xPoint++;
				flag[i] = gogo(drum, yPoint, xPoint, meetShop);
			}
			else if(present == '<') {
				xPoint--;
				flag[i] = gogo(drum, yPoint, xPoint, meetShop);
			}
			else if(present == '*') {
				meetShop = true;
				yPoint = 1;
				flag[i] = gogo(drum, yPoint, xPoint, meetShop);
			}
		}
        
        for(boolean i : flag) {
        	if(i) answer++;
        }
        
        
        return answer;
    }
	
	
	public static boolean gogo(String[] drum, int yPoint, int xPoint, boolean meetShop) {
		boolean isArrived = false;
		if(yPoint < drum.length) {
			String start = drum[yPoint];
			char present = start.charAt(xPoint);
			int x = xPoint;
			int y = yPoint;
			if(present == '#') {
				y++;
				isArrived = gogo(drum, y, x, meetShop);
			}
			else if(present == '>') {
				x++;
				isArrived = gogo(drum, y, x, meetShop);
			}
			else if(present == '<') {
				x--;
				isArrived = gogo(drum, y, x, meetShop);
			}
			else if(present == '*' && !meetShop) {
				meetShop = true;
				y++;
				isArrived = gogo(drum, y, x, meetShop);
			}
			else if(present == '*' && meetShop) {
				isArrived = false;
			}
		}
		else {
			isArrived = true;
		}
		
		return isArrived;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		String[] drum = {	"######",
				">#*###",
				"####*#",
				"#<#>>#",
				">#*#*<",
				"######"};

		System.out.println("the answer is : " +s.solution(drum));
		
	}

}
