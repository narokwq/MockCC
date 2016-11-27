package unipe.service;

import unipe.mock.WebServiceInterface;
import unipe.model.Document;

public class ServiceDocument {
	WebServiceInterface mock;
	
	public ServiceDocument(WebServiceInterface mock) {
		this.mock = mock;
	}

	public String getDocumentSaida(String documentId){	
		Document document = mock.getDocument(documentId);
		
		String tipoSaida = "Tipo Invalido";
		
		switch(document.getTipoSaida()){
			case 1:  tipoSaida = "Retono"; break;
			case 2:  tipoSaida = "Retono SADT"; break;
			case 3:  tipoSaida = "Referencia"; break;
			case 4:  tipoSaida = "Internação"; break;
			case 5:  tipoSaida = "Alta"; break;
			case 6:  tipoSaida = "Obito"; break;
		}
		return tipoSaida;
	}
}
