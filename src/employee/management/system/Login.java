package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	JTextField usertext, passtext;
	
	Login(){
		
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40, 20, 100, 30);
		user.setForeground(Color.WHITE);
		add(user);
		
		usertext = new JTextField();
		usertext.setBounds(150, 20, 150, 30);
		add(usertext);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 70, 100, 30);
		pass.setForeground(Color.WHITE);
		add(pass);
		
		passtext = new JTextField();
		passtext.setBounds(150, 70, 150, 30);
		add(passtext);
		
		JButton login = new JButton("LOGIN");
		login.setBounds(150, 140, 150, 30);
		login.setBackground(Color.BLUE);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/management/system/images/imglogin.png"));
		Image img1 = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i1 = new ImageIcon(img1);
		JLabel i2 = new JLabel(i1);
		i2.setBounds(350, 0, 200, 200);
		add(i2);
		
		setSize(600, 300);
		setLocation(450,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			String userid = usertext.getText();
			String userpass = passtext.getText();
			
			DBCon c = new DBCon();
			String query = "Select * From Login where username = '"+userid+"' and password = '"+userpass+"'";
			
			ResultSet rs = c.s.executeQuery(query);
			if(rs.next()) {
				setVisible(false);
				new Home();
			}else {
				JOptionPane.showMessageDialog(null,"Invild username and password");
				setVisible(false);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String args[]) {
		new Login();
	}
}
