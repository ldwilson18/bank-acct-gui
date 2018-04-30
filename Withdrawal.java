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

public class Withdrawal extends JPanel
{
	private ArrayList <BankAccount> bank;
public Withdrawal(ArrayList <BankAccount> bank)
{
	this.bank = bank;
	setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel withdraw = new JLabel("Withdraw amount:  ");
	add(withdraw,gbc);
	gbc.gridx=1;
	gbc.gridy=0;
	JTextField txtWith = new JTextField("");
	txtWith.setPreferredSize(new Dimension(180,30));
	add(txtWith,gbc);
	gbc.gridx = 0;
	gbc.gridy = 1;
	JLabel accNumWith = new JLabel("Withdrawal account number: ");
	add(accNumWith,gbc);
	gbc.gridx = 1;
	gbc.gridy = 1;
	JTextField txtNumWith = new JTextField("");
	txtNumWith.setPreferredSize(new Dimension(180,30));
	add(txtNumWith,gbc);
	gbc.gridx = 0;
	gbc.gridy = 2;
	JButton fin =new JButton("Submit");
	add(fin,gbc);
	JLabel nuBal = new JLabel("");
	JLabel nuNum = new JLabel("");
	fin.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		for(int i = 0; i<bank.size(); i++)
			{
			if(!BankAccount.isNumeric(txtNumWith.getText())|| !BankAccount.isNumeric(txtWith.getText()))
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
			else if( txtNumWith.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
			else if(txtWith.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
			else if(Integer.parseInt(txtNumWith.getText()) != bank.get(i).getAccountNumber())
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(Integer.parseInt(txtNumWith.getText()) == bank.get(i).getAccountNumber())
				{
					bank.get(i).withdraw(Double.parseDouble(txtWith.getText()));
					nuBal.setText(Double.toString(bank.get(i).getBalance()));
					nuNum.setText(Integer.toString(bank.get(i).getAccountNumber()));
					JOptionPane.showMessageDialog(null, "Withdrawal Complete" + "\n" + "Bank account number " + nuNum.getText() + " has a new balance of " + nuBal.getText(), "Completed", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		}
		});
	setVisible(true);
}

}
