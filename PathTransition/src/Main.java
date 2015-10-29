import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Jason Kuo
 * 10/27/15
 */
public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private ImageView sun = new ImageView(new Image("dota2_io_sticker.png"));
	private ImageView quas = new ImageView(new Image("Quas.png"));
	private ImageView wex = new ImageView(new Image("Wex.png"));
	private ImageView exort = new ImageView(new Image("Exort.png"));
	
	@Override
	public void start(Stage stage) {
		sun.setFitHeight(100);
		sun.setFitWidth(100);
		sun.setX(200);
		sun.setY(200);
		quas.setFitHeight(50);
		quas.setFitWidth(50);
		wex.setFitHeight(50);
		wex.setFitWidth(50);
		exort.setFitHeight(50);
		exort.setFitWidth(50);
		Circle orbit1 = new Circle();
		orbit1.setRadius(70);
		orbit1.setCenterX(250);
		orbit1.setCenterY(250);
		PathTransition path1 = new PathTransition();
		path1.setPath(orbit1);
		path1.setNode(quas);
		path1.setDuration(Duration.seconds(4));
		path1.setCycleCount(Timeline.INDEFINITE);
		path1.setDelay(Duration.millis(0));
		Circle orbit2 = new Circle();
		orbit2.setRadius(150);
		orbit2.setCenterX(250);
		orbit2.setCenterY(250);
		PathTransition path2 = new PathTransition();
		path2.setPath(orbit2);
		path2.setNode(wex);
		path2.setDuration(Duration.seconds(7));
		path2.setCycleCount(Timeline.INDEFINITE);
		Circle orbit3 = new Circle();
		orbit3.setRadius(200);
		orbit3.setCenterX(250);
		orbit3.setCenterY(250);
		PathTransition path3 = new PathTransition();
		path3.setPath(orbit3);
		path3.setNode(exort);
		path3.setDuration(Duration.seconds(17));
		path3.setCycleCount(Timeline.INDEFINITE);
		
		path1.play();
		path2.play();
		path3.play();
		
		Pane pane = new Pane();
		pane.setOnMousePressed(e -> {path1.pause();path2.pause();path3.pause();});
		pane.setOnMouseReleased(e -> {path1.play();path2.play();path3.play();});
		pane.getChildren().addAll(quas, wex, exort, sun);
		stage.setScene(new Scene(pane, 500, 500, Color.BLACK));
		stage.setTitle("Wispcentric Systems");
		stage.show();
	}

}
