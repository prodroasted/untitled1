package application.Controller;

import application.Model.User;
import storage.Storage;

public class Controller {

    public static User createUser(String email, String password){
        User user = new User(email, password);
        Storage.addUser(user);
        return user;
    }

    public static void initContent(){

    }

}
