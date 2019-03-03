package individuallab;
/**
 *@author PeiZhang
 *@version 1.0
 *Entity Class
 */
import java.io.File;

public class Close extends Transaction{
	/**
	 * Close an account
	 * @param path
	 */
	public void setClose(File path) {
		if (path.isFile()) {
			path.delete();
			return;
		}
		File[] paths = path.listFiles();
		for (int i = 0; i < paths.length; i++) {
			setClose(paths[i]);
		}
		path.delete();
	}
}
