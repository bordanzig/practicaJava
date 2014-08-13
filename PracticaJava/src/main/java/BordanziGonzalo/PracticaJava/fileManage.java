package BordanziGonzalo.PracticaJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileManage {

	private ArrayList<String> fileMemory;
	//private Iterator<String> fmIterator;
	
	public void iniciarArchivo(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		fileMemory = new ArrayList<String>();
		//fmIterator = fileMemory.iterator();		
		line = reader.readLine();
		
		while((line = reader.readLine())!=null){	
			fileMemory.add(line);
		}
		reader.close();
	}


	public boolean quedanLineas() {
		
		//return fmIterator.hasNext();
		return !fileMemory.isEmpty();
	}

	public String obtenerLinea() {
		return fileMemory.remove(0);
		//return fmIterator.next();
	}
	
	
}
