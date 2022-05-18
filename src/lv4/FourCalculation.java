package lv4;

import java.util.LinkedList;

public class FourCalculation {
	public int solution(String arr[]) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        for(String s : arr) list.add(s);
        
        System.out.println(list);
        if(list.size() == 1) {
        	return Integer.parseInt(list.get(0));
        }
        else if(list.size() == 3) {
        	if(list.get(1).equals("-")) {
        		return Integer.parseInt(list.get(0))-Integer.parseInt(list.get(2));
        	}
        	else {
        		return Integer.parseInt(list.get(0))+Integer.parseInt(list.get(2));
        	}
        }
        else if(list.size() == 5) {
        	return fiveCal(list);
        }
        else {
        	gogo(list);
        }
        
        
        if(list.size() == 1) {
        	return Integer.parseInt(list.get(0));
        }
        else if(list.size() == 3) {
        	if(list.get(1).equals("-")) {
        		return Integer.parseInt(list.get(0))-Integer.parseInt(list.get(2));
        	}
        	else {
        		return Integer.parseInt(list.get(0))+Integer.parseInt(list.get(2));
        	}
        }
        else if(list.size() == 5) {
        	return fiveCal(list);
        }
        else {
        	answer = 0;
        }
        
        return answer;
    }
	
	public static int fiveCal(LinkedList<String> list) {
		int answer = 0;
		int a = Integer.parseInt(list.get(0));
		int b = Integer.parseInt(list.get(2));
		int c = Integer.parseInt(list.get(4));
		
		if(list.get(1).equals("-")) {
			if(list.get(3).equals("-")) {
				answer = a - (b-c);
			}
			else {
				answer = a - b + c;
			}
		}
		else {
			if(list.get(3).equals("+")) {
				answer = a + b + c;
			}
			else {
				answer = a + b - c;
			}
		}
		
		return answer;
		
	}
	
	public static void gogo(LinkedList<String> list){
		int beforeA = 0;
		int beforeB = 0;
		
		int afterA = 0;
		int afterB = 0;
		
		int value = 0;
		
		String before = "";
		String now = "";
		String after = "";
		System.out.println(list);
		if(list.size() >= 7) {
			for(int i = 3; i <= list.size()-4; i += 2) {
				before = list.get(i-2);
				now = list.get(i);
				after = list.get(i+2);
				beforeA = Integer.parseInt(list.get(i-3));
				beforeB = Integer.parseInt(list.get(i-1));
				afterA = Integer.parseInt(list.get(i+1));
				afterB = Integer.parseInt(list.get(i+3));
				if(now.equals("-")) { 	// 현재 - 면
					if(before.equals("-")) { //앞이 -
						if(after.equals("+")) { // 뒤가 + 면 beforeB와 afterA를 계산 후 재귀
							value = beforeB - afterA;
							list.remove(i-1);
							list.remove(i-1);
							list.remove(i-1);
							list.add(i-1, String.valueOf(value));
							gogo(list);
							break;
						}
						else { 							// 뒤가 -
							if(i == list.size() -4) { // 끝에 다다르면 그냥 afterA- afterB를 계산 후 재귀
								value = afterA - afterB;
								list.remove(i+1);
								list.remove(i+1);
								list.remove(i+1);
								list.add(String.valueOf(value));
								gogo(list);
							}
							continue;
						}
					}
					else {						//	앞이 + 
						if(after.equals("+")) {	//  뒤가 + 면 beforeB 와 afterA를 계산 후 재귀
							value = beforeB - afterA;
							list.remove(i-1);
							list.remove(i-1);
							list.remove(i-1);
							list.add(i-1, String.valueOf(value));
							gogo(list);
							break;
						}
						else {					// 뒤가 -
							if(i == list.size() -4) { // 끝에 다다르면 그냥 afterA- afterB를 계산 후 재귀
								value = afterA - afterB;
								list.remove(i+1);
								list.remove(i+1);
								list.remove(i+1);
								list.add(String.valueOf(value));
								gogo(list);
							}
							continue;
						}
					}
				}
				else {					//현재 + 면
					if(before.equals("-")) {	//앞이 -
						if(after.equals("+")) { 		//뒤가 + 면 before 값들만 계산 후 재귀
							value = beforeA - beforeB;
							list.remove(i-3);
							list.remove(i-3);
							list.remove(i-3);
							list.add(i-3, String.valueOf(value));
							gogo(list);
							break;
						}
						else {							// 뒤가 -
							if(i == list.size() -4) { // 끝에 다다르면 그냥 beforeB + afterA를 계산 후 재귀
								value = beforeB + afterA;
								list.remove(i-1);
								list.remove(i-1);
								list.remove(i-1);
								list.add(i-1, String.valueOf(value));
								gogo(list);
							}
							continue;
						}
					}
					else {						//앞이 +
						if(after.equals("+")) {			// 뒤가 + 면 다 계산 후 재귀
							value = beforeA + beforeB + afterA + afterB;
							list.remove(i-3);
							list.remove(i-3);
							list.remove(i-3);
							list.remove(i-3);
							list.remove(i-3);
							list.remove(i-3);
							list.remove(i-3);
							list.add(i-3, String.valueOf(value));
							gogo(list);
							break;
						}
						else {							// 뒤가 -
							if(i == list.size() -4) { // 끝에 다다르면 그냥 beforeB + afterA를 계산 후 재귀
								value = beforeB + afterA;
								list.remove(i-1);
								list.remove(i-1);
								list.remove(i-1);
								list.add(i-1, String.valueOf(value));
								gogo(list);
							}
							continue;
						}
					}
				}
			}
		}
		
    }

	public static void main(String[] args) {
		FourCalculation s = new FourCalculation();
		
		String[] a = {"1", "-", "3", "+", "5", "-", "8"};
		String[] b = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
		String[] c = {"1"};
		String[] d = {"2","-","4"};
		String[] e = {"2","-","4","-","6"};
		
		
		System.out.println("answer is : " +s.solution(a));
		System.out.println();
		System.out.println("answer is : " +s.solution(b));
		System.out.println();
		System.out.println("answer is : " +s.solution(c));
		System.out.println();
		System.out.println("answer is : " +s.solution(d));
		System.out.println();
		System.out.println("answer is : " +s.solution(e));

	}

}
