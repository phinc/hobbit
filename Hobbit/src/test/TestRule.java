package test;

import by.imix.controlSystem.domain.models.Document;
import by.imix.controlSystem.models.*;
import by.imix.controlSystem.services.*;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 29.10.12
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class TestRule {
    
    private static final Logger LOG = Logger.getLogger(TestRule.class.getName());
    
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
    
    
    public void testRule() {
        Rule rule = new RuleImpl("Rule1", getInstructions());
        Rule rule1 = new RuleImpl("Rule2", getInstructions());
        RuleService ruleService = (RuleService)StartSystem.context.getBean("ruleService");
        ruleService.save(rule);
        ruleService.save(rule1);
        
        Set<Rule> resRules = ruleService.getByName("Rule1");
        LOG.debug("result rules: " + resRules);
    }
}
