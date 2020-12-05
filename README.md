# Project_5
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

### AccountMenuFrame Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="290" alt="accountMenuFrame" src="https://user-images.githubusercontent.com/74845705/101246891-fc048c80-3750-11eb-926f-f616bbf17ca3.png">


+ Pressing "Edit Acoount" button will take the user to EditProfileFrame
+ Pressing "Back" button will take the user to AccountProfileFrame
+ Pressing "Delete Account" button will prompt this message below and delete the profile

<img width="213" alt="deleteProfile" src="https://user-images.githubusercontent.com/74845705/101247219-26574980-3753-11eb-945b-5e53de35b869.png">


### AccountProfileFrame Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="288" alt="accountProfileFrame" src="https://user-images.githubusercontent.com/74845705/101246918-42f28200-3751-11eb-952f-bbc8cb84f60e.png">

+ Pressing "Profile" button will take the user to ProfileMenuFrame
+ Pressing "Back" button will take the user to UserFrame
+ Pressing "Account" button will take the user to AccountMenuFrame
### AddFriendFrame Class
#### Description
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
### EditAccountFrame Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="288" alt="editAccountFrame" src="https://user-images.githubusercontent.com/74845705/101246934-5bfb3300-3751-11eb-936d-5578c25ef8b1.png">

+ Pressing "editAccountButton" button will reset user's account info with input
+ Pressing "Back" button will take the user to AccountMenuFrame
### EditProfileFrame Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="288" alt="profileFrame" src="https://user-images.githubusercontent.com/74845705/101246947-6c131280-3751-11eb-80ab-f20f8d62a04e.png">

+ Pressing "editProfileButton" button will reset user's profile info with input
+ Pressing "Back" button will take the user to ProfileMenuFrame
### LoginFrame Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame    

<img width="440" alt="loginFrame" src="https://user-images.githubusercontent.com/74845705/100880218-70d48e00-34e7-11eb-924e-7f10ba089471.png">

+ Pressing "loginButton" button will take the user to UserFrame if login was succesful, if not below

<img width="197" alt="loginFailure" src="https://user-images.githubusercontent.com/74845705/101247887-e1351680-3756-11eb-9204-f6a967fcfc6b.png">

<img width="195" alt="loginSuccessful" src="https://user-images.githubusercontent.com/74845705/101247892-e85c2480-3756-11eb-9ce9-b6a078837e6b.png">

+ Pressing "registerButton" button will take the user to RegisterFrame
### Profile Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
### ProfileClient Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
### ProfileDisplayFrame Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
#### GUI
##### Run() method
This method set up the appearance of the frame  

<img width="288" alt="profileDisplayFrame" src="https://user-images.githubusercontent.com/74845705/101246958-7c2af200-3751-11eb-813a-ba2bc89de723.png">

+ Pressing "Back" button will take the user to UserFrame or AddFriendFrame depending the current frame the user's at
### ProfileMenuFrame Class
#### Description
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
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
### RegisterFrame Class
#### Description
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

### User Class
#### Description
#### Testing
1. Tested that the class exists and inherits or implement the correct classes
2. Tested that all fields exist, and are of correct type and modifiers
3. Tested that all methods exist, and have the correct return type and modifiers
4. Two implementation tests to test if each method work with correct input and     fails with incorrect input. 
### UserFrame Class
#### Description
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
