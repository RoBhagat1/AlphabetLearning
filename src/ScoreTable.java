/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project: 
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for showing the score in a table
*********************************************************************************/
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//class to show the score in the table
public class ScoreTable extends JPanel {
	private boolean DEBUG = false;

	// Constructor
	public ScoreTable(List<GamePlayer> list) {

		// make a new grid layout that is 1 by 0
		super(new GridLayout(1, 0));

		// column names
		String[] columnNames = { "Player Name", "Score" };

		//make a 2-d list that is the array's length
		Object[][] data = new Object[list.size()][list.size()];
		int i = 0;
		
		//loop to input the data in the right row/column
		for (GamePlayer player : list) {
			data[i][0] = player.getName();
			data[i][1] = player.getScore();
			i++;

		}

		//make a new JTable
		final JTable table = new JTable(data, columnNames) {
			public boolean isCellEditable(int row, int column) {//disable cell editing
				return false;
			}
		};

		table.setPreferredScrollableViewportSize(new Dimension(700, 70));//set preferred scrollable siz
		table.setFillsViewportHeight(true);//fill in viewport height

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
	}

}
