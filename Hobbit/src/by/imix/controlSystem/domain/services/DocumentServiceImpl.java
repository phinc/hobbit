package by.imix.controlSystem.domain.services;

import by.imix.controlSystem.domain.dao.DocumentDao;
import by.imix.controlSystem.domain.models.Document;

public class DocumentServiceImpl implements DocumentService {
	
	private DocumentDao documentDao;
	
	
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}


	@Override
	public Document save(Document document) {
		documentDao.save(document);
		return document;
	}

}
