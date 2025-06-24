import java.util.Scanner;

public class Calc {

	public final static String username = "MyCalculator";

	public final static String password = "ILuvMath";

	public static String userput;

	public static SaveCalulations history = new SaveCalulations();

	public static String fileName;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Functions func = new Functions();
		Scanner in = new Scanner(System.in);

		System.out.println("Would you like to save your history?");

		userput = in.next();

		if(userput.equalsIgnoreCase("Yes")) {

			System.out.println("User and password please.");
			//String user = in.next();
			//String pass = in.next();

			String user = "MyCalculator";
			String pass = "ILuvMath";

			if(user.equals(username) && pass.equals(password)) {
				func.makeCalculator();
			}
		}
		else {
			func.makeCalculator();
		}



		in.close();
	}

}
