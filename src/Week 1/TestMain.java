import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author fahmidahamid
 * @author Philip Gray
 * Nisa kinda helped? Helping her helped me realize I had errors in my code.
 * @date Aug 25 2021
 * @version 1.1.3
 */

public class TestMain {

	/**
	 * 
 	*
 	* This method reads from a file called robotList.txt and creates an ArrayList of Robots.
	 * It also sorts the ArrayList of Robots by their ranks and prints the list.
 	*/

	public static void main(String[] args) {

		//Robot testRobot = new Robot();
		//System.out.println(testRobot);
		//System.out.println("---");

		ArrayList<Robot> roboList = new ArrayList<>();
		// io from https://www.w3schools.com/java/java_files_read.asp
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Please enter the filepath to your robotList.");

			String filePath = userInput.nextLine();
			userInput.close();
			File myFile = new File(filePath);

			System.out.println();
			Scanner myScanner = new Scanner(myFile);
			while (myScanner.hasNextLine()) {
				// https://stackoverflow.com/questions/15002139/parse-a-line-in-java
				String readString = myScanner.nextLine();
				String[] splitString = readString.split(" "); // splits the string on the space
				/*
				for (String item : splitString) {
					System.out.println(item);
				}
				 */
				// shoutout to javatpoint.com/java-string-to-boolean
				String robotName = splitString[0];
				int robotRank = Integer.parseInt(splitString[1]);
				int robotSalary = Integer.parseInt(splitString[2]);
				boolean robotMaskStatus = Boolean.parseBoolean(splitString[3]);
				String robotSkinColor = splitString[4];
				Robot newRobot = new Robot(robotName, robotRank, robotSalary, robotMaskStatus, robotSkinColor);
				roboList.add(newRobot);
			}

			myScanner.close();

			Collections.sort(roboList);
			for (Robot robot : roboList) {
				System.out.println(robot);
			}
			System.out.println("---");
			Collections.sort(roboList, new CompareSalary());
			for (Robot robot : roboList) {
				String myString = robot.getName() + " has a salary of " + robot.getSalary() +".";
				System.out.println(myString);
			}
			System.out.println("---");
			Collections.sort(roboList, new CompareNames());
			for (Robot robot : roboList) {
				System.out.println(robot);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find the file.");
			e.printStackTrace();
		}
	}
}
