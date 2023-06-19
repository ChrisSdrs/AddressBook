public class Contact {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String streetName;
    private String streetNumber;

    //  Constructor
    public Contact(String firstName, String lastName, String phone, String email, String streetName, String streetNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    // Getters and Setters
    /**
     * Returns the first name of the contact.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the contact.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the contact.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the contact.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the phone number of the contact.
     *
     * @return The phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param phone The phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the email address of the contact.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the contact.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the street name of the contact's address.
     *
     * @return The street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name of the contact's address.
     *
     * @param streetName The street name to set.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Returns the street number of the contact's address.
     *
     * @return The street number.
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the street number of the contact's address.
     *
     * @param streetNumber The street number to set.
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
