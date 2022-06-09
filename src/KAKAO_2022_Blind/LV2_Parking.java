package KAKAO_2022_Blind;

import java.util.Arrays;
import java.util.HashMap;

public class LV2_Parking {
	public void putOutRecordToCal(HashMap<String, Integer> cal, String carNumber) {
		if(!cal.containsKey(carNumber))  
			cal.put(carNumber, 0);
	}
	
	public void putCal(	String[] exam, 
						HashMap<String, String> map,
						HashMap<String, Integer> cal) {
		if(exam[2].equals("OUT")) {
			putOutRecordToCal(cal, exam[1]);
			cal.put(exam[1], cal.get(exam[1]) + getMin(map.get(exam[1]), exam[0]));
			map.put(exam[1], "");
		}
		else {
			map.put(exam[1], exam[0]);
		}
	}
	
	public void putMap(	String[] exam, 
							HashMap<String, String> map,
							HashMap<String, Integer> cal) {
		
		if(!map.containsKey(exam[1])) {
			map.put(exam[1], exam[0]);
		}
		else {
			putCal(exam, map, cal);
		}
		
	}
	
	public void putRecords( String[] records, 
							HashMap<String, String> map,
							HashMap<String, Integer> cal) {
		String[] exam = new String[3];
		for(String s : records) {
			exam = s.split(" ");
			putMap(exam, map, cal);
		}
	}
	
	public void putMinTime(	HashMap<String, String> map,
							HashMap<String, Integer> cal,
							String key) {
		
		if(!map.get(key).equals("") && cal.containsKey(key)) {
			cal.put(key, cal.get(key) + getMin(map.get(key), "23:59"));
		}
		else if(!map.get(key).equals("") && !cal.containsKey(key)) {
			cal.put(key, getMin(map.get(key), "23:59"));
		}
	}
	
	public void putSumTime(	HashMap<String, String> map,
							HashMap<String, Integer> cal) {
		for(String key : map.keySet()) {
			putMinTime(map, cal, key);
		}
	}
	
	public void putMoney(HashMap<String, Integer> cal, int[] fees) {
		for(String key : cal.keySet()) {
			cal.put(key, getMoney(fees[0], fees[1], fees[2], fees[3], cal.get(key)));
		}
	}
	
	public int[] copyKeyToArray(Object[] keyArr, int[] answer, 
								HashMap<String, Integer> cal) {
		int i = 0;
		for(Object key : keyArr) {
			answer[i] = cal.get(key);
			i++;
		}
		return answer;
	}
	
	public int[] getKeyArray(HashMap<String, Integer> cal) {
		Object[] keyArr = cal.keySet().toArray();
		Arrays.sort(keyArr);
		return copyKeyToArray(keyArr, new int[keyArr.length], cal);
	}
	
	public int[] solution(int[] fees, String[] records) {
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, Integer> cal = new HashMap<>();
		putRecords(records,map,cal);
		putSumTime(map, cal);
		putMoney(cal, fees);
		
        return getKeyArray(cal);
    }
	
	public int getMoney(int orTime, int orMon, int uniTime, int uniMon, int time) {
		if(time <= orTime)
			return orMon;
		time -= orTime;
		if(time <= uniTime) {
			return uniMon + orMon;
		}
		if(time % uniTime == 0) {
			return ((time/uniTime) * uniMon) + orMon;
		}
		return ((time/uniTime + 1) * uniMon) + orMon;
	}
	
	public int getMin(String in, String out) {
		int inHour = Integer.parseInt(in.substring(0,2));
		int outHour = Integer.parseInt(out.substring(0,2));
		int inMin = 60-Integer.parseInt(in.substring(3));
		int outMin = Integer.parseInt(out.substring(3));
		return (outHour - inHour - 1)*60 + inMin + outMin;
	}

}
