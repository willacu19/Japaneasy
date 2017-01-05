package match;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JF_Match extends JFrame {

	private static final long serialVersionUID = 1L;
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
		txtA.setFont(new Font("MS PMincho", Font.PLAIN, 60));
		txtA.setText("ば");
		txtA.setBounds(40, 40, 130, 111);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		txtX = new JTextField();
		txtX.setFont(new Font("MS PMincho", Font.PLAIN, 60));
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
		txtScore.setText("500");
		txtScore.setBounds(255, 7, 61, 26);
		contentPane.add(txtScore);
		txtScore.setColumns(10);
		

//Variables
		
ArrayList<String> bucketH = new ArrayList<String>();
		
		bucketH.add("あ"); bucketH.add("い"); bucketH.add("う"); bucketH.add("え"); bucketH.add("お");
		bucketH.add("か"); bucketH.add("き"); bucketH.add("く"); bucketH.add("け"); bucketH.add("こ");
		bucketH.add("さ"); bucketH.add("し"); bucketH.add("す"); bucketH.add("せ"); bucketH.add("そ");
		bucketH.add("た"); bucketH.add("ち"); bucketH.add("つ"); bucketH.add("て"); bucketH.add("と");
		bucketH.add("な"); bucketH.add("に"); bucketH.add("ぬ"); bucketH.add("ね"); bucketH.add("の");
		bucketH.add("は"); bucketH.add("ひ"); bucketH.add("ふ"); bucketH.add("へ"); bucketH.add("ほ");
		bucketH.add("ま"); bucketH.add("み"); bucketH.add("む"); bucketH.add("め"); bucketH.add("も");
		bucketH.add("や");					 bucketH.add("ゆ"); 				      bucketH.add("よ");
		bucketH.add("ら"); bucketH.add("り"); bucketH.add("る"); bucketH.add("れ"); bucketH.add("ろ");
		bucketH.add("わ"); 													     bucketH.add("を");
		bucketH.add("ん");
		
		
		ArrayList<String> bucketK = new ArrayList<String>();
		
		bucketK.add("ア"); bucketK.add("イ"); bucketK.add("ウ"); bucketK.add("エ"); bucketK.add("オ");
		bucketK.add("カ"); bucketK.add("キ"); bucketK.add("久"); bucketK.add("ケ"); bucketK.add("コ");
		bucketK.add("サ"); bucketK.add("シ"); bucketK.add("ス"); bucketK.add("セ"); bucketK.add("ソ");
		bucketK.add("タ"); bucketK.add("チ"); bucketK.add("ツ"); bucketK.add("テ"); bucketK.add("ト");
		bucketK.add("ナ"); bucketK.add("ニ"); bucketK.add("ヌ"); bucketK.add("ネ"); bucketK.add("ノ");
		bucketK.add("ハ"); bucketK.add("ヒ"); bucketK.add("フ"); bucketK.add("ヘ"); bucketK.add("ホ");
		bucketK.add("マ"); bucketK.add("ミ"); bucketK.add("ム"); bucketK.add("メ"); bucketK.add("モ");
		bucketK.add("ヤ");					bucketK.add("ユ"); 				     bucketK.add("ヨ");
		bucketK.add("ラ"); bucketK.add("リ"); bucketK.add("ル"); bucketK.add("レ"); bucketK.add("ロ");
		bucketK.add("ワ"); bucketK.add("ヰ");					   bucketK.add("ヱ"); bucketK.add("ヲ");
		bucketK.add("ン");
		
		
//Actions		
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer score = Integer.valueOf(txtScore.getText());
				score = guess(score,txtA.getText(),txtX.getText());
				txtScore.setText(score.toString());
				txtA.setText(newPos(bucketK));
				txtX.setText("");
			}
		});
		btnCheck.setBounds(118, 163, 117, 29);
		contentPane.add(btnCheck);
		
	}
	
	
//Procedures
	public String newPos(ArrayList<String> bucket){
		Integer randomNum = 0 + (int)(Math.random() * 46);
		return bucket.get(randomNum);
	}
	
	public Integer guess(Integer score, String a, String b){
		if(a.equals(b)){
			score += 1;
		} else {
			score -= 1;
		}
		return score;
	}
	
}