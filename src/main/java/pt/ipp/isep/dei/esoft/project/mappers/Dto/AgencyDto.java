package pt.ipp.isep.dei.esoft.project.mappers.Dto;

import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

/**
 * This class serves the purpose of mimicking
 * a real life real estate agency that belongs
 * to an AgencyNetwork
 *
 * @author Diogo Martins (1221223)
 */
public class AgencyDto {
    /**
     * The agency's name
     */
    private String name;

    /**
     * The agency's vat number, for
     * taxation purposes
     */
    private int vat;

    /**
     * The location of the Agency, for
     * tracking purposes
     */
    private String location;

    /**
     * The ageny's email
     */
    private String email;

    /**
     * The agency's phone number
     */
    private String phone;

    /**
     * The agency's agency network
     */
    private AgencyNetwork agencyNetwork;

    /**
     * The agency's manager
     */
    private Employee manager;

    /**
     * The constructor made specifically to create
     * the object Agency. This constructor contains
     * all the parameters needed at once
     *
     * @param name
     * @param vat
     * @param location
     * @param email
     * @param phone
     */
    public AgencyDto(String name, int vat, String location, String email, String phone, AgencyNetwork agencyNetwork) {
        this.name = name;
        this.vat = vat;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.agencyNetwork = agencyNetwork;
    }

    /**
     * The getter for the property name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * The getter for the property vat
     *
     * @return int
     */
    public int getVat() {
        return vat;
    }

    /**
     * The getter for the property location
     *
     * @return String
     */
    public String getLocation() {
        return location;
    }


    /**
     * The getter for the property email
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }


    /**
     * The getter for the property phone
     *
     * @return String
     */
    public String getPhone() {
        return phone;
    }


    /**
     * The getter for the agency's manager
     *
     * @return Employee
     */
    public Employee getManager() {
        return manager;
    }

    /**
     * The getter for the agency's agency network
     *
     * @return AgencyNetwork
     */
    public AgencyNetwork getAgencyNetwork() {
        return agencyNetwork;
    }

    /**
     * The setter for the agency's DTO agency network
     *
     * @param agencyNetwork
     */
    public void setAgencyNetwork(AgencyNetwork agencyNetwork) {
        this.agencyNetwork = agencyNetwork;
    }

}

