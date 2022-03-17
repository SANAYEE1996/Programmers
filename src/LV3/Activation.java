package LV3;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Act {

    public static int fountainActivation(List<Integer> locations) {
    	int answer = 1;
    	int start = 1;
        int end = 0;
    	int n = locations.size();
    	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		if(Math.min(i+1 + locations.get(i), n) > end) {
                start = Math.max(i+1 - locations.get(i), 1);
                end = Math.min(i+1 + locations.get(i), n);
                ArrayList<Integer> exam = new ArrayList<>();
                exam.add(start);
                exam.add(end);
                list.add(exam);
            }
		}
    	Collections.sort(list, new Comparator<ArrayList<Integer>>() {
    		@Override
    		public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
    			if(a.get(0) == b.get(0)) {
    				return a.get(1) - b.get(1);
    			}
    			else {
    				return a.get(0) - b.get(0);
    			}
    		}
    	});
    	int flag = 1;
        int beforeEnd = 0; 
    	start = 0;
    	end = 0;
    	int max = 0;
    	for (ArrayList<Integer> l : list) {
			start = l.get(0); 
			end = l.get(1);
			if(max < end) {
				max = end;
			}
			if(flag < start) {
				System.out.println(flag + " " + max);
				flag = beforeEnd;
				answer++;
			}
			beforeEnd = end;
		}
    	System.out.println(flag + " " +max);
    	
    	
    	return answer;
    }

}

public class Activation {

	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int locationsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> locations = IntStream.range(0, locationsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Act.fountainActivation(locations);
        System.out.println(result);

        bufferedReader.close();

	}

}
