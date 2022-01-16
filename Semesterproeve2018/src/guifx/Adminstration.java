package guifx;


import application.controller.Controller;
import application.model.Arrangement;
import application.model.Tutor;
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
        stage.setTitle("Adminstration af tutorer og arrangementer");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private ListView<Tutor> lvwTutor;
    private TextField txfNavn, txfEmail;
    private ListView<Arrangement> lvwArragement, lvwMulige;
    private Label lblTutor, lblNavn, lblEmail, lblArragement, lblMulige;
    private Button btnFjern, btnTilføj;

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblTutor = new Label();
        pane.add(lblTutor, 0, 0);
        lblTutor.setText("Tutorer");

        lvwTutor = new ListView<>();
        pane.add(lvwTutor, 0, 1, 2, 5);
        lvwTutor.setPrefHeight(200);
        lvwTutor.setPrefWidth(300);
        lvwTutor.getItems().addAll(Controller.getTutorer());

        ChangeListener<Tutor> listener = (ov, oldTutor, newTutor) -> this.selectedTutorChange();
        lvwTutor.getSelectionModel().selectedItemProperty().addListener(listener);

        lblNavn = new Label();
        pane.add(lblNavn, 5, 1);
        lblNavn.setText("Navn");

        txfNavn = new TextField();
        pane.add(txfNavn, 6, 1);
        txfNavn.setEditable(false);

        lblEmail = new Label();
        pane.add(lblEmail, 5, 2);
        lblEmail.setText("Email");

        txfEmail = new TextField();
        pane.add(txfEmail, 6, 2);
        txfEmail.setEditable(false);

        lblArragement = new Label();
        pane.add(lblArragement, 5, 3);
        lblArragement.setText("Arrangementer");

        lvwArragement = new ListView<>();
        pane.add(lvwArragement, 6, 3);
        lvwArragement.setPrefHeight(100);
        lvwArragement.setPrefWidth(300);
        lvwArragement.setEditable(false);

        lblMulige = new Label();
        pane.add(lblMulige, 7, 2);
        lblMulige.setText("Alle Mulige Arragementer");

        lvwMulige = new ListView<>();
        pane.add(lvwMulige, 7, 3);
        lvwMulige.setPrefHeight(100);
        lvwMulige.setPrefWidth(300);
        lvwMulige.setEditable(false);
        lvwMulige.getItems().addAll(Controller.getArragement());

        btnFjern = new Button();
        pane.add(btnFjern, 6, 4);
        btnFjern.setText("Fjern");
        btnFjern.setOnAction(event -> fjernArragement());

        btnTilføj = new Button();
        pane.add(btnTilføj, 7, 4);
        btnTilføj.setText("Tilføj");
        btnTilføj.setOnAction(event -> opretArragement());

    }

    public void selectedTutorChange() {
        Tutor tutor = lvwTutor.getSelectionModel().getSelectedItem();
        if (tutor != null) {
            txfNavn.setText(tutor.getNavn().trim());
            txfEmail.setText(tutor.getEmail().trim());
            lvwArragement.getItems().setAll(tutor.getArrangements());
        }
    }

    public void opretArragement(){
        Arrangement arrangementmulige = lvwMulige.getSelectionModel().getSelectedItem();
        Tutor tutor = lvwTutor.getSelectionModel().getSelectedItem();
        if (arrangementmulige != null && tutor != null){
            tutor.addArragement(arrangementmulige);
            lvwArragement.getItems().add(arrangementmulige);
        }
    }

    public void fjernArragement() {
        Arrangement arrangement = lvwArragement.getSelectionModel().getSelectedItem();
        Tutor tutor = lvwTutor.getSelectionModel().getSelectedItem();
        if (tutor != null && arrangement != null) {
            tutor.removeArragement(arrangement);
            lvwArragement.getItems().remove(arrangement);
        }
    }
}
