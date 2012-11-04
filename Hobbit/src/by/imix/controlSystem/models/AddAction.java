package by.imix.controlSystem.models;

import by.imix.controlSystem.models.AbstractAction;
import by.imix.controlSystem.models.AdapterStateEntity;
import by.imix.controlSystem.services.AdapterStateEntityService;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("AddAction")
public class AddAction extends AbstractAction {

    @Override
    public void apply(AdapterStateEntity adapterStateEntity, AdapterStateEntityService adapterStateEntityService) {
        adapterStateEntityService.insert(adapterStateEntity);
    }

	@Override
	public String toString() {
		return "AddAction []";
	}
    
    
}
