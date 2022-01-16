package storage;

import application.Model.User;
import java.util.ArrayList;

public class Storage {

    public static ArrayList<User> users = new ArrayList<>();

    public static void addUser(User user){users.add(user);}
}
