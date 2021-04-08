/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project: 
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for storing player data
*********************************************************************************/
import java.util.Comparator;

//class to store player information
public class GamePlayer implements Comparable{
	private String name;
	private int score;
	
	//constructor for name and score
	public GamePlayer(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	
	//get name
	public String getName() {
		return name;
	}
	
	//get score
	public int getScore() {
		return score;
	}
	
	//set the name
	public void setName(String name) {
		this.name = name;
	}
	
	//set the score
	public void setScore(int score) {
		this.score = score;
	}
	
	//compare to method to sort the data
	@Override
	public int compareTo(Object arg0) {//compare to class to sort
		
		GamePlayer compareTo = (GamePlayer) arg0;
		return (compareTo.getScore() - this.score);//sort it
	}
	

}
