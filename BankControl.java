package individuallab;

/**
 *@author PeiZhang
 *@version 1.0
 *Control Class Class
 */
import java.io.File;
import java.io.IOException;

public class BankControl {
	Customer aCustomer = new Customer();
	BankAccount aBankAccount = new BankAccount();

	/**
	 * Login system
	 * 
	 * @param id
	 * @param pin
	 * @return whether login is successful
	 */
	public int makeLogin(String id, String pin) {
		int ret = aCustomer.login(id, pin);
		return ret;
	}

	/**
	 * 
	 * @param path
	 */
	public void setClose(File path) {
		aBankAccount.setClose(path);
	}

	/**
	 * Suspend the account
	 * 
	 * @param id
	 * @throws IOException
	 */
	public void setSuspend(String id) throws IOException {
		aBankAccount.setSuspend(id);
	}

	/**
	 * Check whether the account is suspended
	 * 
	 * @param id
	 * @return whether the account is suspended
	 * @throws IOException
	 */
	public int checkSuspend(String id) throws IOException {
		int ret = aBankAccount.checkSuspend(id);
		return ret;
	}

	/**
	 * Add balance or check
	 * 
	 * @param id
	 * @param funds
	 * @param state
	 * @param type
	 * @param type1
	 * @throws IOException
	 */
	public void setDeposit(String id, Double funds, int state, String cleared, String uncleared) throws IOException {
		aBankAccount.setDeposit(id, funds, state, cleared, uncleared);
	}

	/**
	 * Clear check to balance
	 * 
	 * @param id
	 * @param cleared
	 * @param uncleared
	 * @throws IOException
	 */
	public void setCleared(String id, String cleared, String uncleared) throws IOException {
		aBankAccount.setCleared(id, cleared, uncleared);
	}

	/**
	 * Withdraw money
	 * 
	 * @param id
	 * @param funds
	 * @param type
	 * @param overDraft
	 * @return whether withdraw money successfully
	 * @throws IOException
	 */
	public int addWithdraw(String id, String funds, String cleared, int overdraft) throws IOException {
		int ret = aBankAccount.addWithdraw(id, funds, cleared, overdraft);
		return ret;
	}

	/**
	 * View how much money left
	 * 
	 * @param id
	 * @param path
	 * @return whether view money successfully
	 * @throws IOException
	 */
	public float viewFunds(String id, String path) throws IOException {
		float ret = aBankAccount.viewFunds(id, path);
		return ret;
	}

	/**
	 * check date
	 * 
	 * @param string
	 * @return
	 */
	public int checkDate(String date) {
		int ret = aCustomer.checkDate(date);
		return ret;
	}

	/**
	 * user opens account
	 * 
	 * @param name
	 * @param addr
	 * @param date
	 * @param type
	 * @param type1
	 * @throws IOException
	 */
	public void openAccount(String name, String addr, String date, String cleared, String uncleared) throws IOException {
		aCustomer.openAccount(name, addr, date, cleared, uncleared);
	}
}
