import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transaction extends JPanel
{
private  ArrayList <BankAccount> bank;
public Transaction(ArrayList <BankAccount> bank)
{
	this.bank = bank;
	setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel deposit = new JLabel("Deposit amount: ");
	add(deposit,gbc);
	gbc.gridx= 1;
	gbc.gridy= 0;
	JTextField txtDep = new JTextField("");
	txtDep.setPreferredSize(new Dimension(180,30));
	add(txtDep,gbc);
	gbc.gridx = 0;
	gbc.gridy = 1;
	JLabel accNumDep = new JLabel("Deposit account number: ");
	add(accNumDep,gbc);
	gbc.gridx = 1;
	gbc.gridy = 1;
	JTextField txtNumDep = new JTextField("");
	txtNumDep.setPreferredSize(new Dimension(180,30));
	add(txtNumDep,gbc);
	gbc.gridx = 1;
	gbc.gridy= 2;
	JButton fin =new JButton("Submit");
	add(fin,gbc);
	JLabel nuBal = new JLabel("");
	JLabel nuNum = new JLabel("");
	fin.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			
		if(!BankAccount.isNumeric(txtNumDep.getText())||!BankAccount.isNumeric(txtDep.getText()))
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
		else if(!numCheck(bank, txtNumDep.getText()))
		{
			JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
		}
		else if(txtNumDep.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
		else if(txtDep.getText().equals(""))
			{
			JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
		else if(Integer.parseInt(txtNumDep.getText()) != bank.get(Integer.parseInt(txtNumDep.getText())).getAccountNumber())
		{
			JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
		}
		else if(Integer.parseInt(txtNumDep.getText()) != bank.get(Integer.parseInt(txtNumDep.getText())).getAccountNumber())
		{
			JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
		}
			else 
				{
					bank.get(Integer.parseInt(txtNumDep.getText())).deposit(Double.parseDouble(txtDep.getText()));
					nuBal.setText(Double.toString(bank.get(Integer.parseInt(txtNumDep.getText())).getBalance()));
					nuNum.setText(Integer.toString(bank.get(Integer.parseInt(txtNumDep.getText())).getAccountNumber()));
					JOptionPane.showMessageDialog(null, "Deposit Complete" + "\n" + "Bank account number " + nuNum.getText() + " has a new balance of " + nuBal.getText(), "Completed", JOptionPane.PLAIN_MESSAGE);
				}
			
		}
		});
	
	
	
	
	
	
}
private static boolean numCheck(ArrayList <BankAccount> bnk, String str)
{
	for(BankAccount acc : bnk)
	{
		if(acc.getAccountNumber() == Integer.parseInt(str))
		{
			return true;
		}
	}
	return false;
}
}