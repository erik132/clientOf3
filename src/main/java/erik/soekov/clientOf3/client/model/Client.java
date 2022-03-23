package erik.soekov.clientOf3.client.model;

import erik.soekov.clientOf3.client.dto.FullClientDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "client_handlers",
            joinColumns =
                    { @JoinColumn(name = "client_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "user_id", referencedColumnName = "id") })
    private List<UserWithClients> clientHandlers;

    public Client(){

    }

    public Client(FullClientDto client, List<UserWithClients> handlers, Country country){
        clientHandlers = handlers;
        firstname = client.getFirstname();
        lastname = client.getLastname();
        username = client.getUsername();
        email = client.getEmail();
        address = client.getAddress();
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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

    public List<UserWithClients> getClientHandlers() {
        return clientHandlers;
    }

    public void setClientHandlers(List<UserWithClients> clientHandlers) {
        this.clientHandlers = clientHandlers;
    }
}
