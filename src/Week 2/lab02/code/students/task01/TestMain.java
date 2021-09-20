// package students.task01;

/**
 * @author fahmidahamid
 * @author Philip Gray
 * @date Aug 31 2020
 * @version 1.1
 */

// Composition and Delegation

public class TestMain {

	
	public static void main(String[] args) {
		

		String testString = "new strings look interesting with just 53 characters.";
		FunString fn = new FunString(testString);
		System.out.println(fn);
		System.out.println(fn.length());
		System.out.println("There are "+fn.countDigits()+" digits in our string.");
		System.out.println("There are "+fn.countVowels()+" vowels in our string.");
	}

}

class FunString {

	String inputString;

	public FunString(String userInputtedString) {
		this.inputString = userInputtedString;
	}

	public int countDigits() {
		int count = 0;
		char[] charArray = this.inputString.toCharArray();
		for (char charInArray : charArray) {
			if (Character.isDigit(charInArray)) {
				count++;
			}
			;
		}
		return count;
	}

	public int countVowels() {
		int count = 0;
		String stringToParse = this.inputString.toLowerCase(); // just in case
		char[] charArray = stringToParse.toCharArray();
		for (char charInArray : charArray) {
			// https://www.programiz.com/java-programming/examples/vowel-consonant
			// ive never used switch case before, it's cool!
			// https://www.w3schools.com/java/java_switch.asp
			switch (charInArray) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					count++;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		return inputString;
	}

	public int length() {
		return this.inputString.length();
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
}
/**
 * We had to use composition because of how the String class in Java was created.
 * It's a final class, it's unable to be changed.
 * We can't use .length because of above, we're unable to inherit a final class.
 **/
