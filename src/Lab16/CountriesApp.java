package Lab16;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String directoryFolder = "Countries";
		String fileName = "Countries";
		int userChoice;
		
//		CountriesTextFile.createDirectory(directoryFolder, fileName);
//		CountriesTextFile.createFile(directoryFolder, fileName);
		
		System.out.println("Greetings! Welcome to the 'Countries of the World' database!");
		
		do {
		System.out.println();
		userChoice = Validator.getInt(scnr, "Please choose one of the following options: \n 1.) Display List of Countries \n 2.) Enter a new Country \n 3.) Exit Database \n", 1, 3);
			if(userChoice == 1) {
				CountriesTextFile.readFromFile(directoryFolder, fileName);
			}
			else if(userChoice == 2) {
				String userAdd = Validator.getString(scnr, "Enter the name of the country you'd like to add to the list: ");
				CountriesTextFile.writeToFile(directoryFolder, fileName, userAdd);
				System.out.println();
			}
			
		}while (userChoice != 3); 
		
		System.out.println("Ok. Thanks for using the 'Countries of the World' database! Come back any time.....seriously....we get lonely....");
		
		scnr.close();
	}

}
