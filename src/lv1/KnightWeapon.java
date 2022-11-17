package lv1;

public class KnightWeapon {
	public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numberArray = new int[number];
        for(int i = 0; i < number; i++) {
        	for(int j = i+1; j <= number; j += (i+1)) {
        		numberArray[j-1]++;
        	}
        }
        for(int i : numberArray) {
        	if(i > limit) {
        		answer += power;
        		continue;
        	}
        	answer += i;
        }
        return answer;
    }
	
}
