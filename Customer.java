package individuallab;
/**
 *@author PeiZhang
 *@version 1.0
 *Entity Class
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Customer {
	protected String name;
	protected String address;
	protected String birth;
	protected String type;
	protected static String USERINFO = "USER.txt";
	/**
	 * Set user's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Set user's address
	 * @param address
	 */
	public void setAddr(String address) {
		this.address = address;
	}
	/**
	 * Set user's birthday
	 * @param birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * Set user's type of account
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return user's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * @return user's address
	 */
	public String getAddr() {
		return this.address;
	}

	/**
	 * 
	 * @return user's birth
	 */
	public String getBirth() {
		return this.birth;
	}

	/**
	 * 
	 * @return user's type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * user logins into account
	 * @param id
	 * @param pin
	 * @return whether login successfully
	 */
	public int login(String id, String pin) {

		try {
			FileReader userlogin = new FileReader(id + "/" + Customer.USERINFO);
			BufferedReader bufferedReader = new BufferedReader(userlogin);
			String[] strings = bufferedReader.readLine().split(",");
			if (pin.equals(strings[1])) {
				System.err.println(strings[0] + "," + strings[1]);
				bufferedReader.close();
				return 1;
			}

			else {
				bufferedReader.close();
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("404");
		}
		return 0;
	}
	/**
	 * user opens account
	 * @param name
	 * @param addr
	 * @param date
	 * @param type
	 * @param type1
	 * @throws IOException
	 */
	public void openAccount(String name, String addr, String date, String type, String type1) throws IOException {
		String idnumber=null;
		
		idnumber = type.substring(0, 1) + String.valueOf(Calendar.getInstance().getTimeInMillis());

		String pin = String.valueOf(Calendar.getInstance().getTimeInMillis()).substring(4, 8);

		File file = new File(idnumber);
		file.mkdirs();
		
		FileWriter time = new FileWriter(idnumber + "/" + SaverAccount.TIME);
		time.flush();
		time.close();
		BufferedWriter clean = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(idnumber + "/" + SaverAccount.TIME)));
		clean.write("1");
		clean.close();

		FileWriter userinfo = new FileWriter(idnumber + "/" + Customer.USERINFO);
		userinfo.flush();
		userinfo.close();

		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(idnumber + "/" + Customer.USERINFO, true)));
		bufferedWriter.write(idnumber + "," + pin + "\n");

		bufferedWriter.write(name + "," + addr + "," + date + "\n");

		bufferedWriter.close();

		FileWriter saver = new FileWriter(idnumber + "/" + type);
		BufferedWriter bufferedWriter1 = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(idnumber + "/" + type)));
		bufferedWriter1.write(0.0 + "");
		bufferedWriter1.close();
		saver.flush();
		saver.close();

		FileWriter saver1 = new FileWriter(idnumber + "/" + type1);
		BufferedWriter bufferedWriter2 = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(idnumber + "/" + type1)));
		bufferedWriter2.write(0.0 + "");
		bufferedWriter2.close();
		saver1.flush();
		saver1.close();
	}
	/**
	 * check date
	 * @param string
	 * @return
	 */
	public int checkDate(String string) {
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String[] strings = df.format(day).split("/");
		if (Integer.parseInt(strings[2]) - Integer.parseInt(string) <= 16) {
			return 1;
		} else
			return 0;
	}
	

}
