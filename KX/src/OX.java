import java.awt.Color;
import java.util.Random;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class OX {

	static Random rand = new Random();
	
	private JFrame frame;
	
	static int turn;
	static 	int [][] board = new int [3][3];
	
	private JTextField textTurn;
	private JTextField textEnd;
	
	public void whoStarts()
	{
		turn = rand.nextInt(2);
		randomBoard();
	}
	
	public static void randomBoard()
	{
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j]=rand.nextInt(10000);				
	}
	
	
	public void isThisTheEnd()
	{
		//vertical
		for(int i=0;i<3;i++)
			if(board[0][i]==board[1][i] && board[1][i]==board[2][i])				
				endGame();
		
		//horizontal
		for(int i=0;i<3;i++)
			if(board[i][0]==board[i][1] && board[i][1]==board[i][2])
				endGame();

		//diagonal
		if((board[0][0]==board[1][1] && board[1][1]==board[2][2]) || (board[2][0]==board[1][1] && board[1][1]==board[0][2]))
			endGame();
		else 
			nextTurn();
	}
	
	public void nextTurn()
	{
		if(turn==1)
			turn=0;
		else
			turn=1;	
		
		textTurn.setText((turn==1?"X":"O") + " move");
	}
	
	public void endGame()
	{
		textEnd.setText((turn==1?"X":"O") + " wins!");
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					OX window = new OX();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
		});
		
		
		
	}

	public OX() {
		initialize();
	}
	

	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	
	
	private void initialize() {
		
		whoStarts();


		JFrame window = new JFrame();
		window.getContentPane().setEnabled(false);
		window.setBounds(10,10,502,605);
		window.setTitle("Kolko krzyzyk");
		window.setResizable(false);
		window.setVisible(true);
		window.getContentPane().setLayout(null);
		window.getContentPane().setBackground(Color.DARK_GRAY);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		btn1 = new JButton("");
		btn1.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn1.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn1.setBounds(36, 86, 120, 120);
		window.getContentPane().add(btn1);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn1.setBorder(new LineBorder(Color.WHITE));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText((turn==1?"X":"O"));
				board[0][0]=turn;
				isThisTheEnd();
				btn1.setEnabled(false);
			}
		});
		
		
		
		btn2 = new JButton("");
		btn2.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn2.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn2.setBounds(185, 86, 120, 120);
		window.getContentPane().add(btn2);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn2.setBorder(new LineBorder(Color.WHITE));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setText((turn==1?"X":"O"));
				board[0][1]=turn;
				isThisTheEnd();
				btn2.setEnabled(false);
			}
		});
		

		
		btn3 = new JButton("");
		btn3.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn3.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn3.setLocation(333, 86);
		btn3.setSize(120, 120);
		window.getContentPane().add(btn3);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn3.setBorder(new LineBorder(Color.WHITE));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setText((turn==1?"X":"O"));
				board[0][2]=turn;
				isThisTheEnd();	
				btn3.setEnabled(false);
			}
		});
		
		
		btn4 = new JButton("");
		btn4.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn4.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn4.setLocation(36, 228);
		btn4.setSize(120, 120);
		window.getContentPane().add(btn4);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn4.setBorder(new LineBorder(Color.WHITE));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setText((turn==1?"X":"O"));
				board[1][0]=turn;
				isThisTheEnd();
				btn4.setEnabled(false);
			}
		});
		
		
		btn5 = new JButton("");
		btn5.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn5.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn5.setLocation(185, 228);
		btn5.setSize(120, 120);
		window.getContentPane().add(btn5);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn5.setBorder(new LineBorder(Color.WHITE));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setText((turn==1?"X":"O"));
				board[1][1]=turn;
				isThisTheEnd();
				btn5.setEnabled(false);
			}
		});
		
		
		btn6 = new JButton("");
		btn6.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn6.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn6.setLocation(333, 228);
		btn6.setSize(120, 120);
		window.getContentPane().add(btn6);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn6.setBorder(new LineBorder(Color.WHITE));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn6.setText((turn==1?"X":"O"));
				board[1][2]=turn;
				isThisTheEnd();	
				btn6.setEnabled(false);
			}
		});
		
		
		btn7 = new JButton("");
		btn7.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn7.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn7.setLocation(36, 373);
		btn7.setSize(120, 120);
		window.getContentPane().add(btn7);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn7.setBorder(new LineBorder(Color.WHITE));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn7.setText((turn==1?"X":"O"));
				board[2][0]=turn;
				isThisTheEnd();	
				btn7.setEnabled(false);
			}
		});
		
		
		btn8 = new JButton("");
		btn8.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn8.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn8.setLocation(185, 373);
		btn8.setSize(120, 120);
		window.getContentPane().add(btn8);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn8.setBorder(new LineBorder(Color.WHITE));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn8.setText((turn==1?"X":"O"));
				board[2][1]=turn;
				isThisTheEnd();
				btn8.setEnabled(false);
			}
		});
		
		
		btn9 = new JButton("");
		btn9.setFont(new Font("Verdana", Font.PLAIN, 77));
		btn9.setBackground(UIManager.getColor("Button.disabledForeground"));
		btn9.setLocation(333, 373);
		btn9.setSize(120, 120);
		window.getContentPane().add(btn9);
		btn9.setBorder(new LineBorder(Color.WHITE));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn9.setText((turn==1?"X":"O"));
				board[2][2]=turn;
				isThisTheEnd();
				btn9.setEnabled(false);
			}
		});
		
		textTurn = new JTextField();
		textTurn.setForeground(Color.LIGHT_GRAY);
		textTurn.setEditable(false);
		textTurn.setHorizontalAlignment(SwingConstants.LEFT);
		textTurn.setFont(new Font("Verdana", Font.BOLD, 20));
		textTurn.setBackground(Color.DARK_GRAY);
		textTurn.setBounds(36, 21, 200, 40);
		window.getContentPane().add(textTurn);
		textTurn.setColumns(10);
		textTurn.setText((turn==1?"X":"O") + " move");
		textTurn.setBorder(null);
		
		textEnd = new JTextField();
		textEnd.setHorizontalAlignment(SwingConstants.CENTER);
		textEnd.setForeground(Color.LIGHT_GRAY);
		textEnd.setFont(new Font("Verdana", Font.BOLD, 30));
		textEnd.setEditable(false);
		textEnd.setColumns(10);
		textEnd.setBorder(null);
		textEnd.setBackground(Color.DARK_GRAY);
		textEnd.setBounds(105, 515, 284, 50);
		window.getContentPane().add(textEnd);
		
		JButton btnClear = new JButton("Clear!");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				btn6.setText("");
				btn7.setText("");
				btn8.setText("");
				btn9.setText("");
				textEnd.setText("");
				
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
				
				whoStarts();
				randomBoard();
				textTurn.setText((turn==1?"X":"O") + " move");
				
			}
		});
		btnClear.setForeground(Color.LIGHT_GRAY);
		btnClear.setBorder(new LineBorder(Color.WHITE));
		btnClear.setFont(new Font("Verdana", Font.BOLD, 23));
		btnClear.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnClear.setBounds(333, 20, 120, 38);
		window.getContentPane().add(btnClear);

		
		
		
			
		
		

		
		
	}
}
