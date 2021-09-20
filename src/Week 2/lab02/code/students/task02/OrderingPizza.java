// package task02; <- This doesn't work for me.

/**
 * @author fahmidahamid
 * @author Philip Gray
 * @date Aug 31 2021
 * @version 1.1
 * I don't know if I used the open-closed principle properly for this project.
 * I used the following websites for this:
 * https://www.baeldung.com/java-decorator-pattern
 * https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
 */


interface TastyPizza
{
	double totalCost();
	double totalCalories();
	String getToppings();
}

class PizzaMargherita implements TastyPizza {
	// concrete
	double cost = 4.99;
	double calories = 1104;

	String toppings = "margherita pizza with cheese, tomato";

	public PizzaMargherita(){
	}

	public String getToppings() {
		return toppings;
	}

	public double totalCost() {
		return cost;
	}

	public double totalCalories() {
		return calories;
	}
}

class HawaiianPizza implements TastyPizza {
	// concrete
	double cost = 6.49;
	double calories = 1024;

	String toppings = "hawaiian pizza with cheese, tomato, ham, pineapple";

	public HawaiianPizza(){
	}

	public String getToppings() {
		return toppings;
	}

	public double totalCost() {
		return cost;
	}

	public double totalCalories() {
		return calories;
	}
}

class SalamiPizza implements TastyPizza {
	// concrete
	double cost = 5.99;
	double calories = 1160;

	String toppings = "salami pizza with cheese, tomato, salami";

	public SalamiPizza(){
	}

	public String getToppings() {
		return toppings;
	}

	public double totalCost() {
		return cost;
	}

	public double totalCalories() {
		return calories;
	}
}

class PizzaDecorator implements TastyPizza {
	private TastyPizza pizza;

	public PizzaDecorator(TastyPizza pizza)  {
		this.pizza = pizza;
	}

	public double totalCost() {
		return pizza.totalCost();
	}

	public double totalCalories() {
		return pizza.totalCalories();
	}

	public String getToppings() {
		return pizza.getToppings();
	}

	public String toString() {
		String pizzaOrder = "You ordered a " + pizza.getToppings() + ". This pizza has a total of  "
				+ pizza.totalCalories() + " calories. " + "The price is $" + pizza.totalCost() + "." +
				" Thanks for ordering from Philip's Pizzas!";
		return pizzaOrder;
	}
}

class AddCheese extends PizzaDecorator {
	// Decorator
	double cost = 0.69;
	double calories = 92;
	String toppingName = "cheese";

	public AddCheese(TastyPizza pizza) {
		super(pizza);
	}

	public double totalCost() {
		return super.totalCost() + cost;
	}

	public double totalCalories() {
		return super.totalCalories() + calories;
	}

	public String getToppings() {
		return super.getToppings() + ", " + toppingName;
	}
}

class AddHam extends PizzaDecorator {
	// Decorator
	double cost = 0.99;
	double calories = 35;
	String toppingName = "ham";

	public AddHam(TastyPizza pizza) {
		super(pizza);
	}

	public double totalCost() {
		return super.totalCost() + cost;
	}

	public double totalCalories() {
		return super.totalCalories() + calories;
	}

	public String getToppings() {
		return super.getToppings() + ", " + toppingName;
	}
}

class AddOnions extends PizzaDecorator {
	// Decorator
	double cost = 0.69;
	double calories = 22;
	String toppingName = "onions";

	public AddOnions(TastyPizza pizza) {
		super(pizza);
	}

	public double totalCost() {
		return super.totalCost() + cost;
	}

	public double totalCalories() {
		return super.totalCalories() + calories;
	}

	public String getToppings() {
		return super.getToppings() + ", " + toppingName;
	}
}

class AddPineapple extends PizzaDecorator {
	// Decorator
	double cost = 0.79;
	double calories = 24;
	String toppingName = "pineapple";

	public AddPineapple(TastyPizza pizza) {
		super(pizza);
	}

	public double totalCost() {
		return super.totalCost() + cost;
	}

	public double totalCalories() {
		return super.totalCalories() + calories;
	}

	public String getToppings() {
		return super.getToppings() + ", " + toppingName;
	}
}

class AddSalami extends PizzaDecorator {
	// Decorator
	double cost = 0.99;
	double calories = 86;
	String toppingName = "salami";

	public AddSalami(TastyPizza pizza) {
		super(pizza);
	}

	public double totalCost() {
		return super.totalCost() + cost;
	}

	public double totalCalories() {
		return super.totalCalories() + calories;
	}

	public String getToppings() {
		return super.getToppings() + ", " + toppingName;
	}
}

class FamilySize extends PizzaDecorator {
	// Decorator
	double calorieIncrease = 1.95;
	double costIncrease = 4.15;
	String familySized = "family sized ";

	public FamilySize(TastyPizza pizza) {
		super(pizza);
	}

	public double totalCost() {
		return super.totalCost() + costIncrease;
	}

	public double totalCalories() {
		return super.totalCalories() * calorieIncrease;
	}

	public String getToppings() {
		return familySized + super.getToppings();
	}
}

/*
 * Complete the implementation of related classes
 * Follow Open-Closed Principle
 * Please do not forget to add "//Decorator Class" at the beginning of the decorator classes
 * The other classes should be labeled as //Concrete class 
 * 
 * */
public class OrderingPizza {

	public static void main(String[] args) {

		/*
		 * Create the following pizza objects and print their basic information
		 *
		 * a) One FamilySize Hawaiian Pizza with ham and onion
		 * b) One Salami pizza with double pineapple and onion
		 * c) One FamilySize Pizza Margherita with triple cheese and salami
		 *
		 * A basic information about a pizza might look like the following:
		 * Good choice! Here is your Family size Hawaiian Pizza with tomato, cheese, pineapple, ham which costs: 10.64 with 1996.8 calories.
		 *
		 */

		TastyPizza orderA = new FamilySize(new AddHam(new AddOnions(new HawaiianPizza())));
		System.out.println(orderA);

		TastyPizza orderB = new AddPineapple(new AddPineapple(new AddOnions(new SalamiPizza())));
		System.out.println(orderB);

		TastyPizza orderC = new FamilySize(new AddCheese(new AddCheese(new AddCheese(new AddSalami(new PizzaMargherita())))));
		System.out.println(orderC);
	}
}


