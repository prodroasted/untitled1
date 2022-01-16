package guifx;

import application.Model.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateUserWindow extends Stage {
    private User user;

    public CreateUserWindow(String title){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.user = user;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextField txfUser;
    private PasswordField PFpass;
    private Label lblError;

    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblUser = new Label("Username / Email");
        pane.add(lblUser, 0, 0);

        txfUser = new TextField();
        pane.add(txfUser, 0, 1);

        Label lblpass = new Label("Password");
        pane.add(lblpass, 0, 2);

        PFpass = new PasswordField();
        pane.add(PFpass, 0, 3);

        Button ok = new Button("Accept");
        pane.add(ok, 0, 4);

    }
}
