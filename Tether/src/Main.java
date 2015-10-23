import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private ImageView image1 = new ImageView(new Image("dota2_io_sticker.png"));
	private ImageView image2 = new ImageView(new Image("dota2_io_sticker.png"));
	
	@Override
	public void start(Stage stage) {
		image1.setFitHeight(100);
		image1.setFitWidth(100);
		image1.setX(100);
		image1.setY(200);
		image2.setFitHeight(100);
		image2.setFitWidth(100);
		image2.setX(300);
		image2.setY(200);
		Text distance = new Text();
		distance.setText("200");
		image1.setOnMouseDragged(e -> {
			image1.setX(e.getX() - image1.getFitWidth()/2);
			image1.setY(e.getY() - image1.getFitHeight()/2);
			distance.setText(""+(int)Math.sqrt(Math.pow(image2.getX()-image1.getX(), 2)+Math.pow(image2.getY()-image1.getY(), 2)));
		});
		image2.setOnMouseDragged(e -> {
			image2.setX(e.getX() - image2.getFitWidth()/2);
			image2.setY(e.getY() - image2.getFitHeight()/2);
			distance.setText(""+(int)Math.sqrt(Math.pow(image2.getX()-image1.getX(), 2)+Math.pow(image2.getY()-image1.getY(), 2)));
		});
		distance.xProperty().bind(image1.xProperty().add(image2.xProperty()).divide(2).add(50));
		distance.yProperty().bind(image1.yProperty().add(image2.yProperty()).divide(2).add(50));
		Line tether = new Line();
		tether.startXProperty().bind(image1.xProperty().add(image1.fitWidthProperty().divide(2)));
		tether.startYProperty().bind(image1.yProperty().add(image1.fitHeightProperty().divide(2)));
		tether.endXProperty().bind(image2.xProperty().add(image2.fitWidthProperty().divide(2)));
		tether.endYProperty().bind(image2.yProperty().add(image2.fitHeightProperty().divide(2)));
		tether.setStroke(new Color(.5, .95, .99, 1));
		tether.setStrokeWidth(5);
		Pane pane = new Pane();
		pane.getChildren().addAll(tether, image1, image2, distance);
		stage.setScene(new Scene(pane, 500, 500));
		stage.setTitle("Tether");
		stage.show();
	}

}
