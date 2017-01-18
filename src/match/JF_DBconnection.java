package match;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JF_DBconnection extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_DBconnection frame = new JF_DBconnection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JF_DBconnection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtB = new JTextField();
		txtB.setFont(new Font("MS PMincho", Font.PLAIN, 11));
		txtB.setBounds(169, 154, 86, 37);
		contentPane.add(txtB);
		txtB.setColumns(10);
		
		JLabel lbA = new JLabel("-------");
		lbA.setFont(new Font("MS PMincho", Font.PLAIN, 70));
		lbA.setHorizontalAlignment(SwingConstants.CENTER);
		lbA.setBounds(87, 39, 250, 87);
		contentPane.add(lbA);
		
		JButton btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lbA.getText().equals(txtB.getText())){
					System.out.println("+1");
				} else {
					System.out.println("-1");
				}
				
				dbGet(lbA);
					
			}
		});
		btnCheck.setBounds(166, 202, 89, 23);
		contentPane.add(btnCheck);
	}
	
	
	public String dbGet(JLabel a){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
				
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/japaneasy","root","");
				  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from word");  
			while(rs.next()) 
			
			a.setText(rs.getString(2));
		//	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  
//			int rand = 0 + (int)(Math.random() * 4);
			
			con.close();
			
//			return rs.getString(rand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "nothing";
	}
	
}
