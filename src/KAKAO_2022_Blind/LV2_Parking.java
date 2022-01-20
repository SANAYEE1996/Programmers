package KAKAO_2022_Blind;

import java.util.Arrays;
import java.util.HashMap;

public class LV2_Parking {
	public int[] solution(int[] fees, String[] records) {
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, Integer> cal = new HashMap<>();
		String[] exam = new String[3];
		int time = 0;
		for(String s : records) {
			exam = s.split(" ");
			if(!map.containsKey(exam[1])) {
				map.put(exam[1], exam[0]);
			}
			else {
				if(exam[2].equals("OUT")) {
					time = getMin(map.get(exam[1]), exam[0]);
					if(!cal.containsKey(exam[1]))  cal.put(exam[1], 0);
					cal.put(exam[1], cal.get(exam[1]) + time);
					map.put(exam[1], "");
				}
				else {
					map.put(exam[1], exam[0]);
				}
			}
		}
		
		for(String key : map.keySet()) {
			if(!map.get(key).equals("")) {
				time = getMin(map.get(key), "23:59");
				if(!cal.containsKey(key))  cal.put(key, 0);
				cal.put(key, cal.get(key) + time);
			}
		}
		
		time = 0;
		int money = 0;
		
		for(String key : cal.keySet()) {
			time = cal.get(key);
			money = getMoney(fees[0], fees[1], fees[2], fees[3], time);
			cal.put(key, money);
			System.out.println("차량 번호 : " +key + " 누적 시간 : " +time + " 누적 요금 : " +money);
		}
		
		Object[] keyArr = cal.keySet().toArray();
		Arrays.sort(keyArr);
		int[] answer = new int[keyArr.length];
		int i = 0;
		for(Object key : keyArr) {
			answer[i] = cal.get(key);
			i++;
		}
		
		
        return answer;
    }
	
	public static int getMoney(int orTime, int orMon, int uniTime, int uniMon, int time) {
		if(time <= orTime)
			return orMon;
		else {
			time -= orTime;
			int count = 0;
			if(time <= uniTime) {
				count = 1;
			}
			else{
				if(time % uniTime == 0) {
					count = time/uniTime;
				}
				else {
					count = time/uniTime + 1;
				}
			}
			return (count * uniMon) + orMon;
		}
	}
	
	public static int getMin(String in, String out) {
		int time = 0;
		int inHour = Integer.parseInt(in.substring(0,2));
		int outHour = Integer.parseInt(out.substring(0,2));
		int inMin = 60-Integer.parseInt(in.substring(3));
		int outMin = Integer.parseInt(out.substring(3));
		time = (outHour - inHour - 1)*60 + inMin + outMin;
		return time;
	}

	public static void main(String[] args) {
		
		LV2_Parking s = new LV2_Parking();
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", 
							"06:34 0000 OUT", "07:59 5961 OUT", 
							"07:59 0148 IN", "18:59 0000 IN", 
							"19:09 0148 OUT", "22:59 5961 IN", 
							"23:00 5961 OUT"};
		
		int[] fees2 = {120, 0, 60, 591};
		String[] records2 = {"16:00 3961 IN","16:00 0202 IN",
							"18:00 3961 OUT","18:00 0202 OUT",
							"23:58 3961 IN"};
		
		int[] fees3 = {1, 10, 1, 11};
		String[] records3 = {"00:00 1234 IN", "00:02 1234 OUT"};
		
		System.out.println("the answer is : " +Arrays.toString(s.solution(fees, records)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(fees2, records2)));
		System.out.println("the answer is : " +Arrays.toString(s.solution(fees3, records3)));

	}

}
