package individuallab;

import java.io.File;
/**
 *@author PeiZhang
 *@version 1.0
 *Entity Class
 */
import java.io.IOException;

public class BankAccount {

	Transaction aTransaction = new Transaction();
	Deposit aDeposit = new Deposit();
	Suspend aSuspend = new Suspend();
	Close aClose = new Close();
	Withdrawl aWithdrawl = new Withdrawl();

	/**
	 * 
	 * @return a SaverAccount object
	 */
	public SaverAccount retSaver() {
		return new SaverAccount();
	}

	/**
	 * 
	 * @param path
	 */
	public void setClose(File path) {
		aClose.setClose(path);
	}

	/**
	 * Suspend the account
	 * @param id
	 * @throws IOException
	 */
	public void setSuspend(String id) throws IOException {
		aSuspend.setSuspend(id);
	}

	/**
	 * Check whether the account is suspended
	 * 
	 * @param id
	 * @return whether the account is suspended
	 * @throws IOException
	 */
	public int checkSuspend(String id) throws IOException {
		int ret = aSuspend.checkSuspend(id);
		return ret;
	}

	/**
	 * Add balance or check
	 * @param id
	 * @param funds
	 * @param state
	 * @param type
	 * @param type1
	 * @throws IOException
	 */
	public void setDeposit(String id, Double funds, int state, String cleared, String uncleared) throws IOException {
		aDeposit.setDeposit(id, funds, state, cleared, uncleared);
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
		aDeposit.setCleared(id, cleared, uncleared);
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
		int ret = aWithdrawl.addWithdraw(id, funds, cleared, overdraft);
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
		float ret = aDeposit.viewFunds(id, path);
		return ret;
	}

}
