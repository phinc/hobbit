package test;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import by.imix.controlSystem.domain.models.*;
import by.imix.controlSystem.domain.services.*;
import by.imix.controlSystem.models.*;
import by.imix.controlSystem.services.*;

public class TestCase1 {
	
	private static final Logger LOG = Logger.getLogger(TestCase1.class);
	
	private static final ApplicationContext context = StartSystem.context;
	
	public void testCase() {
		//create user
		User user = createUser("Irina");
		//create rules
		Set<Rule> rules = new HashSet<Rule>();
		String ruleName = "create document rule";
		rules.add(createRule(ruleName));
		rules.add(createRule("delete document rule"));
		//create rule applier		
		Client client = createClient(user, rules);
		
		//set state for document on behalf user 'Irina'
		setState(user, createDocument("Irina's document"), ruleName);
	}
	
	private Rule createRule(String name) {
		LOG.debug("Create rule with name: " + name);
		Rule rule = new RuleImpl(name, createInstructions());
        RuleService ruleService = (RuleService)StartSystem.context.getBean("ruleService");
        ruleService.save(rule);
        return rule;
	}
	
	private Set<Instruction> createInstructions() {
		LOG.debug("Rule recipients:");
		Group recipientUserGroup = createGroup("USER");
		LOG.debug("-" + recipientUserGroup);
		Group recipientAnonymousGroup = createGroup("ANONYMOUS");
		LOG.debug("-" + recipientAnonymousGroup);
		
		DomainObjectAdapter recipientUserGroupAdapter = getDomainObjectAdapterFor(recipientUserGroup);
        DomainObjectAdapter recipientAnonymousGroupAdapter = getDomainObjectAdapterFor(recipientAnonymousGroup);
        Set<DomainObjectAdapter> recipients = new HashSet<DomainObjectAdapter>();
        recipients.add(recipientUserGroupAdapter);
        recipients.add(recipientAnonymousGroupAdapter);
        
        LOG.debug("Rule states:");
        State state = new StateImpl("READ");
        StateService stateService = (StateService)StartSystem.context.getBean("stateService");
        state = stateService.save(state);
        LOG.debug("-" + state);
        
        State adminState = new StateImpl("UPDATE");
        adminState = stateService.save(adminState);
        LOG.debug("-" + adminState);
        
        
//        Action addAction = new AddAction();
//        ActionService actionService = (ActionService)StartSystem.context.getBean("actionService");
//        actionService.save(addAction);
//        
//        Action removeAction = new RemoveAction();
//        actionService.save(removeAction);
        
        LOG.debug("Rule instructions:");
        Set<Instruction> instructions = new HashSet<Instruction>();
        instructions.add(new InstructionImpl(Action.ADD_ACTION, state, recipients));
        instructions.add(new InstructionImpl(Action.REMOVE_ACTION, adminState, recipients));
        
        InstructionService instructionService = (InstructionService)StartSystem.context.getBean(
                "instructionService");
        for (Instruction instruction : instructions) {
            instructionService.save(instruction); 
            LOG.debug("-" + instruction);
        }
        return instructions;
	}
	
	private void setState(User user, Document document, String ruleName) {
		LOG.debug("Apply rule '" + ruleName + "' for User : " + user + " and domain object: " + document);		
		DomainObjectAdapter clientObjectAdapter = getDomainObjectAdapterFor(user);
		DomainObjectAdapter domainObjectAdapter = getDomainObjectAdapterFor(document);
		
//		ClientService clientService = (ClientService)context.getBean("clientService");
//		Client client = clientService.getByName(ruleName, clientObjectAdapter);
//		LOG.debug("Client object to be applied: " + client);
//		clientService.applyRules(client, domainObjectAdapter);
		
		RuleService ruleService = (RuleService)context.getBean("ruleService");
		Rule rule = ruleService.getByNameAndClient(ruleName, clientObjectAdapter);
		ruleService.apply(rule, domainObjectAdapter);
	}
	
	private DomainObjectAdapter getDomainObjectAdapterFor(User user) {
		DomainObjectAdapterService domainService = (DomainObjectAdapterService)context.getBean(
				"domainObjectAdapterService");
		DomainObjectAdapter domainAdapter = domainService.getByDomainObject(
				user.getClass().getName(), user.getId());
		if (domainAdapter == null) {
			domainAdapter = createDomainObjectAdapterFor(user);
		}
		return domainAdapter;
	}
	
	private DomainObjectAdapter createDomainObjectAdapterFor(Group group) {
		DomainObjectAdapterService domainService = (DomainObjectAdapterService)context.getBean(
				"domainObjectAdapterService");
		DomainObjectAdapter domainAdapter = new DomainObjectAdapterImpl(group.getClass(), group.getId());
		domainService.saveOrUpdate(domainAdapter);
		return domainAdapter;
	}
	
	private DomainObjectAdapter getDomainObjectAdapterFor(Group group) {
		DomainObjectAdapterService domainService = (DomainObjectAdapterService)context.getBean(
				"domainObjectAdapterService");
		DomainObjectAdapter domainAdapter = domainService.getByDomainObject(
				group.getClass().getName(), group.getId());
		if (domainAdapter == null) {
			domainAdapter = createDomainObjectAdapterFor(group);
		}
		return domainAdapter;
	}
	
	private DomainObjectAdapter createDomainObjectAdapterFor(User user) {
		DomainObjectAdapterService domainService = (DomainObjectAdapterService)context.getBean(
				"domainObjectAdapterService");
		DomainObjectAdapter domainAdapter = new DomainObjectAdapterImpl(user.getClass(), user.getId());
		domainService.saveOrUpdate(domainAdapter);
		return domainAdapter;
	}
	
	private DomainObjectAdapter getDomainObjectAdapterFor(Document document) {
		DomainObjectAdapterService domainService = (DomainObjectAdapterService)context.getBean(
				"domainObjectAdapterService");
		DomainObjectAdapter domainAdapter = domainService.getByDomainObject(
				document.getClass().getName(), document.getId());
		if (domainAdapter == null) {
			domainAdapter = createDomainObjectAdapterFor(document);
		}
		return domainAdapter;
	}
	
	private DomainObjectAdapter createDomainObjectAdapterFor(Document document) {
		DomainObjectAdapterService domainService = (DomainObjectAdapterService)context.getBean(
				"domainObjectAdapterService");
		DomainObjectAdapter domainAdapter = new DomainObjectAdapterImpl(document.getClass(), document.getId());
		domainService.saveOrUpdate(domainAdapter);
		return domainAdapter;
	}
	
	private Client createClient(User user, Set<Rule> rules) {
		ClientService clientService = (ClientService)context.getBean("clientService");
		DomainObjectAdapter clientObjectAdapter = getDomainObjectAdapterFor(user);
		Client client = new ClientImpl(clientObjectAdapter, rules);
		clientService.save(client);
		return client;
	}
	
	private User createUser(String name) {
		UserService userService = (UserService)context.getBean("userService");
		User user = new User();
		user.setName("Irina");
		user.addGroup(createGroup("ADMIN"));		
		return userService.save(user);
	}
	
	private Group createGroup(String name) {
		GroupService groupService = (GroupService)context.getBean("groupService");
		Group group = new Group();
		group.setName(name);
		return groupService.save(group);
	}
	
	private Document createDocument(String name) {
		DocumentService documentService = (DocumentService)context.getBean("documentService");
		Document document = new Document();
		document.setName(name);
		return documentService.save(document);
	}
}
