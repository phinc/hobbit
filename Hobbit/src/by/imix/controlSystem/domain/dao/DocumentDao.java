package by.imix.controlSystem.domain.dao;

import by.imix.controlSystem.domain.models.Document;

public interface DocumentDao {
	
	void save(Document document);
	
	void delete(Document document);
}
