/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author Yaswanth Nallamotu
 *	@since	1/16/2023
 */
 
import java.util.List;
import java.util.ArrayList;

public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	public void bubbleSort(Integer [] arr) 
	{
		for(int outer = arr.length-1; outer > 0; outer --)
		{
			for(int inner = 0; inner < outer; inner++)
			{
				if(arr[inner].compareTo(arr[inner+1]) > 0)
				{
					swap(arr,inner,inner+1);
				}
			}
		}
	}
	private void swap(Integer[] arr, int x, int y)
	{
		Integer temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swapCity(List<City> arr, int x, int y)
	{
		City temp = arr.get(x);
		arr.add(x, arr.get(y));
		arr.remove(x+1);
		arr.add(y, temp);
		arr.remove(y+1);
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void selectionSortPopulation(List<City> arr)
	{
		for(int a = arr.size()-1; a > 0; a--)
		{
			int iMax = 0;
			for(int i = 1; i < a; i++)
			{
				if(arr.get(i).compareTo(arr.get(iMax)) > 0)
				{
					iMax = i;
				}
			}
			swapCity(arr, iMax, a);
		}
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public static void insertionSortNames(List<City> cities) 
	{
		for (int i = 1; i < cities.size(); i++)
		{
			City key = cities.get(i);
			int j = i - 1;
			while (j >= 0 && cities.get(j).getName().compareTo(key.getName()) < 0)
			{
				cities.set(j + 1, cities.get(j));
				j = j - 1;
			}
			cities.set(j + 1, key);
		}
	}
	/**
	 * Merge Sort algorithm to sort the cities alphabetically by descending order.
	 * @param arr
	 * */
	 public void mergeSortNames(List<City> cities) 
	{
		if (cities.size() > 1)
		{
			int mid = cities.size() / 2;
			List<City> left = new ArrayList<City>(cities.subList(0, mid));
			List<City> right = new ArrayList<City>(cities.subList(mid, cities.size()));
			mergeSortNames(left);
			mergeSortNames(right);
			mergeNames(cities, left, right);
		}
	}

	public void mergeNames(List<City> cities, List<City> left, List<City> right)
	{
		int i = 0, j = 0, k = 0;
		while (i < left.size() && j < right.size())
		{
			if (left.get(i).getName().compareTo(right.get(j).getName()) < 0)
			{
				cities.set(k, left.get(i));
				i++;
			} 
			else 
			{
				cities.set(k, right.get(j));
				j++;
			}
			k++;
		}
		while (i < left.size())
		{
			cities.set(k, left.get(i));
			i++;
			k++;
		}
		while (j < right.size())
		{
			cities.set(k, right.get(j));
			j++;
			k++;
		}
	}
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	
	public void mergeSortPopulation(List<City> cities) 
	{
		if (cities.size() > 1)
		{
			int mid = cities.size() / 2;
			List<City> left = new ArrayList<City>(cities.subList(0, mid));
			List<City> right = new ArrayList<City>(cities.subList(mid, cities.size()));
			mergeSortPopulation(left);
			mergeSortPopulation(right);
			mergePopulation(cities, left, right);
		}
	}

	public void mergePopulation(List<City> cities, List<City> left, List<City> right)
	{
		int i = 0, j = 0, k = 0;
		while (i < left.size() && j < right.size())
		{
			if (left.get(i).compareTo(right.get(j)) < 0)
			{
				cities.set(k, left.get(i));
				i++;
			} 
			else 
			{
				cities.set(k, right.get(j));
				j++;
			}
			k++;
		}
		while (i < left.size())
		{
			cities.set(k, left.get(i));
			i++;
			k++;
		}
		while (j < right.size())
		{
			cities.set(k, right.get(j));
			j++;
			k++;
		}
	}


	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/
	
	/**
	 *	Print an array of Integers to the screen
	 *	@param arr		the array of Integers
	 */
	public void printArray(Integer[] arr) {
		if (arr.length == 0) System.out.print("(");
		else System.out.printf("( %4d", arr[0]);
		for (int a = 1; a < arr.length; a++) {
			if (a % 10 == 0) System.out.printf(",\n  %4d", arr[a]);
			else System.out.printf(", %4d", arr[a]);
		}
		System.out.println(" )");
	}
}
