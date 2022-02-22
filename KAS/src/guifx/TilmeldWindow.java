package guifx;

import application.controller.Controller;
import application.model.*;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TilmeldWindow extends Stage {
    private Konference konference;
    private Deltager deltager;
    private Ledsager ledsager;
    private Hotel hotel;
    private Tilmelding tilmelding;
    private int totalSum = -1;

    public TilmeldWindow(String title, Konference konference, Deltager deltager, Ledsager ledsager, Hotel hotel, Tilmelding tilmelding){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.konference = konference;
        this.deltager = deltager;
        this.ledsager = ledsager;
        this.hotel = hotel;
        this.tilmelding = tilmelding;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }


    private TextField txfNavn, txfAdresse, txfBy, txfLand,txfMobilNummer, txfFirmaNavn, txfKonference, txfTotalSum, txfAnkomst, txfAfrejse, txfLedsagerNavn;
    private Label lblError, lblNavn, lblAdresse, lblBy, lblLand, lblMobilNummer, lblFirmaNavn, lblAnkomst, lblAfrejse, lblLedsager, lblCb, lblHotel, lblKonference,lblFordragsholder;
    private ComboBox<Hotel> ccbHotel;
    private CheckBox cbLedsager, cbFordragsholder;
    private ComboBox<Tilvalg> ccbTilvalg, ccbTilvalg2, ccbTilvalg3, ccbTilvalg4, ccbTilvalg5;
    private ComboBox<Udflugt> ccbUdflugt;



    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        txfNavn = new TextField();
        pane.add(txfNavn, 1, 0);

        lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 2, 0);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 3, 0);

        lblBy = new Label("By:");
        pane.add(lblBy, 2, 1);

        txfBy = new TextField();
        pane.add(txfBy, 3, 1);

        lblLand = new Label("Land:");
        pane.add(lblLand, 2, 2);

        txfLand = new TextField();
        pane.add(txfLand, 3, 2);

        lblMobilNummer = new Label("Mobil Nummer:");
        pane.add(lblMobilNummer, 0, 2);

        txfMobilNummer = new TextField();
        pane.add(txfMobilNummer, 1, 2);

        lblAnkomst = new Label("Ankomst Dato:");
        pane.add(lblAnkomst, 0, 5);

        txfAnkomst = new TextField();
        pane.add(txfAnkomst, 1, 5);
        txfAnkomst.setText(konference.getStartDato().toString());

        lblAfrejse = new Label("Afrejse Dato:");
        pane.add(lblAfrejse, 2, 5);

        txfAfrejse = new TextField();
        pane.add(txfAfrejse, 3, 5);
        txfAfrejse.setText(konference.getSlutDato().toString());

        lblKonference = new Label("Valgte Konference:");
        pane.add(lblKonference, 0, 3);

        txfKonference = new TextField();
        pane.add(txfKonference, 1, 3);
        txfKonference.setEditable(false);
        txfKonference.setText(konference.getNavn().trim());

        lblFirmaNavn = new Label("Firma Navn:");
        pane.add(lblFirmaNavn, 0, 1);

        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn, 1, 1);

        lblFordragsholder = new Label("fordragsholder");
        pane.add(lblFordragsholder, 2, 6);


        cbFordragsholder = new CheckBox();
        pane.add(cbFordragsholder, 3, 6);
        cbFordragsholder.setOnAction(event -> checkboxForedragsholderAction());
        // ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> SelectedForedragsholderChanged(newValue);
       //  cbFordragsholder.selectedProperty().addListener(listener);

        lblCb = new Label("Ledsager");
        pane.add(lblCb, 0, 6);

        cbLedsager = new CheckBox();
        pane.add(cbLedsager, 1, 6);
        cbLedsager.setOnAction(event -> checkboxAction());

        lblLedsager = new Label("Ledsagers Fulde Navn:");
        pane.add(lblLedsager, 0, 7);

        txfLedsagerNavn = new TextField();
        pane.add(txfLedsagerNavn, 1, 7);
        txfLedsagerNavn.setDisable(true);

        lblHotel = new Label("Vælg Hotel:");
        pane.add(lblHotel, 0, 4);

        ccbHotel = new ComboBox<>();
        pane.add(ccbHotel, 1, 4);
        ccbHotel.getItems().addAll(konference.getHoteller());

        ChangeListener<Hotel> listener2 = (ov, oldHotel, newHotel) -> this.selectedHotelChange();
        ccbHotel.getSelectionModel().selectedItemProperty().addListener(listener2);

        ccbTilvalg = new ComboBox<>();
        pane.add(ccbTilvalg, 2, 4);

        ccbTilvalg2 = new ComboBox<>();
        pane.add(ccbTilvalg2, 3, 4);

        ccbTilvalg3 = new ComboBox<>();
        pane.add(ccbTilvalg3, 4, 4);

        ccbUdflugt = new ComboBox<>();
        pane.add(ccbUdflugt, 1 , 8);
        ccbUdflugt.getItems().setAll(konference.getUdflugter());
        ccbUdflugt.setVisible(false);

        Label lblSum = new Label("Total:");
        pane.add(lblSum, 2, 7);

        txfTotalSum = new TextField();
        pane.add(txfTotalSum, 3, 7);
        txfTotalSum.setText(konference.getPris() + "");


        Button ok = new Button("Accept");
        pane.add(ok, 3, 8);
        ok.setOnAction(event -> acceptAction());

        Button cancel = new Button("Cancel");
        pane.add(cancel, 4, 8);

        lblError = new Label();
        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void selectedHotelChange(){
        this.updateControls();
    }

    private void SelectedForedragsholderChanged(boolean checked) {
        this.hotel = ccbHotel.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            updateControls();
        }
        txfTotalSum.setText(0+"");
    }


    public void updateControls() {
        this.hotel = ccbHotel.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            ccbTilvalg.getItems().setAll(hotel.getTilvalg());
            ccbTilvalg2.getItems().setAll(hotel.getTilvalg());
            ccbTilvalg3.getItems().setAll(hotel.getTilvalg());
        }
        totalSum = konference.getPris();
        if(cbFordragsholder.isSelected()){
            totalSum = totalSum- konference.getPris();
        }
        totalSum = totalSum + this.ccbHotel.getSelectionModel().getSelectedItem().getPris();
        txfTotalSum.setText(totalSum+"");
    }

    public void checkboxAction(){
        int udflugtpris = 0;
        if (cbLedsager.isSelected()){
            txfLedsagerNavn.setDisable(false);
            ccbUdflugt.setVisible(true);

            checkboxForedragsholderAction();
        }else {
            txfLedsagerNavn.setDisable(true);
            ccbUdflugt.setVisible(false);
            txfLedsagerNavn.clear();
            checkboxForedragsholderAction();
        }
    }

    public void checkboxForedragsholderAction(){
        int hotelpris = 0;
        if (cbFordragsholder.isSelected()){
            if(hotel != null){
                hotelpris = hotel.getPris();
                if(cbLedsager.isSelected()){
                    hotelpris = hotel.getPrisD();
                }
            }
            totalSum = hotelpris;
        }else if (!cbFordragsholder.isSelected()){
            if(hotel != null){
                hotelpris = hotel.getPris();
                if(cbLedsager.isSelected()){
                    hotelpris = hotel.getPrisD();
                }
            }
            totalSum = konference.getPris() + hotelpris;
        }
        txfTotalSum.setText(""+totalSum);
    }


    public void acceptAction () {
        DateTimeFormatter datoformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ankomst = txfAnkomst.getText().trim();
        String afrejse = txfAfrejse.getText().trim();
        LocalDate ankomstdato = LocalDate.parse(ankomst, datoformat);
        LocalDate afrejsedato = LocalDate.parse(afrejse, datoformat);
        String navn = txfNavn.getText().trim();
        String adresse = txfAdresse.getText().trim();
        String by = txfBy.getText().trim();
        String land = txfLand.getText().trim();
        String firmaNavn = txfFirmaNavn.getText().trim();
        String ledsagerNavn = txfLedsagerNavn.getText().trim();
        if (navn.length() == 0 || adresse.length() == 0 || by.length() == 0 || land.length() == 0) {
            lblError.setText("En af felterne mangler tekst");
        } else {
            int mobilNr = -1;
            try {
                mobilNr = Integer.parseInt(txfMobilNummer.getText().trim());
            } catch (NumberFormatException ex) {
                // Do nothing
            }
            if (mobilNr < 0) {
                lblError.setText("Mobil nummeret er ikke langt nok");
            }
            if (deltager != null) {
                Controller.updateDeltager(deltager, navn, adresse, firmaNavn, mobilNr);
            } else {
                Deltager deltager = Controller.createDeltager(navn, adresse, by, land, firmaNavn, mobilNr, DeltagerType.PENSIONST);
                Ledsager ledsager = Controller.createLedsager(ledsagerNavn);
                if (cbLedsager.isSelected()) {
                    Tilmelding tilmelding = Controller.createTilmelding(konference, cbFordragsholder.isSelected(), ankomstdato, afrejsedato, deltager, ledsager);
                    tilmelding.setHotel(hotel);
                }
                else{
                    Tilmelding tilmelding = Controller.createTilmelding(konference, cbFordragsholder.isSelected(), ankomstdato, afrejsedato, deltager, null);
                    tilmelding.setHotel(hotel);
                }
            }

            this.hide();
        }
    }


    private void initControls(){
        if (deltager != null){
            txfNavn.setText(deltager.getNavn());
            txfAdresse.setText(deltager.getAdresse());
            txfMobilNummer.setText("" + deltager.getMobilNr());
            txfLand.setText(deltager.getLand());
            txfBy.setText(deltager.getBy());
            txfFirmaNavn.setText(deltager.getFirmaNavn());
        }
        else{
            txfNavn.clear();
            txfAdresse.clear();
            txfMobilNummer.clear();
            txfBy.clear();
            txfLand.clear();
            txfFirmaNavn.clear();
        }
    }
}