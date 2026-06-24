
package com.mycompany.titanproj;

import java.util.ArrayList;

public class TitanUdata {
    private static ArrayList<TitanUser> users = new ArrayList<>();

    public static void addTitanUser(TitanUser user) {
        users.add(user);
    }

    public static TitanUser login(String email, String password) {
        for (TitanUser user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;  // Return null if login fails
    }
}

