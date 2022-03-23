package erik.soekov.clientOf3.client.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "client_handlers")
public class ClientHandler {

    @EmbeddedId
    private ClientHandlerIdentity id;

    public ClientHandlerIdentity getId() {
        return id;
    }

    public void setId(ClientHandlerIdentity id) {
        this.id = id;
    }
}
