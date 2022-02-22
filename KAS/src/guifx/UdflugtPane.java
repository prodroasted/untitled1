package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

    public class UdflugtPane extends GridPane {
        private Udflugt selectedUdflugt;
        private ListView<Udflugt> lvwUdflugter;
        private ListView<String> lvwLedsagere;
        private TextArea txaUdflugter;
        private Button btnOpretUdflugt;
        private Udflugt udflugt;
        private Ledsager ledsager;
        private Tilmelding tilmelding;
        private Konference konference;

        public UdflugtPane() {
            this.setPadding(new Insets(20));
            this.setHgap(20);
            this.setVgap(10);
            this.setGridLinesVisible(false);

            lvwUdflugter = new ListView<>();
            this.add(lvwUdflugter, 0, 0);
            this.lvwUdflugter.setPrefHeight(200);
            this.lvwUdflugter.setPrefWidth(400);
            this.lvwUdflugter.getItems().addAll(Controller.getUdflugter());

            ChangeListener<Udflugt> listener = (ov, oldHotel, newHoteller) -> this.selectedUdflugtChange();
            lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listener);

            txaUdflugter = new TextArea();
            this.add(txaUdflugter, 1, 0);
            this.txaUdflugter.setPrefHeight(200);
            this.txaUdflugter.setPrefWidth(200);

            lvwLedsagere = new ListView<>();
            this.add(lvwLedsagere, 2, 0);
            this.lvwLedsagere.setPrefHeight(200);
            this.lvwLedsagere.setPrefWidth(200);
            lvwLedsagere.getItems().addAll(udflugt.getPris()+"\n");

            btnOpretUdflugt = new Button("Opret Udflugt");
            this.add(btnOpretUdflugt, 1, 5);
       //     btnOpretUdflugt.setOnAction(event -> OpretUdflugtWindow());

        }

        public void opretUdflugtWindow(){
       // OpretUdflugtWindow opret = new OpretUdflugtWindow("Opret Hotel", selectedUdflugt, null);
       //     opret.showAndWait();

            lvwUdflugter.getItems().setAll(Controller.getUdflugter());
            int Index = lvwUdflugter.getItems().size() -1;
            lvwUdflugter.getSelectionModel().select(Index);
        }


        public void updateControls() {
            this.selectedUdflugt = lvwUdflugter.getSelectionModel().getSelectedItem();

            if (this.selectedUdflugt != null) {
                txaUdflugter.setText(this.selectedUdflugt.getNavn() + "\n");

                }

        }

        public void selectedUdflugtChange() {
            this.updateControls();
        }
    }

