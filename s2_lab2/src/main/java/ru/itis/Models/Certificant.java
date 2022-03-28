package ru.itis.Models;

public class Certificant {
    public String countryCode = "";
    public String state = "";
    public String city = "";
    public String organization = "";
    public String organizationUnit = "";
    public String name = "";
    public String emailAddress = "";
    public String certificateName = "";
    public String rootkey;

    public Certificant(String countryCode, String state, String city, String organization, String organizationUnit, String name, String emailAddress, String certificateName, String rootkey) {
        this.countryCode = countryCode;
        this.state = state;
        this.city = city;
        this.organization = organization;
        this.organizationUnit = organizationUnit;
        this.name = name;
        this.emailAddress = emailAddress;
        this.certificateName = certificateName;
        this.rootkey = rootkey;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(String organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getRootkey() {
        return rootkey;
    }

    public void setRootkey(String rootkey) {
        this.rootkey = rootkey;
    }
}
