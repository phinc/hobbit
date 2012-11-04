package by.imix.controlSystem.models;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "rule")
public class RuleImpl implements Rule {
    
    @Id
    @GeneratedValue
    @Column(name = "rule_id")
    private  Long id;

    @Column(length = 50)
    private String name;
    
    @ManyToMany(cascade = CascadeType.PERSIST, targetEntity = InstructionImpl.class)
    @JoinTable(name="rule_instruction",
            joinColumns=@JoinColumn(name="rule_id", referencedColumnName="rule_id"),
            inverseJoinColumns=@JoinColumn(name="instruction_id", referencedColumnName="instruction_id"))
    private Set<Instruction> instructions;

    public RuleImpl() {}

    public RuleImpl(String name, Set<Instruction> instructions) {
        this.name = name;
        this.instructions = instructions;
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
    public Set<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<Instruction> instructions) {
        this.instructions = instructions;
    }

	@Override
	public String toString() {
		return "RuleImpl [id=" + id + ", name=" + name + ", instructions="
				+ instructions + "]";
	}
    
}
