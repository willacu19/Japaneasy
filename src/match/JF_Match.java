package match;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JF_Match extends JFrame {

	private JLayeredPane contentPane;
	private JTextField txtA;
	private JTextField txtX;
	private JTextField txtScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_Match frame = new JF_Match();
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
	public JF_Match() {
		
//Frame Information
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 233);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtA = new JTextField();
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setFont(new Font("Arial", Font.PLAIN, 60));
		txtA.setText("A");
		txtA.setBounds(40, 40, 130, 111);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtX = new JTextField();
		txtX.setFont(new Font("Arial", Font.PLAIN, 60));
		txtX.setHorizontalAlignment(SwingConstants.CENTER);
		txtX.setText("X");
		txtX.setBounds(182, 40, 130, 111);
		contentPane.add(txtX);
		txtX.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Score");
		lblNewLabel.setBounds(217, 12, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtScore = new JTextField();
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setText("50");
		txtScore.setBounds(255, 7, 61, 26);
		contentPane.add(txtScore);
		txtScore.setColumns(10);
		
		
		
//Actions		
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer score = Integer.valueOf(txtScore.getText());
				System.out.println(txtA.getText());
				System.out.println(txtX.getText());
				if (txtA.getText().equals(txtX.getText())) {
					score += 1;
				} else {
					score -= 1;
				}
				txtScore.setText(score.toString());
				System.out.println(newPos());
			}
		});
		btnCheck.setBounds(118, 163, 117, 29);
		contentPane.add(btnCheck);
		
		
	}
	
	
//Procedures
	public Integer newPos(){
		Integer randomNum = 0 + (int)(Math.random() * 46);
		System.out.println(randomNum);
		return randomNum;
	}
	
}