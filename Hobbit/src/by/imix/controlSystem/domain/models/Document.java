package by.imix.controlSystem.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "document")
public class Document {
	@Id
    @GeneratedValue
    @Column(name = "document_id")
	private Long id;
	
	private String name;

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

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + "]";
	}
  
}
