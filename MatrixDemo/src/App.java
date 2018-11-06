import java.util.Scanner;

public class App {

	static int row ;
	static int col;
	static int value;
	static String [][] array = {{"1","2"," "," "},
								{" "," ","2"," "},
								{" ","4"," ","2"},
								{"2"," ","4"," "}};
	static String [][] displayArray = {	{"  ","C0","C1","C2","C3"},
										{" "," "," "," "," "},
										{"R0","1","2"," "," "},
										{"R1"," "," ","2"," "},
										{"R2"," ","4"," ","2"},
										{"R3","2"," ","4"," "}};

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Validate v = new Validate();
		v.printOutput(displayArray);
		inputValues(s);
		if(v.rowValidation(array, row, value)&&v.columnValidation(array, col, value)&&(v.checkQuadrant(array, row, col,value))) {
			System.out.println("value can be inserted ");
		}
		else {
			System.out.println("value cannot be inserted !!!");
		}
	}

	private static void inputValues(Scanner s) {
		System.out.println("Enter value of row , column and value to insert in the array");
		System.out.println("Enter row number");
		row = s.nextInt();
		if(!(row<4)) {
			System.out.println("Enter value within row limit (<4)");
			row = s.nextInt();
		}
		System.out.println("Enter col number");
		col = s.nextInt();
		if(!(col<4)) {
			System.out.println("Enter value within col limit (<4)");
			col = s.nextInt();
		}
		System.out.println("Enter value to be inserted");
		value = s.nextInt();
	}

}
