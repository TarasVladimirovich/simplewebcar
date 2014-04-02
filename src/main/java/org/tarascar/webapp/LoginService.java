package org.tarascar.webapp;

import org.tarascar.webapp.service.CSVFilePersonService;

import java.util.HashSet;
import java.util.Set;

public class LoginService {

    private Set<User> users = new HashSet<User>(new CSVFilePersonService("/login.csv").getAll());
    private static LoginService instance = new LoginService();

    public LoginService() {
    }


    public static LoginService getInstance() {
        return instance;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void delUser(User user) {
        users.remove(user);
    }

    public boolean isAccessAllowed(User user) {
        if (users.contains(user)) {
            return true;
        }
        return false; //users.contains(user);
    }

    public boolean isRegisteredLogin(User user) {
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }


}
