package by.imix.controlSystem.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "instruction")
public class InstructionImpl implements Instruction {
    @Id
    @GeneratedValue
    @Column(name = "instruction_id")
    private Long id;
    
    //@ManyToOne(targetEntity = AbstractAction.class)
    @Enumerated(EnumType.STRING)
    private Action action;

    @ManyToOne(targetEntity = StateImpl.class)
    private State state;

    @ManyToMany(targetEntity = DomainObjectAdapterImpl.class,
               cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "instruction_adapter",
               joinColumns = @JoinColumn(name = "instruction_id"),
               inverseJoinColumns = @JoinColumn(name = "adapter_id"))
    private Set<DomainObjectAdapter> recipients = new HashSet<DomainObjectAdapter>();

    
    
    public InstructionImpl() {
		super();
	}

	public InstructionImpl(Action action, State state, Set<DomainObjectAdapter> recipients) {
        this.action = action;
        this.state = state;
        this.recipients = recipients;
    }
	
	

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
    public Action getAction() {
        return action;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public Set<DomainObjectAdapter> getRecipients() {
        return recipients;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setRecipients(Set<DomainObjectAdapter> recipients) {
        this.recipients = recipients;
    }

	@Override
	public String toString() {
		return "InstructionImpl [id=" + id + ", action=" + action + ", state="
				+ state + ", recipients=" + recipients + "]";
	}
    
    

//    @Override
//    public void apply(DomainObjectAdapter domainObject) {
//        for (DomainObjectAdapter recipient : recipients) {
//            AdapterStateEntity ase = new AdapterStateEntityImpl(domainObject, recipient, state);
//            action.apply(ase);
//        }
//    }
}
