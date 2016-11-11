import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.io.FileNotFoundException; //in case the user screws up

public class MergeSort {

	private int[] array;
	private int[] mergeArray;
	private int length;

	static Calendar cal1, cal2;
	static long startTime;

	public MergeSort() {
		cal1 = Calendar.getInstance();
		cal2 = Calendar.getInstance();
	}

	public void sort(int toSort[]) {
		array = toSort;
		length = toSort.length;
		mergeArray = new int[length];
		mergeSort(0, length - 1);
	}

	private void mergeSort(int low, int high) { 
		if(low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			mergeParts(low, middle, high);
		}
	}

	private void mergeParts(int low, int middle, int high) {
		
		for(int i = low; i <= high; i++)
			mergeArray[i] = array[i];
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high) {
			if(mergeArray[i] <= mergeArray[j]) {
				array[k] = mergeArray[i];
				i++;
			} else {
				array[k] = mergeArray[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = mergeArray[i];
			k++;
			i++;
		} 
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

		MergeSort sortThis = new MergeSort();
		startTime = cal1.getTimeInMillis();
		sortThis.sort(input);
		for(int i:input)
			System.out.println(i);
		long endTime = cal2.getTimeInMillis();
		System.out.println("Runtime: " + (endTime - startTime));
	}
}
