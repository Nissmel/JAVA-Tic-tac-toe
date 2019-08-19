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
	
	public  void randomBoard()
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
		
		for(int i=0;i<9;i++)
		{
			btn[i].setEnabled(false);
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					OX window = new OX();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		});
	}

	public OX() {
		initialize();
	}
	
	JButton[] btn = new JButton[9];
		
	private void initialize() {
		
		whoStarts();

		JFrame window = new JFrame();
		window.getContentPane().setEnabled(false);
		window.setBounds(10,10,502,605);
		window.setTitle("Tic tac toe");
		window.setResizable(false);
		window.setVisible(true);
		window.getContentPane().setLayout(null);
		window.getContentPane().setBackground(Color.DARK_GRAY);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=0;i<9;i++)
		{
			btn[i] = new JButton("");
			btn[i].setFont(new Font("Verdana", Font.PLAIN, 77));
			btn[i].setBackground(UIManager.getColor("Button.disabledForeground"));
			window.getContentPane().add(btn[i]);
			btn[i].setBorder(new LineBorder(Color.WHITE));
		}
		
		
		btn[0].setBounds(36, 86, 120, 120);
		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[0].setText((turn==1?"X":"O"));
				board[0][0]=turn;
				isThisTheEnd();
				btn[0].setEnabled(false);
			}
		});
		
		btn[1].setBounds(185, 86, 120, 120);
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[1].setText((turn==1?"X":"O"));
				board[0][1]=turn;
				isThisTheEnd();
				btn[1].setEnabled(false);
			}
		});
		

		
		btn[2].setLocation(333, 86);
		btn[2].setSize(120, 120);
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[2].setText((turn==1?"X":"O"));
				board[0][2]=turn;
				isThisTheEnd();	
				btn[2].setEnabled(false);
			}
		});
		
		
		btn[3].setLocation(36, 228);
		btn[3].setSize(120, 120);
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[3].setText((turn==1?"X":"O"));
				board[1][0]=turn;
				isThisTheEnd();
				btn[3].setEnabled(false);
			}
		});
		
		
		
		btn[4].setLocation(185, 228);
		btn[4].setSize(120, 120);
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[4].setText((turn==1?"X":"O"));
				board[1][1]=turn;
				isThisTheEnd();
				btn[4].setEnabled(false);
			}
		});
		
		
		
		btn[5].setLocation(333, 228);
		btn[5].setSize(120, 120);
		btn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[5].setText((turn==1?"X":"O"));
				board[1][2]=turn;
				isThisTheEnd();	
				btn[5].setEnabled(false);
			}
		});
		
		
		btn[6].setLocation(36, 373);
		btn[6].setSize(120, 120);
		btn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[6].setText((turn==1?"X":"O"));
				board[2][0]=turn;
				isThisTheEnd();	
				btn[6].setEnabled(false);
			}
		});
		
		
		btn[7].setLocation(185, 373);
		btn[7].setSize(120, 120);
		btn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[7].setText((turn==1?"X":"O"));
				board[2][1]=turn;
				isThisTheEnd();
				btn[7].setEnabled(false);
			}
		});
		
		
		btn[8].setLocation(333, 373);
		btn[8].setSize(120, 120);
		btn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn[8].setText((turn==1?"X":"O"));
				board[2][2]=turn;
				isThisTheEnd();
				btn[8].setEnabled(false);
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
				
				for(int i=0;i<9;i++)
				{
					btn[i].setText("");
				}
				textEnd.setText("");
				
				for(int i=0;i<9;i++)
				{
					btn[i].setEnabled(true);
				}				
				whoStarts();
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
