import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel
{

	
		public Home()
		{
			setBounds(200,200,100,100);
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			BufferedImage bankpic = null;
			try 
			{
				bankpic = ImageIO.read(new File("lukewilsonwrestling2_LI.jpg"));
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
			gbc.gridx = 0;
			gbc.gridy = 0;
			JLabel home = new JLabel(new ImageIcon(bankpic));
			add(home,gbc);
			gbc.gridx = 2;
			gbc.gridy = 0;
			JLabel title = new JLabel("Welcome to Luke's Bank");
			title.setPreferredSize(new Dimension(300,70));
			add(title,gbc);
			setVisible(true);
		}
		
}
