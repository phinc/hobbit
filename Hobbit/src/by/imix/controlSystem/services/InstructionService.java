package by.imix.controlSystem.services;

import by.imix.controlSystem.models.Instruction;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 29.10.12
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public interface InstructionService {
    Instruction getById(Long id);

    void save(Instruction instruction);

    void delete(Instruction instruction);
}
