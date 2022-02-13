package LV3;

import java.util.ArrayList;
import java.util.Arrays;

public class NightWork {
	public long solution(int n, int[] works) {
        long answer = 0;
        
        Arrays.sort(works);
        
        int value = works[works.length-1];
        int count = 0;
        int differ = 0;
        int index = 0;
        
        for(int i = works.length-1; i >= 0; i--) {
        	//System.out.println(n);
        	if(value == works[i]) {
        		continue;
        	}
        	else {
        		count = works.length-i-1;
        		differ = value - works[i];
        		//System.out.println("개수 : "+count + "\t차이 : " + differ);
        		if(n - differ*count >= 0) {
        			n -= differ*count;
        			value = works[i];
        		}
        		else {
        			index = i;
        			break;
        		}
        		
        	}
        }
        
        //System.out.println("최종 : 일단 어디까지 왔는가" +index + " 얼마나 남았는가 : " +n +"그래서 그 값은 ? : " +value);
        //int size = works.length - index - 1;
        //System.out.println("내가 만들고자 하는 사이즈 : " +size);
        
        int[] array = new int[works.length];
        for(int i = 0; i < array.length; i++) {
        	if(i > index)
        		array[i] = value;
        	else
        		array[i] = works[i];
        }
        
        int mot = 0;
        int nam = 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(array.length > 1 && array[index] == array[index+1]) {
        	int size = works.length - index;
        	//System.out.println("남은 값 : "+n+" 최종 남은 배열 : " +Arrays.toString(array) + " 어디서부터 같은 값인가 ? " +(index));
        	//System.out.println(size);
        	if(n % size == 0) {
        		mot = n/size;
        		for(int i = 0; i < size; i++) {
        			list.add(mot);
        		}
        	}
        	else {
        		mot = n/size;
        		nam = n%size;
        		for(int i = 0; i < size-nam; i++) {
        			list.add(mot);
        		}
        		for(int i = 0; i < nam; i++) {
        			list.add(mot+1);
        		}
        	}
        	int flag = 0;
        	int gob = 0;
        	for(int i = 0; i < array.length; i++) {
            	if(i >= index) {
            		gob = array[i] - list.get(flag);
            		if(gob < 0) gob = 0;
            		answer += Math.pow(gob, 2);
            		flag++;
            	}
            	else {
            		answer += Math.pow(array[i], 2);
            	}
            }
        }
        else if(array.length > 1) {
        	int size = works.length - index-1;
        	//System.out.println("남은 값 : "+n+" 최종 남은 배열 : " +Arrays.toString(array) + " 어디서부터 같은 값인가 ? " +(index+1));
        	index++;
        	//System.out.println(size);
        	if(n % size == 0) {
        		mot = n/size;
        		for(int i = 0; i < size; i++) {
        			list.add(mot);
        		}
        	}
        	else {
        		mot = n/size;
        		nam = n%size;
        		for(int i = 0; i < size-nam; i++) {
        			list.add(mot);
        		}
        		for(int i = 0; i < nam; i++) {
        			list.add(mot+1);
        		}
        	}
        	int flag = 0;
        	int gob = 0;
        	for(int i = 0; i < array.length; i++) {
            	if(i >= index) {
            		gob = array[i] - list.get(flag);
            		if(gob < 0) gob = 0;
            		answer += Math.pow(gob, 2);
            		flag++;
            	}
            	else {
            		answer += Math.pow(array[i], 2);
            	}
            }
        }
        
       // System.out.println(list);
        
        
        
        return answer;
    }

	public static void main(String[] args) {
		NightWork s = new NightWork();
		
		System.out.println("the answer is : " +s.solution(4, new int[] {4, 3, 3}));
		System.out.println("the answer is : " +s.solution(1, new int[] {2,1,2}));
		System.out.println("the answer is : " +s.solution(3, new int[] {1,1}));
		System.out.println("the answer is : " +s.solution(99, new int[] {2, 15, 22, 55, 55}));
		System.out.println("the answer is : " +s.solution(99, new int[] {2, 15, 22, 55, 59}));

	}

}
