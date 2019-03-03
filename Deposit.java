package individuallab;
/**
 *@author PeiZhang
 *@version 1.0
 *Entity Class
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Deposit extends Transaction{
	/**
	 * Clear all of checks to balance
	 * @param id
	 * @param type
	 * @param type1
	 * @throws IOException
	 */
	public void setCleared(String id,String type, String type1) throws IOException {
	

		FileReader getfunds = new FileReader(id + "/" + type1);
		BufferedReader bufferedReader = new BufferedReader(getfunds);
		String uncleared = bufferedReader.readLine();

		FileReader getfunds1 = new FileReader(id + "/" + type);
		BufferedReader bufferedReader1 = new BufferedReader(getfunds1);
		String cleared = bufferedReader1.readLine();
		
		Double temp = Double.parseDouble(cleared) + Double.parseDouble(uncleared);
		bufferedReader.close();
		bufferedReader1.close();

		BufferedWriter bufferedWriter2 = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(id + "/" + type1)));
		bufferedWriter2.write(0.0 + "");
		bufferedWriter2.close();

		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(id + "/" + type)));
		bufferedWriter.write(temp + "");
		bufferedWriter.close();

	}
	/**
	 * Deposit money
	 * @param id
	 * @param funds
	 * @param state
	 * @param type
	 * @param type1
	 * @throws IOException
	 */
	public void setDeposit(String id, Double funds, int state, String type,String type1) throws IOException {
		if (state == 1) {
			
			FileReader getfunds = new FileReader(id + "/" + type);
			BufferedReader bufferedReader = new BufferedReader(getfunds);
			String string = bufferedReader.readLine();
			Double temp = Double.parseDouble(string) + funds;
			bufferedReader.close();
			BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(id + "/" + type)));
			bufferedWriter.write(temp + "");
			bufferedWriter.close();

		}

		if (state == 0) {
			
			FileReader getfunds = new FileReader(id + "/" + type1);
			BufferedReader bufferedReader = new BufferedReader(getfunds);
			String string = bufferedReader.readLine();
			Double temp = Double.parseDouble(string) + funds;
			bufferedReader.close();
			BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(id + "/" + type1)));
			bufferedWriter.write(temp + "");
			bufferedWriter.close();
		}

	}
	/**
	 * view how much money you left
	 * @param id
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public float viewFunds(String id, String path) throws IOException {
		FileReader getfunds = new FileReader(id + "/" + path);
		BufferedReader bufferedReader = new BufferedReader(getfunds);
		Float amount = Float.parseFloat(bufferedReader.readLine());
		bufferedReader.close();
		return amount;
	}
}
