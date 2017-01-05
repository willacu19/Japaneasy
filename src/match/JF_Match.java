package match;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JF_Match extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private JTextField txtA;
	private JTextField txtX;
	private JTextField txtScore;
	private final ButtonGroup bntGrpLanguage = new ButtonGroup();
	private JTextField txtTotal;

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
				
		
//Frame Information
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 248);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtA = new JTextField();
		txtA.setText(newPos(bucketH));
		txtA.setEnabled(false);
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setFont(new Font("MS PMincho", Font.PLAIN, 60));
		txtA.setBounds(31, 75, 130, 111);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Score");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(227, 12, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtScore = new JTextField();
		txtScore.setEditable(false);
		txtScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setText("0");
		txtScore.setBounds(202, 31, 41, 26);
		contentPane.add(txtScore);
		txtScore.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(237, 25, 41, 39);
		contentPane.add(label);
		
		txtTotal = new JTextField();
		txtTotal.setText("0");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(264, 31, 41, 26);
		contentPane.add(txtTotal);
		
		
		JRadioButton rdbtnH = new JRadioButton("Hiragana「あ」");
		rdbtnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnH.isSelected()) 
					txtA.setText(newPos(bucketH));
			}
		});
		bntGrpLanguage.add(rdbtnH);
		rdbtnH.setSelected(true);
		rdbtnH.setBounds(31, 9, 130, 23);
		contentPane.add(rdbtnH);
		
		JRadioButton rdbtnK = new JRadioButton("Katakana「ｱ」");
		rdbtnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnK.isSelected()) 
					txtA.setText(newPos(bucketK));
			}
		});
		bntGrpLanguage.add(rdbtnK);
		rdbtnK.setBounds(31, 35, 130, 23);
		contentPane.add(rdbtnK);
		
		txtX = new JTextField();
		txtX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10){
					Integer score = Integer.valueOf(txtScore.getText());
					Integer total = Integer.valueOf(txtTotal.getText());
					score = guess(score,txtA.getText(),txtX.getText());
					txtScore.setText(score.toString());
					if (rdbtnH.isSelected())
						txtA.setText(newPos(bucketH));
					if (rdbtnK.isSelected())
						txtA.setText(newPos(bucketK));
					txtX.setText("");
					total ++;
					txtTotal.setText(total.toString());
				}
			}
		});
		txtX.setFont(new Font("MS PMincho", Font.PLAIN, 60));
		txtX.setHorizontalAlignment(SwingConstants.CENTER);
		txtX.setBounds(173, 75, 130, 111);
		contentPane.add(txtX);
		txtX.setColumns(10);
		
		
		
			
		
	}
	
	
//Procedures
	public String newPos(ArrayList<String> bucket){
		Integer randomNum = 0 + (int)(Math.random() * 46);
		return bucket.get(randomNum);
	}
	
	public Integer guess(Integer score, String a, String b){
		if(a.equals(b))
			score += 1;
		return score;
	}
}