package Lab16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CountriesTextFile {
	
	public static void readFromFile(String directoryFolder, String fileName) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			
			String line = reader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error - 404: Just another one of those sneaky files.....that isn't there...");
		} catch (IOException e) {
			System.out.println("Error!...Nothing special...just a normal error...dunno why....just is....");
		}

	}

	public static void writeToFile(String directoryFolder, String fileName, String input) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();
		
		String country = input;

		try {
			// The 'true' parameter appends data to the end of the file
			// The 'false' parameter rewrites over the entire file
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(country);
			outW.close(); // This needs to be closed!
		} catch (FileNotFoundException e) {
			System.out.println("Error - 404: File not found....HaHa!");
		}

	}

	public static void createDirectory(String directoryFolder, String fileName) {
		String dirPath = "Countries";

		Path folder = Paths.get(dirPath);

		if (Files.notExists(folder)) {

			try {// This is an example of a checked exception
				Files.createDirectories(folder);
				System.out.println("The folder was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong with the folder creation!");
			}
		} else {
			System.out.println("That folder already exists!");
		}

	}

	public static void createFile(String dirFold, String fName) {
		String directoryFolder = "Countries";
		String fileName = "Countries";

		Path filePath = Paths.get(directoryFolder, fileName);

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully!");
			} catch (IOException e) {
				System.out.println("Error - 404: Things that work the way you want not found!");
			}
		} else {
			System.out.println("File creation failed! File already exists!");
		}

	}

}

