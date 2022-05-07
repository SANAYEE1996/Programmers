package lv3;


public class Vaccum {
	public int solution(int[][] office, int r, int c, String[] move) {
        String direct = "north";
        int[] present = {r,c};
        int[] total = new int[1];
        total[0] = office[r][c];
        office[r][c] = 0;
        
        for(String s : move) {
        	if(s.equals("right")) {
        		direct = turnRight(direct);
        	}
        	else if(s.equals("left")) {
        		direct = turnLeft(direct);
        	}
        	else {
        		gogo(office, s, direct, present, total);
        	}
        	
        }
        
        
        return total[0];
    }
	
	public static String turnRight(String direct) {
		if(direct.equals("north")) {
			return "east";
		}
		else if(direct.equals("east")) {
			return "south";
		}
		else if(direct.equals("south")) {
			return "west";
		}
		else{
			return "north";
		}
	}
	
	public static String turnLeft(String direct) {
		if(direct.equals("north")) {
			return "west";
		}
		else if(direct.equals("west")) {
			return "south";
		}
		else if(direct.equals("south")) {
			return "east";
		}
		else{
			return "north";
		}
	}
	
	public static void gogo(int[][] office, String order, String direct, int[] present, int[] total) {
		if(direct.equals("west") && present[1] >= 1 && office[present[0]][present[1] - 1] != -1) {
			present[1]--;
			total[0] += office[present[0]][present[1]];
			office[present[0]][present[1]] = 0;
			
		}
		else if(direct.equals("east") && present[1] < office[0].length-1 && office[present[0]][present[1] + 1] != -1) {
			present[1]++;
			total[0] += office[present[0]][present[1]];
			office[present[0]][present[1]] = 0;
		}
		else if(direct.equals("north") && present[0] >= 1 && office[present[0]-1][present[1]] != -1) {
			present[0]--;
			total[0] += office[present[0]][present[1]];
			office[present[0]][present[1]] = 0;
		}
		else if(direct.equals("south") && present[0] < office.length-1 && office[present[0]+1][present[1]] != -1) {
			present[0]++;
			total[0] += office[present[0]][present[1]];
			office[present[0]][present[1]] = 0;
		}
	}
	
	

	public static void main(String[] args) {
		
		Vaccum s = new Vaccum();
		
		int[][] office = {{5,-1,4},{6,3,-1},{2,-1,1}};
		String[] move = {"go","go","right","go","right","go","left","go"};
		
		System.out.println("the answer is : " +s.solution(office, 1, 0, move));

	}

}
