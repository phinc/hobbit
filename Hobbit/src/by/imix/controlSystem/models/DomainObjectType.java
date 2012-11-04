package by.imix.controlSystem.models;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 19:20
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "adapter_type")
public class DomainObjectType {
    @Id
    @GeneratedValue
    @Column(name = "adapter_type_id")
    private Long id;

    @Column(unique = true, length = 100)
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
