package BordanziGonzalo.PracticaJava;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;

public class CSVManageTest {
	
	
	@Test
	public void sumarizacionTestClicks(){
		fileManage manager = Mockito.mock(fileManage.class);
		
		Mockito.when(manager.obtenerLinea()).thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,P")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,P")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C");
		
		Mockito.when(manager.quedanLineas()).thenReturn(true).thenReturn(true)
											.thenReturn(true).thenReturn(true)
											.thenReturn(true).thenReturn(true)
											.thenReturn(false);
		
		CSVManage csvManager = new CSVManage();
		try {
			csvManager.parseCSV(manager, "asd.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] arr = "2,bbn,1,3,2,2,2,0,Chrome,Linux,105".split(",");
		CSVNode nodo = new CSVNode(arr);
		
		
		assertTrue(csvManager.getClicks(nodo) == 4);
		
	}
	
	@Test
	public void sumarizacionTestPrints(){
		fileManage manager = Mockito.mock(fileManage.class);
		
		
		Mockito.when(manager.obtenerLinea()).thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,P")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,P")
											.thenReturn("2,bbn,1,3,2,2,2,0,Chrome,Linux,105,C");
		
		Mockito.when(manager.quedanLineas()).thenReturn(true).thenReturn(true)
											.thenReturn(true).thenReturn(true)
											.thenReturn(true).thenReturn(true)
											.thenReturn(false);
		
		CSVManage csvManager = new CSVManage();
		try {
			csvManager.parseCSV(manager, "asd.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] arr = "2,bbn,1,3,2,2,2,0,Chrome,Linux,105".split(",");
		CSVNode nodo = new CSVNode(arr);
		
		
		assertTrue(csvManager.getPrints(nodo) == 2);
		
	}
	
	
	
}
