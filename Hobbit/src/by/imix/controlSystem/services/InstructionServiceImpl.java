package by.imix.controlSystem.services;

import by.imix.controlSystem.models.Instruction;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 29.10.12
 * Time: 13:06
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class InstructionServiceImpl implements InstructionService {
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public Instruction getById(Long id) {
        return (Instruction)sessionFactory.getCurrentSession().get(Instruction.class, id);
    }
    
    @Override
    @Transactional
    public void save(Instruction instruction) {
        sessionFactory.getCurrentSession().save(instruction);
    }
    
    @Override
    @Transactional
    public  void delete(Instruction instruction) {
        sessionFactory.getCurrentSession().delete(instruction);
    }
}
