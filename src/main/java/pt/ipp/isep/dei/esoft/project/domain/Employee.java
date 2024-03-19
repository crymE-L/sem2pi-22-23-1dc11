package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

import java.util.ArrayList;

/**
 * This class serves to create an employee.
 *
 * @author Diogo Martins (1221223)
 */
public class Employee extends Person {
    /**
     * The employee's  number.
     */
    private int passport;

    /**
     * The employee's vat number, for
     * taxation purposes
     */
    private int vat;

    /**
     * The employee's address
     */
    private String address;

    /**
     * The employee's phone number
     */
    private String phone = super.getPhoneNumber();

    /**
     * The employee's agency object
     */
    private Agency agency;

    /**
     * The constructor made specifically to create
     * the object Habitation. This constructor contains
     * all the parameters needed at once
     *
     * @param name
     * @param email
     * @param password
     * @param roles
     * @param passport's card number
     * @param vat
     * @param address
     * @param agency
     */
    public Employee (String name, String email, String password, ArrayList<Role> roles, String phoneNumber, int passport, int vat, String address, Agency agency){
        super(name, email, password, roles, phoneNumber);
		setPassport(passport);
		setVat(vat);
		setAddress(address);
		setAgency(agency);
    }

    /**
     * The getter for the cc number
     *
     * @return int
     */
    public int getPassport() {
        return passport;
    }

    /**
     * The setter for the cc number
     * The cc number must have at least 8 characters.
     *
     * @param passport's card number
     */
    public void setPassport(int passport) {
        if(Integer.toString(passport).length() != 8)
            throw new IllegalArgumentException("The passport's card number must have 8 characters.");

        this.passport = passport;
    }

    /**
     * The getter for the vat number
     *
     * @return int
     */
    public int getVat() {
        return vat;
    }

    /**
     * The setter for the vat number
     * The vat number must have at least 9 characters.
     *
     * @param vat
     */
    public void setVat(int vat) {
        if(Integer.toString(vat).length() != 9)
            throw new IllegalArgumentException("The VAT number must have 9 characters.");

        this.vat = vat;
    }

    /**
     * The getter for the address
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * The setter for the address
     *
     * @param address
     */
    public void setAddress(String address) {
        if(Helpers.isEmpty(address)) throw new IllegalArgumentException("Invalid address.");

        this.address = address;
    }

    /**
     * The getter for the agency object
     *
     * @return String
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * The setter for the agency object
     *
     * @param agency
     */
    public void setAgency(Agency agency) {
        if (agency == null) throw new IllegalArgumentException("Invalid agency.");

        this.agency = agency;
    }

	/**
	 * Returns a string with all the information about
	 * the employee
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return String.format("%s, with the email %s and passport %s", this.getName(), this.getEmail(), this.getPassport());
	}
}
