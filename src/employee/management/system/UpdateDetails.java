package employee.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateDetails extends JFrame implements ActionListener {
	
	JButton update, exit;
	JLabel name, fname, phone, email, education, salary, desig;
	JTextField namebox, fnamebox, phonebox, emailbox, salarybox, desigbox;
	JComboBox educationbox;
	String empId;
	
	UpdateDetails(String empId){
		
		this.empId = empId;
		
		setTitle("Update Employee Details");
		setSize(1100, 650);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		Color bg = new Color(18,18,18);
		Color panel = new Color(30,30,27);
		
		JLabel header = new JLabel("Update Employee Details");
		header.setFont(new Font("Seoge UI", Font.BOLD, 26));
		header.setForeground(Color.WHITE);
		header.setBorder(new EmptyBorder(20,30,20,30));
		add(header, BorderLayout.NORTH);
		
		JPanel main = new JPanel(new BorderLayout());
		main.setBackground(bg);
		add(main, BorderLayout.CENTER);
		
		JPanel form = new JPanel(new GridBagLayout());
		form.setBackground(panel);
		form.setBorder(new EmptyBorder(20,30,20,30));
		main.add(form, BorderLayout.CENTER);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		
		
		JPanel personalinfo = new JPanel(new GridBagLayout());
		personalinfo.setBackground(panel);
		personalinfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Personal Info", TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 14), Color.WHITE));
		
		GridBagConstraints p = new GridBagConstraints();
		p.insets = new Insets(8,8,8,8);
		p.fill = GridBagConstraints.HORIZONTAL;
		p.weightx = 1;
		
		name = new JLabel("Name");
		name.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 0;
		p.gridy = 0;
		personalinfo.add(name, p);
		
		namebox = new JTextField(15);
		namebox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 1;
		personalinfo.add(namebox, p);
		
		fname = new JLabel("Father Name");
		fname.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 0;
		p.gridy = 1;
		personalinfo.add(fname, p);
		
		fnamebox = new JTextField(15);
		fnamebox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 1;
		personalinfo.add(fnamebox, p);
		
		phone = new JLabel("Phone No");
		phone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 0;
		p.gridy = 2;
		personalinfo.add(phone, p);
		
		phonebox = new JTextField(15);
		phonebox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 1;
		personalinfo.add(phonebox, p);
		
		email = new JLabel("Email Id");
		email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 0;
		p.gridy = 3;
		personalinfo.add(email, p);
		
		emailbox = new JTextField(15);
		emailbox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		p.gridx = 1;
		personalinfo.add(emailbox, p);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		form.add(personalinfo, gbc);
		
		JPanel jobinfo = new JPanel(new GridBagLayout());
		jobinfo.setBackground(panel);
		jobinfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Job Info", TitledBorder.LEFT, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), Color.WHITE));
		
		GridBagConstraints j = new GridBagConstraints();
		j.insets = new Insets(8,8,8,8);
		j.fill = GridBagConstraints.HORIZONTAL;
		j.weightx = 1;
		
		salary = new JLabel("Salary");
		salary.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		j.gridx = 0;
		j.gridy = 0;
		jobinfo.add(salary, j);
		
		salarybox = new JTextField(15);
		salarybox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		j.gridx = 1;
		jobinfo.add(salarybox, j);
		
		desig = new JLabel("Designation");
		desig.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		j.gridx = 0;
		j.gridy = 1;
		jobinfo.add(desig, j);
		
		desigbox = new JTextField(15);
		desigbox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		j.gridx = 1;
		jobinfo.add(desigbox, j);
		
		education = new JLabel("Higher Education");
		education.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		j.gridx = 0;
		j.gridy = 2;
		jobinfo.add(education, j);
		
		String comboeducation[] = {"BCA","MCA","B.Tech","MBA","B.Com","M.Tech","MBA","BSC","M.Com"}; 
		educationbox = new JComboBox(comboeducation);
		educationbox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		j.gridx = 1;
		jobinfo.add(educationbox, j);
		
		gbc.gridy = 1;
		form.add(jobinfo, gbc);
		
		
		try {
			DBCon c = new DBCon();
			String query = "select * from Empdetails where empId = '"+empId+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				namebox.setText(rs.getString("name"));
				fnamebox.setText(rs.getString("fname"));
				phonebox.setText(rs.getString("phone"));
				emailbox.setText(rs.getString("email"));
				salarybox.setText(rs.getString("salary"));
				desigbox.setText(rs.getString("designation"));
				educationbox.setSelectedItem(rs.getString("education"));
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();		
		}
		
		
		JPanel button = new JPanel();
		button.setBackground(panel);
		
		update = new JButton("Update");
		update.setForeground(Color.white);
		update.setBackground(new Color(124,58,237));
		update.addActionListener(this);
		update.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		button.add(update);
		
		exit = new JButton("Exit");
		exit.setForeground(Color.white);
		exit.addActionListener(this);
		exit.setBackground(new Color(245,158,11));
		exit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		button.add(exit);
		
		gbc.gridy = 2;
		form.add(button, gbc);
		
		
		JPanel image = new JPanel();
		image.setBackground(bg);
		image.setBorder(new EmptyBorder(20,20,20,20));
		main.add(image, BorderLayout.EAST);
		
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("employee/management/system/images/update1.jfif"));
		Image img = icon.getImage().getScaledInstance(450,450, Image.SCALE_SMOOTH);
		image.add(new JLabel(new ImageIcon(img)));
		
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == update) {
			
			String fname = fnamebox.getText();
			String phone = phonebox.getText();
			String email = emailbox.getText();
			String salary = salarybox.getText();
			String desig = desigbox.getText();
			String education = (String) educationbox.getSelectedItem();
			 
			try {
				
				DBCon c = new DBCon();
				String query = "Update Empdetails set fname='"+fname+"', phone='"+phone+"', email='"+email+"', salary='"+salary+"', designation='"+desig+"', education='"+education+"' where empid ='"+empId+"'";
				
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Update Details Successfully");
				
				setVisible(false);
				new ViewEmployee();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Home();
		}
	}
	public static void main(String args[]) {
		new UpdateDetails("");
	}
}
