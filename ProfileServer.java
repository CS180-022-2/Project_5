public interface ProfileServer {
	boolean dualLoginCheck(String username);
	boolean login(String username, String password);
	boolean register(String username, String password, String name, String email);
	boolean setUserProfile(Profile profile, String userName);
	Profile viewProfile(String username);
	boolean addFriend(String username);
	boolean checkFriendRequest();


}
