package dev.rdunaway.spring5jpafirst.model;

import javax.persistence.*;

@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    @Embedded
    private Address companyAddress;

    public Publisher() {
    }

    public Publisher(String companyName, Address companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public Publisher(Long id, String companyName, Address companyAddress) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "companyName='" + companyName + '\'' +
                ", companyAddress=" + companyAddress +
                '}';
    }
}
