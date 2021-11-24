package ysp_211020;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static void solution(int sizeOfMatrix, int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int x = 0;
		int y = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				x = i; y = j;
				if(matrix[x][y] == 1) {
					
				}
			}
		}
	}
	
	private static class InputData{
		int sizeOfMatrix;
		int[][] matrix;
	}
	
	private static InputData processStdin() {
		InputData inputData = new InputData();
		try(Scanner sc = new Scanner(System.in)){
			
		}
		catch(Exception e) {
			throw e;
		}
		
		return inputData;
	}
	
	public static void main(String[] args) throws Exception{
		InputData inputData = processStdin();
		
		solution(inputData.sizeOfMatrix, inputData.matrix);
	}
}
