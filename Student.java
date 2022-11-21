//Angel Li
//112784616
//Angel.Li@stonybrook.edu
//Homework #1
//CSE 214 (R03)
//TA Kevin Cheng

/**
 *The Student class represents a student which has a name and money.
 *
 *
 * @author Angel Li
 * Angel.Li@stonybrook.edu
 * 112784616
 */
public class Student {
	private String name;
	private double money;

	/**
	 * This is a constructor used to create a new Student object
	 *
	 * @param name
	 * 	The name of the student
	 * @param money
	 * 	The amount of money the student has
	 */
	public Student(String name, double money) {
		this.name = name;
		this.money = money;
	}

	/**
	 *The method gets the name of the student
	 *
	 * @return
	 * 	The name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The method gets the amount of money the student has
	 *
	 * @return
	 * 	The amount of money the student has
	 */
	public double getMoney() {
		return this.money;
	}

	/**
	 * The method changes the name of a student
	 *
	 * @param name
	 * 	The name of the student
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The method changes the amount of money a student has
	 *
	 * @param money
	 * 	The amount of money a student has
	 * @throws NegativeAmount
	 * 	When the user inputs a negative amount of money for a student
	 */
	
	public void setMoney(double money) throws NegativeAmount {
		if(money <0)
			throw new NegativeAmount();
		this.money = money;
	}

	/**
	 * The method checks to see if two students are equal
	 *
	 * @param obj
	 * 	An object
	 * @return
	 * 	True if an object is an instance of student and is also equal to
	 * 	another student
	 */

	public boolean equals(Object obj){
		if(obj instanceof Student){
			Student s = (Student)obj;
			return this.name.equals(s.name) && this.money == s.money;
		}
		return false;
	}

	/**
	 * The method clones a student
	 * @return
	 * 	A clone of the student
	 */

	public Student clone(){
		Student newStudent = new Student(this.name, this.money);
		return newStudent;
	}

	/**
	 * The method gives a printable representation of the Student and its
	 * data members(name,price)
	 *
	 * @return
	 * 	gives string of the Student and its name and price.
	 */

	public String toString(){
		return "Name: " + this.name + "\t\t" + "Money:$" + this.money;
	}

	
	

	
	
	
	
	
}
