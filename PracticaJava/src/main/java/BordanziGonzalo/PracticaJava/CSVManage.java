package BordanziGonzalo.PracticaJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class CSVManage {
	
	private HashMap<CSVNode,Integer> map;
	private String file;
	private ArrayList<CSVNode> lista;
	
	
	
	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public CSVManage(String file){
		this.setFile(file);
	}
	
	
	/* Parse Method */
	public void parseCSV() throws IOException{
		
		map = new HashMap<CSVNode, Integer>();
		lista = new ArrayList<CSVNode>();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		
		line = reader.readLine();
		
		while((line=reader.readLine())!=null){
	    
			String[] attr = line.split(",");
			CSVNode node = new CSVNode(attr);
			Integer value = map.get(node);
			CSVNode listnode = new CSVNode(node);
			

			if (value !=null){
				
				/* Si el valor es null, se le suma 1 al valor de la key */
				map.put(node, map.get(node)+1);
			}	
			else {
				/* Si el valor es null, no existe la key */
				map.put(node, 1);
			}
			
			
			
			if(!lista.contains(listnode)){
				lista.add(listnode);
			}
			
	    }
		reader.close();
	}
	
	public Integer getKeyValue(CSVNode nodo){
		Integer value = map.get(nodo);
		if (value != null){
			return value;
		}else{
			return 0;
		}
	}
	
	public void generateCSV(String outputFile)throws IOException{
		
		FileWriter writer = new FileWriter(outputFile);
		
		for( int i = 0 ; i < lista.size() ; i++ ){
			CSVNode nodoC = new CSVNode(lista.get(i));
			CSVNode nodoP = new CSVNode(lista.get(i));
			String nodo;

			
			nodoC.setCop("C");
			nodoP.setCop("P");
			
			nodo = nodoC.deconstruct(",", getKeyValue(nodoC), getKeyValue(nodoP));

			writer.append(nodo);
			writer.append("\n");

			}
		writer.flush();
		writer.close();
	}
		
		
}
	

