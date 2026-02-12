 package employee.management.system;

 import javax.swing.*;
 import javax.swing.table.DefaultTableModel;
 import java.sql.*;
 import java.awt.*;
 import java.awt.event.*;
 
public class ViewEmployee extends JFrame implements ActionListener {
	
	JTable table;
	JLabel empId;
	Choice combempid;
	JButton search, print, update, back;
	
	ViewEmployee(){
		setLayout(null);
		
		
		empId = new JLabel("Search By Employee Id");
		empId.setForeground(Color.WHITE);
		empId.setBounds(60, 20, 150, 30);
		add(empId);
		
		combempid = new Choice();
		combempid.setBounds(210, 25, 150, 30);
		add(combempid);		
		
		try {
			DBCon conn = new DBCon();
			ResultSet rs = conn.s.executeQuery("select * from empdetails");
			
			while(rs.next()) {
				combempid.add(rs.getString("empid"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		
		try {
			DBCon conn = new DBCon();
			ResultSet rs = conn.s.executeQuery("select * from empdetails");
			
			//Get Column count
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			//Add column name(loop)
			for(int col = 1; col <= columnCount; col++) {
				model.addColumn(rsmd.getColumnName(col));
			}
			
			//Row loop
			while(rs.next()) {
				Object[] row = new Object[columnCount];
				//column loop
				for(int col = 1; col <= columnCount; col++) {
					row[col-1] = rs.getObject(col);
				}
				model.addRow(row);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		table.setModel(model);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 100, 1100, 600);
		add(sp);
		
		search = new JButton("Search");
		search.setBounds(60, 70, 120, 25);
		search.addActionListener(this);
		search.setForeground(Color.BLACK);
		search.setBackground(Color.WHITE);
		add(search);
		
		print = new JButton("Print");
		print.setBounds(210, 70, 120, 25);
		print.addActionListener(this);
		print.setForeground(Color.BLACK);
		print.setBackground(Color.WHITE);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(350, 70, 120, 25);
		update.addActionListener(this);
		update.setForeground(Color.BLACK);
		update.setBackground(Color.WHITE);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(490, 70, 120, 25);
		back.addActionListener(this);
		back.setForeground(Color.BLACK);
		back.setBackground(Color.WHITE);
		add(back);
		
		getContentPane().setBackground(Color.BLACK);
		setSize(1100, 600);
		setLocation(150, 80);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			String query = "select * from Empdetails where empid = '"+combempid.getSelectedItem()+"'";
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
			try {
				DBCon conn = new DBCon();
				ResultSet rs = conn.s.executeQuery(query);
				
				ResultSetMetaData rsmd = rs.getMetaData();
		        int columnCount = rsmd.getColumnCount();

		        while (rs.next()) {
		            Object[] row = new Object[columnCount];
		            for (int i = 1; i <= columnCount; i++) {
		                row[i - 1] = rs.getObject(i);
		            }
		            model.addRow(row);
		        }    
									
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == print) {
			try {				
				table.print();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(ae.getSource() == update) {
			
			setVisible(false);
			new UpdateDetails(combempid.getSelectedItem());
			
		}else{
			setVisible(false);
			new Home();
		}
	}
	
	public static void main(String args[]) {
		new ViewEmployee();
	}
}
