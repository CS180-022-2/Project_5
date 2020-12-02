import java.io.Serializable;
import java.util.ArrayList;

/**
 * Project 05 - Social Network "Profile" Application
 * <p>
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

    /**
     * Creates a User object with the specified parameters
     *
     * @param userId   the user's ID
     * @param password the user's Password
     * @param name     the User's name
     * @param email    the user's email
     */
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

    /**
     * gets request list
     *
     * @return requestList
     */
    public ArrayList<User> getRequestList() {
        return requestList;
    }

    /**
     * sets new request list
     *
     * @param requestList new request list to set as
     */
    public void setRequestList(ArrayList<User> requestList) {
        this.requestList = requestList;
    }

    /**
     * gets pending list
     *
     * @return pendingList
     */
    public ArrayList<User> getPendingList() {
        return pendingList;
    }

    /**
     * sets new pending list
     *
     * @param pendingList new pendingList to set
     */
    public void setPendingList(ArrayList<User> pendingList) {
        this.pendingList = pendingList;
    }

    /**
     * gets User ID
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * gets password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * gets name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * gets friend list
     *
     * @return friendList
     */
    public ArrayList<User> getFriendList() {
        return friendList;
    }

    /**
     * gets user profile
     *
     * @return userProfile
     */
    public Profile getUserProfile() {
        return userProfile;
    }

    /**
     * sets new userId
     *
     * @param userId new UserId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * sets new password
     *
     * @param password new password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * sets new name
     *
     * @param name new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets new email
     *
     * @param email new email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * sets new friend list
     *
     * @param friendList new friend list to set
     */
    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }

    /**
     * set new user profile
     *
     * @param userProfile new user profile to set
     */
    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }
}