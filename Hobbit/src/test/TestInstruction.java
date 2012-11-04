package test;

import by.imix.controlSystem.domain.models.Document;
import by.imix.controlSystem.models.*;
import by.imix.controlSystem.services.ActionService;
import by.imix.controlSystem.services.DomainObjectAdapterService;
import by.imix.controlSystem.services.InstructionService;
import by.imix.controlSystem.services.StateService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 29.10.12
 * Time: 13:14
 * To change this template use File | Settings | File Templates.
 */
public class TestInstruction {
    
    public void testInstruction() {
        DomainObjectAdapter recipient1 = new DomainObjectAdapterImpl(Document.class, new Long(77));
        DomainObjectAdapter recipient2 = new DomainObjectAdapterImpl(Document.class, new Long(78));
        Set<DomainObjectAdapter> recipients = new HashSet<DomainObjectAdapter>();
        recipients.add(recipient1);
        recipients.add(recipient2);

        DomainObjectAdapterService domainObjectAdapterService = (DomainObjectAdapterService)StartSystem.context.getBean(
                "domainObjectAdapterService");
        for(DomainObjectAdapter recipient : recipients) {         
            domainObjectAdapterService.saveOrUpdate(recipient);
        }

        State state = new StateImpl("test state");
        StateService stateService = (StateService)StartSystem.context.getBean("stateService");
        stateService.save(state);

//        Action action = new AddAction();
//        ActionService actionService = (ActionService)StartSystem.context.getBean("actionService");
//        actionService.save(action);
        
        Instruction instruction = new InstructionImpl(Action.ADD_ACTION, state, recipients);
        InstructionService instructionService = (InstructionService)StartSystem.context.getBean(
                "instructionService");
        instructionService.save(instruction);
    }
}
