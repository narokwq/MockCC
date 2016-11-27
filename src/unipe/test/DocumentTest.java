package unipe.test;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import unipe.mock.WebServiceInterface;
import unipe.model.Document;
import unipe.model.SaidaException;
import unipe.service.ServiceDocument;

public class DocumentTest extends TestCase{
	ServiceDocument service;
	WebServiceInterface mock;
	
	@Before
	protected void setUp() throws Exception {		
        mock = EasyMock.createMock(WebServiceInterface.class);
        service = new ServiceDocument(mock);
        EasyMock.expect(mock.getDocument("ID1")).andReturn(new Document(1)); 
        EasyMock.expect(mock.getDocument("ID2")).andReturn(new Document(2)); 
        EasyMock.expect(mock.getDocument("ID3")).andReturn(new Document(3));  
        EasyMock.expect(mock.getDocument("ID4")).andReturn(new Document(4));  
        EasyMock.expect(mock.getDocument("ID5")).andReturn(new Document(5));  
        EasyMock.expect(mock.getDocument("ID6")).andReturn(new Document(6));
        EasyMock.expect(mock.getDocument("ID7")).andReturn(new Document(7));
        EasyMock.expect(mock.getDocument("ERRO")).andThrow(new SaidaException("Formato incorreto"));
        EasyMock.replay(mock);
	}
	

	@Test
	public void testSaidaRetonoSadt(){	       
        assertEquals("Retono", service.getDocumentSaida("ID1"));
        
	}
	
	@Test
	public void testSaidaRetono(){
        assertEquals("Retono SADT", service.getDocumentSaida("ID2"));

    }
	@Test
	public void testSaidaReferencia(){	       
        assertEquals("Referencia", service.getDocumentSaida("ID3"));
	}
	
	@Test
	public void testSaidaInternação(){
        assertEquals("Internação", service.getDocumentSaida("ID4"));

    }
	@Test
	public void testSaidaAlta(){	       
        assertEquals("Alta", service.getDocumentSaida("ID5"));
	}
	
	@Test
	public void testSaidaObito(){
        assertEquals("Obito", service.getDocumentSaida("ID6"));

    }
	
	@Test
	public void testSaidaInvalida(){
        assertEquals("Tipo Invalido", service.getDocumentSaida("ID7"));

    }
	
	@Test
	public void testSaidaException(){
		
		try {
			service.getDocumentSaida("ERRO");
			fail("Sem Exception");
		} catch (SaidaException e) {
			 assertEquals("Formato incorreto", e.getMessage());
		}

    }
	
/*	@Test
	public void testTodos(){	       
        assertEquals("Retono", service.getDocumentSaida("ID1"));
        assertEquals("Retono SADT", service.getDocumentSaida("ID2"));
        assertEquals("Referencia", service.getDocumentSaida("ID3"));
        assertEquals("Internação", service.getDocumentSaida("ID4"));
        assertEquals("Alta", service.getDocumentSaida("ID5"));
        assertEquals("Obito", service.getDocumentSaida("ID6"));
        assertEquals("Tipo Invalido", service.getDocumentSaida("ID7"));
        try {
			service.getDocumentSaida("ERRO");
			fail("Sem Exception");
		} catch (SaidaException e) {
			 assertEquals("Formato incorreto", e.getMessage());
		}
        
        EasyMock.verify(mock); 
	}*/

}
