import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

public class BingoCard {
	
	private static int[][] arr = new int[5][5];
	private static boolean[][] crossedOff = new boolean[5][5];
	
	private static boolean won = false;
	
	private static List<Integer> banks0 = new ArrayList<>(15);
	private static List<Integer> banks1 = new ArrayList<>(15);
	private static List<Integer> banks2 = new ArrayList<>(15);
	private static List<Integer> banks3 = new ArrayList<>(15);
	private static List<Integer> banks4 = new ArrayList<>(15);
	
	private static Random random;
	
	public BingoCard() {
		createRandom(BingoCardTextFrame.seedUpdate());
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				crossedOff[i][j] = false;
				if(i == 2 && j == 2) crossedOff[i][j] = true;
			}
		}
		
		for(int i = 1; i <= 15; i++) {
			banks0.add(i);
			banks1.add(i+15);
			banks2.add(i+15*2);
			banks3.add(i+15*3);
			banks4.add(i+15*4);
			
		}
		
		generateTiles();
	}
	
	public int[][] getArr() {
		return arr;
	}
	
	private void generateTiles() {
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks0.size());
			int number = banks0.get(place);
			banks0.remove(place);
			arr[i][0] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks1.size());
			int number = banks1.get(place);
			banks1.remove(place);
			arr[i][1] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks2.size());
			int number = banks2.get(place);
			banks2.remove(place);
			arr[i][2] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks3.size());
			int number = banks3.get(place);
			banks3.remove(place);
			arr[i][3] = number;
		}
		
		for(int i = 0; i < 5; i++) {
			int place = random.nextInt(banks4.size());
			int number = banks4.get(place);
			banks4.remove(place);
			arr[i][4] = number;
		}
		
	}
	
	
	
	public static void createRandom(long seed) {
		random = new Random(seed);
	}
	
	public static int[][] getBingoNumbers() {
		return arr;
	}
	
	public static boolean isCrossedOff(int i, int j) {
		return crossedOff[i][j];
	}
	
	public static void setCrossedOff(int i, int j) {
		if(!won) crossedOff[i][j] = true;
	}
	
	public static boolean fiveInARow() {
		if(!won) {
			for(int i = 0; i < 5; i++) {
				if(crossedOff[i][0] && crossedOff[i][1] && crossedOff[i][2] &&  crossedOff[i][3] && crossedOff[i][3] && crossedOff[i][4]) return won = true;
			}
			for(int i = 0; i < 5; i++) {
				if(crossedOff[0][i] && crossedOff[1][i] && crossedOff[2][i] &&  crossedOff[3][i] && crossedOff[3][i] && crossedOff[4][i]) return won = true;
			}
			
			//diagonal 1
			if(crossedOff[0][0] && crossedOff[1][1] && crossedOff[2][2] && crossedOff[3][3] && crossedOff[4][4]) return won = true;
			
			//diagonal 2
			if(crossedOff[4][0] && crossedOff[3][1] && crossedOff[2][2] && crossedOff[1][3] && crossedOff[0][4]) return won = true;
			
			return false;
		} else {
			ArrayList<Integer> arr0 = new ArrayList<>();
			for(int i = 1; i <= 15; i++) arr0.add(i);
			banks0 = arr0;
			
			ArrayList<Integer> arr1 = new ArrayList<>();
			for(int i = 16; i <= 30; i++) arr1.add(i);
			banks1 = arr1;
			
			ArrayList<Integer> arr2 = new ArrayList<>();
			for(int i = 31; i <= 45; i++) arr2.add(i);
			banks2 = arr2;
			
			ArrayList<Integer> arr3 = new ArrayList<>();
			for(int i = 46; i <= 60; i++) arr3.add(i);
			banks3 = arr3;
			
			ArrayList<Integer> arr4 = new ArrayList<>();
			for(int i = 61; i <= 75; i++) arr4.add(i);
			banks4 = arr4;
			return true;
		}
	}
	
	
}
