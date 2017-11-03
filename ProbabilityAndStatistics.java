import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.NumberFormatException;

public class ProbabilityAndStatistics {

	private static final String SENTINEL = "done";
	private static Scanner userInput = new Scanner(System.in), scanner = new Scanner(System.in);
	private static List<List<Integer>> valuesArray = new ArrayList<List<Integer>>();
	private static String userValue;
	private static int userValueInt;
	
	public static void main(String[] args) {
		
		System.out.println("How many arrays will you be filling?\n");
		int numOfArrays = scanner.nextInt();
		boolean noErrors = true;
		
		for(int i = 0; i < numOfArrays; i++)
			valuesArray.add(new ArrayList<Integer>());
		for(List<Integer> array : valuesArray) {
			System.out.println("Input your array values - PRESS ENTER AFTER EACH NUMBER - TYPE \"done\" TO COMPLETE THE ARRAY:\n");
			while(true) {
				noErrors = true;
				try {
					userValue = userInput.nextLine();
					userValueInt = Integer.parseInt(userValue);
				} catch(NumberFormatException exception) {
					if(userValue.toLowerCase().equals(SENTINEL))
						break;
					noErrors = false;
					System.out.println("Integer values must be inputted - TYPE \"done\" TO COMPLETE THE ARRAY:\n");
				}
				if(noErrors == true)
					array.add(userValueInt);
			}
		}
		
		userInput.close();
		@SuppressWarnings({ "unused", "unchecked" })
		final Calculations calculations = new Calculations(valuesArray);
		int counter = 0;
		for(List<Integer> arrs : Calculations.getArray())
			for(Integer numbers : arrs) {
				if(counter == arrs.size() - 1)
					System.out.println(numbers + "\n");
				else
					System.out.print(numbers + ", ");
				counter++;
			}
		System.out.println("\n");
		@SuppressWarnings("unused")
		DisplayCalculations displayC = new DisplayCalculations();
	}
	
}
