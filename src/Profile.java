public class Profile {
    private String phoneNumber;
    private String relationship;
    private String gender;
    private String currentOccupation;
    private String interest;
    private String aboutMe;

    public Profile(String phoneNumber, String relationship, String gender,
                   String currentOccupation, String interest, String aboutMe) {
        this.phoneNumber = phoneNumber;
        this.relationship = relationship;
        this.gender = gender;
        this.currentOccupation = currentOccupation;
        this.interest = interest;
        this.aboutMe = aboutMe;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getGender() {
        return gender;
    }

    public String getCurrentOccupation() {
        return currentOccupation;
    }

    public String getInterest() {
        return interest;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCurrentOccupation(String currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}