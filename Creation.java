import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Creation extends JPanel
{
	
private ArrayList<BankAccount> bank;

	public Creation(ArrayList <BankAccount> bank)
	{
		this.bank = bank;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel name = new JLabel("Name:  ");
		add(name,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel deposit = new JLabel("Initial deposit: ");
		add(deposit,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel acct = new JLabel("Account Type: ");
		add(acct,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		JTextField txtName =  new JTextField("");
		txtName.setPreferredSize(new Dimension(180,30));
		add(txtName,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		JTextField txtDeposit = new JTextField("");
		txtDeposit.setPreferredSize(new Dimension(180,30));
		add(txtDeposit,gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		String [] arr = {"Checking Account","Savings Account"};
		JList list = new JList(arr);
		add(list,gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		JButton sub = new JButton("Submit");
		add(sub,gbc);
		JLabel disName = new JLabel("");
		JLabel disNum = new JLabel("");
		JLabel disBal = new JLabel("");
		sub.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!BankAccount.isNumeric(txtDeposit.getText()))
				{
					JOptionPane.showMessageDialog(null, "Sorry, try again", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(txtDeposit.getText().equals("") || txtName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Sorry, try again", "Error", JOptionPane.ERROR_MESSAGE);
				}
							
				else if(list.getSelectedIndex() == 0)
				{
					bank.add(new CheckingAccount(txtName.getText(),Double.parseDouble(txtDeposit.getText()),5,5,5));
					disName.setText(txtName.getText());
					disNum.setText(Integer.toString(bank.get(bank.size()-1).getAccountNumber()));
					disBal.setText(txtDeposit.getText());
					txtName.setText("");
					txtDeposit.setText("");
					JOptionPane.showMessageDialog(null, "Account name: " + disName.getText() + "\n" + "Account number: " + disNum.getText() + "\n" + "Opening Balance: " + disBal.getText(), "Account", JOptionPane.PLAIN_MESSAGE);
				}
				else if(list.getSelectedIndex() == 1)
				{
					bank.add(new SavingsAccount(txtName.getText(),Double.parseDouble(txtDeposit.getText()),5,5,5));
					disName.setText(txtName.getText());
					disNum.setText(Integer.toString(bank.get(bank.size()-1).getAccountNumber()));
					disBal.setText(txtDeposit.getText());
					txtName.setText("");
					txtDeposit.setText("");
					JOptionPane.showMessageDialog(null, "Account name: " + disName.getText() + "\n" + "Account number: " + disNum.getText() + "\n" + "Opening Balance: " + disBal.getText(), "Account", JOptionPane.PLAIN_MESSAGE);
				}
						
			}

			
			
		});
		
		setVisible(true);		
		
		

	}
	

}
