/*********************************************************************************
Name: Rohan Bhagat
Course: CS170-0X
Project: 
Submission Date: 10:00 pm, Wed (12/9)
Brief Description: The code for making a music player class
*********************************************************************************/
import java.io.File;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

//music player class
public class MusicPlayer extends Application {

	// start the stage
	public void start(Stage stage) {
		stage.show();
	}

	// play the music file
	public void play(File file) {
		AudioClip audioClip = new AudioClip(file.toURI().toString());
		audioClip.play();
	}

}
