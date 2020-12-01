import java.io.Serializable;
import java.util.ArrayList;
/**
 * Project 05 - Social Network "Profile" Application
 *
 * A class representing the user who will be registering to use our application.
 *
 * @author Group 022-2
 * @version November 30, 2020
 */

public class User implements Serializable {
    private String userId;
    private String password;
    private String name;
    private String email;
    private ArrayList<User> friendList;
    private ArrayList<User> requestList;
    private ArrayList<User> pendingList;
    private Profile userProfile;

    public User(String userId, String password, String name, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        friendList = new ArrayList<>();
        pendingList = new ArrayList<>();
        requestList = new ArrayList<>();
        userProfile = new Profile("", "", "", "", "", "");
    }

    public ArrayList<User> getRequestList() {
        return requestList;
    }

    public void setRequestList(ArrayList<User> requestList) {
        this.requestList = requestList;
    }

    public ArrayList<User> getPendingList() {
        return pendingList;
    }

    public void setPendingList(ArrayList<User> pendingList) {
        this.pendingList = pendingList;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<User> getFriendList() {
        return friendList;
    }

    public Profile getUserProfile() {
        return userProfile;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }

    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }
}