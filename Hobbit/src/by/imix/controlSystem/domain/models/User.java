package by.imix.controlSystem.domain.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "user")
public class User {
    
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;
    
	@Column(unique = true)
	private String name;
    
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "users"
        )
    private Set<Group> groups = new HashSet<Group>();

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroup(Set<Group> groups) {
        this.groups = groups;
    }
    
    public void addGroup(Group group) {
    	group.getUsers().add(this);
    	groups.add(group);
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", groups=" + groups + "]";
	}
    
    
    
}
