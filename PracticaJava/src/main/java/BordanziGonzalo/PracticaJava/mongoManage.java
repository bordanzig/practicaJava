package BordanziGonzalo.PracticaJava;

import java.net.UnknownHostException;

import com.mongodb.*;

public class mongoManage {

	private MongoClient cliente;
	private DB base;
	
	public mongoManage(String ip, int port, String dbname) throws UnknownHostException{
		cliente = new MongoClient(ip,port);
		base = cliente.getDB(dbname);
	}
	
	public mongoManage(String dbname) throws UnknownHostException{
		cliente = new MongoClient();
		base = cliente.getDB(dbname);
	}

	public MongoClient getCliente() {
		return cliente;
	}

	public void setCliente(MongoClient cliente) {
		this.cliente = cliente;
	}

	public DB getBase() {
		return base;
	}

	public void setBase(DB base) {
		this.base = base;
	}
	
	public void dropCollection(String nombre){
		DBCollection collection = base.getCollection(nombre);
		collection.drop();
	}
	

	public void insertInCollection(String string, BasicDBObject documento) {
		DBCollection collection = base.getCollection(string);
		collection.insert(documento); 
	}
	
}
