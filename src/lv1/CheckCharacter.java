package lv1;

import java.util.HashMap;

public class CheckCharacter {
	
	char[] characterArray = {'R','T','C','F','J','M','A','N'};
	int[] notAgreeScore = {3,2,1};
	int[] veryAgreeScore = {1,2,3};
	
	public String solution(String[] survey, int[] choices) {
		HashMap<Character, Integer> characterMap = new HashMap<>();
		makeDefaultMap(characterMap);
		for(int i = 0; i < choices.length; i++) {
			putValueToCharacterMap(characterMap, survey[i], choices[i]);
		}
		StringBuilder sb = new StringBuilder();
		getResultCharacter(characterMap, sb);
        return sb.toString();
    }
	
	void makeDefaultMap(HashMap<Character, Integer> characterMap) {
		for(char a : characterArray) {
			characterMap.put(a, 0);
		}
	}
	
	void putValueToCharacterMap(HashMap<Character, Integer> characterMap, String survey, int value) {
		if(value < 4) {
			characterMap.put(survey.charAt(0), characterMap.get(survey.charAt(0)) + notAgreeScore[value-1]);
		}
		else if(4 < value) {
			characterMap.put(survey.charAt(1), characterMap.get(survey.charAt(1)) + veryAgreeScore[value-5]);
		}
	}
	
	void getResultCharacter(HashMap<Character, Integer> characterMap, StringBuilder sb) {
		sb.append((characterMap.get('R') >= characterMap.get('T'))? "R" : "T");
		sb.append((characterMap.get('C') >= characterMap.get('F'))? "C" : "F");
		sb.append((characterMap.get('J') >= characterMap.get('M'))? "J" : "M");
		sb.append((characterMap.get('A') >= characterMap.get('N'))? "A" : "N");
	}
	
	void print(HashMap<Character, Integer> characterMap) {
		for(Character key : characterMap.keySet()) {
			System.out.println("key : " +key+ " value : " +characterMap.get(key));
		}
	}
}
