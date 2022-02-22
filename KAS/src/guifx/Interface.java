package guifx;

import application.controller.Controller;
import application.model.Konference;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Interface extends Application {
    @Override
    public void init(){
        Controller.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tilmelding");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent(BorderPane pane){
        TabPane tabPane = new TabPane();
        this.initTab(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTab (TabPane tabPane){
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabKonference = new Tab("Konferencer");
        tabPane.getTabs().add(tabKonference);

        KonferencePane konferencePane = new KonferencePane();
        tabKonference.setContent(konferencePane);
        tabKonference.setOnSelectionChanged(event -> konferencePane.updateControls());

        Tab tabHotel = new Tab("Hoteller");
        tabPane.getTabs().add(tabHotel);

        HotelPane hotelPane = new HotelPane();
        tabHotel.setContent(hotelPane);
        tabHotel.setOnSelectionChanged(event -> hotelPane.updateControls());


    }
}