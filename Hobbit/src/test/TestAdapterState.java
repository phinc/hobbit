package test;

import by.imix.controlSystem.domain.models.Document;
import by.imix.controlSystem.domain.models.Group;
import by.imix.controlSystem.models.*;
import by.imix.controlSystem.services.AdapterStateEntityService;
import by.imix.controlSystem.services.DomainObjectAdapterService;
import by.imix.controlSystem.services.StateService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 23:28
 * To change this template use File | Settings | File Templates.
 */
public class TestAdapterState {

    private static final Logger LOG = Logger.getLogger(TestAdapterState.class.getName());
    
    public void testAdapterSate() {
        DomainObjectAdapter domainObjectAdapter = new DomainObjectAdapterImpl(Document.class, new Long(77));
        DomainObjectAdapterService domainObjectAdapterService = (DomainObjectAdapterService)StartSystem.context.getBean(
                "domainObjectAdapterService");
        domainObjectAdapterService.saveOrUpdate(domainObjectAdapter);

        DomainObjectAdapter client = new DomainObjectAdapterImpl(Group.class, new Long(27));
        domainObjectAdapterService.saveOrUpdate(client);
        
        State state = new StateImpl("read");
        StateService stateService = (StateService)StartSystem.context.getBean("stateService");
        stateService.save(state);

        AdapterStateEntity adapterStateEntity = new AdapterStateEntityImpl(domainObjectAdapter, client, state);
        AdapterStateEntityService adapterStateEntityService = (AdapterStateEntityService)StartSystem.context.getBean(
                "adapterStateEntityService");
        adapterStateEntityService.insert(adapterStateEntity);
        List<AdapterStateEntity> entities = adapterStateEntityService.getByAdapter(domainObjectAdapter);
        LOG.debug("get AdapterStateEntity by adapter: " + entities);
    }
}
