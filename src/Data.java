import java.util.ArrayList;
import java.util.Arrays;

public class Data {



	private int num;
	private String labelName;
	private ArrayList<String> sensorData;



	public Data(int num, String labelName, ArrayList<String> sensorData) {
		this.num = num;
		this.labelName = labelName;
		this.sensorData = sensorData;


	}

	public Data(int num, String labelName, int sensorData) {
		this.num = num;
		this.labelName = labelName;
		this.sensorData = new ArrayList<String>(sensorData);
	}


	public Data(int num, String labelName, String sensorData) {
		this.num = num;
		this.labelName = labelName;
		this.sensorData = new ArrayList<String>(Integer.parseInt(sensorData));
	}
}
