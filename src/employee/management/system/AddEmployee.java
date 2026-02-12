package employee.management.system;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {
	
	Random r = new Random();
	int value = r.nextInt(999999);
	
	JLabel header, name, empidbox, fname, dob, salary, address, phone, email, education, desig, adhar, empid;
	JTextField namebox, fnamebox, salarybox, addressbox, phonebox, emailbox, desigbox, adharbox;
	JButton submit, back;
	JDateChooser dobbox;
	JComboBox educationbox;
	
	AddEmployee(){
		setLayout(null);
		
		header = new JLabel("New Employee Details");
		header.setBounds(280, 40, 250, 40);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Raleway", Font.PLAIN, 20));
		add(header);
		
		name = new JLabel("Employee Name");
		name.setFont(new Font("Raleway", Font.PLAIN, 15));
		name.setBounds(60, 100, 150, 30);
		name.setForeground(Color.WHITE);
		add(name);
		
		namebox = new JTextField();
		namebox.setBounds(170, 100, 150, 30);
		add(namebox);
		
		fname = new JLabel("Father Name");
		fname.setFont(new Font("Raleway", Font.PLAIN, 15));
		fname.setBounds(400, 100, 150, 30);
		fname.setForeground(Color.WHITE);
		add(fname);
		
		fnamebox = new JTextField();
		fnamebox.setBounds(500, 100, 150, 30);
		add(fnamebox);
		
		dob = new JLabel("Date Of Birth");
		dob.setFont(new Font("Raleway", Font.PLAIN, 15));
		dob.setBounds(60, 160, 150, 30);
		dob.setForeground(Color.WHITE);
		add(dob);
		
		dobbox = new JDateChooser();
		dobbox.setBounds(170, 160, 150, 30);
		add(dobbox);
		
		salary = new JLabel("Salary");
		salary.setFont(new Font("Raleway", Font.PLAIN, 15));
		salary.setBounds(400, 160, 150, 30);
		salary.setForeground(Color.WHITE);
		add(salary);
		
		salarybox = new JTextField();
		salarybox.setBounds(500, 160, 150, 30);
		add(salarybox);
		
		address = new JLabel("Address");
		address.setFont(new Font("Raleway", Font.PLAIN, 15));
		address.setBounds(60, 220, 150, 30);
		address.setForeground(Color.WHITE);
		add(address);
		
		addressbox = new JTextField();
		addressbox.setBounds(170, 220, 150, 30);
		add(addressbox); 
		
		phone = new JLabel("Phone");
		phone.setFont(new Font("Raleway", Font.PLAIN, 15));
		phone.setBounds(400, 220, 150, 30);
		phone.setForeground(Color.WHITE);
		add(phone);
		
		phonebox = new JTextField();
		phonebox.setBounds(500, 220, 150, 30);
		add(phonebox);
		
		email = new JLabel("Email Id");
		email.setFont(new Font("Raleway", Font.PLAIN, 15));
		email.setBounds(60, 280, 150, 30);
		email.setForeground(Color.WHITE);
		add(email);
		
		emailbox = new JTextField();
		emailbox.setBounds(170, 280, 150, 30);
		add(emailbox);
		
		education = new JLabel("Education");
		education.setFont(new Font("Raleway", Font.PLAIN, 15));
		education.setBounds(400, 280, 150, 30);
		education.setForeground(Color.WHITE);
		add(education);
		
		String comboeducation[] = {"BCA","MCA","B.Tech","MBA","B.Com","M.Tech","MBA","BSC","M.Com"}; 
		educationbox = new JComboBox(comboeducation);
		educationbox.setBounds(500, 280, 150, 30);
		add(educationbox);
		
		desig = new JLabel("Designation");
		desig.setFont(new Font("Raleway", Font.PLAIN, 15));
		desig.setBounds(60, 340, 150, 30);
		desig.setForeground(Color.WHITE);
		add(desig);
		
		desigbox = new JTextField();
		desigbox.setBounds(170, 340, 150, 30);
		add(desigbox);
		
		adhar = new JLabel("Adhar No");
		adhar.setFont(new Font("Raleway", Font.PLAIN, 15));
		adhar.setBounds(400, 340, 150, 30);
		adhar.setForeground(Color.WHITE);
		add(adhar);
		
		adharbox = new JTextField();
		adharbox.setBounds(500, 340, 150, 30);
		add(adharbox);
		
		empid = new JLabel("Employee Id");
		empid.setFont(new Font("Raleway", Font.PLAIN, 15));
		empid.setBounds(60, 400, 150, 30);
		empid.setForeground(Color.WHITE);
		add(empid);
		
		empidbox = new JLabel("" +value);
		empidbox.setFont(new Font("Raleway", Font.PLAIN, 15));
		empidbox.setBounds(170, 400, 150, 30);
		empidbox.setForeground(Color.WHITE);
		add(empidbox);
		
		submit = new JButton("Submit");
		submit.setBounds(250, 460, 150, 30);
		submit.addActionListener(this);
		submit.setForeground(Color.BLACK);
		submit.setBackground(Color.BLUE);
		add(submit);
		
		back = new JButton("Back");
		back.setBounds(450, 460, 150, 30);
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.RED);
		add(back);
		
		
		getContentPane().setBackground(Color.BLACK);
		setSize(850, 600);
		setLocation(250, 80);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			String name = namebox.getText();
			String fname = fnamebox.getText();
			String dob = ((JTextField) dobbox.getDateEditor().getUiComponent()).getText();
			String salary = salarybox.getText();
			String address = addressbox.getText();
			String phone = phonebox.getText();
			String email = emailbox.getText();
			String education = (String) educationbox.getSelectedItem();
			String designation = desig.getText(); 
			String adhar = adharbox.getText();
			String empid = empidbox.getText();
			
			try {
				DBCon conn = new DBCon();
				String query = "insert into Empdetails values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+adhar+"','"+empid+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Added Succeefully");
				
				setVisible(false);
				new Home();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		} else {
			setVisible(false);
			new Home();
		}
	}
	
	public static void main(String args[]) {
		new AddEmployee();
	}

}
