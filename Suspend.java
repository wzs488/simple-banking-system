package individuallab;
/**
 *@author PeiZhang
 *@version 1.0
 *Entity Class
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Suspend extends Transaction{
	
	protected static String SUS = "SUSPEND.txt";
	
	public void setSuspend(String id) throws IOException {
		FileWriter userinfo = new FileWriter(id + "/" + SUS);
		userinfo.flush();
		userinfo.close();
	}
	
	public int checkSuspend(String id) throws IOException {
		File file = new File(id);
		File[] files = file.listFiles();
		for (File file1 : files) {

			if (file1.getName().equals("SUSPEND.txt")) {
				return 1;

			}

		}
		return 0;
	}
}
