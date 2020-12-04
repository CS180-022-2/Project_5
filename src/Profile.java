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
     * creates a new Profile with the provided details
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
     * gets phone number
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * gets relationship status
     *
     * @return relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * gets gender
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * gets current occupation
     *
     * @return currentOccupation
     */
    public String getCurrentOccupation() {
        return currentOccupation;
    }

    /**
     * gets interest
     *
     * @return interest
     */
    public String getInterest() {
        return interest;
    }

    /**
     * gets about me page
     *
     * @return aboutMe
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * sets phone number
     *
     * @param phoneNumber new phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * sets relationship status
     *
     * @param relationship new relationship status
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * sets gender
     *
     * @param gender new gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * sets new current occupation
     *
     * @param currentOccupation new occupation to set
     */
    public void setCurrentOccupation(String currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    /**
     * sets interest
     *
     * @param interest new interests to set
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * sets about me page
     *
     * @param aboutMe new about me page to set
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}