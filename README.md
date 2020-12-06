# Project 5, Group 022-2
### CS 180 Capstone Project
To design and implement a limited form of social network application. 

***

**This README file has to be submitted under the Documentation of our project.**

This document will include the following for each class: 
1. A detailed description.
2. Descriptions of the testing done on that class. For GUI testing, provide step-by-step guidance on the tests performed. 

In situation where the user needs to select a line and engage action, the below prompt will appear if they don't

<img width="196" alt="selectLine" src="https://user-images.githubusercontent.com/74845705/101247930-3f61f980-3757-11eb-961d-9709fbf044f4.png">

In situation where the user needs to input info for account or profile, something like the below prompt will appear if they input something invalid

<img width="428" alt="rerror1" src="https://user-images.githubusercontent.com/74845705/101247963-84862b80-3757-11eb-9969-f80adc369654.png">

## Instructions 
Run the program by first running profileServer.java, then profileClient.java. The login GUI should pop up if everything is working. If profileClient.java cannot connect, check the socket id and port numbers. 

### AccountMenuFrame Class
#### Description
This is a class representing the frame that gives users the option to either edit, or delete their accounts. The above mentioned functions are accessed through the use of buttons. 
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method sets up the appearance of the frame  

<img width="290" alt="accountMenuFrame" src="https://user-images.githubusercontent.com/74845705/101246891-fc048c80-3750-11eb-926f-f616bbf17ca3.png">


+ Pressing "Edit Acoount" button will take the user to EditProfileFrame
+ Pressing "Back" button will take the user to AccountProfileFrame
+ Pressing "Delete Account" button will prompt this message below and delete the profile

<img width="213" alt="deleteProfile" src="https://user-images.githubusercontent.com/74845705/101247219-26574980-3753-11eb-945b-5e53de35b869.png">

### AccountProfileFrame Class
#### Description
A class representing the frame that serves as an intermediary for creation, edition, and deletion of both user account and profile.
When the user wants to edit or delete their account, they can click "Account" button and vice versa for their profile.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method sets up the appearance of the frame  

<img width="288" alt="accountProfileFrame" src="https://user-images.githubusercontent.com/74845705/101246918-42f28200-3751-11eb-952f-bbc8cb84f60e.png">

+ Pressing "Profile" button will take the user to ProfileMenuFrame
+ Pressing "Back" button will take the user to UserFrame
+ Pressing "Account" button will take the user to AccountMenuFrame
### AddFriendFrame Class
#### Description
A class representing the frame to send friend requests to another users, view a list of all the application's users, search a specific user among all the application's users, view the requested friend list and the pending friend list.
Three JScrollPane, each contains a JTable. The center one would have a table that contains all users where you can choose users to send friend request. The left one would have a table that record all users which you have sent request to but not get respond. You can choose to resend request. The right one would have a table that contains all users which have sent you a request. You can either accept or deny
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="688" alt="addFriendFrame" src="https://user-images.githubusercontent.com/74845705/101246923-4ede4400-3751-11eb-84c8-1124b8405ee9.png">

+ Selecting "viewProfile" button will take the user to ProfileDisplayFrame of that user
+ Pressing "Back" button will take the user to UserFrame
+ Pressing "sendFriendRequest" button will make current user appear on the pending list of the requested user, while the requested user will apeear on current user's requested list
+ Pressing "accept" button will make accepted user appear on current user's friendlist
+ Pressing "deny" button will make the denied user disappear from the pending list
+ Pressing "resendRequest" button will make current user reappear on requested user's pending list

**Pending Table**

<img width="227" alt="pendingDerek" src="https://user-images.githubusercontent.com/74845705/101283377-e789c800-3814-11eb-8e4a-c7e8d218a110.png">

**If Deny**

<img width="227" alt="pendingDeny" src="https://user-images.githubusercontent.com/74845705/101283397-08eab400-3815-11eb-900a-558ff2c57065.png">


**If Accept**

<img width="229" alt="pendingAccept - Copy" src="https://user-images.githubusercontent.com/74845705/101283402-0ab47780-3815-11eb-8a22-c81460a1d749.png">

**This prompt comes up**

<img width="236" alt="acceptSuccess - Copy" src="https://user-images.githubusercontent.com/74845705/101283400-0a1be100-3815-11eb-93a1-c0b084d974a2.png">

**Derek will be added to friend list**

<img width="395" alt="afterafteraccept" src="https://user-images.githubusercontent.com/74845705/101283401-0a1be100-3815-11eb-8d5d-1debf2b96371.png">

#### Class Documentation
##### updateAllUserModel() method
Communicates with the server to get most updated user list
##### updatePendingModel()
Communicates with the server to get the updated user info in the pending list
##### updateRequestModel() method
Communicates with the server to get the updated user info in the request list
##### updateAll() method
Updates the data by changing the model of all three tables. Resets the rowSorter to make sure the search bar keep working. Then repaints the JFrame addFriendFrame

### EditAccountFrame Class
#### Description
A class representing the frame to edit the user account details.
Users can change their name, email address, and password but not the user ID. All the changed account details must conform to the respective validation rules.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method sets up the appearance of the frame  

<img width="288" alt="editAccountFrame" src="https://user-images.githubusercontent.com/74845705/101246934-5bfb3300-3751-11eb-936d-5578c25ef8b1.png">

+ Pressing "editAccountButton" button will reset user's account info with input
+ Pressing "Back" button will take the user to AccountMenuFrame
#### Class Documentation
##### contentCheck() method
Checks inserted information to make sure it doesn't contain forbidden characters.

### EditProfileFrame Class
#### Description
A class representing the frame to edit the details of the user profile. All the changed profile details must conform to the respective validation rules.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method sets up the appearance of the frame  

<img width="288" alt="profileFrame" src="https://user-images.githubusercontent.com/74845705/101246947-6c131280-3751-11eb-80ab-f20f8d62a04e.png">

+ Pressing "editProfileButton" button will reset user's profile info with input
+ Pressing "Back" button will take the user to ProfileMenuFrame

Test by editing Derek's profile which was blank

<img width="278" alt="editProfileAsDerek" src="https://user-images.githubusercontent.com/74845705/101283849-135a7d00-3818-11eb-9e8e-7989fa670575.png">

Viewing Derek's profile as another user

<img width="288" alt="profileDisplayFrame" src="https://user-images.githubusercontent.com/74845705/101283851-148baa00-3818-11eb-89ba-2a5587b5648b.png">

It's just as how Derek edited it

<img width="224" alt="ViewDerekProfile" src="https://user-images.githubusercontent.com/74845705/101283853-148baa00-3818-11eb-8e0d-77746a57adda.png">

#### Class Documentation
##### contentCheck()
Checks inserted information to make sure it doesn't contain forbidden characters and that it isn't empty.


### LoginFrame Class
#### Description
A class representing the frame that will appear at the very beginning when the user starts the application. Users will be able to login using their User ID and Password. Note that users need to first register to be able to log in. 
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method sets up the appearance of the frame    

<img width="440" alt="loginFrame" src="https://user-images.githubusercontent.com/74845705/100880218-70d48e00-34e7-11eb-924e-7f10ba089471.png">

+ Pressing "loginButton" button will take the user to UserFrame if login was succesful, if not below

<img width="197" alt="loginFailure" src="https://user-images.githubusercontent.com/74845705/101247887-e1351680-3756-11eb-9204-f6a967fcfc6b.png">

<img width="195" alt="loginSuccessful" src="https://user-images.githubusercontent.com/74845705/101247892-e85c2480-3756-11eb-9ce9-b6a078837e6b.png">

+ Pressing "registerButton" button will take the user to RegisterFrame


### Profile Class
#### Description
A class representing the profile of the registered user.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### Class Documentation
##### public Profile(String phoneNumber, String relationship, String gender, String currentOccupation, String interest, String aboutMe)
Constructor for the Profile class. Creates a new Profile with the provided data. 
Class includes getters and setters for each of the fields.

### ProfileClient Class
#### Description
A class representing the client-side of our application. This class includes the main method and invokes the Login frame of our application when begin.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 


### ProfileDisplayFrame Class
#### Description
A class representing the profile details of the user in a separate frame. Profile details include: Phone Number, Current Occupation, About Me, Interests, Gender, and Relationship Status
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method sets up the appearance of the frame  

<img width="288" alt="profileDisplayFrame" src="https://user-images.githubusercontent.com/74845705/101246958-7c2af200-3751-11eb-813a-ba2bc89de723.png">

+ Pressing "Back" button will take the user to UserFrame or AddFriendFrame depending the current frame the user's at


### ProfileMenuFrame Class
#### Description
A class representing the frame that gives users the option to either create, edit, or delete their profiles. This class cts as a hub hosting buttons that leads users to other frames that carry out creation, edition, or deletion.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="289" alt="profileMenuFrame" src="https://user-images.githubusercontent.com/74845705/101246970-8b11a480-3751-11eb-883c-962f9a46a5bb.png">

+ Pressing "Back" button will take the user to AccountProfileFrame
+ Pressing "editProfileButton" button will take the user to EditProfileFrame
+ Pressing "deleteProfileButton" button will prompt a comfirmation message, if the user chose yes then its profile info will be reset to blank

<img width="213" alt="deleteProfile" src="https://user-images.githubusercontent.com/74845705/101247657-bac2ab80-3755-11eb-8d93-8a571f51b73a.png">



### ProfileServer Class
#### Description
A class representing the backend server-side of our application. All the processing of data, connecting to the client, and file I/O happens here.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### Class Documentation
##### login() method
Check the username and password to see if the user logs in. Returns true if the user entered username and password are correct, false otherwise.
##### getProfile() method
Returns the Profile that matches with the given userId parameter
##### setUserProfile() method
Sets the userProfile up with the inserted userId. Return true if setup is successful, false if userId is not found in the database.
##### requestFriend() method
Sends out a friend request to the reciever using userId as a guide. Returns "RequestSuccess" if the request was successful; "Already friend!" if in each other 's friendList already; "Already requested!" if requested user is in requester's requested list; "Already being requested!" if the requested user has already sent a request to requester.
##### deleteFriend() method
Deletes a friend in user's friend's list and removes user from the deleted friend's friends list. Return true if the deletion is successful, false otherwise.
##### uniquePhoneNoCheck() method
Checks to make sure every phone number registered is unique. Returns true if the phone number is unique, false if it has been used.
##### uniqueIdCheck() method
Checks if the given parameter userId is unique in the database. Returns true if userId is unique, false otherwise
##### acceptFriend() method
Accepts the request in pending list, add to each other's friendList, and remove from pending and requested list. Return "AcceptSuccess" if there is an request and are accepted successfully; "No request found" if there are no request; "No such user found" if Ids cannot be found.
##### denyFriend() method
Denies the request in pending list and deletes history in pending and requested list. Return "DenySuccess" if there is an request and deny successfully; "No request found" if there are no request; "No such user found" if Ids cannot be found.
##### resendRequest() method
Checks if the request has been sent. If not, resend request; if sent, asks the user to be more patient. Return "RequestExisted" if the request is in the user's pending list; "ResendSuccess" if there is no request and the request is resend; "No such user found" if Ids cannot be found.
##### run() method
Starts whenever a new socket is accepted. Creates a printWriter and a bufferedReader. Uses a switch statement to perform different tasks required by the client.

### RegisterFrame Class
#### Description
A class representing the frame that allows the users to register for this application. All users must register before being able to login to the application. All the account details must conform to the respective validation rules.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="288" alt="registerFrame" src="https://user-images.githubusercontent.com/74845705/101246985-9d8bde00-3751-11eb-91d0-3c22fe1cf4b7.png">

+ Pressing "Back" button will take the user to LoginFrame
+ Pressing "registerButton" button will save the user's input and create a new User object for it if the inputs are valid, if not below

<img width="330" alt="rerror3" src="https://user-images.githubusercontent.com/74845705/101247819-784d9e80-3756-11eb-9f24-55e86483644d.png">

<img width="379" alt="rerror4" src="https://user-images.githubusercontent.com/74845705/101247820-78e63500-3756-11eb-870c-307520975777.png">

<img width="428" alt="rerror1" src="https://user-images.githubusercontent.com/74845705/101247821-797ecb80-3756-11eb-95c7-f20ee400e052.png">

<img width="626" alt="rerror2" src="https://user-images.githubusercontent.com/74845705/101247823-7a176200-3756-11eb-8f57-ada560164c6e.png">
#### Class Documentation
##### contentCheck() method
Checks the format of text in JTextField and JPasswordField for user id, password, real name, and email. The functionality is implemented using String.matches() method which requires a regex as its parameter. The content has to fully match the regex in order to have boolean correct as true


### User Class
#### Description
A class representing the user who will be registering to use our application.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### Class Documentation
##### public User(String userId, String password, String name, String email) Constructor
Creates a User object with the specified parameters. Three empty arraylist and a profile with empty string would be constructed/initialized.
##### Getters & Setters
Class also contains getters and setters for fields userId, password, name, email, friendList, and userProfile.

### UserFrame Class
#### Description
A class representing the frame displaying the friend list of the user in the application. The user is able to see the profile of users in the friend list and delete them from the friend list. Use a JTable to display all your friends and a search bar to find certain friends.
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="403" alt="userFrame" src="https://user-images.githubusercontent.com/74845705/101246998-ab416380-3751-11eb-82ea-26a07555de52.png">

+ Pressing "Back" button will take the user to LoginFrame
+ Pressing "add" button will take the user to AddFriendFrame
+ Pressing "account" button will take the user to AccountProfileFrame

**Search Bar Testing**

Before search

<img width="405" alt="UserBeforeSearch" src="https://user-images.githubusercontent.com/74845705/101283545-03da3480-3816-11eb-9efc-a6fda40e5bce.png">

After search, the id that matches remains, the rest disappear

<img width="402" alt="UserAfterSearch" src="https://user-images.githubusercontent.com/74845705/101283547-050b6180-3816-11eb-9f64-a30d5f7cbb7b.png">

#### Class Documentation
##### public UserFrame(Socket socket, String userId) Constructor
The constructor of UserFrame which use two parameters : socket and userId. socket: the socket that connect this computer connect with the server. userId: The userId of the login user
##### updateModel() method
Communicates with the server and get the updated userInfo in the login user's friendList
