package by.imix.controlSystem.models;

import by.imix.controlSystem.models.DomainObjectAdapter;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "adapter")
public class DomainObjectAdapterImpl implements DomainObjectAdapter {
    @Id
    @GeneratedValue
    private Long id;
    
    private Long identity;
    
//    @ManyToOne
//    private DomainObjectType type;
    private String type;
    
    public DomainObjectAdapterImpl() {}

    public DomainObjectAdapterImpl(Class<? extends Object> clazz, Long identity) {
        this.type = clazz.getName();
        this.identity = identity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "DomainObjectAdapterImpl [id=" + id + ", identity=" + identity
				+ ", type=" + type + "]";
	}
    
    
}
