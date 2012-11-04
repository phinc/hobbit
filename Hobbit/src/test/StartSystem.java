package test;

import by.imix.controlSystem.models.DomainObjectAdapter;
import by.imix.controlSystem.models.DomainObjectAdapterImpl;
import by.imix.controlSystem.services.DomainObjectAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */

public class StartSystem {
    public static void main(String str[]){
        new StartSystem();
    }

    public static ApplicationContext context;

    public StartSystem() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    	context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

//        DomainObjectAdapterService domainObjectAdapterService = (DomainObjectAdapterService)context.getBean("domainObjectAdapterService");
//        DomainObjectAdapter domainObjectAdapter = new DomainObjectAdapterImpl(Document.class, new Long(14));
//        domainObjectAdapterService.saveOrUpdate(domainObjectAdapter);

//        new TestState().testSaveState();

//        new TestAction().testAction();

//        new TestAdapterState().testAdapterSate();

//        new TestInstruction().testInstruction();

//        new TestRule().testRule();
        
//        new TestClient().testClient();
        
        new TestCase1().testCase();
    }

    public static Object getBean(Class className){
        return context.getBean(className);
    }
    public static Object getBean(String idBean,Class className){
        return context.getBean(idBean,className);
    }


}
