package modelemployee;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String name;
	private boolean trainee;
	private int age;
	private int birthDay;
	private String efternavn;
	private String fornavn;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputName, int inputAge, String inputEfternavn, String inputFornavn) {
		name = inputName;
		trainee = true;
		age = inputAge;
		birthDay = 0;
		efternavn = inputEfternavn;
		fornavn = inputFornavn;
	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setName(String inputName) {
		name = inputName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getName() {
		return name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int inputAge) {
		age = inputAge;
	}

	public String getEfternavn(){return efternavn;}

	public String getFornavn(){return fornavn;}

	public void setEfternavn(String inputEfternavn){efternavn = inputEfternavn;}

	public void setFornavn(String inputFornavn){fornavn = inputFornavn;}


	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Name " + name);
		System.out.println("Efternavn " + efternavn);
		System.out.println("Fornavn " + fornavn);
		System.out.println("Trainee " + trainee);
		System.out.println("Age " + age);
		System.out.println();
	}
}
