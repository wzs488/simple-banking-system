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

public class Withdrawl extends Transaction {
	/**
	 * Withdraw money from balance
	 * @param id
	 * @param funds
	 * @param type
	 * @param overDraft
	 * @return
	 * @throws IOException
	 */
	public int addWithdraw(String id, String funds,String type,int overDraft) throws IOException {
		FileReader getfunds = new FileReader(id + "/" + type);
		BufferedReader bufferedReader = new BufferedReader(getfunds);
		Float amount = Float.parseFloat(bufferedReader.readLine());
		Float balance = amount - Float.parseFloat(funds);
		bufferedReader.close();

		if (balance >= overDraft) {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(id + "/" + type)));
			bufferedWriter.write(balance + "");
			bufferedWriter.close();
			return 1;
		} else {
			return 0;
		}

	}

}
