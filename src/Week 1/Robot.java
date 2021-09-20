import java.util.Comparator;

/**
 * @author fahmidahamid
 * @author Philip Gray
 * Nisa kinda helped? Helping her helped me realize I had errors in my code.
 * @date Aug 25 2021
 * @version 1.1.3
 * 
 * The Robot class is used to create a Robot object with the following properties:
 *  name, rank, salary, faceMask, bodyColor
 *
 */
public class Robot implements Comparable<Robot>{

	private String name;
	private int rank;  // lower the better
	private double salary; //per week
	private boolean faceMask; 
	private String bodyColor;
	
	
	Robot(){
		this.name = "essential worker";
		this.rank = 10; //lowest rank
		this.salary = 1000.00; //lowest possible salary
		this.faceMask = false; //
		this.bodyColor = "yellow";
	}
	
	Robot(Robot r){
		this.name = r.name;
		this.rank = r.rank; 
		this.salary = r.salary; 
		this.faceMask = r.faceMask; 
		this.bodyColor = r.bodyColor;
	}
	
	
	Robot(String[] information){
		this.name = information[0];
		this.rank = Integer.valueOf(information[1]); 
		this.salary = Double.valueOf(information[2]); 
		this.faceMask = Boolean.valueOf(information[3]); 
		this.bodyColor = information[4];
	}
	
	Robot(String name, int rank, double salary, boolean faceMask, String bodyColor)
	{
		this.name = name;
		this.rank = rank;
		this.salary = salary;
		this.faceMask = faceMask;
		this.bodyColor = bodyColor;
		
	}
	
	// add setters and getters
	// add constructor if necessary 

	public String getName() {
		return this.name;
	}

	public int getRank() {
		return this.rank;
	}

	public Double getSalary() {
		return this.salary;
	}

	public boolean getFaceMask() {
		return this.faceMask;
	}

	public String getBodyColor() {
		return this.bodyColor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setFaceMask(boolean faceMask) {
		this.faceMask = faceMask;
	}

	public void setBodyColor (String bodyColor) {
		this.bodyColor = bodyColor;
	}

	public void alterFaceMask() {
		if (this.faceMask) {
			this.faceMask = false;
		} else {
			this.faceMask = true;
		}
	}

	@Override
	public String toString() {
		String createdString = (name + " is a rank "+ rank + " robot.");
		return createdString;
	}

	public int compareTo(Robot robot) {
		if (this.rank == robot.getRank()) {
			return 0;
		} else if (this.rank > robot.getRank()) {
			return -1;
		} else {
			return 1;
		}
	}
}

class CompareSalary implements Comparator<Robot> {
	public int compare(Robot robotOne, Robot robotTwo) {
		if (robotOne.getSalary() == robotTwo.getSalary()) {
			return 0;
		} else if (robotOne.getSalary() < robotTwo.getSalary()) {
			return 1;
		} else {
			return -1;
		}
	}
}
// https://www.geeksforgeeks.org/compare-two-strings-lexicographically-in-java/?ref=rp
class CompareNames implements Comparator<Robot> {
	public int compare(Robot robotOne, Robot robotTwo) {
		return robotOne.getName().compareTo(robotTwo.getName());
	}
}
