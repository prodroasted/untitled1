package guifx;

import application.Model.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class loginscreen extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Loginscreen Demo");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private TextField user, password;

    private void initContent(GridPane pane){
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));

        pane.setHgap(10);

        pane.setVgap(10);

        Label lbluser = new Label("Username / Email");
        pane.add(lbluser, 0, 0);

        TextField txfuser = new TextField();
        pane.add(txfuser, 0, 1);

        Label lblpass = new Label("Password");
        pane.add(lblpass, 0, 2);

        PasswordField PFpass = new PasswordField();
        pane.add(PFpass, 0, 3);

        Button btnlogin = new Button("Login");
        pane.add(btnlogin, 2, 4);

        Button btnexit = new Button("Forgot Password");
        pane.add(btnexit, 1, 4);

        Button btncreate = new Button("Create Account");
        pane.add(btncreate, 0, 4);
        btncreate.setOnAction(actionEvent -> createUser());

    }

    public void createUser (){
        CreateUserWindow create = new CreateUserWindow("Create Account");
        create.showAndWait();
    }

}
