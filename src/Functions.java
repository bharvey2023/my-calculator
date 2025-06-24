import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

//import CustomJFrame.InnerActionListener;

/**
 * The Class Functions creates all functions for the calculator
 */
public class Functions extends JFrame {

	private double num1;
	private double num2;
	private String answer;
	private String sign;

	private StringBuilder input;

	private JButton addButton;
	private JButton divideButton;
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton neg;

	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton zero;

	private JTextField box;

	private JButton clear;
	private JButton equal;
	private JButton dot;


	/**
	 * Instantiates all of the functional buttons and text area.
	 */
	public Functions() {

		box = new JTextField();

		addButton = new JButton("+");
		divideButton = new JButton("/");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("*");
		clear = new JButton("CE");
		equal = new JButton("=");
		dot = new JButton(".");
		neg = new JButton("±");

		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");

		num1 = 0;
		num2 = 0;

		input = new StringBuilder();

	}

	public void setNum1(double s) {
		num1 = s;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum2(double s) {
		num2 = s;
	}

	public double getNum2() {
		return num2;
	}

	public void setAnswer(String s) {
		answer = s;
	}

	public String getAnswer() {
		return answer;
	}

	public void setSign(String s) {
		sign = s;
	}

	public String getSign() {
		return sign;
	}


	/**
	 * Make calculator sets up frame for calculator.
	 */
	public void makeCalculator() {

		this.setTitle("The Calculator");

		this.setLayout(new GridBagLayout());

		GridBagConstraints layman = new GridBagConstraints();

		makeSelect act = new makeSelect();

		layman.insets = new Insets(5, 10, 5, 10);  

		//functional buttons
		layman.gridx = 1;
		layman.gridy = 5;
		this.add(dot,layman);

		layman.gridx = 2;
		layman.gridy = 5;
		this.add(neg,layman);

		//box where numbers appear
		layman.gridx = 5;
		layman.gridy = 0;
		this.add(box, layman);
		box.setColumns(25);
		box.setEditable(false);

		//more functional buttons
		layman.gridx = 4;
		layman.gridy = 0;
		this.add(addButton, layman);

		layman.gridx = 4;
		layman.gridy = 1;
		this.add(divideButton, layman);

		layman.gridx = 4;
		layman.gridy = 2;
		this.add(subtractButton, layman);

		layman.gridx = 4;
		layman.gridy = 3;
		this.add(multiplyButton, layman);

		layman.gridx = 2;
		layman.gridy = 3;
		this.add(clear, layman);

		layman.gridx = 1;
		layman.gridy = 3;
		this.add(equal, layman);


		//Numbers buttons
		layman.gridx = 0;
		layman.gridy = 0;
		this.add(one, layman);


		layman.gridx = 1;
		layman.gridy = 0;
		this.add(two, layman);


		layman.gridx = 2;
		layman.gridy = 0;
		this.add(three, layman);

		layman.gridx = 0;
		layman.gridy = 1;
		this.add(four, layman);

		layman.gridx = 1;
		layman.gridy = 1;
		this.add(five, layman);

		layman.gridx = 2;
		layman.gridy = 1;
		this.add(six, layman);

		layman.gridx = 0;
		layman.gridy = 2;
		this.add(seven, layman);

		layman.gridx = 1;
		layman.gridy = 2;
		this.add(eight, layman);

		layman.gridx = 2;
		layman.gridy = 2;
		this.add(nine, layman);

		layman.gridx = 0;
		layman.gridy = 3;
		this.add(zero, layman);

		box.setText("0.0");

		//adding to action performed so the method can grab what buttons
		//are being pressed
		one.addActionListener(act);
		two.addActionListener(act);
		three.addActionListener(act);
		four.addActionListener(act);
		five.addActionListener(act);
		six.addActionListener(act);
		seven.addActionListener(act);
		eight.addActionListener(act);
		nine.addActionListener(act);
		zero.addActionListener(act);
		addButton.addActionListener(act);
		divideButton.addActionListener(act);
		subtractButton.addActionListener(act);
		multiplyButton.addActionListener(act);
		clear.addActionListener(act);
		equal.addActionListener(act);
		dot.addActionListener(act);
		neg.addActionListener(act);


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.pack();


		this.setVisible(true);

	}

	/**
	 * The Class makeSelect is the action listener class that
	 * grabs each button pressed and gives them a place before calculation
	 */
	public class makeSelect implements ActionListener{
		//made global for easy use of clear but grabs the button that was pressed
		String coms;

		/**
		 * Action performed which grabs the buttons pressed
		 * and does checks/calculations depending on the button
		 * also minor error checking too 
		 *
		 * @param the button pressed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			coms = e.getActionCommand();
			String[] seq;
			//String answer = null;

			//had trouble concating the strings if the user accidently adds two symbols so i try catch and clear the issue
			try {

				//grabs what button user presses while make sure its not clear
				//grabs command and attaches to the textbox
				if(!(coms.equalsIgnoreCase("CE"))) {
					input.append(coms);
					box.setText(input.toString());
				}

				//checks if user presses equal sign to finish calculations
				if(input.toString().contains("=")) {

					//this (±) is how the code determines if a number is negative
					String grab = input.toString();
					//grab = grab.replace("±", "± ");

					//could've went further and put the checking of the math symbol
					//in own method but this was just better for me to do

					//adding
					if(grab.contains("+")) {
						seq = grab.split("\\+");

						checkSigns(seq);

						sign = "+";

						answer = adding(num1,num2).toString();

					}
					//subtracting
					else if(grab.contains("-")) {

						seq = grab.split("-");

						checkSigns(seq);

						sign = "-";

						answer = subtracting(num1,num2).toString();
					}
					//multiply
					else if(grab.contains("*")) {

						seq = grab.split("\\*");

						checkSigns(seq);

						sign = "*";

						answer = multiplying(num1,num2).toString();
						System.out.println(getAnswer());

					}

					//divide
					else if(grab.contains("/")) {
						seq = grab.split("/");

						//checkSigns(seq);

						sign = "/";

						if(seq[0].charAt(0) == '0' || (seq[0].contains("±") && seq[0].charAt(1) == '0')) {
							box.setText("Divide by zero");
							answer = "Divide by zero error";
						}
						else {
							checkSigns(seq);
							answer = dividing(num1,num2).toString();
						}
					}

					// if number is too big this shows that it is continuos
					if(answer.length() > box.getColumns()) {
						answer = answer.substring(0,box.getColumns()) + "->";
					}

					clear();
					box.setText(answer);
					answer = "0.0";
					if(Calc.userput.equalsIgnoreCase("yes")) {
						Calc.history.writeResults(getNum1() + " " + getSign() + " " + getNum2() + " = " +getAnswer());
					}

				}

			}catch (Exception ex) {

				box.setText("Error");
				input = new StringBuilder();
				coms = "";
				System.out.println(ex.getMessage());

				//clear within catch 
				if(e.getActionCommand().equalsIgnoreCase("CE")) {
					clear();
					answer="0.0";
				}
			}

			//checking for clear option
			if(e.getActionCommand().equalsIgnoreCase("CE")) {
				clear();
				answer = "0.0";
			}
		}

		//Using wrapper class Double so i can convert to string for answer
		/**
		 * Adding calculations after check
		 *
		 * @param one the one
		 * @param two the two
		 * @return the answer
		 */
		private Double adding(double one, double two) {
			return one+two;
		}

		/**
		 * Multiplying calculations after check
		 *
		 * @param one the one
		 * @param two the two
		 * @return the answer
		 */
		private Double multiplying(double one, double two) {
			return one*two;
		}

		/**
		 * Subtracting calculations after check
		 *
		 * @param one the one
		 * @param two the two
		 * @return the answer
		 */
		private Double subtracting(double one, double two) {
			return one-two;
		}

		/**
		 * Dividing calculations after check
		 *
		 * @param one the one
		 * @param two the two
		 * @return the answer
		 */
		private Double dividing(double one, double two) {
			return one/two;
		}

		/**
		 * Check signs mainly for negative numbers
		 *
		 * @param arr the that grab was split into
		 */
		private void checkSigns(String[] arr) {
			if(arr[0].contains("±")) {

				String m = arr[0].substring(1, arr[0].length()).trim();
				System.out.println(m);
				//num1 = -1.0*Double.parseDouble(m);
				setNum1(-1.0*Double.parseDouble(m));
			}
			else {
				//num1 = Double.parseDouble(arr[0].trim());
				setNum1(Double.parseDouble(arr[0].trim()));
			}
			if(arr[1].contains("±") ) {

				String m  = arr[1].substring(1, arr[1].length()).trim();
				System.out.println(m);
				//num2 = -1.0*Double.parseDouble(m.replace("=", ""));
				setNum2(-1.0*Double.parseDouble(m.replace("=", "")));

			}
			else {
				setNum2(Double.parseDouble(arr[1].replace("=","")));
				//num2 = Double.parseDouble(arr[1].replace("=",""));
			}
		}

		//making text clear
		private void clear() {

			input = new StringBuilder();
			coms = "";
			//answer = "0.0";
			box.setText("0.0");
			
		}

	}


}
