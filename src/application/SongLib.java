//Coders: Brenda M. Rios (NetID: bmr111) & Roy Jacome (NetID: roj5)

package application;
	
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import application.Songs.Song;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class SongLib extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();   
			loader.setLocation(getClass().getResource("/application/ListView.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			ListViewController listController = loader.getController();
			ArrayList<Song> songlist = new ArrayList<Song>();
			
			/*Fills ArrayList called songlist if songlist.txt exists && is not empty
			 * songlist is in alphabetical order upon filling.*/
			File file = new File("songlibrary.txt"); //C:/Users/Belle/Desktop/
			if(file.exists() && file.isFile()){
				Scanner sc = new Scanner(file);
				while(sc.hasNextLine()){
					String ln = sc.nextLine();
					String arr [] = ln.split("~");
					if(!arr[2].equals(" ")) {
						songlist.add(new Song(arr[0], arr[1], arr[2], Integer.parseInt(arr[3])));
					}
					else {
						songlist.add(new Song(arr[0], arr[1], null, Integer.parseInt(arr[3])));
					}
				}
				sc.close();
			}
			else{ 
				System.out.println("File doesn't exist. New file being created...");
				file.createNewFile();
				//file.getParentFile().mkdirs();
			}
			listController.start(primaryStage, file, songlist);
			Scene scene = new Scene(root,700,550);
			primaryStage.setTitle("Song Library");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}