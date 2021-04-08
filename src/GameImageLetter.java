/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project: 
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for storing the letter and its related properties
*********************************************************************************/
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//class to store letter and its related properties
public class GameImageLetter {
	private String imageFile;
	private String soundFile;
	private char letter;
	private static List<Color> colorList;
	private int letterColor;
	
	//create a game letter with image file, sound files, and letter
	public GameImageLetter(String imageFile,String soundFile, char letter) {
		this.imageFile = imageFile;
		this.soundFile = soundFile;
		this.letter= letter;
			
		// create a randomized color list for the letters
		colorList = new ArrayList<Color>();
		colorList.add(new Color(102, 0, 153));
		colorList.add(new Color(0, 255, 127));
		colorList.add(new Color(210, 105, 30));
		colorList.add(new Color(255, 0, 255));
		colorList.add(new Color(0, 0, 255));
		colorList.add(new Color(220, 20, 60));
		//get the random color
		letterColor = (int) (Math.random() * 5);


	}
	//return the letter
	public char getLetter()
	{
		return letter;
	}
	
	//return sound file of letter
	public String getSoundFile()
	{
		return soundFile;
	}
	
	//return image file of letter
	public String getImageFile()
	{
		return imageFile;
	}

	//return color of the letter
	public Color getLetterColor() {
		return colorList.get(letterColor);
	}
}
