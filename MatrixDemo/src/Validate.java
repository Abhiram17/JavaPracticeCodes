import java.util.HashSet;
import java.util.Set;

public class Validate {
	public boolean checkQuadrant(String array[][],int row, int col,int value) {
		String quad ="";
		if(row>1) {
			if(col<2) {
				quad = "3";
			}
			else {
				quad="4";
			}
		}
		else {
				if(col<2) {
					quad="1";
				}
				else {
					quad="2";
				}
				
			}
		
		Set<Integer> set = new HashSet<Integer>();
		int row1 =row-(row%2);
		int col1 = col-(col%2);
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
		if(array[row1][col1]!=" ")
			set.add(Integer.parseInt(array[row1+i][col1+j]));
			}
		}
		if(!set.contains(value)) {
			set.add(value);
		}
		else {
			System.out.println("Conflict in quadrant: " + quad);
			return false;
		}
		System.out.println("No colfilct to add "+value+ " in Quadrant: " + quad);	
		return true;
				
		
	}

	public boolean columnValidation(String[][] array,int col,int value) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i =0;i< 4;i++) {
			if(array[i][col]!=" ")
				set.add(Integer.parseInt(array[i][col]));
		}
			
				if(!set.contains(value)) {
					set.add((value));
				}
				else {
					System.out.println("Conflict in Column: " + col);
					return false;
				}
		System.out.println("No colfilct to add "+value+ " in Column: " + col);
		return true;
	}

	public boolean rowValidation(String[][] array,int row,int value) {
		Set<Integer> set = new HashSet<Integer>();
		for(int j =0;j< 4;j++) {
			if(array[row][j]!=" ")
				set.add(Integer.parseInt(array[row][j]));
		}
			
				if(!set.contains(value)) {
					set.add((value));
				}
				else {
					System.out.println("Conflict in Row: " + row);
					return false;
				}
		System.out.println("No colfilct to add "+value+ " in Row: " + row);
		return true;
	}

	public void printOutput(String[][] array) {
		System.out.println("the output is :");
		for(int i=0;i<6;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(array[i][j]+"\t");
				
			}
			System.out.println("");
		}
		System.out.println("");
	}	
}
