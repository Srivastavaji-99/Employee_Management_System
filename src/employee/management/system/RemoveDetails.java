package employee.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.sql.ResultSet;
import java.awt.Choice;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class RemoveDetails extends JFrame implements ActionListener {
	
	JLabel empId, name, phone, email, lblname, lblphone, lblemail;
	Choice lblempId;
	JButton delete, back;
	String empIdValue;
	RemoveDetails(){
		setTitle("Remove Employee Details");
		setSize(1100, 650);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JLabel header = new JLabel("Remove Employee Details");
		header.setFont(new Font("Seoge UI", Font.BOLD, 26));
		header.setForeground(Color.WHITE);
		header.setBorder(new EmptyBorder(20,30,20,30));
		add(header, BorderLayout.NORTH);
		
		JPanel main = new JPanel(new BorderLayout());
		main.setBackground(new Color(18,18,18));
		add(main, BorderLayout.CENTER);
		
		JPanel form = new JPanel(new GridBagLayout());
		form.setForeground(Color.WHITE);
		form.setBackground(new Color(18,18,18));
		form.setBorder(new EmptyBorder(20,30,20,30));
		main.add(form, BorderLayout.CENTER);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		
		empId = new JLabel("Employee Id");
		empId.setFont(new Font("Seoge UI", Font.PLAIN, 20));
		empId.setForeground(Color.WHITE);
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    form.add(empId, gbc);
	    
	    lblempId = new Choice();
	    lblempId.setFont(new Font("Seoge UI", Font.PLAIN, 20));
	    lblempId.setForeground(Color.BLACK);
	    gbc.gridx = 1;
	    form.add(lblempId, gbc);
	    
	    try {
	    	
	    	DBCon c = new DBCon();
	    	String query = "select * from Empdetails";
	    	ResultSet rs = c.s.executeQuery(query);
	    	while(rs.next()) {
	    		lblempId.add(rs.getString("empId"));
	    	}
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
		name = new JLabel("Name");
	    name.setFont(new Font("Seoge UI", Font.PLAIN, 20));
	    name.setForeground(Color.WHITE);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    form.add(name, gbc);
	    
	    lblname = new JLabel();
	    lblname.setFont(new Font("Seoge UI", Font.PLAIN, 20));
	    lblname.setForeground(Color.WHITE);
	    gbc.gridx = 1;
	    form.add(lblname, gbc);
	    
	    phone = new JLabel("Phone No");
	    phone.setFont(new Font("Seoge UI", Font.PLAIN, 20));
	    phone.setForeground(Color.WHITE);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    form.add(phone, gbc);
	    
	    lblphone = new JLabel();
	    lblphone.setFont(new Font("Seoge UI", Font.PLAIN, 20));
	    lblphone.setForeground(Color.WHITE);
	    gbc.gridx = 1;
	    form.add(lblphone, gbc);
	    
	    email = new JLabel("Email Id");
	    email.setFont(new Font("Seoge UI", Font.PLAIN, 20));
	    email.setForeground(Color.WHITE);
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    form.add(email, gbc);
	    
	    lblemail = new JLabel();
	    lblemail.setFont(new Font("Seoge UI", Font.PLAIN, 20));
	    lblemail.setForeground(Color.WHITE);
	    gbc.gridx = 1;
	    form.add(lblemail, gbc);
	    
	    gbc.gridy = 1;
	    
          try {
	    	
	        	DBCon c = new DBCon();
	    	    String query = "select * from Empdetails where empId = '"+lblempId.getSelectedItem()+"'";
	    	    ResultSet rs = c.s.executeQuery(query);
	    	    while(rs.next()) {
	    		      lblname.setText(rs.getString("name"));
	    		      lblphone.setText(rs.getString("phone"));
	    		      lblemail.setText(rs.getString("email"));
	    	    }
	    	
	          }catch(Exception e) {
	    	        e.printStackTrace();
	          }
	     
	    JPanel button = new JPanel();
		button.setBackground(new Color(18,18,18));
		
		delete = new JButton("Delete");
		delete.setForeground(Color.white);
		delete.setBackground(new Color(124,58,237));
		delete.addActionListener(this);
		delete.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		button.add(delete);
		
		back = new JButton("Back");
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBackground(new Color(245,158,11));
		back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		button.add(back);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		form.add(button, gbc);
		
		JPanel image = new JPanel();
		image.setBackground(new Color(37,37,37));
		image.setBorder(new EmptyBorder(20,20,20,20));
		main.add(image, BorderLayout.EAST);
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("employee/management/system/images/remove 2.jfif"));
		Image img = icon.getImage().getScaledInstance(550,450, Image.SCALE_SMOOTH);
		image.add(new JLabel(new ImageIcon(img)));
		
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
	}
	
	public void actionitemEvent() {
//		lblempId.addItemListener(lblempId)
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == delete) {
			
		}else if(ae.getSource() == back) {
			setVisible(false);
			new Home();
		}
	   	
	}
	
	public static void main(String args[]) {
		new RemoveDetails();
	}

}
