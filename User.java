import java.util.ArrayList;

public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
	private ArrayList<User> friendList;
<<<<<<< Updated upstream
=======
	private ArrayList<User> requestList;
	private ArrayList<User> pendingList;
>>>>>>> Stashed changes
	private Profile userProfile;

	public User(String userId, String password, String name, String email) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		friendList = new ArrayList<>();
<<<<<<< Updated upstream
=======
		pendingList = new ArrayList<>();
		requestList = new ArrayList<>();
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
>>>>>>> Stashed changes
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

