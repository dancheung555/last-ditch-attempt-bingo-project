import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;

public class BingoCard {
	
	private int[][] arr = new int[5][5];
	private boolean[][] crossedOff = new boolean[5][5];
	
	private List<Integer> banks0 = new ArrayList<>(15);
	private List<Integer> banks1 = new ArrayList<>(15);
	private List<Integer> banks2 = new ArrayList<>(15);
	private List<Integer> banks3 = new ArrayList<>(15);
	private List<Integer> banks4 = new ArrayList<>(15);
	
	private static Random random;
	
	public BingoCard() {
		createRandom(BingoCardTextFrame.seedUpdate());
		
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
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	
	public static void createRandom(long seed) {
		random = new Random(seed);
	}
	
	
}
