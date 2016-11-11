import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.io.FileNotFoundException; //in case the user screws up

public class QuickSort {

	private int[] array;
	private int length;

	static Calendar cal1, cal2;
	static long startTime;

	public QuickSort() {
		cal1 = Calendar.getInstance();
		cal2 = Calendar.getInstance();
	}

	public void sort(int[] toSort) {
		if(toSort == null || toSort.length == 0) {
			return;
		}
		array = toSort;
		length = toSort.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int low, int high) {
		int i = low;
		int j = high;
		int pivot = array[low + (high - low) / 2];

		while (i <= j) {
			while(array[i] < pivot) {
				i++;
			}
			while(array[j] > pivot) {
				j--;
			}
			if(i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}

		if(low < j)
			quickSort(low, j);
		if(i < high)
			quickSort(i, high);
	}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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

		QuickSort sortThis = new QuickSort();
		startTime = cal1.getTimeInMillis();
		sortThis.sort(input);
		for(int i:input)
			System.out.println(i);
		long endTime = cal2.getTimeInMillis();
		System.out.println("Runtime: " + (endTime - startTime));
	}
}
