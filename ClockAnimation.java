
//U10111003朱永捷

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class ClockAnimation extends Application {
  // create button
	private Button reset = new Button("暫停時間");
	private Button upH = new Button("加一小時");
	private Button downH = new Button("減一小時");
	private Button upM = new Button("加一分鐘");
	private Button downM = new Button("減一分鐘");
	private Button start = new Button("調整完成");
	private int addH = 0;
	private int addM = 0;

	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		ClockPane clock = new ClockPane(); // Create a clock
		GridPane place = new GridPane();
		place.setAlignment(Pos.CENTER);
		place.setPadding(new Insets(12.5, 12.5, 12.5, 12.5));
		place.setHgap(5);
		place.setVgap(5);

		// Add button
		place.add(reset, 0, 0);
		place.add(start, 0, 1);
		place.add(upH, 1, 0);
		place.add(downH, 1, 1);
		place.add(upM, 2, 0);
		place.add(downM, 2, 1);

		// Add all
		pane.setCenter(clock);
		pane.setBottom(place);

		// set time
		clock.setCurrentTime();

		// Create a handler for animation
		EventHandler<ActionEvent> eventHandler = e -> {
			clock.setCurrentTime(); // Set a new clock time
		};
    
		// Create an animation for a running clock
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation

		// Create button event
		reset.setOnAction(e -> {
			animation.stop();
		});
		start.setOnAction(e -> {
			animation.play();
		});
		upH.setOnAction(e -> {
			addH += 1;
			clock.setAddH(addH);
		});
		downH.setOnAction(e -> {
			addH -= 1;
			clock.setAddH(addH);
		});
		upM.setOnAction(e -> {
			addM += 1;
			clock.setAddM(addM);
		});
		downM.setOnAction(e -> {
			addM -= 1;
			clock.setAddM(addM);
		});
    
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 350);
		primaryStage.setTitle("ClockAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
	public static void main(String[] args) {
		launch(args);
	}
}
