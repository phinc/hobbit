package test;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.imix.controlSystem.domain.models.Document;
import by.imix.controlSystem.domain.models.Group;
import by.imix.controlSystem.domain.models.User;

import java.util.Date;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class ServiseSystemImpl implements ServiseSystem {
    @Autowired
    private SessionFactory sessionFactory;//= (SessionFactory) StartSystem.getBean("mySessionFactory", SessionFactory.class);

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(){
        User us=new User();
        us.setName("Miha-"+new Date().toLocaleString());
        sessionFactory.getCurrentSession().saveOrUpdate(us);
    }

    @Override
    public void addGroup(){
        Group gr=new Group();
        gr.setName("Group-"+new Date().toLocaleString());
        sessionFactory.getCurrentSession().saveOrUpdate(gr);
    }


    @Override
    public void addListDocument(){
        for(int i=0;i<20;i++){
            Document d=new Document();
            d.setName("Document-"+new Random(999).nextInt());
            sessionFactory.getCurrentSession().saveOrUpdate(d);
        }
    }
}
