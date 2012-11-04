package by.imix.controlSystem.models;

import by.imix.controlSystem.models.AbstractAction;
import by.imix.controlSystem.models.AdapterStateEntity;
import by.imix.controlSystem.services.AdapterStateEntityService;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("RemoveAction")
public class RemoveAction extends AbstractAction {

    @Override
    public void apply(AdapterStateEntity adapterStateEntity, AdapterStateEntityService adapterStateEntityService) {
        adapterStateEntityService.delete(adapterStateEntity);
    }

	@Override
	public String toString() {
		return "RemoveAction []";
	}
    
    
}
