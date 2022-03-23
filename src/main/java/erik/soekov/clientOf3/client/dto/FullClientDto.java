package erik.soekov.clientOf3.client.dto;

import erik.soekov.clientOf3.client.model.Client;

public class FullClientDto {

    private Integer clientId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String address;
    private Integer countryId;

    public FullClientDto(){

    }

    public FullClientDto(Client client){
        clientId = client.getId();
        firstname = client.getFirstname();
        lastname = client.getLastname();
        username = client.getUsername();
        email = client.getEmail();
        address = client.getAddress();
        countryId = client.getCountry().getId();

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "FullClientDto{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
