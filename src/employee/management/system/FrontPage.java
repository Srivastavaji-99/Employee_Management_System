package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontPage extends JFrame implements ActionListener{
	
	FrontPage(){
		
		//getContentPane select all frame.
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);  // i don't want default layout.
		
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("employee/management/system/images/firstPage.jfif"));
		Image i1 = image1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i1);
		JLabel image = new JLabel(i2);
		image.setBounds(50, 100, 1050, 450);
		add(image);
		
		JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
		clickhere.setBounds(800, 380, 240, 60);
		clickhere.setBackground(Color.BLACK);
		clickhere.setForeground(Color.WHITE);
		clickhere.addActionListener(this);
		image.add(clickhere);
 		
		JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		heading.setBounds(60, 20, 1200, 60);
		heading.setFont(new Font("serif", Font.PLAIN, 60));
		heading.setForeground(Color.GREEN);
		add(heading);
		
		//give size and location for frame
		setSize(1160, 650);
		setLocation(135, 50);
		setVisible(true);
		
		while(true) {
			heading.setVisible(false);
			try {
				Thread.sleep(400);
			}catch(Exception e) {
				
			}
			
			heading.setVisible(true);
			try {
				Thread.sleep(400);
			}catch(Exception e) {
				
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
	
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) {
		new FrontPage();
	}
}
