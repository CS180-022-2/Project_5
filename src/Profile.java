import java.io.Serializable;

/**
 * Project 05 - Social Network "Profile" Application
 * <p>
 * A class representing the profile of the registered user.
 *
 * @author Group 022-2
 * @version November 30, 2020
 */
public class Profile implements Serializable {
    private String phoneNumber;
    private String relationship;
    private String gender;
    private String currentOccupation;
    private String interest;
    private String aboutMe;

    /**
     * Creates a new Profile with the provided details
     *
     * @param phoneNumber       phone number of the user
     * @param relationship      relationship status of the user
     * @param gender            gender of the user
     * @param currentOccupation current occupation of the user
     * @param interest          interests of the user
     * @param aboutMe           about me page of the user
     */
    public Profile(String phoneNumber, String relationship, String gender,
                   String currentOccupation, String interest, String aboutMe) {
        this.phoneNumber = phoneNumber;
        this.relationship = relationship;
        this.gender = gender;
        this.currentOccupation = currentOccupation;
        this.interest = interest;
        this.aboutMe = aboutMe;
    }

    /**
     * Gets phone number
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets relationship status
     *
     * @return relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * Gets gender
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets current occupation
     *
     * @return currentOccupation
     */
    public String getCurrentOccupation() {
        return currentOccupation;
    }

    /**
     * Gets interest
     *
     * @return interest
     */
    public String getInterest() {
        return interest;
    }

    /**
     * Gets about me page
     *
     * @return aboutMe
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * Sets phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets relationship status
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * Sets gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets new current occupation
     */
    public void setCurrentOccupation(String currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    /**
     * Sets interest
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * Sets about me page
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}