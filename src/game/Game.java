package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -4910623787603743743L;

	private Container c;
	
	private JLabel level;
	private JLabel score;
	private JLabel guessmynumber;
	private JLabel enternumber;
	private JLabel image;
	
	private JLabel life1;
	private JLabel life2;
	private JLabel life3;
	private JLabel life4;
	private JLabel life5;
	
	private JButton giveup;
	private JButton again;
	private JButton guess;
	private JButton buylife;
	
	private JTextField scores;
	private JTextField levels;
	private JTextField Enternumber;
	
	private int userAnswer;
	private int computerNumber;
	private int Lives;
	private int Score;
	private int Level;
	private int range1;
	private int range2;
	
	Game(){
		
		userAnswer=0;
		computerNumber=(int) (Math.random()*11);
		Lives=5;
		Score=0;
		Level=1;
	    range1=0;
	    range2=10;
	}
	
		public void frame() {
		setTitle("GUESS MY NUMBER");
		setBounds(0,0,650,450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		c=getContentPane();
		c.setLayout(null);
		
		life1=new JLabel();
		life1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/heart.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		life1.setSize(50, 50);
		life1.setLocation(550, 10);
		c.add(life1);
		
		life2=new JLabel();
		life2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/heart.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		life2.setSize(50, 50);
		life2.setLocation(560, 10);
		c.add(life2);
		
		life3=new JLabel();
		life3.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/heart.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		life3.setSize(50, 50);
		life3.setLocation(570, 10);
		c.add(life3);
		
		life4=new JLabel();
		life4.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/heart.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		life4.setSize(50, 50);
		life4.setLocation(580, 10);
		c.add(life4);
		
		life5=new JLabel();
		life5.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/heart.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		life5.setSize(50, 50);
		life5.setLocation(590, 10);
		c.add(life5);
		
		scores=new JTextField();
		scores.setSize(55, 22);
		scores.setLocation(40, 20);
		scores.setEditable(false);
		scores.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		scores.setBackground(Color.WHITE);
		scores.setText(String.valueOf(Score));
		scores.setHorizontalAlignment(JTextField.CENTER);
		c.add(scores);
		
		score=new JLabel("Score");
		score.setSize(115, 35);
		score.setLocation(102, 15);
		score.setFont(new Font("centaur" , Font.BOLD , 14));
		c.add(score);
		
		levels=new JTextField();
		levels.setSize(55, 22);
		levels.setLocation(180, 20);
		levels.setEditable(false);
		levels.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		levels.setBackground(Color.WHITE);
		levels.setText(String.valueOf(Level));
		levels.setHorizontalAlignment(JTextField.CENTER);
		c.add(levels);
		
		level=new JLabel("Level");
		level.setSize(115, 35);
		level.setLocation(242, 15);
		level.setFont(new Font("centaur" , Font.BOLD , 14));
		c.add(level);
		
		guessmynumber=new JLabel("Guess My Number Game");
		guessmynumber.setSize(300, 160);
		guessmynumber.setLocation(320, 60);
		guessmynumber.setFont(new Font("centaur" , Font.BOLD , 26));
		guessmynumber.setForeground(Color.RED);
		c.add(guessmynumber);
		
		enternumber=new JLabel("Enter number between "+range1+"-"+range2);
		enternumber.setSize(220, 50);
		enternumber.setLocation(360, 145);
		enternumber.setFont(new Font("Andalus" , Font.PLAIN , 17));
		c.add(enternumber);
		
		Enternumber=new JTextField();
		Enternumber.setSize(70, 30);
		Enternumber.setLocation(410, 190);
		Enternumber.setHorizontalAlignment(JTextField.CENTER);
		c.add(Enternumber);
		
		giveup=new JButton("Quit!");
		giveup.setSize(110, 30);
		giveup.setLocation(300, 320);
		giveup.setFont(new Font("centaur" , Font.ROMAN_BASELINE , 17));
		giveup.addActionListener(this);
		c.add(giveup);
		
		again=new JButton("Restart!");
		again.setSize(110, 30);
		again.setLocation(460, 320);
		again.setFont(new Font("centaur" , Font.ROMAN_BASELINE , 17));
		again.addActionListener(this);
		c.add(again);
		
		guess=new JButton("Guess");
		guess.setSize(120, 30);
		guess.setLocation(380, 240);
		guess.setFont(new Font("centaur" , Font.ROMAN_BASELINE , 17));
		guess.addActionListener(this);
		c.add(guess);
		
		buylife=new JButton("Buy life");
		buylife.setSize(75, 22);
		buylife.setLocation(450, 25);
		buylife.setFont(new Font("centaur" , Font.ROMAN_BASELINE , 12));
		buylife.addActionListener(this);
		c.add(buylife);
		
		image=new JLabel();
		image.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/question.png")).getImage().getScaledInstance(280, 355, Image.SCALE_DEFAULT)));
		image.setSize(287, 390);
		image.setLocation(10, 35);
		c.add(image);
		
		
		
		setVisible(true);
		
	}
	
	public void welcometoRules() {
		
		JOptionPane.showMessageDialog(null, "Welcome to Guess My Number Game" , "Welcome" , JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Rules of the game:\n1.Entering numbers within the range\n2.Each level the range gets larger\n3.5 lives,after them,game over\n4.10 points for each correct guess\n5.Spend 15 points and buy a life\n6.Have Fun...!" , "Rules..." , JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public boolean Isdigit() {
		
		String text=Enternumber.getText();
		int digit=0;
		
		for(int i=0;i<text.length();i++) {
			
			if(Character.isDigit(text.charAt(i)))
				digit++;
			
		}
		
		if(digit==text.length())
			return true;
		
		else
			return false;
		
	}
	
	public void Reset() {
		
		userAnswer=0;
		computerNumber=(int) Math.random();
		Lives=5;
		Score=0;
		Level=1;
		range1=0;
		range2=10;
		Enternumber.setText("");
		enternumber.setText("Enter number between "+range1+"-"+range2);
		levels.setText(String.valueOf(Level));
		scores.setText(String.valueOf(Score));
		
		if(!life1.isVisible())
			life1.setVisible(true);
		if(!life2.isVisible())
			life2.setVisible(true);
		if(!life3.isVisible())
			life3.setVisible(true);
		if(!life4.isVisible())
			life4.setVisible(true);
		if(!life5.isVisible())
			life5.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==guess) {
			
			if(Enternumber.getText().isEmpty())
				
				JOptionPane.showMessageDialog(null, "Nothing is entered!\nPlease enter a number.", "Empty field!", JOptionPane.ERROR_MESSAGE);
			
			else if(!Isdigit()) 
				JOptionPane.showMessageDialog(null, "You must enter only numbers!", "Input error!", JOptionPane.ERROR_MESSAGE);
			
			else if(Isdigit()) {
				
				userAnswer=Integer.parseInt(Enternumber.getText());
				
				if(userAnswer<=range2 && userAnswer>=range1) {
					
					//System.out.println(computerNumber);      //Optional
					if(userAnswer==computerNumber) {
						
						Level++;
						Score+=20;
						range1+=5;
						range2=Level*10;
						computerNumber=range1+(int)(Math.random()*((range2-range1)+1));
						Enternumber.setText("");
						enternumber.setText("Enter number between "+range1+"-"+range2);
						levels.setText(String.valueOf(Level));
						scores.setText(String.valueOf(Score));
						
					}
					else {
						if(life5.isVisible()) {
							life5.setVisible(false);
							Lives--;
						}
						else if(life4.isVisible()) {
							life4.setVisible(false);
							Lives--;
						}
						else if(life3.isVisible()) {
							life3.setVisible(false);
							Lives--;
						}
						else if(life2.isVisible()) {
							life2.setVisible(false);
							Lives--;
						}
						else if(life1.isVisible()) {
							life1.setVisible(false);
							Lives--;
						}
						Enternumber.setText("");
						if(Lives==0) {
							int choice =JOptionPane.showConfirmDialog(null, "Your hearts are gone,Do you want to play again?" , "Game Over!" , JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
							 //0=yes  1=no
							if(choice==0)
								Reset();
							else
								System.exit(0);
						}
					}
					
				}
				else
					JOptionPane.showMessageDialog(null, "Your number should be between "+range1+" and "+range2 , "Out of range!" , JOptionPane.ERROR_MESSAGE);
					
				
			  }
		 	    
		 	    
			}
		
		if(e.getSource()==buylife) {
			
			if(Lives==5) {
				
				JOptionPane.showMessageDialog(null, "You can't buy any life now!", "Lives are full...", JOptionPane.ERROR_MESSAGE);
				
			}
			
			if(Score<15 && Lives!=5)
				JOptionPane.showMessageDialog(null, "You don't have enough score to buy a life!" , "Error!" , JOptionPane.ERROR_MESSAGE);
			
			else {
				
				if(!life1.isVisible()) {
					life1.setVisible(true);
					Lives++;
					Score-=15;
					scores.setText(String.valueOf(Score));
				}
				else if(!life2.isVisible()) {
					life2.setVisible(true);
					Lives++;
					Score-=15;
					scores.setText(String.valueOf(Score));
				}
				else if(!life3.isVisible()) {
					life3.setVisible(true);
					Lives++;
					Score-=15;
					scores.setText(String.valueOf(Score));
				}
				else if(!life4.isVisible()) {
					life4.setVisible(true);
					Lives++;
					Score-=15;
					scores.setText(String.valueOf(Score));
				}
				else if(!life5.isVisible()) {
					life5.setVisible(true);
					Lives++;
					Score-=15;
					scores.setText(String.valueOf(Score));
				}
				
			}
			
		}
		
		if(e.getSource()==giveup) {
			
			JOptionPane.showMessageDialog(null, "Hope you enjoyed the game...\nCome again later!" , "Thank you for your patricipating!" , JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);

		}
		
		if(e.getSource()==again)
			Reset();
			
		}
		
	}



