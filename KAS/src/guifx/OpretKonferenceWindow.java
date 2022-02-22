package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OpretKonferenceWindow extends Stage {

    private TextField txfKonfNavn, txfKonfLokation, txfDagsPris;
    private Label lblKonfNavn, lblKonfStart, lblKonfSlut, lblKonfLokation, lblHotel, lblDagsPris;
    private ComboBox<Hotel> cbHotel;
    private DatePicker dpKonfStart, dpKonfSlut;
    private Button btnAccept;
    private Konference konference;

    public OpretKonferenceWindow(String title, Konference konference){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblKonfNavn = new Label("Konference Navn:");
        pane.add(lblKonfNavn, 0, 0);

        txfKonfNavn = new TextField();
        pane.add(txfKonfNavn, 1, 0);

        lblKonfLokation = new Label("Lokation:");
        pane.add(lblKonfLokation, 0, 1);

        txfKonfLokation = new TextField();
        pane.add(txfKonfLokation, 1, 1);

        lblKonfStart = new Label("Start Dato:");
        pane.add(lblKonfStart, 0, 2);

        dpKonfStart = new DatePicker();
        pane.add(dpKonfStart, 1, 2);

        lblKonfSlut = new Label("Slut Dato:");
        pane.add(lblKonfSlut, 3, 2);

        dpKonfSlut = new DatePicker();
        pane.add(dpKonfSlut, 4, 2);

        lblHotel = new Label("Vælg Hotel");
        pane.add(lblHotel, 0, 3);

        cbHotel = new ComboBox<>();
        pane.add(cbHotel, 1, 3);
        cbHotel.getItems().addAll(Controller.getHotels());

        txfDagsPris = new TextField();
        pane.add(txfDagsPris, 4, 4);

        lblDagsPris = new Label("Dags Pris:");
        pane.add(lblDagsPris, 3, 4);

        btnAccept = new Button("Accept");
        pane.add(btnAccept, 5, 5);
        btnAccept.setOnAction(event -> acceptButton());

    }

    public void acceptButton(){
        LocalDate start = dpKonfStart.getValue();
        LocalDate slut = dpKonfSlut.getValue();
        String lokation = txfKonfLokation.getText();
        String navn = txfKonfNavn.getText();
        int pris = Integer.parseInt(txfDagsPris.getText());
        if (konference != null) {
            Controller.updateKonference(konference, navn, lokation, pris, start, slut);
        }else {
            Controller.createKonference(navn, lokation, pris, start, slut);
        }
        this.hide();
    }
}