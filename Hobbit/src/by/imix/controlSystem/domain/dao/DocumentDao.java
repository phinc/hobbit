package by.imix.controlSystem.domain.dao;
/*
 * Author: Irinka
 */

import by.imix.controlSystem.domain.models.Document;

public interface DocumentDao {
	
	void save(Document document);
	
	void delete(Document document);
}
