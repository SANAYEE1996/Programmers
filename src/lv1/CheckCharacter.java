package lv1;

import java.util.HashMap;

public class CheckCharacter {
	
	char[] characterArray = {'R','T','C','F','J','M','A','N'};
	
	public String solution(String[] survey, int[] choices) {
		HashMap<Character, Integer> characterMap = new HashMap<>();
		makeDefaultMap(characterMap);
		for(int i = 0; i < choices.length; i++) {
			putValueToCharacterMap(characterMap, survey[i], choices[i]);
		}
        String answer = "";
        return answer;
    }
	
	void makeDefaultMap(HashMap<Character, Integer> characterMap) {
		for(char a : characterArray) {
			characterMap.put(a, 0);
		}
	}
	
	void putValueToCharacterMap(HashMap<Character, Integer> characterMap, String survey, int value) {
		if(value < 4) {
			characterMap.put(survey.charAt(0), characterMap.get(survey.charAt(0)) + 1);
		}
		else if(4 < value) {
			characterMap.put(survey.charAt(1), characterMap.get(survey.charAt(1)) + 1);
		}
	}
}
