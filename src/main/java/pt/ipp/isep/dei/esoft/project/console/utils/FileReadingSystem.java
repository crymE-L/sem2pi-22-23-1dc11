package pt.ipp.isep.dei.esoft.project.console.utils;

import java.io.*;
import java.util.Scanner;

/**
 * This class exists to help us read files more easily
 * without having to rewrite over and over again
 * complex operations. This class is dynamic
 * and ready to be used by multiple types
 * of files
 *
 * @author Miguel Ferreira (1210701)
 */
public class FileReadingSystem {
	/**
	 * The file's name
	 */
	private String filename;

	/**
	 * The file object
	 */
	private File file;

	/**
	 * The number of lines of the file
	 */
	private int lines = -1;

	/**
	 * This constant limits the number of users that
	 * we can have on the platform
	 */
	static final int LIMIT = 500;

	/**
	 * This constructor allows us to use the file reading system
	 * anywhere in the system, after initializing it
	 *
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public FileReadingSystem(String filename) throws FileNotFoundException {
		setFilename(filename);
		File file = null;

		/**
		 * We want to be really careful when trying to create a file
		 * and we should let our beautiful programmer know that
		 * something is not right by throwing the exception
		 */
		try {
			file = new File(filename);
		} catch(IllegalArgumentException exception) {
			throw new IllegalArgumentException("Invalid file provided");
		}

		/**
		 * Setup the file and the number of lines
		 */
		this.file = file;
		this.lines = this.countFileLines();
	}

	/**
	 * The getter for the filename
	 *
	 * @return String
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * This setter for the filename will verify if
	 * the filename isn't empty and if it has
	 * a valid file extension
	 *
	 * @param filename
	 */
	public void setFilename(String filename) {
		if(Helpers.isEmpty(filename))
			throw new IllegalArgumentException("Invalid filename");

		if(!this.hasValidExtension(filename))
			throw new IllegalArgumentException("Invalid file extension");

		this.filename = filename;
	}

	/**
	 * The getter for the file
	 *
	 * @return File
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * The getter for the number of lines in a file
	 *
	 * @return int
	 */
	public int getLines() {
		return this.lines;
	}

	/**
	 * This function exists to read the data from the file
	 * provided by the user
	 *
	 * @return String[][]
	 * @throws FileNotFoundException
	 */
	public String[][] readData() throws FileNotFoundException {
		String dataChunk;
		String processedData;

		int rowPlacement;

		/**
		 * This bad boy right here is the number of rows we have in a line
		 */
		int rows = 5;

		if(this.file.exists() && !this.file.isFile())
			throw new IllegalCallerException("You must first provide a valid file");

		/**
		 * If the file is not initialized correctly, then
		 * the number of lines is -1
		 */
		if(lines == -1)
			throw new IllegalCallerException("You must first provide a valid file");

		String[][] data = new String[lines][rows];

		for (int i = 2; i <= this.lines; i++) {
			rowPlacement = 0;

			dataChunk = this.findLine(i);
			processedData = processData(dataChunk);

			/**
			 * We're going to loop through each string chunk in a line
			 * and add it to our data array, creating that way a nice and
			 * clean matrix with all the info we need.
			 *
			 * The rowPlacement variable is here to place the data in its
			 * specific positions
			 */
			for (String parameter : processedData.split(";")) {
				int line = i - 2;

				data[line][rowPlacement] = parameter;
				rowPlacement++;
			}
		}

		return data;
	}

	/**
	 * This function exists to find the content of a specific
	 * line in our file, allowing us to have a better
	 * understanding of its content
	 *
	 * @param line
	 * @return String
	 * @throws FileNotFoundException
	 */
	public String findLine(int line) throws FileNotFoundException {
		Scanner read = new Scanner(this.file);
		String[] lines = new String[LIMIT];
		int counter = 0;

		do {
			lines[counter] = read.nextLine();
			counter++;
		} while (read.hasNextLine());

		read.close();

		/**
		 * If the line doesn't exist in the file,
		 * we're going to return an empty string
		 */
		try {
			return lines[line - 1];
		} catch (Exception exception) {
			return "";
		}
	}

	/**
	 * This function will check the number of lines in the initialized
	 * file and return them, in order for the programmer to use later
	 *
	 * @return int
	 */
	public int countFileLines() throws FileNotFoundException {
		/**
		 * We want to verify if the file was really
		 * initializes and is ready to be used
		 */
		if(this.file.exists() && !this.file.isFile())
			throw new IllegalCallerException("You must first provide a valid file");

		Scanner read = new Scanner(this.file);
		int counter = 0;

		while (read.hasNextLine()) {
			if (read.nextLine().equals("")) {
				break;
			}

			counter++;
		}

		read.close();

		return counter;
	}

	/**
	 * The writeData function allows the programmer to introduce an
	 * array of strings to a certain file in order to store it...
	 *
	 * for all eternity 😈
	 *
	 * @param data
	 * @throws IOException
	 */
	public void writeData(String[] data) throws IOException {
		/**
		 * In order to save the data forever we actually need to tell
		 * our code that we want to append the data instead
		 * of overriding it
		 */
		FileWriter fileWriter = new FileWriter(this.filename, true);
		PrintWriter writer = new PrintWriter(fileWriter);

		String dataString = String.join(";", data);

		writer.println(dataString);

		writer.close();
	}

	/**
	 * This function exists has a private validation to really
	 * see if the file has a valid exception or not,
	 * according to an array
	 *
	 * @param filename
	 * @return boolean
	 */
	private boolean hasValidExtension(String filename) {
		/**
		 * A little of all the possible extensions
		 * to the file
		 */
		String[] possibleExtensions = {
			".csv",
			".txt"
		};

		boolean hasExtension = false;

		for(String possibleExtension : possibleExtensions) {
			if(filename.contains(possibleExtension)) {
				hasExtension = true;
				break;
			}
		}

		return hasExtension;
	}

	/**
	 * This private function exists to remove all the possible
	 * spaces in a given data chunk, in order for the code
	 * to have the purest form of data
	 *
	 * @return String
	 */
	private String processData(String dataChunk) {
		/**
		 * We're going to take the string with all of its spaces
		 * just so it's easier to get the data from the string
		 * after we split it
		 */
		return dataChunk.replaceAll("\\s", "");
	}
}
