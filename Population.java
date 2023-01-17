import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Population - A program that the user can use to sort cities by name and population.
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Yaswanth Nallamotu
 *	@since	1/16/2023
 */
public class Population {
	
	// List of cities
	private List<City> cities;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	// Constructor
	public Population()
	{
		cities = new ArrayList<City>();
	}
	
	///Creates an instance of Population and calls run()
	public static void main(String[] args)
	{
		Population pop = new Population();
		pop.run();
	}
	
	/**
	 * Prints the introduction and a menu of options for the user.  Depending
	 * 		on the user's choice, we call the appropiate method to sort the cities.
	 * If the user enters a 9, the program terminates.
	 * */
	public void run()
	{
		int choice = 0;
		initCities();
		printIntroduction();
		do
		{
			printMenu();
			choice = getChoice();
			if(choice == 1)
			{
				leastPopCities();
			}
			else if(choice == 2)
			{
				mostPopCities();
			}
			else if(choice == 3)
			{
				firstAlphaCities();
			}
			else if(choice == 4)
			{
				lastAlphaCities();
			}
			else if(choice == 5)
			{
				mostPopCitiesInState();
			}
			else if(choice == 6)
			{
				mostPopNamedCities();
			}
		}while(choice != 9);
		
		System.out.println("\nThanks for using Population!");
	}
	
	/**
	 * Reads the data file and creates City objects for the information
	 * 		and adds the objects to the cities ArrayList.
	 * */
	public void initCities()
	{
		FileUtils fileUtil = new FileUtils();
		Scanner kb = fileUtil.openToRead(DATA_FILE).useDelimiter("[\t\n]");
		int cnt = 0;
		String state = ""; String name = ""; String type = "";  String pop = "";
		for(int ind = 0; kb.hasNext(); ind++)
		{
			String wrd = kb.next();
			if(ind == 0)
			{
				state = wrd;
				
			}
			else if(ind == 1)
			{
				name = wrd;
			}
			else if(ind == 2)
			{
				type = wrd;
			}
			else if(ind == 3)
			{
				pop = wrd;
				City city = new City(state, name, type, Integer.parseInt(pop));
				cities.add(city);
				ind = -1;
			}
		}
	}
	
	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
	/**
	 * Prompts the user to enter a number from 1-6 and 9, each number corresponds
	 * 		with a menu choice.
	 * 
	 * @return selection(the user's choice).
	 * */
	public int getChoice()
	{
		Prompt pr = new Prompt();
		return pr.getInt("Enter Selection:",1,9);
	}
	
	/**
	 * Sorts the cities from least to greatest population using a selectionsort.
	 * After sorting the cities, prints 50 cities with the least population,
	 * 		and the elapsed time that was taken to run the program.
	 * */
	public void leastPopCities()
	{
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.selectionSortPopulation(cities);
		long endMillisec = System.currentTimeMillis();
		System.out.println("\nFifty least populous cities"); 
		System.out.printf("     %-23s%-23s%-14s%12s", "State", "City",
			"Type","Population\n");
		for(int i = 0; i < 50; i++)
		{
			String index = "" + (i+1) + ": ";
			System.out.printf("%5s",index);
			System.out.println(cities.get(i).toString());
		}
		System.out.println("\nElapsed time " + (endMillisec - startMillisec) + " miliseconds\n");
	}
	
	/**
	 * Sorts the cities from least to greatest population using a merge sort.
	 * After sorting the cities, prints 50 cities with the most population,
	 * 		and the elapsed time that was taken to run the program.
	 * */
	public void mostPopCities()
	{
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.mergeSortPopulation(cities);
		long endMillisec = System.currentTimeMillis();
			System.out.println("\nFifty most populous cities"); 
		System.out.printf("     %-23s%-23s%-14s%12s", "State", "City",
			"Type","Population\n");
		int cnt = 1;
		for(int i = cities.size()-1; i >= cities.size()-50; i--)
		{
			String index = "" + (cnt) + ": ";
			System.out.printf("%5s",index);
			System.out.println(cities.get(i).toString());
			cnt++;
		}
		System.out.println("\nElapsed time " + (endMillisec - startMillisec) + " miliseconds\n");
	}
	
	/**
	 * Sorts the cities from least to greatest in alphabetic value using a insertion sort.
	 * After sorting the cities, prints 50 cities in ascending alphabetic order
	 * 		and the elapsed time that was taken to run the program.
	 * */
	public void firstAlphaCities()
	{
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.insertionSortNames(cities);
		long endMillisec = System.currentTimeMillis();
			System.out.println("\nFifty cities sorted by name"); 
		System.out.printf("     %-23s%-23s%-14s%12s", "State", "City",
			"Type","Population\n");
		int cnt = 1;
		for(int i = cities.size()-1; i >= cities.size()-50; i--)
		{
			String index = "" + (cnt) + ": ";
			System.out.printf("%5s",index);
			System.out.println(cities.get(i).toString());
			cnt++;
		}
		System.out.println("\nElapsed time " + (endMillisec - startMillisec) + " miliseconds\n");
	}
	
	/**
	 * Sorts the cities from least to greatest in alphabetic value using a merge sort.
	 * After sorting the cities, prints 50 cities in descending alphabetic order
	 * 		and the elapsed time that was taken to run the program.
	 * */
	public void lastAlphaCities()
	{
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.mergeSortNames(cities);
		long endMillisec = System.currentTimeMillis();
			System.out.println("\nFifty cities sorted by name descending"); 
		System.out.printf("     %-23s%-23s%-14s%12s", "State", "City",
			"Type","Population\n");
		int cnt = 1;
		for(int i = cities.size()-1; i >= cities.size()-50; i--)
		{
			String index = "" + (cnt) + ": ";
			System.out.printf("%5s",index);
			System.out.println(cities.get(i).toString());
			cnt++;
		}
		System.out.println("\nElapsed time " + (endMillisec - startMillisec) + " miliseconds\n");
	}
	
	/**
	 * Asks the user for a specific state and sorts the cities in that state from least 
	 * 		to greatest in popualtion using a merge sort.
	 * After sorting the cities, prints 50 cities in descending order
	 * 		and the elapsed time that was taken to run the program.
	 * */
	public void mostPopCitiesInState()
	{
		System.out.println();
		List<City> stateCities = new ArrayList<City>();
		
		Prompt pr = new Prompt();
		String state = "";
		while(stateCities.size() == 0)
		{
			state = pr.getString("Enter State name");
			for(int i = 0; i < cities.size(); i++)
			{
				if(cities.get(i).getState().equalsIgnoreCase(state.trim()))
				{
					stateCities.add(cities.get(i));
				}
			}
			if(stateCities.size() == 0)
			{
				System.out.println("ERROR: " + state + " is not valid");
			}
		}
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.mergeSortPopulation(stateCities);
		long endMillisec = System.currentTimeMillis();
			System.out.println("\nFifty most populous cities in " + state); 
		System.out.printf("     %-23s%-23s%-14s%12s", "State", "City",
			"Type","Population\n");
		int cnt = 1;
		int size = 0;
		if(stateCities.size() < 50)
			size = stateCities.size();
		else
			size = 50;
		for(int i = stateCities.size()-1; i >= stateCities.size()-size; i--)
		{
			String index = "" + (cnt) + ": ";
			System.out.printf("%5s",index);
			System.out.println(stateCities.get(i).toString());
			cnt++;
		}
		System.out.println("\nElapsed time " + (endMillisec - startMillisec) + " miliseconds\n");
		
	}
	/**
	 * Asks the user for a city and sorts the cities with that name from least 
	 * 		to greatest in popualtion using a merge sort.
	 * After sorting the cities, prints 50 cities in descending order
	 * 		and the elapsed time that was taken to run the program.
	 * */
	public void mostPopNamedCities()
	{
		System.out.println();
		List<City> identicalCities = new ArrayList<City>();
		Prompt pr = new Prompt();
		String city  = "";
		while(identicalCities.size() == 0)
		{
			city = pr.getString("Enter City name");
			for(int i = 0; i < cities.size(); i++)
			{
				if(cities.get(i).getName().equalsIgnoreCase(city.trim()))
				{
					identicalCities.add(cities.get(i));
				}
			}
			if(identicalCities.size() == 0)
			{
				System.out.println("ERROR: " + city + " is not valid");
			}
		}
		SortMethods sm = new SortMethods();
		long startMillisec = System.currentTimeMillis();
		sm.mergeSortPopulation(identicalCities);
		long endMillisec = System.currentTimeMillis();
			System.out.println("\nCity " + city + " by population"); 
		System.out.printf("     %-23s%-23s%-14s%12s", "State", "City",
			"Type","Population\n");
		int cnt = 1;
		for(int i = identicalCities.size()-1; i >= 0; i--)
		{
			String index = "" + (cnt) + ": ";
			System.out.printf("%5s",index);
			System.out.println(identicalCities.get(i).toString());
			cnt++;
		}
		System.out.println("\nElapsed time " + (endMillisec - startMillisec) + " miliseconds\n");
	}
	
}
