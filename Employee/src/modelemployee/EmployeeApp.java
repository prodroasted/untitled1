package modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", 25, "Johansen","John");
		e1.printEmployee();
		e1.setName("Viggo");
		e1.setAge(32);
		e1.setEfternavn("Pedersen");
		e1.setFornavn("");
		e1.printEmployee();
	}

}
