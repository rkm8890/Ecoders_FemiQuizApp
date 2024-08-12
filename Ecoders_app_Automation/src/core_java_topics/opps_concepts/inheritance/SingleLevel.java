// Inheritance : when one class inherits properties from another class its known as 
package core_java_topics.opps_concepts.inheritance;

class Ramesh{
	int money = 1000;
}

class Suresh extends Ramesh{
	// virtual money = 1000 will be present here. no need to write the code.
}

public class SingleLevel {

	public static void main(String[] args) 
	{
		// create object of the suresh class to access the money variable. 
		Suresh s = new Suresh();
		// access the non static variable money from the Suresh class using the reference variable
		System.out.println(s.money);
	}
}