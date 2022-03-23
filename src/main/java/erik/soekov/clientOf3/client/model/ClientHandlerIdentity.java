package erik.soekov.clientOf3.client.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClientHandlerIdentity implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "client_id")
    private Integer clientId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        ClientHandlerIdentity target = (ClientHandlerIdentity) obj;

        if(!this.userId.equals(target.userId)) return false;

        return this.userId.equals(target.userId);
    }
}
