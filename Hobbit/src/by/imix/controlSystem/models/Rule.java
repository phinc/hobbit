package by.imix.controlSystem.models;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 12:32
 * To change this template use File | Settings | File Templates.
 */
public interface Rule {
    
    String getName();

    Set<Instruction> getInstructions();
    
//    public void apply(DomainObjectAdapter domainObject);
}
