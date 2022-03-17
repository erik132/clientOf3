package erik.soekov.clientOf3.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Comparable{

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public int compareTo(Object o) {
        if(o.getClass() != Role.class){
            throw new ClassCastException();
        }
        Role target = (Role)o;

        if(target.getId() == this.id){
            return 0;
        }if(target.getId() > this.id){
            return -1;
        }
        return 1;
    }
}
