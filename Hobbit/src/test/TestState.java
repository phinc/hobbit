package test;

import by.imix.controlSystem.models.State;
import by.imix.controlSystem.models.StateDinamicImpl;
import by.imix.controlSystem.models.StateImpl;
import by.imix.controlSystem.services.StateService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
//@Test
public class TestState {
    
    private static final Logger LOG = Logger.getLogger(TestState.class.getName());
    
    private  ApplicationContext context = StartSystem.context;
    
//    @Before
//    public void init() {
//        context = StartSystem.context;
//    }
    
    public void testSaveState() {
        State state = new StateImpl("test state");
        StateService stateService = (StateService)context.getBean("stateService");
        stateService.save(state);

        State stateDin=new StateDinamicImpl("test state dinamic");
        stateService.save(stateDin);
        
        List<State> states = stateService.getAll();
        LOG.debug("all states: " + states);
    }
}
