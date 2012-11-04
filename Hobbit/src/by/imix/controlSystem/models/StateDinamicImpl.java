package by.imix.controlSystem.models;

import by.imix.controlSystem.models.StateDinamic;
import by.imix.controlSystem.models.StateImpl;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("StateDynamic")
public class StateDinamicImpl extends StateImpl implements StateDinamic {

    public StateDinamicImpl() {
        super();
    }

    public StateDinamicImpl(String name) {
        super(name);
    }

    @Override
    public void init() {
        System.out.println("Urrraaaa working init");
    }

    @Override
    public void destroy() {
        System.out.println("Urrraaaa working destroy");
    }
}
