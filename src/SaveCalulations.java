import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class SaveCalulations {
	private String calculationFile;

	private FileWriter fileOutput;

	private PrintWriter out;


	public SaveCalulations() {
		calculationFile = "CalcHistory.txt";

		try {
			fileOutput = new FileWriter(calculationFile);
			out = new PrintWriter(fileOutput);
			out.println("History");

			out.close();
			fileOutput.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}public void writeResults(String data) {


		try {
			fileOutput = new FileWriter(calculationFile,true);
			out = new PrintWriter(fileOutput);
			out.println(data);

			out.close();
			fileOutput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
