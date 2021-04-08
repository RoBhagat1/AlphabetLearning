/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project: 
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for making the letter-buttons
*********************************************************************************/
import java.awt.*;

import javax.swing.*;

import javafx.scene.paint.Color;
//class to make letter-buttons
public class AlphabetLetterButton extends JButton{
	//character of the button
	private char letter;
	//constructor
	public AlphabetLetterButton(GameImageLetter gLetter)
	{
		
		//get the letter and set its properties
		this.letter=gLetter.getLetter();
		super.setFont(new Font("Segoe Script", Font.BOLD, 40));//set font
		super.setText(String.valueOf(letter));//set the text
		super.setBorder(BorderFactory.createRaisedBevelBorder());//make a raised border
		super.setPreferredSize(new java.awt.Dimension(80, 80));//set dimensions
		super.setForeground(gLetter.getLetterColor());//get color
		super.setOpaque(true);//set it to opaque
		super.setBorderPainted(false);//don't paint border
		
	}
	//get the letter to return later
	public char getLetter() 
	{
		return letter;
	}
	
	

}
