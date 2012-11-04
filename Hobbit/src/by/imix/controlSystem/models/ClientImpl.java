package by.imix.controlSystem.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "clients")
public class ClientImpl implements Client {
	
	@Id
	@GeneratedValue
	@Column(name = "client_id")
	private Long id;
	
    @OneToOne(targetEntity = DomainObjectAdapterImpl.class)
    @JoinColumn(name = "adapter_id")
    private DomainObjectAdapter clientDomainObject;
    
    @ManyToMany(targetEntity = RuleImpl.class, cascade = CascadeType.PERSIST)
    private Set<Rule> rules;
    
    
    public ClientImpl() {
		super();
	}

	public ClientImpl(DomainObjectAdapter client, Set<Rule> rules) {
		super();
		this.clientDomainObject = client;
		this.rules = rules;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
    public DomainObjectAdapter getClientDomainObject() {
        return clientDomainObject; 
    }

    public void setClient(DomainObjectAdapter client) {
        this.clientDomainObject = client;
    }

    @Override
    public Set<Rule> getRules() {
        return rules; 
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

	@Override
	public String toString() {
		return "ClientImpl [id=" + id + ", clientDomainObject="
				+ clientDomainObject + "]";
	}
   
    

//    @Override
//    public void apply(DomainObjectAdapter domainObject) {
//        for (Rule rule : rules) {
//            rule.apply(domainObject);
//        }
//    }
}
