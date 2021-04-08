/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project: 
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for storing the score and player data
*********************************************************************************/
import java.io.*;
import java.util.*;

//class for storing player's name and score
public class ScoreFile {

	private List<GamePlayer> gamePlayers;
	private String fileName;
	private String myFilePath;
	private final int TOTAL_SCORE = 5;

	//Constructor
	public ScoreFile() {

		//create list of player
		gamePlayers = new ArrayList<GamePlayer>();
		fileName = "scores.txt";
		myFilePath = "files/";

	}

	//update the score by adding new name and score
	public void addScore(String name, int score) {

		gamePlayers.add(new GamePlayer(name, score));

	}

	//get the list of the players
	public List<GamePlayer> getGamePlayers() {
		return gamePlayers;
	}
	
	//save the top 5 scores to the file
	public void saveScore() {
		try {
			File myFile = new File(myFilePath + fileName);
			PrintWriter out = new PrintWriter(myFile);

			//sort the scores by highest
			Collections.sort(gamePlayers);
			
			//get top five scores
			int top_five = Math.min(TOTAL_SCORE, gamePlayers.size());
			for (int i = 0; i < top_five; i++) {//get only the top 5 scores
				out.println(gamePlayers.get(i).getName() + "-" + gamePlayers.get(i).getScore());
			}
			out.close();//close file
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	//read the scores
	public void readScore() {
		try {

			//clear original list
			gamePlayers.clear();

			//open the file and read the lines
			File myFile = new File(myFilePath + fileName);
			BufferedReader in = new BufferedReader(new FileReader(myFile));
			String line = in.readLine(); // Read in a line from file

			while (line != null) {
				//seperate the player name and score using indexOf - 
				int index = line.indexOf('-');
				if (index >= 0) {
					String name = line.substring(0, index);//get playerName using substring
					String score = line.substring(index + 1);//get the score
					GamePlayer newPlayer = new GamePlayer(name, Integer.parseInt(score));
					gamePlayers.add(newPlayer);//add new player
				}
				line = in.readLine();
			}

			in.close(); // Close input file

			Collections.sort(gamePlayers);//sort topScores 
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}