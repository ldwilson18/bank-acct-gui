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

public class AccessAccount extends JPanel
{
private ArrayList <BankAccount> bank;
public AccessAccount(ArrayList <BankAccount> bank)
{
	this.bank = bank;
	setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 0;
	JLabel name = new JLabel("Name: ");
	add(name, gbc);
	gbc.gridx = 1;
	gbc.gridy = 0;
	JTextField txtName = new JTextField("");
	txtName.setPreferredSize(new Dimension(180,30));
	add(txtName,gbc);
	gbc.gridx = 0;
	gbc.gridy = 1;
	JButton sub = new JButton("Submit");
	add(sub,gbc);
	JLabel accData = new JLabel("");
	sub.addActionListener(new ActionListener()
	{
		String accts = "";
		public void actionPerformed(ActionEvent e)
		{
			for(int i = 0; i < bank.size(); i++)
			{
				if(!bank.get(i).getName().equals(txtName.getText())|| txtName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Sorry, try again!", "error", JOptionPane.ERROR_MESSAGE);
				}
				else if( bank.get(i).getName().equals(txtName.getText()))
				{
					accts += bank.get(i).toString();
				}
			}
			accData.setText(accts);
			JOptionPane.showMessageDialog(null, accts, "Accounts", JOptionPane.PLAIN_MESSAGE);
		}
	});
setVisible(true);
}
}
