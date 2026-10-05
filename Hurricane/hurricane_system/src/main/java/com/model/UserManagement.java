package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Keeps track of every user in the system (the "UserList").
 * Singleton: there is only ever one of these, so the whole app
 * shares the same list of users. The facade is the only class
 * that should be calling these methods.
 *
 * @author Abaan Jafri
 */
public class UserManagement {
    private static UserManagement userManagement;
    private ArrayList<User> users;

    /**
     * Private so nobody can do "new UserManagement()".
     * Loads the saved users from the JSON file when the list is first created.
     */
    private UserManagement() {
        users = DataLoader.getUsers();
    }

    /**
     * Gets the one shared UserManagement, creating it the first time it's asked for.
     * @return the single UserManagement instance
     */
    public static UserManagement getInstance() {
        if (userManagement == null) {
            userManagement = new UserManagement();
        }
        return userManagement;
    }

    /**
     * @return every user in the system
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Finds a user by their id.
     * @param id the user's UUID
     * @return the matching user, or null if nobody has that id
     */
    public User getUser(UUID id) {
        if (id == null) {
            return null;
        }
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Finds a user by their username. Not case sensitive, so "JohnDoe" finds "johndoe".
     * This is what login uses.
     * @param userName the username to look for
     * @return the matching user, or null if that username isn't taken
     */
    public User getUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName.trim())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Adds a new user to the list. This is what create account uses.
     * Won't add a null user or a user whose username is already taken.
     * @param user the user to add
     * @return true if the user was added, false if they were rejected
     */
    public boolean addUser(User user) {
        if (user == null || getUserByUserName(user.getUserName()) != null) {
            return false;
        }
        users.add(user);
        return true;
    }

    /**
     * Removes the user with the given id.
     * @param id the id of the user to remove
     */
    public void removeUser(UUID id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    /**
     * Updates a user's profile info.
     * @param id the id of the user to edit
     * @param firstName their new first name
     * @param lastName their new last name
     * @param location their new location
     */
    public void editUser(UUID id, String firstName, String lastName, Location location) {
        User user = getUser(id);
        if (user != null) {
            user.editProfile(firstName, lastName, location);
        }
    }
}
