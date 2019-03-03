package individuallab;

/**
 *@author PeiZhang
 *@version 1.0
 *Boundary Class
 */
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BankGUI {

	private JFrame frame;
	private JPanel panel;
	private JLabel jLabel;

	BankControl aBankControl = new BankControl();

	/**
	 * Constructor
	 */
	public BankGUI() {
		frame = new JFrame("A Simple Banking System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 700);
		frame.setLocation(500, 200);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	/**
	 * Main window
	 */
	public void enterBank() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 700);

		JButton openButton = new JButton("Open Account");
		openButton.setBounds(300, 250, 200, 50);
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				frame.remove(panel);
				openAccount();

			}
		});

		JButton nextButtion = new JButton("Login");
		nextButtion.setBounds(300, 350, 200, 50);
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(300, 450, 200, 50);

		panel.add(openButton);
		panel.add(nextButtion);
		nextButtion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				frame.remove(panel);
				login();
			}
		});
		panel.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		frame.add(panel);
		frame.setVisible(true);

	}

	/**
	 * Open-Account window
	 */
	public void openAccount() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 700);
		frame.add(panel);
		frame.setVisible(true);

		JLabel jLabeln = new JLabel("Name");
		jLabeln.setBounds(200, 100, 100, 50);
		panel.add(jLabeln);

		JLabel jLabelt = new JLabel("Account Type");
		jLabelt.setBounds(200, 400, 100, 50);
		panel.add(jLabelt);

		JCheckBox sjBox = new JCheckBox("Saver Account");
		sjBox.setBounds(300, 415, 200, 20);

		panel.add(sjBox);

		JCheckBox jjBox = new JCheckBox("Junior Account");
		jjBox.setBounds(300, 465, 200, 20);
		panel.add(jjBox);

		JCheckBox cjBox = new JCheckBox("Current Account");
		cjBox.setBounds(300, 515, 200, 20);
		panel.add(cjBox);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(sjBox);
		buttonGroup.add(jjBox);
		buttonGroup.add(cjBox);

		TextField jTextFieldn = new TextField();
		jTextFieldn.setBounds(300, 115, 200, 20);
		jTextFieldn.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keychar = e.getKeyChar();
				if (keychar >= KeyEvent.VK_A && keychar <= KeyEvent.VK_Z || keychar == KeyEvent.VK_SPACE
						|| keychar >= 97 && keychar <= 122) {

				} else {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(jTextFieldn);

		JLabel jLabela = new JLabel("Address");
		jLabela.setBounds(200, 200, 100, 50);
		panel.add(jLabela);

		TextField jTextFielda = new TextField();
		jTextFielda.setBounds(300, 215, 200, 20);
		jTextFielda.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keychar = e.getKeyChar();
				if (keychar >= KeyEvent.VK_A && keychar <= KeyEvent.VK_Z || keychar == KeyEvent.VK_SPACE
						|| keychar >= 97 && keychar <= 122 || keychar >= 48 && keychar <= 57 || keychar == 44) {

				} else {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(jTextFielda);

		JLabel jLabelb = new JLabel("Birth Date");
		jLabelb.setBounds(200, 300, 100, 50);
		panel.add(jLabelb);

		JTextField showDate = new JTextField("Choose your birth date");
		showDate.setBounds(300, 315, 200, 20);
		showDate.setEditable(false);
		DateChooser dateChooser1 = DateChooser.getInstance("MM/dd/yyyy");
		dateChooser1.register(showDate);
		showDate.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String[] strings = showDate.getText().split("/");
				// System.err.println(strings[2]);
				if (aBankControl.checkDate(strings[2]) != 1) {
					jjBox.setEnabled(false);
				} else
					jjBox.setEnabled(true);

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(showDate);

		JButton sendButton = new JButton("CONFRIM");
		sendButton.setBounds(300, 615, 200, 20);
		panel.add(sendButton);
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jTextFieldn.getText().length() == 0 || jTextFielda.getText().length() == 0
						|| showDate.getText().equals("Choose your birth date")) {
					JOptionPane.showMessageDialog(panel, "Incomplete Information", "PROMPT",
							JOptionPane.INFORMATION_MESSAGE);

				}
				Boolean temp = sjBox.isSelected() || jjBox.isSelected() || cjBox.isSelected();
				if (!temp) {
					JOptionPane.showMessageDialog(panel, "Must choose an account", "PROMPT",
							JOptionPane.INFORMATION_MESSAGE);
				}

				if (jTextFieldn.getText().length() != 0 && jTextFielda.getText().length() != 0
						&& !(showDate.getText().equals("Choose your birth date"))) {
					if (sjBox.isSelected()) {
						try {
							aBankControl.openAccount(jTextFieldn.getText(), jTextFielda.getText(), showDate.getText(),
									SaverAccount.SAVER, SaverAccount.UNCLEARED);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(panel, "Success!", "PROMPT", JOptionPane.INFORMATION_MESSAGE);
						panel.setVisible(false);
						frame.remove(panel);
						enterBank();
					}

					if (jjBox.isSelected()) {
						try {
							aBankControl.openAccount(jTextFieldn.getText(), jTextFielda.getText(), showDate.getText(),
									JuniorAccount.JUNIOR, JuniorAccount.UNCLEARED);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(panel, "Success!", "PROMPT", JOptionPane.INFORMATION_MESSAGE);
						panel.setVisible(false);
						frame.remove(panel);
						enterBank();
					}

					if (cjBox.isSelected()) {
						try {
							aBankControl.openAccount(jTextFieldn.getText(), jTextFielda.getText(), showDate.getText(),
									CurrentAccount.CURRENT, CurrentAccount.UNCLEARED);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(panel, "Success!", "PROMPT", JOptionPane.INFORMATION_MESSAGE);
						panel.setVisible(false);
						frame.remove(panel);
						enterBank();
					}

				}

			}
		});

		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 10, 100, 20);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				frame.remove(panel);
				enterBank();

			}
		});
		panel.add(backButton);

	}

	/**
	 * Login window
	 */
	public void login() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 700);
		frame.add(panel);
		frame.setVisible(true);

		JLabel jLabelname = new JLabel("UserID");
		jLabelname.setBounds(200, 100, 100, 50);
		panel.add(jLabelname);

		TextField jTextFieldn = new TextField();
		jTextFieldn.setBounds(300, 115, 200, 20);
		panel.add(jTextFieldn);

		JLabel jLabelpin = new JLabel("PIN");
		jLabelpin.setBounds(200, 200, 100, 50);
		panel.add(jLabelpin);

		JPasswordField jTextFieldpin = new JPasswordField();
		jTextFieldpin.setBounds(300, 215, 200, 20);
		panel.add(jTextFieldpin);

		JButton nextButton = new JButton("Confirm");
		nextButton.setBounds(300, 400, 200, 50);
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// String type=null;
				// if(jTextFieldn.getText().substring(0, 1).equals("S"))
				// {
				// type=SaverAccount.SAVER
				// }
				if (aBankControl.makeLogin(jTextFieldn.getText(), String.valueOf(jTextFieldpin.getPassword())) == 1) {
					panel.setVisible(false);
					frame.remove(panel);
					try {
						operation(jTextFieldn.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(panel, "Either ID or PIN is incorrect!", "PROMPT",
							JOptionPane.INFORMATION_MESSAGE);
					jTextFieldn.setText("");
					jTextFieldpin.setText("");

				}
			}
		});
		panel.add(nextButton);

		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 10, 100, 20);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				frame.remove(panel);
				enterBank();

			}
		});
		panel.add(backButton);
	}

	/**
	 * Operation window
	 */
	public void operation(String id) throws IOException, ParseException {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 700);
		frame.add(panel);
		frame.setVisible(true);

		if (id.charAt(0) == 'J') {
			jLabel = new JLabel(id + "/$" + aBankControl.viewFunds(id, JuniorAccount.JUNIOR));
			jLabel.setBounds(600, 10, 200, 20);
			panel.add(jLabel);
		}

		if (id.charAt(0) == 'C') {
			jLabel = new JLabel(id + "/$" + aBankControl.viewFunds(id, CurrentAccount.CURRENT));
			jLabel.setBounds(600, 10, 200, 20);
			panel.add(jLabel);
		}

		if (id.charAt(0) == 'S') {
			jLabel = new JLabel(id + "/$" + aBankControl.viewFunds(id, SaverAccount.SAVER));
			jLabel.setBounds(600, 10, 200, 20);
			panel.add(jLabel);
		}

		JButton deposit = new JButton("Deposit Funds");
		deposit.setBounds(300, 115, 200, 50);
		panel.add(deposit);
		deposit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				frame.remove(panel);
				deposit(id);
			}
		});

		JButton clear = new JButton("Clear Funds");
		clear.setBounds(300, 215, 200, 50);
		panel.add(clear);
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (id.charAt(0) == 'S') {
					try {
						aBankControl.setCleared(id, SaverAccount.SAVER, SaverAccount.UNCLEARED);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (id.charAt(0) == 'J') {
					try {
						aBankControl.setCleared(id, JuniorAccount.JUNIOR, JuniorAccount.UNCLEARED);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (id.charAt(0) == 'C') {
					try {
						aBankControl.setCleared(id, CurrentAccount.CURRENT, CurrentAccount.UNCLEARED);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					panel.setVisible(false);
					frame.remove(panel);
					operation(id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Uncleared funds have been credited to the account", "PROMPT",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		JButton withdraw = new JButton("Withdraw Funds");

		withdraw.setBounds(300, 315, 200, 50);
		panel.add(withdraw);

		if (id.charAt(0) == 'S') {
			if ((new SaverAccount()).getDay(id) == 0) {
				withdraw.setText("Waiting");
				withdraw.setEnabled(false);
			}
			if ((new SaverAccount()).getDay(id) == 1) {
				withdraw.setEnabled(true);
			}

		}

		withdraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (id.charAt(0) == 'S') {
					try {
						if ((new SaverAccount()).checkday(id) == 1) {
							JOptionPane.showMessageDialog(panel,
									"Please wait for at least 1 day in order to withdraw funds", "PROMPT",
									JOptionPane.INFORMATION_MESSAGE);
							try {
								(new SaverAccount()).giveDay(id);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							withdraw.setText("Waiting");
							withdraw.setEnabled(false);
						}

						else {

							panel.setVisible(false);
							frame.remove(panel);
							withdraw(id);

						}
					} catch (HeadlessException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					panel.setVisible(false);
					frame.remove(panel);
					withdraw(id);
				}

			}
		});

		JButton suspend = new JButton("Suspend Account");
		if (aBankControl.checkSuspend(id) == 1) {
			deposit.setEnabled(false);
			clear.setEnabled(false);
			withdraw.setEnabled(false);
			suspend.setText("Reinstate");

		}
		suspend.setBounds(300, 415, 200, 50);
		panel.add(suspend);

		suspend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (suspend.getText().equals("Suspend Account")) {
						aBankControl.setSuspend(id);
						deposit.setEnabled(false);
						clear.setEnabled(false);
						withdraw.setEnabled(false);
						JOptionPane.showMessageDialog(panel, "This account has been suspended!", "PROMPT",
								JOptionPane.INFORMATION_MESSAGE);
						suspend.setText("Reinstate");
					} else {
						File path = new File(id + "/" + Suspend.SUS);
						path.delete();
						deposit.setEnabled(true);
						clear.setEnabled(true);
						withdraw.setEnabled(true);
						JOptionPane.showMessageDialog(panel, "This account has been reinstated!", "PROMPT",
								JOptionPane.INFORMATION_MESSAGE);
						suspend.setText("Suspend Account");
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton close = new JButton("Close Account");
		close.setBounds(300, 515, 200, 50);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aBankControl.setClose(new File(id));
				JOptionPane.showMessageDialog(panel, "This account has been closed!", "PROMPT",
						JOptionPane.INFORMATION_MESSAGE);
				panel.setVisible(false);
				frame.remove(panel);
				enterBank();

			}
		});
		panel.add(close);

		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 10, 100, 20);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(panel, "You need to re-paid all debts before leaving the bank!", "PROMPT",
						JOptionPane.INFORMATION_MESSAGE);
				panel.setVisible(false);
				frame.remove(panel);

				login();

			}
		});
		panel.add(backButton);
	}

	/**
	 * Deposit window
	 */
	public void deposit(String id) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 700);
		frame.add(panel);
		frame.setVisible(true);

		JLabel jLabel = new JLabel("Amount");
		jLabel.setBounds(200, 100, 100, 50);
		panel.add(jLabel);

		TextField amount = new TextField();
		amount.setBounds(300, 115, 200, 20);
		panel.add(amount);
		amount.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keychar = e.getKeyChar();
				if (keychar >= 48 && keychar <= 57 || keychar == 46) {

				} else {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel state = new JLabel("State");
		state.setBounds(200, 200, 100, 50);
		panel.add(state);

		JCheckBox clearstate = new JCheckBox("Cleared");
		clearstate.setBounds(300, 215, 200, 20);
		panel.add(clearstate);
		clearstate.setSelected(true);

		JCheckBox unclearstate = new JCheckBox("Uncleared");
		unclearstate.setBounds(300, 265, 200, 20);
		panel.add(unclearstate);

		ButtonGroup aButtonGroup = new ButtonGroup();
		aButtonGroup.add(clearstate);
		aButtonGroup.add(unclearstate);

		JButton deposit = new JButton("Confirm");
		deposit.setBounds(300, 400, 200, 50);
		panel.add(deposit);
		deposit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int temp = 9;
				if (clearstate.isSelected())
					temp = 1;
				if (unclearstate.isSelected())
					temp = 0;
				if (id.charAt(0) == 'S') {
					try {
						aBankControl.setDeposit(id, Double.parseDouble(amount.getText()), temp, SaverAccount.SAVER,
								SaverAccount.UNCLEARED);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (id.charAt(0) == 'J') {
					try {
						aBankControl.setDeposit(id, Double.parseDouble(amount.getText()), temp, JuniorAccount.JUNIOR,
								JuniorAccount.UNCLEARED);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (id.charAt(0) == 'C') {
					try {
						aBankControl.setDeposit(id, Double.parseDouble(amount.getText()), temp, CurrentAccount.CURRENT,
								CurrentAccount.UNCLEARED);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(panel, "The funds have been deposited", "PROMPT",
						JOptionPane.INFORMATION_MESSAGE);
				amount.setText("");

			}
		});

		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 10, 100, 20);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				frame.remove(panel);
				try {
					operation(id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(backButton);

	}

	/**
	 * Withdraw window
	 */
	public void withdraw(String id) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 700);
		frame.add(panel);
		frame.setVisible(true);

		JLabel jLabel = new JLabel("Amount");
		jLabel.setBounds(200, 100, 100, 50);
		panel.add(jLabel);

		TextField amount = new TextField();
		amount.setBounds(300, 115, 200, 20);
		panel.add(amount);
		amount.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keychar = e.getKeyChar();
				if (keychar >= 48 && keychar <= 57 || keychar == 46) {

				} else {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 10, 100, 20);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setVisible(false);
				frame.remove(panel);
				try {
					operation(id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(backButton);

		JButton withdraw = new JButton("Confirm");
		withdraw.setBounds(300, 400, 200, 50);
		panel.add(withdraw);
		withdraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (id.charAt(0) == 'J') {
					try {
						if (aBankControl.addWithdraw(id, amount.getText(), JuniorAccount.JUNIOR, 0) == 1) {
							JOptionPane.showMessageDialog(panel, "$" + amount.getText() + " has been withdrawn!",
									"PROMPT", JOptionPane.INFORMATION_MESSAGE);
							amount.setText("");
						} else {
							JOptionPane.showMessageDialog(panel, "No balance available!", "PROMPT",
									JOptionPane.INFORMATION_MESSAGE);
							amount.setText("");
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (id.charAt(0) == 'C') {
					try {
						if (aBankControl.addWithdraw(id, amount.getText(), CurrentAccount.CURRENT, -1000) == 1) {
							JOptionPane.showMessageDialog(panel, "$" + amount.getText() + " has been withdrawn!",
									"PROMPT", JOptionPane.INFORMATION_MESSAGE);
							amount.setText("");
						} else {
							JOptionPane.showMessageDialog(panel, "Exceeding overdraft limit! ", "PROMPT",
									JOptionPane.INFORMATION_MESSAGE);
							amount.setText("");
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (id.charAt(0) == 'S') {
					try {
						if (aBankControl.addWithdraw(id, amount.getText(), SaverAccount.SAVER, 0) == 1) {
							JOptionPane.showMessageDialog(panel, "$" + amount.getText() + " has been withdrawn!",
									"PROMPT", JOptionPane.INFORMATION_MESSAGE);
							amount.setText("");
						} else {
							JOptionPane.showMessageDialog(panel, "No balance available!", "PROMPT",
									JOptionPane.INFORMATION_MESSAGE);
							amount.setText("");
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					BufferedWriter clean = null;
					try {
						clean = new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream(id + "/" + SaverAccount.TIME)));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						clean.write("1");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						clean.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
	}
}
