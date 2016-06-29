/* Person.java

 * Author: Alyssa Lagimoniere
 * Submission Date: 4/10/15
 * 
 * Purpose: Methods for the object Person to set different parameters:
 * name, age, cash and if they own a house.
 * 
 * Statement of Academic Honesty: 
 * 
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */

import java.text.DecimalFormat;

//Class representing a person (a human user) on a real estate market.
//A person has a name, age, cash, and (potentially) a house.
public class Person {

	//Instance variables

	private String name;
	private int age;
	private double cash;
	private House house;
	
	//Constructors

	//The Default constructor creates a 20 year old John L. with a 
	//penny of cash and no home.
	public Person() {
		name = "John L.";
		age = 21;
		cash = .01;
		house = null;
	}
	
	//A second constructor that enables the creation of a custom instance of the Person class. 
	//The house instance variable is set to null.
	//@param name : the person's name 
	//@param age : the person's age
	//@param cash : the amount of money the person has
	public Person(String name, int age, double cash) {
		this.name = name;
		this.age = age;
		this.cash = cash;
	}

	//A third constructor including a parameter for the persons house. The house is also updated
	//because it is no longer for sale.
	//@param name : the person's name 
	//@param age : the person's age
	//@param cash : the amount of money the person has
	//@param house : the person's home
	public Person(String name, int age, double cash, House house) {
		this.name = name;
		this.age = age;
		this.cash = cash;
		this.house.setForSale(false);
	}
	
	 //Show the name and age of the person as well as their assets (cash and home if they have one).
	 //E.g.
	 //Name: John L.
	 //Age: 20 years old
	 //Cash: $ 0.01
	@Override
	public String toString() {
		DecimalFormat decimalFormatObj = (DecimalFormat) DecimalFormat.getInstance();
		decimalFormatObj.setMinimumFractionDigits(2);
	    decimalFormatObj.setMaximumFractionDigits(2);
		String stringName = "Name: " + name;
		String stringAge = "\nAge: " + age;
		String stringCash = "\nCash: $" + decimalFormatObj.format(cash);
		String stringHouse = "";
		if (house != null) {
			stringHouse = "\nHome:\n " + house.toString();
		}
		return stringName + stringAge + stringCash + stringHouse;
	}
	
	// Accessors / Getters
	
	//@return the person's name 
	public String getName() {
		return name;
	}
	
	//@return the person's age
	public int getAge() {
		return age;
	}
	
	//@return the amount of cash this person has
	public double getCash() {
		return cash;
	}
	
	//@return a reference the house object currently owned by this person
	public House getHouse() {
		return house;
	}
	
	//@return true if this person has a home
	public boolean ownsAHouse() {
		if (house != null)
			return true;
		else
			return false;
	}
	
	// Mutators
	
	//@param amount : the amount of cash to give this person
	public void addCash(double amount) {
		amount += cash;
	}
	
	//If this person owns home, put it up for sale and pay the person 
	//the price of the home.
	public void sellHome() {
		if (house != null) {
			cash = cash + house.getPrice();
			house.forSale = true;
			house = null;
			System.out.println(name + " has sold their house!");
		} else {
			System.out.println(name + " has no house to sell.");
		}		
	}

	//This method lets the person buy a home if they do not already have a home, have the cash and the home is for sale.
	//If the person successfully buys a home, their cash is decreased by the cost of the home.
	//@param h the house to be bought
	public void buyHouse(House h) {
		if ((house == null) && (cash >= h.getPrice()) && (h.forSale = true)) {
			cash = cash - (h.getPrice());
			house = h;
			house.forSale = false;
			System.out.println(name + " is now a proud homeowner!");
		} else if (house != null) {
			System.out.println(name + " is already a homeowner!");
		} else if (cash < h.getPrice()) {
			System.out.println(name + " cannot afford this house.");
		} else {
			System.out.println("This house is not for sale.");
		}
	}
}