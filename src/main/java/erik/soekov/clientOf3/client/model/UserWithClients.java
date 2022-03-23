package erik.soekov.clientOf3.client.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserWithClients {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @ManyToMany(mappedBy = "clientHandlers", fetch = FetchType.EAGER)
    private List<Client> clients;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
