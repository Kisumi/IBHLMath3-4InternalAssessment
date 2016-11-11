import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.io.FileNotFoundException; //in case the user screws up

public class InsertionSort {
 
	static Calendar cal1, cal2;
	static long startTime;

	public static int[] insertionSort(int[] input) {
		int temp;
		for(int i = 1; i < input.length; i++) {
			for(int j = i; j > 0; j--) {
				if(input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		return input;
	}

	public static void main(String args[]) throws FileNotFoundException {
		String fileNumbers = new Scanner(new File(args[0])).useDelimiter("\\Z").next();
		int indexOfSpace = 0;
		ArrayList<String> listOfStrings = new ArrayList<>();

		for(int i = 0; i < fileNumbers.length() - 1; i++) {
			if(fileNumbers.substring(i, i + 1).equals(" ")) {
				listOfStrings.add(fileNumbers.substring(indexOfSpace + 1, i));
				indexOfSpace = i;
			}
		}

		listOfStrings.add(fileNumbers.substring(indexOfSpace + 1, fileNumbers.length() - 1));

		String[] inputStrings = listOfStrings.toArray(new String[listOfStrings.size()]);
		int[] input = new int[inputStrings.length];

		for(int j = 0; j < inputStrings.length; j++)
			input[j] = Integer.parseInt(inputStrings[j]);

		int[] output = insertionSort(input);
		cal1 = Calendar.getInstance();
		cal2 = Calendar.getInstance();
		startTime = cal1.getTimeInMillis();
		for(int i:output)
			System.out.println(i);
		long endTime = cal2.getTimeInMillis();
		System.out.println("Runtime: " + (endTime - startTime));
	}
}
