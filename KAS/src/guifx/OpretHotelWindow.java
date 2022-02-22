package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Tilvalg;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpretHotelWindow extends Stage {

    private TextField txfHotelNavn, txfHotelPris, txfHotelTilvalg, txfTilvalgPris, txfHotelDobbel;
    private TextArea txaTilvalg;
    private Label lblHotelNavn, lblHotelPris, lblHotelTilvalg, lblTilvalgPris, lblHotelDobbel, lblØnsketTilvalg;
    private Button btnAcceptTilvalg, btnAccept, btnClear;
    private CheckBox cbTilvalg;
    private Hotel hotel;
    private Tilvalg tilvalg;

    public OpretHotelWindow(String title, Hotel hotel, Tilvalg tilvalg) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.hotel = hotel;
        this.tilvalg = tilvalg;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblHotelNavn = new Label("Hotel Navn:");
        pane.add(lblHotelNavn, 0, 0);

        txfHotelNavn = new TextField();
        pane.add(txfHotelNavn, 1, 0);

        lblHotelPris = new Label("Enkeltværelses Pris:");
        pane.add(lblHotelPris, 0, 1);

        txfHotelPris = new TextField();
        pane.add(txfHotelPris, 1, 1);

        txaTilvalg = new TextArea();
        pane.add(txaTilvalg, 2, 0, 2, 4);
        txaTilvalg.setPrefWidth(200);
        txaTilvalg.setPrefHeight(100);

        lblHotelDobbel = new Label("Dobbeltværelses pris:");
        pane.add(lblHotelDobbel, 0, 2);

        txfHotelDobbel = new TextField();
        pane.add(txfHotelDobbel, 1, 2);

        lblØnsketTilvalg = new Label("Ønsker du Tilvalg?");
        pane.add(lblØnsketTilvalg, 0, 3);

        cbTilvalg = new CheckBox();
        pane.add(cbTilvalg, 1, 3);
        cbTilvalg.setOnAction(event -> cbAction());

        lblHotelTilvalg = new Label("Navn på Tilvalg:");
        pane.add(lblHotelTilvalg, 0, 4);

        txfHotelTilvalg = new TextField();
        pane.add(txfHotelTilvalg, 1, 4);
        txfHotelTilvalg.setDisable(true);

        lblTilvalgPris = new Label("Pris på Tilvalg:");
        pane.add(lblTilvalgPris, 0, 5);

        txfTilvalgPris = new TextField();
        pane.add(txfTilvalgPris, 1, 5);
        txfTilvalgPris.setDisable(true);

        btnAcceptTilvalg = new Button("Accepter Tilvalg");
        pane.add(btnAcceptTilvalg, 1, 6);
        btnAcceptTilvalg.setDisable(true);
        btnAcceptTilvalg.setOnAction(event -> accepterTilvalg());

        btnAccept = new Button("Accept");
        pane.add(btnAccept, 3, 6);
        btnAccept.setOnAction(event -> createHotel());

        btnClear = new Button("Slet alle Tilvalg");
        pane.add(btnClear, 2, 6);
        btnClear.setOnAction(event -> clearTilvag());

    }

    public void createHotel() {
        String tilvalgNavn = txfHotelTilvalg.getText();
        int tilvalgPris = 0;
        try {
            tilvalgPris = Integer.parseInt(txfTilvalgPris.getText());
        }catch (NumberFormatException ex){
            // Do nothing
        }
        String navn = txfHotelNavn.getText();
        int pris = Integer.parseInt(txfHotelPris.getText());
        int prisdobbelt = Integer.parseInt(txfHotelDobbel.getText());
        if (hotel != null) {
            Controller.updateTilvalg(tilvalg, tilvalgNavn, tilvalgPris);
            Controller.updateHotel(hotel, navn, pris, prisdobbelt);
        } else {
            Hotel hotel = Controller.createHotel(navn, pris, prisdobbelt);
            Controller.createTilvalg(hotel, tilvalgNavn, tilvalgPris);
        }
        this.hide();
    }

    public void clearTilvag(){
        txaTilvalg.clear();
    }

    public void accepterTilvalg() {
        txaTilvalg.appendText(txfHotelTilvalg.getText() + ", Pris:" + Integer.parseInt(txfTilvalgPris.getText()) + "\n");
        txfHotelTilvalg.clear();
        txfTilvalgPris.clear();
    }


    public void cbAction(){
        if (cbTilvalg.isSelected()){
            btnAcceptTilvalg.setDisable(false);
            txfHotelTilvalg.setDisable(false);
            txfTilvalgPris.setDisable(false);
        }else{
            btnAcceptTilvalg.setDisable(true);
            txfHotelTilvalg.setDisable(true);
            txfTilvalgPris.setDisable(true);
            txfHotelTilvalg.clear();
            txfTilvalgPris.clear();
            txaTilvalg.clear();

        }
    }
}