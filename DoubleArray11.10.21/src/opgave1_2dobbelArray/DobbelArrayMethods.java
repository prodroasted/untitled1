package opgave1_2dobbelArray;

import java.lang.reflect.Array;

/**
 * @author mad
 *
 */
public class DobbelArrayMethods {

	public void udskrivArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + "  ");
			}
			System.out.println();
		}
	}

	// Opgave 1.1
	public int getValueAt(int[][] numbers, int row, int col) {
		//TODO returner værdien på plads (row,col) i numbers
		return numbers[row][col];
	}

	// Opgave 1.2
	public void setValueAt(int[][] numbers, int row, int col, int value) {
		//TODO opdater pladsen (row,col) i numbers til value
		numbers[row][col] = value;
	}

	// Opgave 1.3
	public int sumRow(int[][] numbers, int row) {
		//TODO returner summen af tallene i rækken row
		int rowsum = 0;
		for (int i = 0; i < numbers.length; i++) {
			rowsum += numbers[i][row];
		}
		return rowsum;
	}

	// Opgave 1.4
	public int sumCol(int[][] numbers, int col) {
		//TODO returner summen af tallene i kolonnen col
		int colsum = 0;
		for (int i = 0; i < numbers[col].length; i++) {
			colsum += numbers[col][i];
		}
		return colsum;
	}

	// Opgave 1.5
	public int sum(int[][] numbers) {
		//TODO returnerer summen af alle tallene i numbers
		int overallsum = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				overallsum += numbers[i][j];
			}
		}
		return overallsum;
	}
}