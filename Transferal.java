import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transferal extends JPanel
{
private ArrayList <BankAccount> bank;
	public Transferal(ArrayList <BankAccount> bank)
	{
		this.bank = bank;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel amtTrans = new JLabel("Transfer Amount: ");
		add(amtTrans,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		JTextField txtAmt = new JTextField("");
		txtAmt.setPreferredSize(new Dimension(90,30));
		add(txtAmt,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel accNum = new JLabel("Account Number you are Transfering From: ");
		add(accNum,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		JTextField txtAccNum = new JTextField("");
		txtAccNum.setPreferredSize(new Dimension(90,30));
		add(txtAccNum,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel accNum2 = new JLabel("Account Number you are Transfering To: ");
		add(accNum2,gbc);
		JTextField txtAccNum2 = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 2;
		txtAccNum2.setPreferredSize(new Dimension(90,30));
		add(txtAccNum2,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		JButton enter = new JButton("submit");
		add(enter,gbc);
		JLabel amt = new JLabel();
		JLabel acct1 = new JLabel();
		JLabel acct2 = new JLabel();
		
		
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			if(Integer.parseInt(txtAccNum.getText()) >= bank.size())
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
			else if(Integer.parseInt(txtAccNum2.getText()) >= bank.size())
			{
				JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				bank.get(Integer.parseInt(txtAccNum.getText())).transfer(bank.get(Integer.parseInt(txtAccNum2.getText())), Double.parseDouble(txtAmt.getText()));
				amt.setText(txtAmt.getText());
				acct1.setText(txtAccNum.getText());
				acct2.setText(txtAccNum2.getText());
				JOptionPane.showMessageDialog(null, "Transfer Completed" + "\n" + amt.getText() + " has been transfered from account number " + acct1.getText() + " to " + acct2.getText(), "Completed", JOptionPane.PLAIN_MESSAGE);
				
			}
			
			}
		});
		setVisible(true);
	}
}
