package individuallab;
/**
 *@author PeiZhang
 *@version 1.0
 *One of subclasses of BankAccount
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class SaverAccount extends BankAccount {
	protected static String SAVER = "SAVER.txt";
	protected static String UNCLEARED = "UNCLEARED.txt";
	protected static String TIME = "TIME.txt";

	public void giveDay(String id) throws IOException {
		Date date=new Date();
		String day = String.valueOf(date.getTime());
		BufferedWriter bufferedWriter1 = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(id + "/" + SaverAccount.TIME)));
		bufferedWriter1.write(day);
		bufferedWriter1.close();

	}
	
	public int getDay(String id) throws IOException, ParseException {

		FileReader getday = new FileReader(id + "/" + SaverAccount.TIME);
		BufferedReader bufferedReader = new BufferedReader(getday);

		double lastday = Double.parseDouble((bufferedReader.readLine()));
		double nowday = Double.parseDouble(String.valueOf(Calendar.getInstance().getTimeInMillis()));

		bufferedReader.close();
		if ((nowday - lastday) / 86400000 >= 1) {

			return 1;
		} else {

			bufferedReader.close();

			return 0;
		}
	}
	
	public int checkday(String id) throws IOException {
		FileReader getday = new FileReader(id + "/" + SaverAccount.TIME);
		BufferedReader bufferedReader = new BufferedReader(getday);

		String temp = bufferedReader.readLine();
		bufferedReader.close();
		System.err.println(temp);

		if (temp.equals("1")) {
			System.err.println(temp);
			return 1;
		}

		else
			return 0;
	}

}
