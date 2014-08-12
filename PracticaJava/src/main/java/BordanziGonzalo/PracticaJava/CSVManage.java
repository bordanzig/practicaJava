package BordanziGonzalo.PracticaJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mongodb.BasicDBObject;


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
	
	public Integer getClicks(CSVNode nodo){
		CSVNode nodoC = new CSVNode(nodo);
		nodoC.setCop("C");
		return getKeyValue(nodoC);
	}
	
	public Integer getPrints(CSVNode nodo){
		CSVNode nodoP = new CSVNode(nodo);
		nodoP.setCop("P");
		return getKeyValue(nodoP);
	}
	
	public void generateCSV(String outputFile)throws IOException{
		
		FileWriter writer = new FileWriter(outputFile);
		
		for( int i = 0 ; i < lista.size() ; i++ ){

			String nodo;
			nodo = lista.get(i).deconstruct(",", getClicks(lista.get(i)), getPrints(lista.get(i)));

			writer.append(nodo);
			writer.append("\n");

			}
		writer.flush();
		writer.close();
	}
	
	public void exportToMongo (mongoManage mongo){
		mongo.dropCollection("csvColl");
		for( int i = 0 ; i < lista.size() ; i++ ){
			BasicDBObject documento = new BasicDBObject("ad_placement",lista.get(i).getAd_placement())
									.append("format_iab", lista.get(i).getFormat_iab())
									.append("gender", lista.get(i).getGender())
									.append("age", lista.get(i).getAge())
									.append("scholarity", lista.get(i).getScholarity())
									.append("marital", lista.get(i).getMarital())
									.append("income",lista.get(i).getIncome())
									.append("connection",lista.get(i).getConnection())
									.append("browser", lista.get(i).getBrowser())
									.append("so", lista.get(i).getSo())
									.append("interest_id", lista.get(i).getInterest_id())
									.append("clicks", getClicks(lista.get(i)))
									.append("prints", getPrints(lista.get(i)));
			mongo.insertInCollection("csvColl", documento);			
			
		}
	}
		
		
}
	

