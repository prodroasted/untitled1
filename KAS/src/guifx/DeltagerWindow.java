package guifx;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Konference;
import application.model.Tilmelding;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeltagerWindow extends Stage {
    private Konference konference;
    private Tilmelding tilmelding;

    public DeltagerWindow(String title, Konference konference, Tilmelding tilmelding) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;
        this.tilmelding = tilmelding;


        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextArea txaDeltager;
    private ListView<Deltager> lvwDeltager;
    private TextField txfNavn, txfAdresse, txfMobilNr, txfFirmaNavn, txaBy, txaLand, txfType, txfTilmeldingsNr, txfLedsager;
    private Label lblNavn, lblAdresse, lblMobilNr, lblFirmaNavn, lblBy, lblLand, lblType, lblDeltager, lblTilmeldingsNr, lblLedsager;
    private Button btnTilmeld;


    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);


        lblDeltager = new Label("Deltagere:");
        pane.add(lblDeltager, 0, 0);

        lvwDeltager = new ListView<>();
        pane.add(lvwDeltager, 0, 1, 1, 3);
        lvwDeltager.setPrefHeight(200);
        lvwDeltager.setPrefWidth(400);
        System.out.println(konference);
        lvwDeltager.getItems().setAll(konference.getDeltagere());

        ChangeListener<Deltager> listener = (ov, oldDeltager, newDeltager) -> this.selectedDeltagerChange();
        lvwDeltager.getSelectionModel().selectedItemProperty().addListener(listener);

        lblNavn = new Label("Navn:");
        pane.add(lblNavn, 1, 1);

        txfNavn = new TextField();
        pane.add(txfNavn, 2, 1);
        txfNavn.setEditable(false);

        lblMobilNr = new Label("Mobil Nr:");
        pane.add(lblMobilNr, 1, 2);

        txfMobilNr = new TextField();
        pane.add(txfMobilNr, 2, 2);
        txfMobilNr.setEditable(false);

        lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 1, 3);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 2, 3);
        txfAdresse.setEditable(false);

        lblType = new Label("Fordragsholder:");
        pane.add(lblType, 1, 4);

        txfType = new TextField();
        pane.add(txfType, 2, 4);
        txfType.setEditable(false);

        lblFirmaNavn = new Label("Firma Navn:");
        pane.add(lblFirmaNavn, 1, 5);

        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn, 2, 5);
        txfFirmaNavn.setEditable(false);

        lblTilmeldingsNr = new Label("Tilmeldings Nr:");
        pane.add(lblTilmeldingsNr, 1, 6);

        txfTilmeldingsNr = new TextField();
        pane.add(txfTilmeldingsNr, 2, 6);

        Button btnUpdate = new Button("Update");
        pane.add(btnUpdate, 0, 5);
        btnUpdate.setOnAction(event -> this.updateAction());

    }

    private void updateAction() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();
        if (deltager != null) {

            TilmeldWindow dia = new TilmeldWindow("Update Window", konference, deltager, null, null, tilmelding);
            dia.showAndWait();

            // Wait for the modal dialog to close

            int selectIndex = lvwDeltager.getSelectionModel().getSelectedIndex();
            lvwDeltager.getItems().setAll(Controller.getDeltager());
            lvwDeltager.getSelectionModel().select(selectIndex);
        }
    }

    private void selectedDeltagerChange() {
        this.updateControls();
    }

    public void updateControls() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            txfNavn.setText(deltager.getNavn());
            txfAdresse.setText(deltager.getAdresse().trim());
            txfMobilNr.setText(String.valueOf(deltager.getMobilNr()));
            txfFirmaNavn.setText(deltager.getFirmaNavn());
            if(deltager.erForedragsholder() == true){
                txfType.setText("Foredragsholder");
            }
            else{
                txfType.setText("");
            }
            if(deltager.getDeltagersTilmeldingsNr() > 0){
                txfTilmeldingsNr.setText(deltager.getDeltagersTilmeldingsNr()+"");
            }

        }
        else{
            txfNavn.clear();
            txfAdresse.clear();
            txfMobilNr.clear();
            txfFirmaNavn.clear();
            txfType.clear();
        }
    }
}