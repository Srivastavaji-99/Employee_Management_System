package employee.management.system;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
	
	JButton add, view, remove, update, back;
	
	Home() {
		setLayout(null);
		
		ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("employee/management/system/images/homepage.jfif"));
		Image i2 = i.getImage().getScaledInstance(1120, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1120, 600);
		add(image);
		
		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(650, 40, 400, 40);
		heading.setFont(new Font("Raleway", Font.BOLD, 25));
		image.add(heading);
		
		add = new JButton("Add Employee");
		add.setBounds(650, 80, 150, 40);
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.addActionListener(this);
		image.add(add);
		
		view = new JButton("Employee Details");
		view.setBounds(860, 80, 150, 40);
		view.setBackground(Color.BLACK);
		view.setForeground(Color.WHITE);
		view.addActionListener(this);
		image.add(view);
		
		remove = new JButton("Remove Employee");
		remove.setBounds(650, 140, 150, 40);
		remove.setBackground(Color.BLACK);
		remove.addActionListener(this);
		remove.setForeground(Color.WHITE);
		image.add(remove);
		
		update = new JButton("Update Employee");
		update.setBounds(860, 140, 150, 40);
		update.setBackground(Color.BLACK);
		update.addActionListener(this);
		update.setForeground(Color.WHITE);
		image.add(update);
		
		back = new JButton("Back");
		back.setBounds(750, 200, 150, 40);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		image.add(back);
		
		
		setSize(1120, 600);
		setLocation(180, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == add) {
			
		}else if(ae.getSource() == view) {
			
		}else if(ae.getSource() == remove) {
			
		}else if(ae.getSource() == update) {
			
		}else {
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String args[]) {
		new Home();
	}

}
