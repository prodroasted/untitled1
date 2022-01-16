package gui;

import application.controller.Controller;
import application.model.Kamp;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Adminstration extends Application {

    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Adminstration af spiller deltagelse");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private ListView<Kamp> lwvKamp;
    private TextField txfSpillersted, txfSpilledato, txfSpilletid;
    private Label lblKampe, lblSted, lblDato, lblTid;
    private Button btnCreate, btnOpdater, btnLavFil;

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lwvKamp = new ListView<>();
        pane.add(lwvKamp, 0, 1, 2, 5);
        lwvKamp.setPrefHeight(200);
        lwvKamp.setPrefWidth(300);
        lwvKamp.getItems().addAll(Controller.getKamp());

        ChangeListener<Kamp> listener = (ov, oldDeltager, newDeltager) -> this.selectedDeltagerChange();
        lwvKamp.getSelectionModel().selectedItemProperty().addListener(listener);

        txfSpillersted = new TextField();
        pane.add(txfSpillersted, 6, 0);
        txfSpillersted.setEditable(false);

        txfSpilledato = new TextField();
        pane.add(txfSpilledato, 6, 1);
        txfSpilledato.setEditable(false);

        txfSpilletid = new TextField();
        pane.add(txfSpilletid, 6, 2);
        txfSpilletid.setEditable(false);

        lblKampe = new Label();
        pane.add(lblKampe, 0, 0);
        lblKampe.setText("Kampe");

        lblSted = new Label();
        pane.add(lblSted, 5, 0);
        lblSted.setText("Sted:");

        lblDato = new Label();
        pane.add(lblDato, 5, 1);
        lblDato.setText("Dato:");

        lblTid = new Label();
        pane.add(lblTid, 5, 2);
        lblTid.setText("Tid:");

        btnCreate = new Button();
        pane.add(btnCreate, 5, 3);
        btnCreate.setText("Create");

        btnOpdater = new Button();
        pane.add(btnOpdater, 6,3);
        btnOpdater.setText("Opdater");

        btnLavFil = new Button();
        pane.add(btnLavFil, 5, 4);
        btnLavFil.setText("Lav Fil");

    }

    private void selectedDeltagerChange() {
        Kamp kampe = lwvKamp.getSelectionModel().getSelectedItem();
        if (kampe != null) {
            txfSpillersted.setText(kampe.getSted().trim());
            txfSpilledato.setText(String.valueOf(kampe.getDato()));
            txfSpilletid.setText(String.valueOf(kampe.getTid()));
        }
    }
}
