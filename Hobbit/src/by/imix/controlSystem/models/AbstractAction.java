package by.imix.controlSystem.models;

import by.imix.controlSystem.models.Action;
import by.imix.controlSystem.services.AdapterStateEntityService;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="action")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "action_type",
        discriminatorType = DiscriminatorType.STRING        
)
public abstract class AbstractAction  {
    @Id
    @GeneratedValue
    @Column(name = "action_id")
    private Long id;

//    @Transient
//    private AdapterStateEntityService adapterStateEntityService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public abstract void apply(AdapterStateEntity adapterStateEntity, AdapterStateEntityService adapterStateEntityService);

//    public void setAdapterStateEntityService(AdapterStateEntityService adapterStateEntityService) {
//        this.adapterStateEntityService = adapterStateEntityService;
//    }
//
//    @Override
//    public AdapterStateEntityService getAdapterStateEntityService() {
//        return adapterStateEntityService;
//    }
}
