package by.imix.controlSystem.models;

import by.imix.controlSystem.models.AdapterStateEntity;
import by.imix.controlSystem.services.AdapterStateEntityService;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public enum Action {

    ADD_ACTION {

		@Override
		public void apply(AdapterStateEntity adapterStateEntity,
				AdapterStateEntityService adapterStateEntityService) {
			adapterStateEntityService.insert(adapterStateEntity);
		}
    	
    },
    REMOVE_ACTION {
		
    	@Override
		public void apply(AdapterStateEntity adapterStateEntity,
				AdapterStateEntityService adapterStateEntityService) {
    		adapterStateEntityService.delete(adapterStateEntity);
		}
	};
    
	public abstract void apply(AdapterStateEntity adapterStateEntity, 
			AdapterStateEntityService adapterStateEntityService);

}
