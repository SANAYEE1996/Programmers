package LV3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ShuttleBus {
	public static String addTime(String startTime, int t) {
		int hour = Integer.parseInt(startTime.substring(0, 2));
		int min = Integer.parseInt(startTime.substring(3));
		min += t;
		if(min >= 60) {
			min -= 60;
			hour += 1;
		}
		
		StringBuilder sb = new StringBuilder();
		if(hour < 10) { 
			sb.append(0);
			sb.append(hour);
			sb.append(":");
			if(min < 10) {
				sb.append(0);
				sb.append(min);
			}
			else {
				sb.append(min);
			}
		}
		else {
			sb.append(hour);
			sb.append(":");
			if(min < 10) {
				sb.append(0);
				sb.append(min);
			}
			else {
				sb.append(min);
			}
		}
		
		return sb.toString();
	}
	
	public static String minus(String people) {
		int hour = Integer.parseInt(people.substring(0,2));
		int min = Integer.parseInt(people.substring(3));
		min -= 1;
		if(min < 0) {
			min += 60;
			hour -= 1;
		}
		
		StringBuilder sb = new StringBuilder();
		if(hour < 10) {
			sb.append(0);
			sb.append(hour);
			sb.append(":");
			if(min < 10) {
				sb.append(0);
				sb.append(min);
			}
			else {
				sb.append(min);
			}
		}
		else {
			sb.append(hour);
			sb.append(":");
			if(min < 10) {
				sb.append(0);
				sb.append(min);
			}
			else {
				sb.append(min);
			}
		}
		
		return sb.toString();
	}
	
	public static boolean isPossible(String shuttle, String people) {
		int sHour = Integer.parseInt(shuttle.substring(0,2));
		int sMin = Integer.parseInt(shuttle.substring(3));;
		int pHour = Integer.parseInt(people.substring(0,2));;
		int pMin = Integer.parseInt(people.substring(3));;
		
		if(sHour > pHour) {
			return true;
		}
		else if(sHour == pHour) {
			if(sMin >= pMin) {
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	
	public String solution(int n, int t, int m, String[] timetable) {
        
        String startTime = "09:00";
        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> crue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
        	list.add(startTime);
        	startTime = addTime(startTime, t);
        }
        System.out.println("셔틀 시간표 : "+list);
        
        Arrays.sort(timetable, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		int aHour = Integer.parseInt(a.substring(0,2));
        		int bHour = Integer.parseInt(b.substring(0,2));
        		int aMin = Integer.parseInt(a.substring(3));
        		int bMin = Integer.parseInt(b.substring(3));
        		if(aHour == bHour) {
        			return aMin - bMin;
        		}
        		else {
        			return aHour - bHour;
        		}
        		
        	}
        	
        });
        ArrayList<String> conn = new ArrayList<>();
        for(String s : timetable) crue.add(s);
        System.out.println("원래 크루원들 "+crue);
        System.out.println("한번 최대 탑승 인원 :  "+m);
        
        String shuttle = "";
        int size = 0;
        for(int i = 0; i < list.size(); i++) {
        	shuttle = list.get(i);
        	size = crue.size();
        	if(size < m) {
        		conn.add(shuttle);
        		for(int j = 0; j < size; j++) {
        			crue.remove(0);
        		}
        	}
        	else {
        		for(int j = 0; j < m; j++) {
        			
        		}
        	}
        }
        
        System.out.println("나중 크루원들 "+crue);
        System.out.println("최종 : " +conn);
        
        return "";
    }

	public static void main(String[] args) {
		ShuttleBus s = new ShuttleBus();
		
		System.out.println("the answer is : " 
		+s.solution(1, 1, 5, new String[] {"08:00", "08:01", "08:02", "08:03"}));
		System.out.println();
		System.out.println("the answer is : " 
		+s.solution(2, 10, 2, new String[] {"09:10", "09:09", "08:00"}));
		System.out.println();
		System.out.println("the answer is : " 
		+s.solution(2, 1, 2, new String[] {"09:00", "09:00", "09:00", "09:00"}));
		System.out.println();
		System.out.println("the answer is : " 
		+s.solution(1, 1, 5, new String[] {"00:01", "00:01", "00:01", 
				"00:01", "00:01"}));
		System.out.println();
		System.out.println("the answer is : " +s.solution(1, 1, 1, new String[] {"23:59"}));
		System.out.println();
		System.out.println("the answer is : " +s.solution(10, 60, 45, new String[] {"23:59","23:59", 
				"23:59", "23:59", 
				"23:59", "23:59", 
				"23:59", "23:59", 
				"23:59", "23:59", 
				"23:59", "23:59", 
				"23:59", "23:59", 
				"23:59", "23:59"}));
		
		
	}

}
