package guifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Booking extends Application {

    public void start(Stage stage) throws Exception{
        stage.setTitle("Booking af tennisbaner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private void initContent(GridPane pane) {
        
    }
}
