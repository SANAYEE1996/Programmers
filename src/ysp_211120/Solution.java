package ysp_211120;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String solution(String character, String[] monsters) {
        String[] a = character.split(" ");
        int[] player = new int[3];
        for(int i = 0; i < player.length; i++) {
        	player[i] = Integer.parseInt(a[i]);
        }
        int playerHp = 0;
        int playerAtt = 0;
        int playerDef = 0;
        int monsterEx = 0;
        int monsterHp = 0;
        int monsterAtt = 0;
        int monsterDef = 0;
        int time = 0;
        double perEx = 0;
        boolean isNotClear = false;
        String[][] str = new String[monsters.length][3];
        for(int i = 0; i < monsters.length; i++) {
        	String[] b = monsters[i].split(" ");
        	playerHp = player[0];
        	playerAtt = player[1]; 
        	playerDef = player[2];
        	monsterEx = Integer.parseInt(b[1]);
        	monsterHp = Integer.parseInt(b[2]);
        	monsterAtt = Integer.parseInt(b[3]);
        	monsterDef = Integer.parseInt(b[4]);
        	time = 0;
        	while(true) {
        		playerHp = player[0];
        		if(playerAtt - monsterDef > 0) {
        			monsterHp -= (playerAtt - monsterDef);
        		}
        		else {
        			isNotClear = true;
        		}
        		time++;
        		if(monsterHp <= 0) {
        			break;
        		}
        		if(monsterAtt - playerDef > 0) {
        			playerHp -= (monsterAtt - playerDef);
        		}
        		if(playerHp <= 0) {
        			time = -1;
        			break;
        		}
        		else if(isNotClear && playerHp > 0) {
        			time = -1;
        			break;
        		}
        	}
        	if(time == -1) {
        		monsterEx = 0;
        		perEx = 0;
        	}
        	else {
        		perEx = (double)monsterEx/time;
        	}
        	str[i][0] = b[0];
        	str[i][1] = String.valueOf(perEx);
        	str[i][2] = String.valueOf(monsterEx);
        }
        
        Arrays.sort(str, new Comparator<String[]>() {
        	@Override
        	public int compare(String[] o1, String[] o2) {
        		double PerEx1 = Double.parseDouble(o1[1]);
        		double PerEx2 = Double.parseDouble(o2[1]);
        		int ex1 = Integer.parseInt(o1[2]);
        		int ex2 = Integer.parseInt(o2[2]);
        		if(PerEx1 == PerEx2) {
        			if(ex1 != ex2) {
        				return ex1 - ex2;
        			}
        			return ex2 - ex1;
        		}
        		else if (PerEx1 - PerEx2 > 0){
        			return -1;
        		}
        		else{
        			return 1;
        		}
        	}
        });
        
        return str[0][0];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] a = {"Knight 3 10 10 3","Wizard 5 10 15 1","Beginner 1 1 15 1"};
		
		System.out.println(s.solution("10 5 2", a));
		

	}

}
