package erik.soekov.clientOf3.client.dto;

import erik.soekov.clientOf3.client.model.Client;

public class ClientDto {

    private String firstname;
    private String lastname;
    private String username;
    private String country;

    public ClientDto(){

    }

    public ClientDto(Client client){
        firstname = client.getFirstname();
        lastname = client.getLastname();
        username = client.getUsername();
        country = client.getCountry().getName();
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
