
package com.mycompany.titanproj;

public class TitanUserSession {
    private static TitanUser loggedInTitanUser;

    public static void setLoggedInTitanUser(TitanUser user) {
        loggedInTitanUser = user;
    }

    public static TitanUser getLoggedInTitanUser() {
        return loggedInTitanUser;
    }
}
