package com.example.pac_architecture.LandingPAC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LandingAbstraction {
    /**
     * The set of customers account
     */
    private final Map<String, String> customersMap = new HashMap<>();

    /**
     * The set of sellers account
     */
    private final Map<String, String> sellersMap = new HashMap<>();

    /**
     * Constructor of the class, add all the login/password data needed to the app
     * from the file ""
     */
    public LandingAbstraction() {
        // add the file data
    }

    /**
     * Tell if a User is in the database for login
     * 
     * @param login represent the login of the User
     * @param password represent the password of the User
     * @param mode tell if the user want to be register as a seller or a csustomer
     * 
     * @return 1 if the User as an account, 0 if not, -1 if there is an error
     */
    public int getUser(String login, String password, LandingController.Mode mode) {
        switch (mode) {
            case Seller :
                if (sellersMap.containsKey(login) && sellersMap.get(login).compareTo(password) == 0) {
                    return 1; // success
                }
                return 0; // Invalid password or login invalid

            case Customer :
                if (customersMap.containsKey(login) && customersMap.get(login).compareTo(password) == 0) {
                    return 1; // success
                }
                return 0; // Invalid password or login invalid
        }
        return -1; // Error
    }

    /**
     * Register a new User in the database
     * 
     * @param login represent the login of the User
     * @param password represent the password of the User
     * @param mode tell if the user want to be register as a seller or a csustomer
     * 
     * @return 1 if success, 0 if there already an account with the same login, -2 if something went wrong with the file, -1 overwise
     */
    public int setUser(String login, String password, LandingController.Mode mode) {
        switch (mode) {
            case Seller :
                if (sellersMap.containsKey(login)) {
                    return 0;
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("sellerUser.txt", true))) {
                    bw.write(login + " " + password);
                    bw.newLine();
                    sellersMap.put(login, password);
                    return 1;
                } catch (IOException e) {
                    return -2;
                }

            case Customer :
                if (customersMap.containsKey(login)) {
                    return 0;
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("customersSet.txt", true))) {
                    bw.write(login + " " + password);
                    bw.newLine();
                    customersMap.put(login, password);
                    return 1;
                } catch (IOException e) {
                    return -2;
                }
        }
        return -1;
    }
}
