/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project: 
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for starting the game and sending a welcome message
*********************************************************************************/
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class runGame {

	public static void main(String[] args) {

		//Show welcome message to player, ask for player name, display instructions
		JFrame frame = new JFrame("Welcome to Alphabet Learning Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String name = new String();
		boolean run = true;
		
		//check if name is not null and if no name is provided, continue with loop to ask for player name
		while (run)
		{
			name = (String) JOptionPane.showInputDialog(frame, ""
				+ "Instruction: To play the game, select the letter that the image starts with. \r\n\n" 
				+ "Input player name",
				"Welcome to Alphabet Learning Game!", JOptionPane.PLAIN_MESSAGE, null, null, "New Player");

			if((name != null && name.isEmpty())) 
			{
				JOptionPane.showMessageDialog(frame, "" 
						+ "Player Name is empty, please enter name","Incorrect name",JOptionPane.ERROR_MESSAGE);
			

			}
			else if ((name != null && name.contains("-")))
			{
				JOptionPane.showMessageDialog(frame, "" 
						+ "Invalid character, please don't use - in your name","Incorrect name",JOptionPane.ERROR_MESSAGE);
			}
			else
				run = false;//valid name has been provided
				
		}
		
		//check if ok or cancel, if cancel, shut game down
		if (name != null) {
			
			//start game
			JFrame runFrame = new AlphabetGameScreen(name);
			runFrame.setVisible(true);
		}
		else//exit game
			System.exit(0);
	}

}
