public class Profile {
    private long phoneNumber;
    private boolean relationship;
    private boolean gender;
    private String currentOccupation;
    private String[] interest;
    private String aboutMe;

    public Profile(long phoneNumber, boolean relationship, boolean gender,
                   String currentOccupation, String[] interest, String aboutMe) {
        this.phoneNumber = phoneNumber;
        this.relationship = relationship;
        this.gender = gender;
        this.currentOccupation = currentOccupation;
        this.interest = interest;
        this.aboutMe = aboutMe;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isRelationship() {
        return relationship;
    }

    public boolean isGender() {
        return gender;
    }

    public String getCurrentOccupation() {
        return currentOccupation;
    }

    public String[] getInterest() {
        return interest;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRelationship(boolean relationship) {
        this.relationship = relationship;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setCurrentOccupation(String currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    public void setInterest(String[] interest) {
        this.interest = interest;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}