/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for making the panel and the buttons inside of the panel
*********************************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.*;

public class AlphabetGamePanel extends JPanel implements ActionListener {

	private List<AlphabetLetterButton> alphabetButtonsList;

	private List<GameImageLetter> imageLetterList;
	private GameImageLetter currentLetter;
	private JButton pauseGameButton;
	private JButton exitGameButton;
	private JLabel currentScore;
	private JButton topScores;

	String name;
	private BufferedImage image;
	private ImageIcon checkImage;
	private ImageIcon errorImage;
	MusicPlayer musicPlayer;//new music player

	JLabel imageToSelectLetter;
	int score;
	JLabel resultImage;

	public AlphabetGamePanel(String name) {

		// player name assign
		this.name = name;

		// list of the game letters
		createGameImageLetters();
		
		//create the buttons to represent the letters
		createButtons();

		//load the images to show the results(check/error image )
		loadImages();

		// create label for the the center clue image
		imageToSelectLetter = new JLabel();
		// create label for the checkmark or error image
		resultImage = new JLabel();
		// set the score
		score = 0;

		// select the first letter randomly
		selectNewLetter();

		//create the layout of the buttons and other panels
		createLayout();
		
		musicPlayer = new MusicPlayer();//create new music player
	}

	public void createGameImageLetters() {

		this.imageLetterList = new ArrayList<GameImageLetter>();
		GameImageLetter letter;

		letter = new GameImageLetter("images/a.jpg","sounds/a.mp3", 'A');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/b.png",  "sounds/b.mp3", 'B');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/c.jpg", "sounds/c.mp3", 'C');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/d.png",  "sounds/d.mp3", 'D');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/e.jpg", "sounds/e.mp3", 'E');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/f.jpg", "sounds/f.mp3", 'F');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/g.png", "sounds/g.mp3", 'G');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/h.jpg",  "sounds/h.mp3", 'H');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/i.png",  "sounds/i.m4a", 'I');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/j1.png", "sounds/j.mp3", 'J');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/k.jpg", "sounds/k.mp3", 'K');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/l1.jpg", "sounds/l.mp3", 'L');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/m.jpg",  "sounds/m.mp3", 'M');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/n.jpg", "sounds/n.m4a", 'N');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/o.jpg",  "sounds/o.m4a", 'O');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/p.jpg", "sounds/p.mp3", 'P');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/q.jpg", "sounds/q.mp3", 'Q');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/r.jpg",  "sounds/r.mp3", 'R');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/s.jpg", "sounds/s.mp3", 'S');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/t.jpg", "sounds/t.mp3", 'T');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/u.png",  "sounds/u.m4a", 'U');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/v1.jpg", "sounds/v.mp3", 'V');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/w.jpg",  "sounds/w.m4a", 'W');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/x.jpg", "sounds/x.mp3", 'X');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/y.jpg", "sounds/y.mp3", 'Y');
		imageLetterList.add(letter);

		letter = new GameImageLetter("images/z.jpg", "sounds/z.mp3", 'Z');
		imageLetterList.add(letter);

	}

	public void createButtons() {
		// create a button list for each letter
		this.alphabetButtonsList = new ArrayList<AlphabetLetterButton>();

		int j = 0;
		for (char i = 'A'; i <= 'Z'; i++) {

			// get first game letter
			GameImageLetter gLetter = imageLetterList.get(j);
			j++;

			//create a new button for each letter, and add it to the list
			AlphabetLetterButton button = new AlphabetLetterButton(gLetter);
			button.setFocusable(true);//enable focusing to accept key press events
			alphabetButtonsList.add(button);
			
			//add a actionListener for each button
			button.addActionListener(this);
			
			//add a keyListener for each key
			button.addKeyListener(
					new KeyAdapter() {
				      public void keyPressed( KeyEvent e ) {
				    	int id = e.getKeyCode(); //get key code from event
				  		String keyString;
				  		if (id >= KeyEvent.VK_A && id <= KeyEvent.VK_Z) {//check if it alphabet key code
				  			char c = e.getKeyChar();
				  			char cUpper = Character.toUpperCase(c);//convert to upper case
				  			if (currentLetter.getLetter() == cUpper) {//check if its the same
				  				correctMatch();
				  			} else {
				  				noMatch();
				  			}
				  		}
				      }
					}
				      );
		}
	}
	
	//action listner for the letter buttons
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();//get the source

		if (source instanceof AlphabetLetterButton) {//check is alphabet button
			AlphabetLetterButton button = (AlphabetLetterButton) source;
			actionPerformOnLetter(button);//perform the action on the button
		}
	}
	
	//perform action on lettter button
	public void actionPerformOnLetter(AlphabetLetterButton button) {
		
		//check if currently selected letter is the same as the button pressed are same
		if (currentLetter.getLetter() == button.getLetter()) {//if letters are matched
			
			correctMatch();
		} else {
			noMatch();
		}
	}
	
	//if letters match
	private void correctMatch() {
		
		//set checkmark image for result
		resultImage.setIcon(checkImage);
		
		//Increment score, and set it to current score label
		score++;
		currentScore.setText(Integer.toString(score));
		
		try {
			//get soundfile for current letter, and play
			File file = new File(currentLetter.getSoundFile());
			musicPlayer.play(file);
			wait(3);//wait for sound to end
		} catch (Exception e1) {//exception handling no sound file
			System.out.println(e1.toString());
		}
		//select new letter
		selectNewLetter();
	}
	


	private void noMatch() {
		resultImage.setIcon(errorImage);//set result icon
		if (score > 0) {
			score--;//decrement score if its greater then 0
			currentScore.setText(Integer.toString(score));//set score to score label
		}


		try {
			//get sound file for current letter 
			File errorFile = new File("sounds/error.m4a");
			musicPlayer.play(errorFile);
			wait(5);
			File letterFile = new File(currentLetter.getSoundFile());
			musicPlayer.play(letterFile);
			wait(3);//pause to let it play
		} catch (Exception e2) {//exception handling if no file
			System.out.println(e2.toString());
		}
		//select new letter
		selectNewLetter();
	}
	
	//select a new letter
	private void selectNewLetter() {
		//make a random selection of the letters
		int randomSelection = (int) (Math.random() * 25);
		currentLetter = imageLetterList.get(randomSelection);
		
	
		try {
			//get a imageFile of the newly selected letter, and display it to user
			String imageFile = currentLetter.getImageFile();
			image = ImageIO.read(new File(imageFile));
			imageToSelectLetter.setIcon(new ImageIcon(image));
			imageToSelectLetter.setBounds(0, 0, 120, 40);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
		
	
	private void loadImages() {

		try {
			ImageIcon tmpImage;
			Image transformedImage;
			Image newImage;

			//load image for wrong result
			tmpImage = new ImageIcon(ImageIO.read(new File("images/Wrong.jpg")));
			transformedImage = tmpImage.getImage(); // transform it
			newImage = transformedImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			errorImage = new ImageIcon(newImage);
			
			//load image for right result
			tmpImage = new ImageIcon(ImageIO.read(new File("images/Right.jpg")));
			transformedImage = tmpImage.getImage(); // transform it
			newImage = transformedImage.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			checkImage = new ImageIcon(newImage);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//create layout for the game panel
	public void createLayout() {

		// create game panel using border layout
		this.setLayout(new BorderLayout());

		// create topCenter panel for welcome message
		JPanel topCenter = new JPanel();
		topCenter.setLayout(new FlowLayout());

		// set color of background to light blue
		Color lightBlue = new Color(8, 232, 222);
		topCenter.setBackground(lightBlue);

		// create a welcome message with player name
		JLabel welcome = new JLabel("Welcome to the Alphabet Game, " + name + "!");
		welcome.setFont(new Font("Segoe Script", Font.PLAIN, 18));

		// add welcome message to topCenter
		topCenter.add(welcome, BorderLayout.NORTH);

		// create topRight panel for scorePanel and resultPanel
		JPanel topRight = new JPanel();
		topRight.setLayout(new BorderLayout());
		topRight.setBackground(Color.white);

		// create a score Panel to organize player name, score and the result
		// image(check/error image)
		JPanel scorePanel = new JPanel();
		scorePanel.setBackground(Color.white);
		scorePanel.setLayout(new FlowLayout());

		// add player name to score panel
		JLabel scoreLable = new JLabel("Player name " + name + "'s score is: ");
		scorePanel.add(scoreLable, FlowLayout.LEFT);

		// add currentScore to the score Panel
		currentScore = new JLabel(Integer.toString(score));
		scorePanel.add(currentScore, FlowLayout.CENTER);

		// create result image panel
		JPanel scoreImagePanel = new JPanel();
		scoreImagePanel.setBackground(Color.white);
		scoreImagePanel.setLayout(new BorderLayout());

		// add resultImage(check/error image) to the scoreImagePanel
		scoreImagePanel.add(resultImage, BorderLayout.CENTER);

		// add these to the topRight section
		topRight.add(scorePanel, BorderLayout.NORTH);
		topRight.add(scoreImagePanel, BorderLayout.CENTER);

		// create topLeft panel, add menuPanel inside it
		JPanel topLeft = new JPanel();
		topLeft.setLayout(new FlowLayout());
		topLeft.setBackground(Color.white);

		// create menuPanel to store Top scores, pause, and exit
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.white);
		menuPanel.setLayout(new BorderLayout());
		topLeft.add(menuPanel, BorderLayout.WEST);

		// create a topScore button and add to menu panel
		topScores = new JButton("Top Score");
		topScores.setPreferredSize(new Dimension(125, 50));// restrict size of button
		topScores.setFocusable(false);//disable focusing to avoid keypress events
		menuPanel.add(topScores, BorderLayout.NORTH);

		// add actionlistener for top scores
		topScores.addActionListener(new ActionListener() {
			// display a file with top 5 scores when clicked
			public void actionPerformed(ActionEvent e) {
				ScoreFile myFile = new ScoreFile();
				myFile.readScore();// read score file
				List<GamePlayer> list = myFile.getGamePlayers();
				createAndShowScoreTable(list);// show table with scores using list
			}
		});

		// create pause button
		pauseGameButton = new JButton("Pause Game");
		pauseGameButton.setPreferredSize(new Dimension(125, 50));// set size
		pauseGameButton.setFocusable(false);//disable focusing to avoid keypress events
		menuPanel.add(pauseGameButton, BorderLayout.CENTER);
		
		// add action listener to pause game
		pauseGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// have users press ok when ready to resume
				try {
					JOptionPane.showMessageDialog(null, "Press ok when ready to resume", "Pause",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// create exit button
		exitGameButton = new JButton("Exit Game");
		exitGameButton.setPreferredSize(new Dimension(125, 50));// set size
		exitGameButton.setFocusable(false);//disable focusing to avoid keypress events
		menuPanel.add(exitGameButton, BorderLayout.SOUTH);
		
		// add action listener to make it exit when clicked
		exitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreFile myFile = new ScoreFile();
				myFile.readScore();// open score file and read it
				myFile.addScore(name, score);// update current player Score
				myFile.saveScore();// save score file
				// exit system
				System.exit(0);
			}
		});
		
		JPanel panelOne = new JPanel(); // hold first 13 letters
		panelOne.setBackground(Color.white);
		JPanel panelTwo = new JPanel();//hold last 13 letters
		panelTwo.setBackground(Color.white);

		for (char i = 'A'; i <= 'M'; i++) {//loop to assign the letters to the buttons
			panelOne.add(alphabetButtonsList.get(i - 'A'));
		}

		for (char i = 'N'; i <= 'Z'; i++) {//loop to assign letters to bottom buttons
			panelTwo.add(alphabetButtonsList.get(i - 'A'));
		}
		
		//make a bottomButtonPanel for the alphabet in the bottom
		JPanel bottomButtonPanel = new JPanel();
		bottomButtonPanel.setBackground(Color.white);
		bottomButtonPanel.setLayout(new BorderLayout());

		bottomButtonPanel.add(panelOne, BorderLayout.NORTH);//add first panel to the top
		bottomButtonPanel.add(panelTwo, BorderLayout.SOUTH);//add second panel to bottom section

		
		//make a panel for the center image
		JPanel centerImagePanel = new JPanel();
		centerImagePanel.setBackground(Color.white);
		centerImagePanel.setLayout(new FlowLayout());
		
		//add image clue to center panel
		centerImagePanel.add(imageToSelectLetter);
		
		//add all panels to the screen in correct Layout
		this.add(topLeft, BorderLayout.WEST);
		this.add(topRight, BorderLayout.EAST);
		this.add(topCenter, BorderLayout.NORTH);
		this.add(centerImagePanel, BorderLayout.CENTER);
		this.add(bottomButtonPanel, BorderLayout.SOUTH);
	}

	
	//helper function to wait for seconds
	private void wait(int seconds) {
		TimeUnit time = TimeUnit.SECONDS;//unit oftime
		try {
			// Calling the sleep method on the object of TimeUnit Class
			time.sleep(seconds);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception Caught" + e);
		}
	}

	//create score table for topScores
	private static void createAndShowScoreTable(List<GamePlayer> list) {
		// Create and set up the window.
		JFrame frame = new JFrame("Score Table");

		// Create and set up the content pane.
		ScoreTable newContentPane = new ScoreTable(list);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.a
		frame.setResizable(false);
		frame.setBounds(0, 0, 300, 200);
		frame.setVisible(true);
	}
}
