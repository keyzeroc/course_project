package project.entity;

import java.util.HashMap;

public class UserDB {
    private static final HashMap<String,User> users = new HashMap<>(); // <NAME, USER>

    public static void addUser(User user){
        users.put(user.getName(),user);
    }

    public static boolean nameAvailable(String name){
        return !(users.containsKey(name));
    }
}
