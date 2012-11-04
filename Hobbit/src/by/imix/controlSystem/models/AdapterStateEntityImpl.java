package by.imix.controlSystem.models;


import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "adapter_state")
public class AdapterStateEntityImpl implements AdapterStateEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "adapter_state_id")
    private Integer id;

    @ManyToOne(targetEntity = DomainObjectAdapterImpl.class, 
    		cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private DomainObjectAdapter adapter;

    @ManyToOne(targetEntity = DomainObjectAdapterImpl.class, 
    		cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private DomainObjectAdapter client;

    @ManyToOne(targetEntity = StateImpl.class, 
    		cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private State state;

    
    public AdapterStateEntityImpl() {}

    public AdapterStateEntityImpl(DomainObjectAdapter adapter, DomainObjectAdapter client, State state) {
        this.adapter = adapter;
        this.client = client;
        this.state = state;
    }

    @Override
    public DomainObjectAdapter getAdapter() {
        return adapter;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public DomainObjectAdapter getClient() {
        return client;  
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdapter(DomainObjectAdapter adapter) {
        this.adapter = adapter;
    }

    public void setClient(DomainObjectAdapter client) {
        this.client = client;
    }

    public void setState(State state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "AdapterStateEntityImpl [id=" + id + ", adapter=" + adapter
				+ ", client=" + client + ", state=" + state + "]";
	}
    
    
}
