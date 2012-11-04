package test;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import by.imix.controlSystem.domain.models.Document;
import by.imix.controlSystem.domain.models.User;
import by.imix.controlSystem.models.*;
import by.imix.controlSystem.services.ActionService;
import by.imix.controlSystem.services.DomainObjectAdapterService;
import by.imix.controlSystem.services.InstructionService;
import by.imix.controlSystem.services.ClientService;
import by.imix.controlSystem.services.RuleService;
import by.imix.controlSystem.services.StateService;

public class TestClient {
	
	private static final Logger LOG = Logger.getLogger(TestClient.class.getName());
	
	public void testClient() {
		DomainObjectAdapter client = new DomainObjectAdapterImpl(User.class, new Long(3));
		DomainObjectAdapterService domainObjectAdapterService = (DomainObjectAdapterService)StartSystem.context.getBean(
                "domainObjectAdapterService");
		domainObjectAdapterService.saveOrUpdate(client);
		
		Client ruleApplier = new ClientImpl(client, getRules());
		
		ClientService service = (ClientService)StartSystem.context.getBean("clientService");
		service.save(ruleApplier);
		
		ruleApplier = service.getByName("Rule1", client);
		LOG.debug("rule applier: " + ruleApplier);
	}
	
	private Set<Rule> getRules() {
		Rule rule = new RuleImpl("Rule1", getInstructions());
        Rule rule1 = new RuleImpl("Rule2", getInstructions());
        RuleService ruleService = (RuleService)StartSystem.context.getBean("ruleService");
        ruleService.save(rule);
        ruleService.save(rule1);
        
        Set<Rule> rules = new HashSet<Rule>();
        rules.add(rule);
        rules.add(rule1);
        return rules;
	}
	
	private Set<Instruction> getInstructions() {
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
        
        State adminState = new StateImpl("admin");
        stateService.save(adminState);

//        Action addAction = new AddAction();
//        ActionService actionService = (ActionService)StartSystem.context.getBean("actionService");
//        actionService.save(addAction);
//        
//        Action removeAction = new RemoveAction();
//        actionService.save(removeAction);

        Set<Instruction> instructions = new HashSet<Instruction>();
        instructions.add(new InstructionImpl(Action.ADD_ACTION, state, recipients));
        instructions.add(new InstructionImpl(Action.REMOVE_ACTION, adminState, recipients));
        
        InstructionService instructionService = (InstructionService)StartSystem.context.getBean(
                "instructionService");
        for (Instruction instruction : instructions) {
            instructionService.save(instruction); 
        }
        return instructions;
    }
}
