/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for making the screen and game frame
*********************************************************************************/
import javax.swing.*;
import java.awt.*;

//main class for creating screen and game frame
public class AlphabetGameScreen extends JFrame {
	
	public AlphabetGameScreen(String name) {
		setTitle("Welcome to Alphabet Learning Game!");

		//create game panel and add it to the frame
		JPanel panel = new AlphabetGamePanel(name);
		this.add(panel);

		//position the frame 
		centerWindow();
		//exit it on closing screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void centerWindow() {
		//get screen dimensions, and then set the bounds to the system screen size
		Toolkit systemToolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimensions = systemToolkit.getScreenSize();
		//set game to full screen
		setBounds(0, 0, screenDimensions.width, screenDimensions.height);
		//do not allow for users to resize game
		setResizable(false);
	}

}
