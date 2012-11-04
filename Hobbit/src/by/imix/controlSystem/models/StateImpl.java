package by.imix.controlSystem.models;

import by.imix.controlSystem.models.State;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="state")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "state_type",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("StateImpl")
public class StateImpl implements State {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    public StateImpl() {
    }

    public StateImpl(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "StateImpl [id=" + id + ", name=" + name + "]";
	}
    
    
}
