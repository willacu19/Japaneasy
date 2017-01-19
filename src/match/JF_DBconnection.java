package match;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class JF_DBconnection extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtB;
	private ArrayList<Cls_DbLine> Cls_DbLines = new ArrayList<Cls_DbLine>();
	private int score = 0;
	private int total = 0;
	private String q= "jph";
	private String a= "jph";
	private final ButtonGroup buttonGroupQ = new ButtonGroup();
	private final ButtonGroup buttonGroupA = new ButtonGroup();
	
	
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
		setBounds(100, 100, 625, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtB = new JTextField();
		txtB.setHorizontalAlignment(SwingConstants.CENTER);
		txtB.setFont(new Font("MS PMincho", Font.BOLD, 20));
		txtB.setBounds(256, 374, 86, 37);
		contentPane.add(txtB);
		txtB.setColumns(10);
		
		JLabel lbA = new JLabel(dbGet());
		lbA.setFont(new Font("MS PMincho", Font.PLAIN, 70));
		lbA.setHorizontalAlignment(SwingConstants.CENTER);
		lbA.setBounds(174, 259, 250, 87);
		contentPane.add(lbA);
		
		JLabel lbScore = new JLabel("Score 0/0");
		lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		lbScore.setBounds(403, 234, 96, 14);
		contentPane.add(lbScore);
		
		JButton btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dbCheck(lbA.getText(), txtB.getText())){
					score = score + 1;
				}
				total = total + 1;
				lbScore.setText("Score "+score+"/"+total);
				lbA.setText(dbGet());
				txtB.setText("");
			}
		});
		btnCheck.setBounds(253, 422, 89, 23);
		contentPane.add(btnCheck);
		
		JRadioButton rbQjpH = new JRadioButton("Hiragana");
		rbQjpH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				q= "jph";
				lbA.setText(dbGet());
			}
		});
		rbQjpH.setSelected(true);
		buttonGroupQ.add(rbQjpH);
		rbQjpH.setBounds(156, 57, 109, 23);
		contentPane.add(rbQjpH);
		
		JRadioButton rbQjpK = new JRadioButton("Katakana");
		rbQjpK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				q= "jpk";
				lbA.setText(dbGet());
			}
		});
		buttonGroupQ.add(rbQjpK);
		rbQjpK.setBounds(156, 83, 109, 23);
		contentPane.add(rbQjpK);
		
		JRadioButton rbQsp = new JRadioButton("Español");
		rbQsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				q= "sp";
				lbA.setText(dbGet());
			}
		});
		buttonGroupQ.add(rbQsp);
		rbQsp.setBounds(156, 106, 109, 23);
		contentPane.add(rbQsp);
		
		JRadioButton rbQen = new JRadioButton("English");
		rbQen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				q= "en";
				lbA.setText(dbGet());
			}
		});
		buttonGroupQ.add(rbQen);
		rbQen.setBounds(156, 130, 109, 23);
		contentPane.add(rbQen);
		
		JRadioButton rbAjpH = new JRadioButton("Hiragana");
		rbAjpH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a= "jph";
			}
		});
		rbAjpH.setSelected(true);
		buttonGroupA.add(rbAjpH);
		rbAjpH.setBounds(335, 57, 109, 23);
		contentPane.add(rbAjpH);
		
		JRadioButton rbAjpK = new JRadioButton("Katakana");
		rbAjpK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a= "jpk";
			}
		});
		buttonGroupA.add(rbAjpK);
		rbAjpK.setBounds(335, 83, 109, 23);
		contentPane.add(rbAjpK);
		
		JRadioButton rbAsp = new JRadioButton("Español");
		rbAsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a= "sp";
			}
		});
		buttonGroupA.add(rbAsp);
		rbAsp.setBounds(335, 106, 109, 23);
		contentPane.add(rbAsp);
		
		JRadioButton rbAen = new JRadioButton("English");
		rbAen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a= "en";
			}
		});
		buttonGroupA.add(rbAen);
		rbAen.setBounds(335, 130, 109, 23);
		contentPane.add(rbAen);
		
		
	}
	
	
	public String dbGet(){
		String randString = "";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
				
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/japaneasy?useUnicode=true&characterEncoding=utf-8","root","");
				  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from word");  			
			while(rs.next()){ 
				Cls_DbLines.add( new Cls_DbLine(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5)));
			}
			con.close();
			switch (q){
			case "jph" : 
				randString = Cls_DbLines.get(0 + (int)(Math.random() * 4)).getJph();
				break;
			case "jpk" : 
				randString = Cls_DbLines.get(0 + (int)(Math.random() * 4)).getJpk();
				break;
			case "sp" : 
				randString = Cls_DbLines.get(0 + (int)(Math.random() * 4)).getSp();
				break;
			case "en" : 
				randString = Cls_DbLines.get(0 + (int)(Math.random() * 4)).getEn();
				break;
			}
			return randString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randString;
	}
	
	public boolean dbCheck(String question, String text){
		Cls_DbLine Cls_DbLine = new Cls_DbLine();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
				
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/japaneasy?useUnicode=true&characterEncoding=utf-8","root","");
				  
			Statement stmt=con.createStatement(); 

			ResultSet rs=stmt.executeQuery("select * from word where "+ q +" ='" + question +"'"); 
			while(rs.next()){
				Cls_DbLine = new Cls_DbLine(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5));
			}
			con.close();
			String answer = "none";
			switch (a){
			case "jph" : 
				answer = Cls_DbLine.getJph();
				break;
			case "jpk" : 
				answer = Cls_DbLine.getJpk();
				break;
			case "sp" : 
				answer = Cls_DbLine.getSp();
				break;
			case "en" : 
				answer = Cls_DbLine.getEn();
				break;
			}
			
			if (answer.equals(text)){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
