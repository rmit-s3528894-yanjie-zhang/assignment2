package gui;

import java.util.ArrayList;

import Ozlympic.Driver;
import Ozlympic.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowFinalResult implements EventHandler<ActionEvent> {

	ArrayList<Game> games;
	Driver driver;

	ShowFinalResult(ArrayList<Game> games, Driver driver) {
		this.driver = driver;
		this.games = games;
	}

	@Override
	public void handle(ActionEvent event) {
		int countGame = games.size();

		Stage showFinalResult = new Stage();
		showFinalResult.setTitle("Result");

		GridPane border = new GridPane();
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(border);

		border.setPadding(new Insets(5));
		border.setHgap(20);
		border.setVgap(5);

		Scene scene=new Scene(scrollPane,450, 400);         
		
		for(int i=0;i<countGame;i++)
		{
	        Text GameNumber=new Text( "GameNumber: "+games.get(i).getGameID());
	        GameNumber.setFill(Color.RED);
	        Text OfficalName=new Text( "OfficalName: "+driver.getOffName(games.get(i).getOfficialID()));
	        final Text Name=new Text( "Name");
	        final Text Age=new Text("Age");
	        final Text State=new Text("State");
	        final Text AthleteType=new Text("Athlete Type");
	        final Text Time=new Text("Time");
	        final Text Point=new Text("Point");
	        border.add(GameNumber, 0, i*12+0);
	        border.add(OfficalName, 0, i*12+1);
	        border.add(Name, 0, i*12+2);
	        border.add(Age, 1, i*12+2);
	        border.add(State, 2, i*12+2);
	        border.add(AthleteType, 3, i*12+2);
	        border.add(Time, 4, i*12+2);
	        border.add(Point, 5, i*12+2);
	
	        int countAthlete=games.get(i).getAthletes().size();
	        for(int j=0;j<countAthlete;j++)
	        {
	    		String[] athleteinf = driver.getAthleteInf(games.get(i).getAthletes().get(j));
	        	int time = games.get(i).getResults().get(j);
				int point = games.get(i).getPoints().get(j);
				border.add(new Text(athleteinf[0]), 0,i*12+j+3);
				border.add(new Text(athleteinf[1]), 1,i*12+j+3);
				border.add(new Text(athleteinf[2]), 2,i*12+j+3);
				border.add(new Text(athleteinf[3]), 3,i*12+j+3);
				border.add(new Text(time+""), 4,i*12+j+3);
				border.add(new Text(point+""), 5,i*12+j+3);
	        }
		}
		showFinalResult.setScene(scene);
		showFinalResult.show(); // Display the stage
	}
}