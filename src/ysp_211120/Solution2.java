package ysp_211120;

public class Solution2 {
	public int solution(int time, int gold, int[][] upgrade) {
        int answer = -1;
        for(int i = 0; i < upgrade.length; i++) {
        	gogo(time, gold, upgrade, i);
        }
        
        
        return answer;
    }
	
	public static void gogo(int time, int gold, int[][] upgrade, int flag) {
		int perTime = upgrade[0][1];
		
		if(upgrade[flag][0] == 0) {
			gold  = gold*(time/perTime);
		}
		else {
			
		}
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[][] a = {{0, 5}, {1500, 3}, {3000, 1}};
		int[][] b = {{0, 5}, {1500, 3}, {1501, 1}};
		int[][] c = {{0, 5}, {100, 4}, {200, 3}};
		
		System.out.println(s.solution(100, 200, a));
		System.out.println(s.solution(49, 200, b));
		System.out.println(s.solution(11, 1000, c));

	}

}
